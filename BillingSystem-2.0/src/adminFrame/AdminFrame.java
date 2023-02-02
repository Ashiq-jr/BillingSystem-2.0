package adminFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import employee.Designation;
import employee.Employee;
import employee.EmployeeRepository;
import loginInfo.LoginInfo;
import loginInfo.LoginInfoRepository;
import mainFrame.MainFrame;
import store.Address;
import store.Store;
import store.StoreRepository;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblCurrentUser;
	private JLabel lblLogTime;
	private JLabel lblDate;
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
	private JMenuBar menuBar;
	private JMenu userMenu;
	private JMenuItem logOut;
	private JLabel lblTitle;
	private static int empId = 0;

	public AdminFrame() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1055, 747);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(11, 105, 504, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBounds(526, 105, 504, 571);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_3.setBounds(0, 303, 504, 268);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		lblTitle = new JLabel("ADMIN OPERATIONS");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(11, 0, 1020, 42);
		contentPane.add(lblTitle);
		
		lblCurrentUser = new JLabel();
		lblCurrentUser.setBounds(10, 43, 269, 26);
		lblCurrentUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblCurrentUser);
		
		lblLogTime = new JLabel();
		lblLogTime.setBounds(10, 69, 269, 26);
		lblLogTime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblLogTime);
		
		lblDate = new JLabel();
		lblDate.setBounds(904, 43, 137, 26);
		lblDate.setText("DATE : 23-01-2023");
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblDate);
			
		lblAddEmployee = new JLabel("ADD EMPLOYEE");
		lblAddEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAddEmployee.setBounds(11, 17, 484, 35);
		panel.add(lblAddEmployee);
		
		lblPasswordReset = new JLabel("RESET PASSWORD");
		lblPasswordReset.setBounds(14, 14, 484, 35);
		panel_3.add(lblPasswordReset);
		lblPasswordReset.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordReset.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		lblEmployeeId = new JLabel("EMPLOYEE ID  :");
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEmployeeId.setBounds(88, 72, 124, 27);
		panel_3.add(lblEmployeeId);
		
		tFieldId = new JTextField();
		tFieldId.setColumns(10);
		tFieldId.setBounds(256, 72, 158, 24);
		panel_3.add(tFieldId);
		
		lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPassword.setBounds(88, 127, 124, 27);
		panel_3.add(lblPassword);
		
		tFieldPwd = new JTextField();
		tFieldPwd.setColumns(10);
		tFieldPwd.setBounds(256, 132, 158, 24);
		panel_3.add(tFieldPwd);
		
		btnResetPassword = new JButton("RESET PASSWORD");
		btnResetPassword.setBounds(100, 191, 125, 35);
		panel_3.add(btnResetPassword);
		
		btnClear = new JButton("CLEAR");
		btnClear.setBounds(266, 191, 125, 35);
		panel_3.add(btnClear);
		
		lblName = new JLabel("NAME :");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblName.setBounds(88, 80, 124, 27);
		panel.add(lblName);
		
		lblMobileNumber = new JLabel("MOBILE NUMBER :");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblMobileNumber.setBounds(88, 118, 124, 27);
		panel.add(lblMobileNumber);
		
		lblEmailid = new JLabel("EMAIL-ID :");
		lblEmailid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEmailid.setBounds(87, 158, 124, 27);
		panel.add(lblEmailid);
		
		lblDesignation = new JLabel("DESIGNATION :");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDesignation.setBounds(86, 206, 124, 27);
		panel.add(lblDesignation);
		
		tFieldName = new JTextField();
		tFieldName.setBounds(256, 80, 158, 24);
		panel.add(tFieldName);
		tFieldName.setColumns(10);
		
		tFieldMobileNum = new JTextField();
		tFieldMobileNum.setColumns(10);
		tFieldMobileNum.setBounds(256, 123, 158, 24);
		panel.add(tFieldMobileNum);
		
		tFieldMailId = new JTextField();
		tFieldMailId.setColumns(10);
		tFieldMailId.setBounds(256, 161, 158, 24);
		panel.add(tFieldMailId);
		
		cBoxDesignation = new JComboBox<Designation>();
		cBoxDesignation.setBounds(256, 206, 158, 25);
		panel.add(cBoxDesignation);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(129, 259, 85, 35);
		panel.add(btnAdd);
		
		btnReset = new JButton("RESET");
		btnReset.setBounds(275, 259, 85, 35);
		panel.add(btnReset);
		
		lblEditStoreDetails = new JLabel("EDIT STORE DETAILS");
		lblEditStoreDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditStoreDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEditStoreDetails.setBounds(12, 13, 484, 35);
		panel_2.add(lblEditStoreDetails);
		
		lblStoreName = new JLabel("NAME :");
		lblStoreName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreName.setBounds(85, 70, 124, 27);
		panel_2.add(lblStoreName);
		
		tFieldStoreName = new JTextField();
		tFieldStoreName.setColumns(10);
		tFieldStoreName.setBounds(253, 70, 158, 24);
		panel_2.add(tFieldStoreName);
		
		lblStoreDoor = new JLabel("DOOR NUMBER :");
		lblStoreDoor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreDoor.setBounds(85, 108, 124, 27);
		panel_2.add(lblStoreDoor);
		
		tFieldStoreDoor = new JTextField();
		tFieldStoreDoor.setColumns(10);
		tFieldStoreDoor.setBounds(253, 113, 158, 24);
		panel_2.add(tFieldStoreDoor);
		
		lblStoreArea = new JLabel("AREA :");
		lblStoreArea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreArea.setBounds(84, 148, 124, 27);
		panel_2.add(lblStoreArea);
		
		tFieldStoreArea = new JTextField();
		tFieldStoreArea.setColumns(10);
		tFieldStoreArea.setBounds(253, 151, 158, 24);
		panel_2.add(tFieldStoreArea);
		
		lblStoreCity = new JLabel("CITY :");
		lblStoreCity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreCity.setBounds(85, 199, 124, 27);
		panel_2.add(lblStoreCity);
		
		tFieldStoreCity = new JTextField();
		tFieldStoreCity.setColumns(10);
		tFieldStoreCity.setBounds(253, 199, 158, 24);
		panel_2.add(tFieldStoreCity);
		
		lblStoreState = new JLabel("STATE :");
		lblStoreState.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreState.setBounds(85, 239, 124, 27);
		panel_2.add(lblStoreState);
		
		tFieldStoreState = new JTextField();
		tFieldStoreState.setColumns(10);
		tFieldStoreState.setBounds(253, 244, 158, 24);
		panel_2.add(tFieldStoreState);
		
		lblStorePin = new JLabel("PINCODE :");
		lblStorePin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStorePin.setBounds(84, 289, 124, 27);
		panel_2.add(lblStorePin);
		
		tFieldStorePin = new JTextField();
		tFieldStorePin.setColumns(10);
		tFieldStorePin.setBounds(253, 292, 158, 24);
		panel_2.add(tFieldStorePin);
		
		lblGstNumber = new JLabel("GST NUMBER :");
		lblGstNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblGstNumber.setBounds(85, 344, 124, 27);
		panel_2.add(lblGstNumber);
		
		tFieldStoreGst = new JTextField();
		tFieldStoreGst.setColumns(10);
		tFieldStoreGst.setBounds(253, 344, 158, 24);
		panel_2.add(tFieldStoreGst);
		
		tFieldStoreMobile = new JTextField();
		tFieldStoreMobile.setColumns(10);
		tFieldStoreMobile.setBounds(253, 389, 158, 24);
		panel_2.add(tFieldStoreMobile);
		
		lblStoreMobile = new JLabel("MOBILE NUMBER :");
		lblStoreMobile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreMobile.setBounds(85, 384, 124, 27);
		panel_2.add(lblStoreMobile);
		
		lblStoreEmail = new JLabel("EMAIL-ID :");
		lblStoreEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblStoreEmail.setBounds(84, 434, 124, 27);
		panel_2.add(lblStoreEmail);
		
		tFieldStoreMail = new JTextField();
		tFieldStoreMail.setColumns(10);
		tFieldStoreMail.setBounds(253, 437, 158, 24);
		panel_2.add(tFieldStoreMail);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setBounds(126, 500, 85, 35);
		panel_2.add(btnLoad);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(270, 500, 85, 35);
		panel_2.add(btnUpdate);
		
		// To Display Details such as Employee Name, date, time
		
		LoginInfoRepository logRep = new LoginInfoRepository();
		LoginInfo info = logRep.getCurrentUser();
		
		EmployeeRepository empRep = new EmployeeRepository();
		empId = Integer.parseInt(info.getName());
		Employee employee = empRep.findEmployeeById(empId);
		lblCurrentUser.setText("Welcome :" + " " + employee.getName() + " ( " + employee.getDesignation() + " )" );
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH : mm");;
		lblLogTime.setText("LOGGED-IN @ : "  + time.format(timeFormatter));
		lblDate.setText("DATE : " + date.format(dateFormatter));
		
		//Adding LogOut in Menu Bar and LogOut Action.
				menuBar = new JMenuBar();
				
				userMenu = new JMenu("User");
				logOut = new JMenuItem("LogOut");
				userMenu.add(logOut);
				menuBar.add(userMenu);
				this.setJMenuBar(menuBar);
				logOut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JOptionPane pane = new JOptionPane("DO YOU WANT TO EXIT?", JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
						JDialog dialog = pane.createDialog(null, "WARNING");
						dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
						dialog.setVisible(true);
						int input = (Integer)pane.getValue();
						
						if(input == JOptionPane.OK_OPTION)
						{
							dispose();
							MainFrame mFrame = new MainFrame();
							mFrame.setVisible(true);
						}
					}
				});
		
		//Filling the Designation ComboBox.
		
		cBoxDesignation.removeAllItems();
		for(Designation designation : Designation.values())
		{
			if(designation != designation.ADMIN)
			{
				cBoxDesignation.addItem(designation);
			}
		}
		cBoxDesignation.setSelectedItem(null);
			
		//Adding New Employee Details and Login Details
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tFieldName.getText().toString().isEmpty() || cBoxDesignation.getSelectedItem() == null || tFieldMailId.getText().toString().isEmpty() || tFieldName.getText().toString().isEmpty())
				{	
					JOptionPane.showMessageDialog(null, "EMPTY FIELDS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					EmployeeRepository empRep = new EmployeeRepository();
					int id = 0;
					try {
						 id = empRep.generateNewEmployeeId();
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					}
					String name = tFieldName.getText();
					long mobileNum = Long.parseLong(tFieldMobileNum.getText());
					String emailId = tFieldMailId.getText();
					Designation designation = (Designation) cBoxDesignation.getSelectedItem();
					Employee employee = new Employee(id, name, mobileNum, emailId, designation);
					LoginInfoRepository infoRep = new LoginInfoRepository();
					try {
						empRep.addEmployee(employee);
						infoRep.addNewLoginInfo(name);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					tFieldName.setText("");
					tFieldMobileNum.setText("");
					tFieldMailId.setText("");
					cBoxDesignation.setSelectedItem(null);
					
					JOptionPane.showMessageDialog(null, "EMPLOYEE ID : " + employee.getId() +"\n" + "EMPLOYEE NAME : " + employee.getName(), "EMPLOYEE ADDED", JOptionPane.INFORMATION_MESSAGE);
				}
				

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
				
				if(tFieldId.getText().toString().isEmpty() || tFieldPwd.getText().toString().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "EMPTY FIELDS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					EmployeeRepository empRep = new EmployeeRepository();
					TreeMap<Integer, Employee> tMap = new TreeMap<Integer, Employee>();
					try {
						tMap = empRep.loadEmployeeInfo();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					if(tMap.containsKey(Integer.parseInt(tFieldId.getText().toString())))
					{
						String pwd = tFieldPwd.getText().toString();
						LoginInfoRepository infoRep = new LoginInfoRepository();
						try {
							infoRep.changePassword(Integer.parseInt(tFieldId.getText().toString()), pwd);
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
				
				StoreRepository storeRep = new StoreRepository();
				Store store = null;
				try {
					store = storeRep.loadStoreDetails();
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
				
				if(tFieldStoreName.getText().toString().isEmpty() || tFieldStoreDoor.getText().toString().isEmpty() || tFieldStoreArea.getText().toString().isEmpty() || tFieldStoreCity.getText().toString().isEmpty() || tFieldStoreState.getText().toString().isEmpty() ||
						tFieldStorePin.getText().toString().isEmpty() || tFieldStoreGst.getText().toString().isEmpty() || tFieldStoreMobile.getText().toString().isEmpty() || tFieldStoreMail.getText().toString().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "EMPTY FIELDS", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
				else {
					
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
					StoreRepository storeRep = new StoreRepository();
					try {
						storeRep.updateStoreDetails(store);
						JOptionPane.showMessageDialog(null, "SUCCESS", "STORE DETAILS UPDATED", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					tFieldStoreName.setText("");
					tFieldStoreDoor.setText("");
					tFieldStoreArea.setText("");
					tFieldStoreCity.setText("");
					tFieldStoreState.setText("");
					tFieldStorePin.setText("");
					tFieldStoreGst.setText("");
					tFieldStoreMobile.setText("");
					tFieldStoreMail.setText("");
				}
				
				
			}
		});
		
	}
}
