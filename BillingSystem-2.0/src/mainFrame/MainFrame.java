package mainFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminFrame.AdminFrame;
import employee.Designation;
import loginInfo.LoginInfo;
import loginInfo.LoginInfoRepository;
import managerFrame.ManagerFrame;
import operatorFrame.OperatorFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField textField_Name;
	private JLabel lblPassword;
	private JButton btnEnter;
	private JPasswordField textField_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("LOGIN FORM\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("NAME  :");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblName.setBounds(118, 107, 98, 27);
		contentPane.add(lblName);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(248, 106, 166, 28);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		lblPassword = new JLabel("PASSWORD  :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPassword.setBounds(118, 155, 98, 27);
		contentPane.add(lblPassword);
		
		btnEnter = new JButton("ENTER");
		btnEnter.setBackground(Color.RED);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnEnter.setBounds(211, 223, 94, 37);
		contentPane.add(btnEnter);
		
		textField_Password = new JPasswordField();
		textField_Password.setBounds(248, 157, 166, 27);
		contentPane.add(textField_Password);
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				LoginInfoRepository logInfo = new LoginInfoRepository();
				List<LoginInfo> logList = new ArrayList<LoginInfo>();
				try {
					logList = logInfo.getLoginInfoList();
				} catch (FileNotFoundException e1) {
					System.out.println("empty list");
				}
				int i = 0;
				for(LoginInfo x : logList)
				{
					i++;
					boolean checkPassword = Arrays.equals(textField_Password.getPassword(), x.getPassword().toCharArray()) ? true : false;
				
					if(textField_Name.getText().toString().equals(x.getName()) && checkPassword)
					{
						String name = textField_Name.getText();
						String pwd = textField_Password.getPassword().toString();
						Designation designation = Designation.valueOf(x.getDesignation().name());
						LoginInfo currentUser = new LoginInfo(name, pwd, designation);
						LoginInfoRepository logRep = new LoginInfoRepository();
						logRep.setCurrentUser(currentUser);
						
						
						if(x.getDesignation().toString().equals("OPERATOR"))
						{	
							OperatorFrame opFrame = null;
							try {
								opFrame = new OperatorFrame();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							opFrame.setTitle("Welcome " + textField_Name.getText());
							opFrame.setVisible(true);
							textField_Name.setText("");
							textField_Password.setText("");
							dispose();
							break;
						}
						else if(x.getDesignation().toString().equals("MANAGER"))
						{
							ManagerFrame manFrame = new ManagerFrame();
							manFrame.setTitle("Welcome " + textField_Name.getText());
							manFrame.setVisible(true);
							textField_Name.setText("");
							textField_Password.setText("");
							dispose();
							break;
						}
						else if(x.getDesignation().toString().equals("ADMIN"))
						{
							AdminFrame adFrame = new AdminFrame();
							adFrame.setTitle("Welcome " + textField_Name.getText());
							adFrame.setVisible(true);
							textField_Name.setText("");
							textField_Password.setText("");
							dispose();
							break;
						}
					}	
					
					else if(i >= logList.size())
					{
						JOptionPane.showMessageDialog(null, "INVALID INFO", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}

			}
		});
		
		
		
		
		
		
		
		
	}
}
