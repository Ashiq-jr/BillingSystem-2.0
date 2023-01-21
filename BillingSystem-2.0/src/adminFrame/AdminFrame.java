package adminFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import employee.Designation;
import employee.Employee;
import loginInfo.LoginInfo;
import store.Address;
import store.Store;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblAddEmployee;
	private JLabel lblPasswordReset;
	private JLabel lblEditStoreDetails;
	private JLabel lblName;
	private JLabel lblMobileNumber;
	private JLabel lblEmailid;
	private JLabel lblDesignation;
	private JTextField tFieldName;
	private JTextField tFieldMobileNum;
	private JTextField tFieldMailId;
	private JComboBox<Designation> cBoxDesignation;
	private JButton btnAdd;
	private JButton btnReset;
	private JLabel lblEmployeeId;
	private JTextField tFieldId;
	private JLabel lblPassword;
	private JTextField tFieldPwd;
	private JButton btnResetPassword;
	private JButton btnClear;
	private JLabel lblStoreName ;
	private JTextField tFieldStoreName;
	private JLabel lblStoreDoor;
	private JTextField tFieldStoreDoor;
	private JLabel lblStoreArea;
	private JTextField tFieldStoreArea;
	private JLabel lblStoreCity;
	private JTextField tFieldStoreCity;
	private JLabel lblStoreState;
	private JTextField tFieldStoreState;
	private JLabel lblStorePin;
	private JTextField tFieldStorePin;
	private JLabel lblGstNumber;
	private JTextField tFieldStoreGst;
	private JLabel lblStoreMobile;
	private JTextField tFieldStoreMobile;
	private JLabel lblStoreEmail;
	private JTextField tFieldStoreMail;

	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(10, 10, 504, 661);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBounds(525, 10, 504, 661);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_3.setBounds(0, 332, 504, 329);
		panel.add(panel_3);
		panel_3.setLayout(null);
			
		lblAddEmployee = new JLabel("ADD EMPLOYEE");
		lblAddEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAddEmployee.setBounds(10, 10, 484, 35);
		panel.add(lblAddEmployee);
		
		lblPasswordReset = new JLabel("RESET PASSWORD");
		lblPasswordReset.setBounds(10, 10, 484, 35);
		panel_3.add(lblPasswordReset);
		lblPasswordReset.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordReset.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		lblEmployeeId = new JLabel("EMPLOYEE ID  :");
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEmployeeId.setBounds(86, 90, 124, 27);
		panel_3.add(lblEmployeeId);
		
		tFieldId = new JTextField();
		tFieldId.setColumns(10);
		tFieldId.setBounds(254, 90, 158, 24);
		panel_3.add(tFieldId);
		
		lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPassword.setBounds(86, 145, 124, 27);
		panel_3.add(lblPassword);
		
		tFieldPwd = new JTextField();
		tFieldPwd.setColumns(10);
		tFieldPwd.setBounds(254, 150, 158, 24);
		panel_3.add(tFieldPwd);
		
		btnResetPassword = new JButton("RESET PASSWORD");
		btnResetPassword.setBounds(98, 207, 125, 35);
		panel_3.add(btnResetPassword);
		
		btnClear = new JButton("CLEAR");
		btnClear.setBounds(264, 207, 125, 35);
		panel_3.add(btnClear);
		
		lblName = new JLabel("NAME :");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblName.setBounds(90, 79, 124, 27);
		panel.add(lblName);
		
		lblMobileNumber = new JLabel("MOBILE NUMBER :");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblMobileNumber.setBounds(90, 117, 124, 27);
		panel.add(lblMobileNumber);
		
		lblEmailid = new JLabel("EMAIL-ID :");
		lblEmailid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEmailid.setBounds(89, 157, 124, 27);
		panel.add(lblEmailid);
		
		lblDesignation = new JLabel("DESIGNATION :");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDesignation.setBounds(88, 205, 124, 27);
		panel.add(lblDesignation);
		
		tFieldName = new JTextField();
		tFieldName.setBounds(258, 79, 158, 24);
		panel.add(tFieldName);
		tFieldName.setColumns(10);
		
		tFieldMobileNum = new JTextField();
		tFieldMobileNum.setColumns(10);
		tFieldMobileNum.setBounds(258, 122, 158, 24);
		panel.add(tFieldMobileNum);
		
		tFieldMailId = new JTextField();
		tFieldMailId.setColumns(10);
		tFieldMailId.setBounds(258, 160, 158, 24);
		panel.add(tFieldMailId);
		
		cBoxDesignation = new JComboBox<Designation>();
		cBoxDesignation.setBounds(258, 205, 158, 25);
		panel.add(cBoxDesignation);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(128, 272, 85, 35);
		panel.add(btnAdd);
		
		btnReset = new JButton("RESET");
		btnReset.setBounds(274, 272, 85, 35);
		panel.add(btnReset);
		
		lblEditStoreDetails = new JLabel("EDIT STORE DETAILS");
		lblEditStoreDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditStoreDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEditStoreDetails.setBounds(10, 10, 484, 35);
		panel_2.add(lblEditStoreDetails);
		
		lblStoreName = new JLabel("NAME :");
		lblStoreName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreName.setBounds(86, 103, 124, 27);
		panel_2.add(lblStoreName);
		
		tFieldStoreName = new JTextField();
		tFieldStoreName.setColumns(10);
		tFieldStoreName.setBounds(254, 103, 158, 24);
		panel_2.add(tFieldStoreName);
		
		lblStoreDoor = new JLabel("DOOR NUMBER :");
		lblStoreDoor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreDoor.setBounds(86, 141, 124, 27);
		panel_2.add(lblStoreDoor);
		
		tFieldStoreDoor = new JTextField();
		tFieldStoreDoor.setColumns(10);
		tFieldStoreDoor.setBounds(254, 146, 158, 24);
		panel_2.add(tFieldStoreDoor);
		
		lblStoreArea = new JLabel("AREA :");
		lblStoreArea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreArea.setBounds(85, 181, 124, 27);
		panel_2.add(lblStoreArea);
		
		tFieldStoreArea = new JTextField();
		tFieldStoreArea.setColumns(10);
		tFieldStoreArea.setBounds(254, 184, 158, 24);
		panel_2.add(tFieldStoreArea);
		
		lblStoreCity = new JLabel("CITY :");
		lblStoreCity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreCity.setBounds(86, 232, 124, 27);
		panel_2.add(lblStoreCity);
		
		tFieldStoreCity = new JTextField();
		tFieldStoreCity.setColumns(10);
		tFieldStoreCity.setBounds(254, 232, 158, 24);
		panel_2.add(tFieldStoreCity);
		
		lblStoreState = new JLabel("STATE :");
		lblStoreState.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreState.setBounds(86, 272, 124, 27);
		panel_2.add(lblStoreState);
		
		tFieldStoreState = new JTextField();
		tFieldStoreState.setColumns(10);
		tFieldStoreState.setBounds(254, 277, 158, 24);
		panel_2.add(tFieldStoreState);
		
		lblStorePin = new JLabel("PINCODE :");
		lblStorePin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStorePin.setBounds(85, 322, 124, 27);
		panel_2.add(lblStorePin);
		
		tFieldStorePin = new JTextField();
		tFieldStorePin.setColumns(10);
		tFieldStorePin.setBounds(254, 325, 158, 24);
		panel_2.add(tFieldStorePin);
		
		lblGstNumber = new JLabel("GST NUMBER :");
		lblGstNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblGstNumber.setBounds(86, 377, 124, 27);
		panel_2.add(lblGstNumber);
		
		tFieldStoreGst = new JTextField();
		tFieldStoreGst.setColumns(10);
		tFieldStoreGst.setBounds(254, 377, 158, 24);
		panel_2.add(tFieldStoreGst);
		
		tFieldStoreMobile = new JTextField();
		tFieldStoreMobile.setColumns(10);
		tFieldStoreMobile.setBounds(254, 422, 158, 24);
		panel_2.add(tFieldStoreMobile);
		
		lblStoreMobile = new JLabel("MOBILE NUMBER :");
		lblStoreMobile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreMobile.setBounds(86, 417, 124, 27);
		panel_2.add(lblStoreMobile);
		
		lblStoreEmail = new JLabel("EMAIL-ID :");
		lblStoreEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreEmail.setBounds(85, 467, 124, 27);
		panel_2.add(lblStoreEmail);
		
		tFieldStoreMail = new JTextField();
		tFieldStoreMail.setColumns(10);
		tFieldStoreMail.setBounds(254, 470, 158, 24);
		panel_2.add(tFieldStoreMail);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setBounds(144, 538, 85, 35);
		panel_2.add(btnLoad);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(288, 538, 85, 35);
		panel_2.add(btnUpdate);
		
		//Filling the Designation ComboBox.
		
		cBoxDesignation.removeAllItems();
		for(Designation designation : Designation.values())
		{
			cBoxDesignation.addItem(designation);
		}
		cBoxDesignation.setSelectedItem(null);
		
		//Adding New Employee Details and Login Details
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Employee emp = new Employee();
				int id = 0;
				try {
					 id = emp.generateNewEmployeeId();
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				String name = tFieldName.getText();
				long mobileNum = Long.parseLong(tFieldMobileNum.getText());
				String emailId = tFieldMailId.getText();
				Designation designation = (Designation) cBoxDesignation.getSelectedItem();
				Employee employee = new Employee(id, name, mobileNum, emailId, designation);
				LoginInfo info = new LoginInfo();
				try {
					employee.addEmployee(employee);
					info.addNewLoginInfo(name);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				tFieldName.setText("");
				tFieldMobileNum.setText("");
				tFieldMailId.setText("");
				cBoxDesignation.setSelectedItem(null);
				
				JOptionPane.showMessageDialog(null, "EMPLOYEE ID : " + employee.getId() +"\n" + "EMPLOYEE NAME : " + employee.getName(), "EMPLOYEE ADDED", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tFieldName.setText("");
				tFieldMobileNum.setText("");
				tFieldMailId.setText("");
				cBoxDesignation.setSelectedItem(null);
				
			}
		});
		
		btnResetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Employee employee = new Employee();
				TreeMap<Integer, Employee> tMap = new TreeMap<Integer, Employee>();
				try {
					tMap = employee.loadEmployeeInfo();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				if(tMap.containsKey(Integer.parseInt(tFieldId.getText().toString())))
				{
					String pwd = tFieldPwd.getText().toString();
					LoginInfo info = new LoginInfo();
					try {
						info.changePassword(Integer.parseInt(tFieldId.getText().toString()), pwd);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				tFieldId.setText("");
				tFieldPwd.setText("");
				JOptionPane.showMessageDialog(null, "SUCCESS", "PASSWORD RESET", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tFieldId.setText("");
				tFieldPwd.setText("");
			}
		});
		
		btnLoad.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				Store store = new Store();
				try {
					store = store.getStoreDetails();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				tFieldStoreName.setText(store.getName());;
				Address address = store.getAddress();
				tFieldStoreDoor.setText(address.getDoorNo());;
				tFieldStoreArea.setText(address.getArea());;
				tFieldStoreCity.setText(address.getCity());;
				tFieldStoreState.setText(address.getState());;
				tFieldStorePin.setText(String.valueOf(address.getPincode()));
				tFieldStoreGst.setText(store.getGstNumber());;
				tFieldStoreMobile.setText(String.valueOf(store.getMobileNum()));;
				tFieldStoreMail.setText(store.getMailId());
				
				btnLoad.enable(false);
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = tFieldStoreName.getText();
				String doorNo = tFieldStoreDoor.getText();
				String area = tFieldStoreArea.getText();
				String city = tFieldStoreCity.getText();
				String state = tFieldStoreState.getText();
				int pincode = Integer.parseInt(tFieldStorePin.getText());
				Address address = new Address(doorNo, area, city, state, pincode);
				String gst = tFieldStoreGst.getText();
				long mobileNum = Long.parseLong(tFieldStoreMobile.getText());
				String mailId = tFieldStoreMail.getText();
				Store store = new Store(name, address, gst, mobileNum, mailId);
				try {
					store.updateStoreDetails(store);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
	}
}
