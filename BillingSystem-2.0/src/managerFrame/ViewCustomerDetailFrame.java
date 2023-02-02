package managerFrame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bill.Bill;
import bill.BillRepository;
import bill.StoredBillInfoRepository;
import customer.Customer;
import customer.CustomerRepository;
import javax.swing.JComboBox;

public class ViewCustomerDetailFrame extends JFrame {

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
	private JLabel lblPreviousPurchases;
	private JComboBox<String> cBoxBillNumbers;
	private JButton btnLoadBill;
	
	private static List<String> billNumbersList = new ArrayList<String>();
	private JButton btnClear;

	
	public ViewCustomerDetailFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("VIEW CUSTOMER DETAILS");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 571, 52);
		contentPane.add(lblTitle);
		
		lblName = new JLabel("NAME :");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblName.setBounds(86, 219, 82, 25);
		contentPane.add(lblName);
		
		lblShowName = new JLabel("");
		lblShowName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblShowName.setBounds(285, 219, 215, 25);
		contentPane.add(lblShowName);
		
		lblPhNumber = new JLabel("PHONE NUMBER :");
		lblPhNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPhNumber.setBounds(86, 268, 129, 25);
		contentPane.add(lblPhNumber);
		
		lblShowPhNumber = new JLabel("");
		lblShowPhNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblShowPhNumber.setBounds(285, 268, 215, 25);
		contentPane.add(lblShowPhNumber);
		
		lblMail = new JLabel("EMAIL-ID :");
		lblMail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMail.setBounds(86, 323, 82, 25);
		contentPane.add(lblMail);
		
		lblShowMail = new JLabel("");
		lblShowMail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblShowMail.setBounds(285, 320, 215, 25);
		contentPane.add(lblShowMail);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblId.setBounds(86, 169, 82, 25);
		contentPane.add(lblId);
		
		lblShowId = new JLabel("");
		lblShowId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblShowId.setBounds(285, 169, 215, 25);
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
		btnLoad.setBounds(472, 88, 81, 33);
		contentPane.add(btnLoad);
		
		lblPreviousPurchases = new JLabel("PREVIOUS PURCHASES :");
		lblPreviousPurchases.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPreviousPurchases.setBounds(86, 381, 176, 25);
		contentPane.add(lblPreviousPurchases);
		
		cBoxBillNumbers = new JComboBox<String>();
		cBoxBillNumbers.setBounds(285, 379, 159, 26);
		contentPane.add(cBoxBillNumbers);
		
		btnLoadBill = new JButton("LOAD");
		btnLoadBill.setBounds(479, 376, 81, 33);
		contentPane.add(btnLoadBill);
		
		btnClear = new JButton("CLEAR");
		btnClear.setBounds(249, 468, 81, 33);
		contentPane.add(btnClear);
		
		//Button to Load Customer Details
		
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblShowId.setText("");
				lblShowName.setText("");
				lblShowPhNumber.setText("");
				lblShowMail.setText("");
				cBoxBillNumbers.removeAllItems();
				
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
								StoredBillInfoRepository sbRep = new StoredBillInfoRepository();
								billNumbersList.clear();
								billNumbersList = sbRep.getAllBillsPurchasedByACustomer(id);
								
								lblShowId.setText(String.valueOf(id));
								lblShowName.setText(name);
								lblShowPhNumber.setText(String.valueOf(phNumber));
								lblShowMail.setText(mail);
								cBoxBillNumbers.removeAllItems();
								for(String x : billNumbersList)
								{
									cBoxBillNumbers.addItem(x);
								}
								cBoxBillNumbers.setSelectedItem(null);
								
								tFieldPhNumber.setText("");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "NUMBER NOT REGISTERED / INVALID ", "ERROR", JOptionPane.OK_OPTION );
							}
						} catch (HeadlessException | IOException e1) {
							e1.printStackTrace();
						}
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "EMPTY FIELD", "ERROR", JOptionPane.ERROR_MESSAGE );
				}
			}
		});
		
		// Button to Load Bill Details
		
		btnLoadBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String billNumber = cBoxBillNumbers.getSelectedItem().toString();
				BillRepository billRep = new BillRepository();
				Bill bill = null;
				try {
					bill = billRep.loadBillUsingBillNumber(billNumber);
					billRep.passCurrentBillDetails(bill);
					LoadBillFrame lbFrame = new LoadBillFrame();
					lbFrame.setVisible(true);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});
		
		// Button to Clear Details
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblShowId.setText("");
				lblShowName.setText("");
				lblShowPhNumber.setText("");
				lblShowMail.setText("");
				cBoxBillNumbers.removeAllItems();
			}
		});
	}
}
