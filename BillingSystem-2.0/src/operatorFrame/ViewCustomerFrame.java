package operatorFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import customer.Customer;
import customer.CustomerRepository;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class ViewCustomerFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblName;
	private JLabel lblShowName;
	private JLabel lblPhNumber;
	private JLabel lblShowPhNumber;
	private JLabel lblMail;
	private JLabel lblShowMail;
	private JLabel lblId;
	private JLabel lblShowId;
	private JLabel lblGetPhNumber;
	private JTextField tFieldPhNumber;
	private JButton btnLoad;

	
	public ViewCustomerFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("VIEW CUSTOMER DETAILS");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 526, 52);
		contentPane.add(lblTitle);
		
		lblName = new JLabel("NAME :");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblName.setBounds(86, 219, 82, 25);
		contentPane.add(lblName);
		
		lblShowName = new JLabel("");
		lblShowName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblShowName.setBounds(253, 219, 215, 25);
		contentPane.add(lblShowName);
		
		lblPhNumber = new JLabel("PHONE NUMBER :");
		lblPhNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPhNumber.setBounds(86, 268, 129, 25);
		contentPane.add(lblPhNumber);
		
		lblShowPhNumber = new JLabel("");
		lblShowPhNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblShowPhNumber.setBounds(253, 268, 215, 25);
		contentPane.add(lblShowPhNumber);
		
		lblMail = new JLabel("EMAIL-ID :");
		lblMail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMail.setBounds(86, 323, 82, 25);
		contentPane.add(lblMail);
		
		lblShowMail = new JLabel("");
		lblShowMail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblShowMail.setBounds(253, 320, 215, 25);
		contentPane.add(lblShowMail);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblId.setBounds(86, 169, 82, 25);
		contentPane.add(lblId);
		
		lblShowId = new JLabel("");
		lblShowId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblShowId.setBounds(253, 169, 215, 25);
		contentPane.add(lblShowId);
		
		lblGetPhNumber = new JLabel("PHONE NUMBER :");
		lblGetPhNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblGetPhNumber.setBounds(59, 92, 146, 25);
		contentPane.add(lblGetPhNumber);
		
		tFieldPhNumber = new JTextField();
		tFieldPhNumber.setBounds(231, 89, 176, 31);
		contentPane.add(tFieldPhNumber);
		tFieldPhNumber.setColumns(10);
		
		btnLoad = new JButton("LOAD");
		btnLoad.setBounds(446, 89, 81, 33);
		contentPane.add(btnLoad);
		
		//Button to Load Customer Details
		
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblShowId.setText("");
				lblShowName.setText("");
				lblShowPhNumber.setText("");
				lblShowMail.setText("");
				
				if(!tFieldPhNumber.getText().isEmpty())
				{
					CustomerRepository custRep = new CustomerRepository();
					long phNumber = Long.parseLong(tFieldPhNumber.getText());
					try {
							if( custRep.isPhoneNumberValid(phNumber) )
							{
								Customer customer = null;
								try {
									customer = custRep.getCustomerDetailsUsingPhNumber(phNumber);
								} catch (FileNotFoundException e1) {
									e1.printStackTrace();
								}
								
								int id = customer.getId();
								String name = customer.getName();
								String mail = customer.getMailId();
								
								lblShowId.setText(String.valueOf(id));
								lblShowName.setText(name);
								lblShowPhNumber.setText(String.valueOf(phNumber));
								lblShowMail.setText(mail);
								
								tFieldPhNumber.setText("");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "NUMBER NOT REGISTERED / INVALID ", "ERROR", JOptionPane.OK_OPTION );
							}
						} catch (HeadlessException | FileNotFoundException e1) {
							e1.printStackTrace();
						}
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "EMPTY FIELD", "ERROR", JOptionPane.OK_OPTION );
				}
			}
		});
	}

}
