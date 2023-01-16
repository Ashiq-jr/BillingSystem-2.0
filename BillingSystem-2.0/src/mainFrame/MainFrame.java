package mainFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminFrame.AdminFrame;
import managerFrame.ManagerFrame;
import operatorFrame.OperatorFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField textField_Name;
	private JLabel lblPassword;
	private JTextField textField_Password;
	private JButton btnEnter;

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
		
		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(248, 154, 166, 28);
		contentPane.add(textField_Password);
		
		btnEnter = new JButton("ENTER");
		btnEnter.setBackground(Color.RED);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnEnter.setBounds(211, 223, 94, 37);
		contentPane.add(btnEnter);
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_Name.getText().toString().equals("admin") && textField_Password.getText().toString().equals("admin"))
				{
					AdminFrame adFrame = new AdminFrame();
					adFrame.setTitle("Welcome " + textField_Name.getText());
					adFrame.setVisible(true);
					dispose();
				}
				else if(textField_Name.getText().toString().equals("manager") && textField_Password.getText().toString().equals("manager"))
				{
					ManagerFrame manFrame = new ManagerFrame();
					manFrame.setTitle("Welcome " + textField_Name.getText());
					manFrame.setVisible(true);
					dispose();
				}
				else if(textField_Name.getText().toString().equals("operator") && textField_Password.getText().toString().equals("operator"))
				{
					OperatorFrame opFrame = new OperatorFrame();
					opFrame.setTitle("Welcome " + textField_Name.getText());
					opFrame.setVisible(true);
					dispose();
				}
				else
				{
			           JOptionPane.showMessageDialog(null, "INVALID ACCOUNT DETAILS",
                               "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
	
			}
		});
	}
}
