package operatorFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import employee.Employee;
import employee.EmployeePerformance;
import employee.EmployeeRepository;
import employee.Performance;
import loginInfo.LoginInfo;
import loginInfo.LoginInfoRepository;
import mainFrame.MainFrame;
import managerFrame.LoadBillFrame;
import product.Product;
import product.ProductInCart;
import product.ProductRepository;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import bill.Bill;
import bill.BillQueue;
import bill.BillRepository;
import bill.PaymentType;
import bill.StoredBillInfo;
import bill.StoredBillInfoRepository;
import customer.Customer;
import customer.CustomerRepository;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.management.loading.PrivateClassLoader;
import javax.management.modelmbean.InvalidTargetObjectTypeException;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JSlider;

public class OperatorFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCurrentUser;
	private JLabel lblLogTime;
	private JLabel lblDate;
	private JTable table;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu viewMenu;
	private JMenu userMenu;
	private JMenuItem addCustomer;
	private JMenuItem myPerformance;
	private JMenuItem logOut;
	private JMenuItem bill;
	private JMenuItem customerDetails;
	private JTextField tFieldProduct;
	private JList<String> list;
	private JLabel lblProduct;
	private JLabel lblQuantity;
	private JComboBox<Integer> cBoxQuantity;
	private JButton btnAddProd ;
	private JLabel lblPhNumber;
	private JTextField tFieldPhNumber;
	private JButton btnSubmit;
	private JButton btnBill;
	private JButton btnPreviousBill;
	private JButton btnNextBill;
	private List<Product> prodList;
	private JButton btnEdit;
	private JButton btnDelete;
	private JLabel lblTotal;
	private JLabel lblShowTotal;
	private JButton btnClear;
	private JButton btnUpdateBill;
	private static int billNumber = 0;
	private static int i = 1;
	private static int custId = 0;
	private static int empId = 0;
	private static double oneDayCollection = 0;
	private static double currentSessionCollection = 0;
	private static Performance performance = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorFrame frame = new OperatorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public OperatorFrame() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1113, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("BILLING");
		lblTitle.setBounds(10, 0, 1080, 51);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle);
		
		lblCurrentUser = new JLabel();
		lblCurrentUser.setBounds(18, 43, 269, 26);
		lblCurrentUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblCurrentUser);
		
		lblLogTime = new JLabel();
		lblLogTime.setBounds(20, 61, 269, 26);
		lblLogTime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblLogTime);
		
		lblDate = new JLabel();
		lblDate.setBounds(962, 43, 288, 26);
		lblDate.setText("LOGGED-IN @ : 22:40\n  DATE : 23-01-2023");
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblDate);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 106, 428, 275);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel);
		panel.setLayout(null);
		
		tFieldProduct = new JTextField();
		tFieldProduct.setBounds(208, 27, 166, 25);
		panel.add(tFieldProduct);
		tFieldProduct.setColumns(10);
		
		lblProduct = new JLabel("PROD ID / NAME : ");
		lblProduct.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setBounds(28, 26, 156, 25);
		panel.add(lblProduct);
		
		JScrollPane scrollPaneList = new JScrollPane();
		scrollPaneList.setBounds(208, 52, 166, 95);
		panel.add(scrollPaneList);
		scrollPaneList.setVisible(false);
		
		list = new JList<String>();
		scrollPaneList.setViewportView(list);
		list.setVisible(false);
		
		lblQuantity = new JLabel("QUANTITY :");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblQuantity.setBounds(28, 169, 156, 25);
		panel.add(lblQuantity);
		
		cBoxQuantity = new JComboBox<Integer>();
		cBoxQuantity.setBounds(208, 170, 72, 25);
		panel.add(cBoxQuantity);
		
		btnAddProd = new JButton("ADD");
		btnAddProd.setBounds(169, 223, 85, 31);
		panel.add(btnAddProd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setBounds(551, 78, 538, 332);
		contentPane.add(scrollPane);
		
		table = new JTable();
		final Object[] row = new Object[5];
		Object[] column = {"S.No", "PRODUCT", "PRICE", "QUANTITY", "NETPRICE"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(80);
		columnModel.getColumn(4).setPreferredWidth(120);
		table.setRowHeight(30);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for(int i = 0; i < model.getColumnCount(); i++)
		{
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}	
		scrollPane.setViewportView(table);
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(18, 497, 428, 137);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblPhNumber = new JLabel("PHONE NUMBER : ");
		lblPhNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPhNumber.setBounds(30, 38, 156, 25);
		panel_1.add(lblPhNumber);
		
		tFieldPhNumber = new JTextField();
		tFieldPhNumber.setColumns(10);
		tFieldPhNumber.setBounds(210, 39, 166, 25);
		panel_1.add(tFieldPhNumber);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(174, 93, 85, 31);
		panel_1.add(btnSubmit);
		
		btnBill = new JButton("PAYMENT");
		btnBill.setBounds(735, 602, 148, 32);
		contentPane.add(btnBill);
		
		btnPreviousBill = new JButton("PREVIOUS BILL");
		btnPreviousBill.setBounds(540, 602, 140, 32);
		contentPane.add(btnPreviousBill);
		
		btnNextBill = new JButton("NEXT BILL");
		btnNextBill.setBounds(930, 602, 148, 32);
		contentPane.add(btnNextBill);
		
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		viewMenu = new JMenu("View");
		userMenu = new JMenu("User");
		addCustomer = new JMenuItem("Add Customer");
		bill = new JMenuItem("Bill");
		customerDetails = new JMenuItem("Customer Details");
		myPerformance = new JMenuItem("My Performance");
		logOut = new JMenuItem("LogOut");

		
		fileMenu.add(addCustomer);
		viewMenu.add(bill);
		viewMenu.add(customerDetails);
		userMenu.add(myPerformance);
		userMenu.add(logOut);
		
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		menuBar.add(userMenu);

		
		this.setJMenuBar(menuBar);
		
		
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
		
		// Working With Product
		
		tFieldProduct.addKeyListener(new KeyAdapter() { 
			@Override
			public void keyReleased(KeyEvent e) {
				
				DefaultListModel<String> dlm = new DefaultListModel<String>();
				if(tFieldProduct.getText().length() >= 1)
				{
					String enteredText = tFieldProduct.getText();
					ProductRepository prodRep = new ProductRepository();
					try {
						prodList = prodRep.getListOfProducts();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					for(Product x : prodList)
					{
						
						if(x.getName().contains(enteredText))  
						{
							scrollPaneList.setVisible(true);
							list.setVisible(true);
							dlm.addElement(x.getName());

						} 
					}
					
					list.setModel(dlm);
					prodList.clear();
				}
				else
				{
					dlm.clear();
					scrollPaneList.setVisible(false);
					list.setVisible(false);
				}
			}
		});
		
		// List Selection to TextField
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String selectedText = list.getSelectedValue().toString();
				tFieldProduct.setText(selectedText);
				scrollPaneList.setVisible(false);
				list.setVisible(false);
				
			}
		});
		
		// Adding Values to Quantity ComboBox
		
		cBoxQuantity.addItem(1);
		cBoxQuantity.addItem(2);
		cBoxQuantity.addItem(3);
		cBoxQuantity.addItem(4);
		cBoxQuantity.addItem(5);
		cBoxQuantity.addItem(6);
		cBoxQuantity.addItem(7);
		cBoxQuantity.addItem(8);
		cBoxQuantity.addItem(9);
		cBoxQuantity.addItem(10);
		cBoxQuantity.setSelectedItem(null);
		
		btnEdit = new JButton("EDIT QUANTITY");
		btnEdit.setBounds(540, 479, 140, 32);
		contentPane.add(btnEdit);
		
		btnDelete = new JButton("DELETE ITEM");
		btnDelete.setBounds(930, 479, 148, 32);
		contentPane.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(940, 427, 136, 32);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblShowTotal = new JLabel("");
		lblShowTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowTotal.setEnabled(false);
		lblShowTotal.setBounds(10, 0, 126, 32);
		panel_2.add(lblShowTotal);
		
		lblTotal = new JLabel("TOTAL :");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTotal.setBounds(863, 427, 111, 32);
		contentPane.add(lblTotal);
		
		JButton btnSaveBill = new JButton("ADD BILL");
		btnSaveBill.setBounds(618, 537, 148, 32);
		contentPane.add(btnSaveBill);
		
		btnClear = new JButton("CLEAR");
		btnClear.setBounds(735, 479, 148, 32);
		contentPane.add(btnClear);
		
		btnUpdateBill = new JButton("UPDATE BILL");
		btnUpdateBill.setBounds(852, 537, 148, 32);
		contentPane.add(btnUpdateBill);
		
		// Button to Add Product
		
		btnAddProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(tFieldProduct.getText().isEmpty() || cBoxQuantity.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "EMPTY FIELDS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else
				{  
					String name = tFieldProduct.getText();
					ProductRepository prodRep = new ProductRepository();
					Product product = null;
					try {
						product = prodRep.getProductUsingName(name);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					int s_No = model.getRowCount() + 1;
					int quantity =Integer.parseInt(cBoxQuantity.getSelectedItem().toString());
					double netPrice = product.getUnitPrice() * quantity;
					
					ProductInCart prodInCart = new ProductInCart(s_No, product, quantity, netPrice);
					
					row[0] = prodInCart.getS_No();
					row[1] = prodInCart.getProduct().getName();
					row[2] = prodInCart.getProduct().getUnitPrice();
					row[3] = prodInCart.getQuantity();
					row[4] = prodInCart.getNetPrice();
					
					model.addRow(row);
					
					cBoxQuantity.setSelectedItem(null);
					tFieldProduct.setText(null);
					String total = String.valueOf(getTotal(table));
					lblShowTotal.setText(total);
				}
				
				
			}
		});
		
		// Delete a Selected Row
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1)
				{
					int temp = table.getSelectedRow();
					model.removeRow(temp);
					String total = String.valueOf(getTotal(table));
					lblShowTotal.setText(total);
					updateSerialNum(table);
				}
				else {
					JOptionPane.showMessageDialog(null, "SELECT A PRODUCT TO DELETE");
				}
			}
		});
		
		// Editing Qauntities in JTable
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1)
				{
					int index = table.getSelectedRow();
					
					JComboBox<Integer> cBoxEditQuantity = new JComboBox<Integer>();
					cBoxEditQuantity.addItem(1);
					cBoxEditQuantity.addItem(2);
					cBoxEditQuantity.addItem(3);
					cBoxEditQuantity.addItem(4);
					cBoxEditQuantity.addItem(5);
					cBoxEditQuantity.addItem(6);
					cBoxEditQuantity.addItem(7);
					cBoxEditQuantity.addItem(8);
					cBoxEditQuantity.addItem(9);
					cBoxEditQuantity.addItem(10);
									
	
					int input;
					String updatedQuantity = "";
					input  = JOptionPane.showConfirmDialog(null, cBoxEditQuantity, "EDIT QUANTITY", JOptionPane.DEFAULT_OPTION);
					
					if(input == JOptionPane.OK_OPTION )
					{
						updatedQuantity = cBoxEditQuantity.getSelectedItem().toString();
						int quantity = Integer.parseInt(updatedQuantity);
						double price = (double)model.getValueAt(index, 2);
						double updatedNetPrice = price * quantity;						
						model.setValueAt(quantity, index, 3);
						model.setValueAt(updatedNetPrice, index, 4);
						double total = getTotal(table);
						lblShowTotal.setText(String.valueOf(total));
					}
									
					
				}
				else {
					JOptionPane.showMessageDialog(null, "SELECT A PRODUCT TO EDIT QUANTITY");
				}
				
			}
		});	
		
		// Button to Add Customer to Bill
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				long phNumber = Long.parseLong(tFieldPhNumber.getText());;
				CustomerRepository custRep = new CustomerRepository();
				try {
					if(custRep.isPhoneNumberValid(phNumber))
					{
						custId = custRep.getIdUsingPhNumber(phNumber);
						JOptionPane.showMessageDialog(null, "CUSTOMER ADDED TO BILL", "SUCCESS", JOptionPane.OK_OPTION);
						tFieldPhNumber.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(null,  "INVALID PHONE NUMBER", "ERROR", JOptionPane.OK_OPTION);
					}
				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}
				
				
	
			}
		});
		
		// Button to Add Bill to Queue
		
		btnSaveBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(table.getRowCount() >= 1 && custId != 0)
				{
					billNumber = i;
					BillQueue bq = new BillQueue();
					int tempBNo = billNumber;
					String bDate = date.format(dateFormatter);
					int id = custId;
					List<ProductInCart> list = null;
					try {
						list = getTableToList(table);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					double total = getTotal(table);
					Bill bill = new Bill(String.valueOf(tempBNo), bDate, id, empId, list, total, PaymentType.CASH);
					if(!bq.billNumberExists(String.valueOf(tempBNo)))
					{
						bq.addBill(bill);
					}
			
					model.setRowCount(0);
					clearTable(table);
					lblShowTotal.setText("");
					i++;
					custId = 0;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "EMPTY BILL / CUSTOMER ID", "ERROR", JOptionPane.OK_OPTION);
				}
		
			}
		});
		
		//Button to Update Existing Bill
		
		btnUpdateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BillQueue queue = new BillQueue();
				if(queue.billNumberExists(String.valueOf(billNumber)) && table.getRowCount() != 0)
				{
					int tempBNo = billNumber;
					String bDate = date.format(dateFormatter);
					int id = custId;
					List<ProductInCart> list = null;
					try {
						list = getTableToList(table);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					double total = getTotal(table);
					Bill currentBill = new Bill(String.valueOf(tempBNo),bDate,id, empId, list, total, PaymentType.CASH);
					queue.updateBill(currentBill,String.valueOf(billNumber));
				}
				else {
					JOptionPane.showMessageDialog(null, "NOTHING TO UPFATE / BILL NOT IN QUEUE");
				}

				
			}
		});
		
		//Button to Load Next Bill
		
		btnNextBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model.setRowCount(0);
				BillQueue bq = new BillQueue();
				int noOfBills = bq.getBillsInListCount();
				if(noOfBills >= 1)
				{
					Bill nextBill = bq.getNextBill(String.valueOf(billNumber));			
					setTableUsingList(table, row, nextBill);
					double total = getTotal(table);
					lblShowTotal.setText(String.valueOf(total));
					billNumber = Integer.parseInt(nextBill.getNumber());
				}
				else {
					JOptionPane.showMessageDialog(null, "NO BILL IN QUEUE");
				}
			
			}
		});
				

		
		//Button to Load Previous Bill
		
		btnPreviousBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model.setRowCount(0);
				BillQueue bq = new BillQueue();
				int noOfBills = bq.getBillsInListCount();
				if(noOfBills >= 1)
				{
					Bill previousBill = bq.getPreviousBill(String.valueOf(billNumber));		
					setTableUsingList(table, row, previousBill);
					double total = getTotal(table);
					lblShowTotal.setText(String.valueOf(total));
					billNumber = Integer.parseInt(previousBill.getNumber());
				}
				else {
					JOptionPane.showMessageDialog(null, "NO BILL IN QUEUE");
				}
			}
		});
		
		// Button to Clear Table Contents
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				model.setRowCount(0);
				lblShowTotal.setText("");
			}
		});
		
		// Menu Add Customer
		
		addCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddCustomerFrame acFrame = new AddCustomerFrame();
				acFrame.setVisible(true);
			}
		});
		
		// Menu View Details of Customer
		
		customerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewCustomerFrame vcFrame = new ViewCustomerFrame();
				vcFrame.setVisible(true);
			}
		});
		
		// Menu View Performance
		
		myPerformance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoadTodaysCollectionAndPerformance(empId);
				JOptionPane.showMessageDialog(null, "Performance : " + performance.toString() + "\nAmount Collected : " + oneDayCollection);
			}
		});
		
		// Menu LogOut
		
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BillQueue queue = new BillQueue();
				int noOfBills = queue.getBillsInListCount();
				int input = 0;
				if(noOfBills >= 1)
				{
					JOptionPane pane = new JOptionPane("BILLS IN QUEUE WILL BE DELETED .\nDO YOU WANT TO EXIT?", JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
					JDialog dialog = pane.createDialog(null, "WARNING");
					dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					dialog.setVisible(true);
					input = (Integer)pane.getValue();
	
				}
				
				if(input != JOptionPane.CANCEL_OPTION)
				{
					LoadTodaysCollectionAndPerformance(empId);
					JOptionPane.showMessageDialog(null, "AMOUNT BILLED\n" + "THIS SESSION : " + currentSessionCollection + "\nTODAY : " + oneDayCollection);
					dispose();
					MainFrame mFrame = new MainFrame();
					mFrame.setVisible(true);
				}

			}
		});
		
		// Add Bill to File
		
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getRowCount() >= 1)
				{
					
					JComboBox<PaymentType> cBoxPayType = new JComboBox<PaymentType>();
					PaymentType[] pt = PaymentType.values();
					for(PaymentType x : pt)
					{
						cBoxPayType.addItem(x);
					}
					int input;
					PaymentType payType = null;
					input  = JOptionPane.showConfirmDialog(null, cBoxPayType, "SELECT PAYMENT TYPE", JOptionPane.DEFAULT_OPTION);
					if(input == JOptionPane.OK_OPTION )
					{
						payType = (PaymentType)(cBoxPayType.getSelectedItem());
					}
					
					BillQueue queue = new BillQueue();
					Bill tempBill = queue.popBillOutOfQueue(String.valueOf(billNumber));
					BillRepository billRep = new BillRepository();
					StoredBillInfoRepository storedBillRep = new StoredBillInfoRepository();
					
					String number = "";
					try {
						number = billRep.generateBillNumber();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					Bill finalBill = new Bill(number, tempBill.getDate(), tempBill.getCustomerId(), tempBill.getEmpId(), tempBill.getProductsinCart(), tempBill.getTotal(), payType);
					StoredBillInfo storedBillInfo = new StoredBillInfo(number, tempBill.getDate(), tempBill.getCustomerId(), tempBill.getEmpId());
					
					try {
						
						billRep.storeBill(finalBill);
						storedBillRep.writeNewBillInfo(storedBillInfo);
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					queue.removeBill(String.valueOf(billNumber));
					int billCount = queue.getBillsInListCount();
					if(billCount >=1)
					{
						billNumber = Integer.parseInt(queue.getExitingBillNumber());
					}					
					model.setRowCount(0);
					lblShowTotal.setText("");
					
					currentSessionCollection += tempBill.getTotal();
				}
				else {
	
					JOptionPane.showMessageDialog(null, "SELECT A BILL FIRST");
				}

				
			}
		});
		

		
	
		
		
		
			
		}
		
	
		
	
	public static double getTotal(JTable table)
	{
		double total = 0;
		for(int  i =0; i < table.getRowCount(); i++)
		{
			double temp = (double) table.getModel().getValueAt(i, 4);
			total += temp;			
		}
		
		return total;
	}
	
	public static void updateSerialNum(JTable table)
	{
		for(int j= 0; j <table.getRowCount(); j++ )
		{
			int temp = j+1;
			table.getModel().setValueAt(temp, j, 0);
		}

	}
	
	public static List<ProductInCart> getTableToList(JTable table) throws IOException
	{
		List<ProductInCart> list = new ArrayList<ProductInCart>();
		for(int i = 0; i < table.getRowCount(); i++)
		{
			int s_No = (int)table.getModel().getValueAt(i, 0);
			String pName = (String) table.getModel().getValueAt(i, 1);
			ProductRepository prodRep = new ProductRepository();
			Product product = prodRep.getProductUsingName(pName);
			int quantity = (int)table.getModel().getValueAt(i, 3);
			double netPrice = (double)table.getModel().getValueAt(i, 4);
			ProductInCart prodCart = new ProductInCart(s_No, product, quantity, netPrice);
			list.add(prodCart);
		}
		return list;
	}
	
	public static void setTableUsingList(JTable table,Object[] row, Bill bill )
	{
		List<ProductInCart> list = bill.getProductsinCart();
		int i = 0;
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(ProductInCart x : list)
		{
						
			while(i < list.size())
			{				
				row[0] = x.getS_No();
				row[1] = x.getProduct().getName();
				row[2] = x.getProduct().getUnitPrice();
				row[3] = x.getQuantity();
				row[4] = x.getNetPrice();
				
				model.addRow(row);
				i++;
				break;
			}
		}
		
	}
	
	public static void clearTable(JTable table)
	{
		int i = 0;
		
		while( i < table.getRowCount())
		{
			int j = 0;
			while(j < table.getColumnCount())
			{
				table.getModel().setValueAt("", i, j);
				j++;
			}
			
			i++;
		}
	
	}
	
	public static void LoadTodaysCollectionAndPerformance(int id)
	{		
		EmployeePerformance empPer = new EmployeePerformance();
		try {
			
			oneDayCollection = empPer.getTodaysCollection(id);
			performance = empPer.getToadysPerformance(id);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

		
	
