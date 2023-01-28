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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AddCustomerFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JTextField tFieldCustName;
	private JLabel lblCustName;
	private JLabel lblCustPhNumber;
	private JTextField tFieldPhNumber;
	private JLabel lblEmail;
	private JTextField tFieldMail;
	private JButton btnAdd;

	
	public AddCustomerFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("ADD CUSTOMER");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 416, 37);
		contentPane.add(lblTitle);
		
		lblCustName = new JLabel("NAME :");
		lblCustName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblCustName.setBounds(63, 80, 122, 30);
		contentPane.add(lblCustName);
		
		tFieldCustName = new JTextField();
		tFieldCustName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFieldCustName.setBounds(195, 81, 185, 30);
		contentPane.add(tFieldCustName);
		tFieldCustName.setColumns(10);
		
		lblCustPhNumber = new JLabel("PHONE NUMBER :");
		lblCustPhNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblCustPhNumber.setBounds(63, 141, 122, 30);
		contentPane.add(lblCustPhNumber);
		
		tFieldPhNumber = new JTextField();
		tFieldPhNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFieldPhNumber.setColumns(10);
		tFieldPhNumber.setBounds(195, 142, 185, 30);
		contentPane.add(tFieldPhNumber);
		
		lblEmail = new JLabel("E-MAIL :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEmail.setBounds(63, 208, 122, 30);
		contentPane.add(lblEmail);
		
		tFieldMail = new JTextField();
		tFieldMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFieldMail.setColumns(10);
		tFieldMail.setBounds(195, 209, 185, 30);
		contentPane.add(tFieldMail);
		
		btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnAdd.setBounds(174, 280, 89, 40);
		contentPane.add(btnAdd);
		
		
		//Button to Add New Customer
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !tFieldCustName.getText().isEmpty() && !tFieldPhNumber.getText().isEmpty() && !tFieldMail.getText().isEmpty() )
				{
					CustomerRepository custRep = new CustomerRepository();
					String name = tFieldCustName.getText();
					long phNumber = Long.parseLong(tFieldPhNumber.getText());
					String mail = tFieldMail.getText();
					int id = 0;
					try {
						id = custRep.generateCustomerId();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					Customer customer = new Customer(id, name, phNumber, mail);
					try {
						if(!custRep.checkifDetailsExist(phNumber, mail))
						{
							custRep.addCustomer(customer);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "PHONE NUMBER / EMAIL ALREADY EXISTS ", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					tFieldCustName.setText("");
					tFieldPhNumber.setText("");
					tFieldMail.setText("");
					
					JOptionPane.showMessageDialog(null, "CUSTOMER ADDED", "SUCCESS", JOptionPane.OK_OPTION);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "EMPTY FIELDS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
