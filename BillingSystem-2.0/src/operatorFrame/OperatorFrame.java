package operatorFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import employee.Employee;
import employee.EmployeeRepository;
import loginInfo.LoginInfo;
import loginInfo.LoginInfoRepository;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;

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
	private JTextField textField;
	

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
		setBounds(100, 100, 1164, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("BILLING");
		lblTitle.setBounds(10, 0, 1130, 79);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle);
		
		lblCurrentUser = new JLabel();
		lblCurrentUser.setBounds(20, 83, 269, 26);
		lblCurrentUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblCurrentUser);
		
		lblLogTime = new JLabel();
		lblLogTime.setBounds(20, 119, 269, 26);
		lblLogTime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblLogTime);
		
		lblDate = new JLabel();
		lblDate.setBounds(992, 83, 148, 26);
		lblDate.setText("LOGGED-IN @ : 22:40\n  DATE : 23-01-2023");
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblDate);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 165, 256, 253);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(276, 165, 256, 253);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(42, 25, 166, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 49, 166, 157);
		panel.add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(590, 165, 538, 479);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
		scrollPane.setViewportView(table);
		
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
		
		
		

		
		
	}
}
