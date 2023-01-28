package operatorFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import employee.Employee;
import employee.EmployeeRepository;
import loginInfo.LoginInfo;
import loginInfo.LoginInfoRepository;
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

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import customer.Customer;
import customer.CustomerRepository;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JMenuItem myPerformance;
	private JMenuItem bill;
	private JMenuItem customerDetails;
	private JTextField tFieldProduct;
	private JList<String> list;
	private JLabel lblProduct;
	private JLabel lblQuantity;
	private JComboBox<Integer> cBoxQuantity;
	private JButton btnAddProd ;
	private JLabel lblEmailId;
	private JTextField tFieldEmail;
	private JButton btnAddCust;
	private JButton btnBill;
	private JButton btnPreviousBill;
	private JButton btnNextBill;
	private List<Product> prodList;
	private JButton btnEdit;
	private JButton btnDelete;
	private JLabel lblTotal;
	private JLabel lblShowTotal;
	private static int billNumber = 0;
	private static int i = 1;
	private static int custId;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		scrollPane.setBounds(551, 79, 538, 359);
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
		
		lblEmailId = new JLabel("CUSTOMER ID: ");
		lblEmailId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEmailId.setBounds(30, 38, 156, 25);
		panel_1.add(lblEmailId);
		
		tFieldEmail = new JTextField();
		tFieldEmail.setColumns(10);
		tFieldEmail.setBounds(210, 39, 166, 25);
		panel_1.add(tFieldEmail);
		
		btnAddCust = new JButton("CHECK");
		btnAddCust.setBounds(174, 93, 85, 31);
		panel_1.add(btnAddCust);
		
		btnBill = new JButton("DONE");
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBill.setBounds(767, 514, 85, 32);
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
		
		myPerformance = new JMenuItem("My Performance");
		bill = new JMenuItem("Bill");
		customerDetails = new JMenuItem("Customer Details");
		
		viewMenu.add(myPerformance);
		viewMenu.add(bill);
		viewMenu.add(customerDetails);
		
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		
		this.setJMenuBar(menuBar);
		
		
		// To Display Details such as Employee Name, date, time
		
		LoginInfoRepository logRep = new LoginInfoRepository();
		LoginInfo info = logRep.getCurrentUser();
		
		EmployeeRepository empRep = new EmployeeRepository();
		int id = Integer.parseInt(info.getName());
		Employee employee = empRep.findEmployeeById(id);
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
		
		btnEdit = new JButton("EDIT");
		btnEdit.setBounds(540, 515, 85, 32);
		contentPane.add(btnEdit);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(993, 515, 85, 32);
		contentPane.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(940, 455, 136, 32);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblShowTotal = new JLabel("");
		lblShowTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowTotal.setEnabled(false);
		lblShowTotal.setBounds(10, 0, 126, 32);
		panel_2.add(lblShowTotal);
		
		lblTotal = new JLabel("TOTAL :");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTotal.setBounds(863, 455, 111, 32);
		contentPane.add(lblTotal);
		
		JButton btnSaveBill = new JButton("ADD BILL");
		btnSaveBill.setBounds(735, 602, 148, 32);
		contentPane.add(btnSaveBill);
		
		// Button to Add Product
		
		btnAddProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model.setRowCount(0);
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
						model.setValueAt(updatedQuantity, index, 3);
						model.setValueAt(updatedNetPrice, index, 4);
						double total = getTotal(table);
						lblShowTotal.setText(String.valueOf(total));
					}
									
					
				}
				
			}
		});	
		
		// Button to Add Customer
		
		btnAddCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
			}
		});
		
		// Button to Save Bill to Queue
		
		btnSaveBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				billNumber = i;
				BillQueue bq = new BillQueue();
				int tempBNo = billNumber;
				String bDate = date.format(dateFormatter);
				String id = String.valueOf(custId);
				List<ProductInCart> list = null;
				try {
					list = getTableToList(table);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				double total = getTotal(table);
				Bill bill = new Bill(tempBNo,bDate,id,list, total);
				if(!bq.billNumberExists(tempBNo))
				{
					bq.addBill(bill);
				}
			
				clearTable(table);
				lblShowTotal.setText("");
				//lblNewLabel.setText(String.valueOf(billNumber)); 
				i++;
			}
		});
		
		//Button to Load Next Bill
		
		btnNextBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BillQueue bq = new BillQueue();
				Bill nextBill = bq.getNextBill(billNumber);			
				setTableUsingList(table, nextBill);
				double total = getTotal(table);
				lblShowTotal.setText(String.valueOf(total));
				billNumber = nextBill.getNumber();
				
			
			}
		});
				

		
		//Button to Load Previous Bill
		
		btnPreviousBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BillQueue bq = new BillQueue();
				Bill previousBill = bq.getPreviousBill(billNumber);		
				setTableUsingList(table, previousBill);
				double total = getTotal(table);
				lblShowTotal.setText(String.valueOf(total));
				billNumber = previousBill.getNumber();
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
	
	public static void setTableUsingList(JTable table,Bill bill )
	{
		List<ProductInCart> list = bill.getProductsinCart();
		int i = 0;
		for(ProductInCart x : list)
		{
			int sNo = x.getS_No();
			String name = x.getProduct().getName();
			double price = x.getProduct().getUnitPrice();
			int quantity = x.getQuantity();
			double netPrice = x.getNetPrice();
			
			while( i < table.getRowCount())
			{
				table.getModel().setValueAt(sNo, i, 0);
				table.getModel().setValueAt(name, i, 1);
				table.getModel().setValueAt(price, i, 2);
				table.getModel().setValueAt(quantity, i, 3);
				table.getModel().setValueAt(netPrice, i, 4);
				i++;
				break;
			}
		}
		
	}
	
	public static void clearTable(JTable table)
	{
		int i = 0;
		int j = 0;
		while( i < table.getRowCount())
		{
			while(j < table.getColumnCount())
			{
				table.getModel().setValueAt("", i, j);
				j++;
			}
			
			i++;
		}
		
	}
}

		
	
