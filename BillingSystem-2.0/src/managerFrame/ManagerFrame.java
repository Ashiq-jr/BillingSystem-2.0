package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import bill.Bill;
import bill.BillRepository;
import bill.StoredBillInfoRepository;
import category.Category;
import category.CategoryRepository;
import mainFrame.MainFrame;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblAddProduct;
	private JLabel lblAddCategory;
	private JLabel lblAddSubCategory;
	private JButton btnAddProduct;
	private JButton btnAddProdCat;
	private JButton btnAddSubCategory;
	private JLabel lblTitle;
	private JTextField tFieldCategory;
	private JLabel lblAddTaxCat;
	private JButton btnAddTaxCat;
	private JPanel panel_1;		
	private JLabel lblRemoveACategory;
	private JLabel lblRemoveSubCategory;
	private JButton btnRemoveProdCat;
	private JButton btnRemoveSubCat;
	private JLabel lblRemoveTaxCategory;
	private JButton btnRemoveTaxCat;
	private JLabel lblEditTaxPercentage;
	private JButton btnEditTaxPercent;
	private JTextField tFieldEnterBillNumber;
	private JMenuBar menuBar;
	private JMenu userMenu;
	private JMenuItem logOut;
	private JLabel lblViewCustomer;
	private JButton btnLoadCustmer;
	private JLabel lblEmployeePerformance;
	private JButton btnLoadEmpPerformance;
	
	
	private static List<String> billNumbersList = new ArrayList<String>();


	public ManagerFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 865, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(131, 80, 578, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblAddProduct = new JLabel("ADD PRODUCT  :");
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblAddProduct.setBounds(45, 24, 186, 29);
		panel.add(lblAddProduct);
		
		lblAddCategory = new JLabel("ADD PRODUCT CATEGORY  :");
		lblAddCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblAddCategory.setBounds(45, 70, 186, 29);
		panel.add(lblAddCategory);
		
		lblAddSubCategory = new JLabel("ADD SUB CATEGORY  :");
		lblAddSubCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblAddSubCategory.setBounds(45, 120, 186, 29);
		panel.add(lblAddSubCategory);
		
		btnAddProduct = new JButton("LOAD");
		btnAddProduct.setBounds(242, 25, 85, 26);
		panel.add(btnAddProduct);
		
		btnAddProdCat = new JButton("ADD\r\n");
		btnAddProdCat.setBounds(454, 70, 85, 26);
		panel.add(btnAddProdCat);
		
		btnAddSubCategory = new JButton("LOAD");
		btnAddSubCategory.setBounds(242, 122, 85, 26);
		panel.add(btnAddSubCategory);
		
		tFieldCategory = new JTextField();
		tFieldCategory.setBounds(242, 72, 179, 23);
		panel.add(tFieldCategory);
		tFieldCategory.setColumns(10);
		
		lblAddTaxCat = new JLabel("ADD TAX CATEGORY  :");
		lblAddTaxCat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblAddTaxCat.setBounds(44, 166, 186, 29);
		panel.add(lblAddTaxCat);
		
		btnAddTaxCat = new JButton("LOAD\r\n");
		btnAddTaxCat.setBounds(242, 168, 85, 26);
		panel.add(btnAddTaxCat);
		
		lblTitle = new JLabel("MANAGER OPERATIONS");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 831, 77);
		contentPane.add(lblTitle);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(25, 323, 373, 356);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblRemoveACategory = new JLabel("REMOVE A CATEGORY  :");
		lblRemoveACategory.setBounds(34, 32, 186, 15);
		lblRemoveACategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_1.add(lblRemoveACategory);
		
		lblRemoveSubCategory = new JLabel("REMOVE SUB CATEGORY  :");
		lblRemoveSubCategory.setBounds(33, 105, 170, 15);
		lblRemoveSubCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_1.add(lblRemoveSubCategory);
		
		btnRemoveProdCat = new JButton("LOAD\r\n");
		btnRemoveProdCat.setBounds(249, 27, 85, 26);
		panel_1.add(btnRemoveProdCat);
		
		btnRemoveSubCat = new JButton("LOAD\r\n");
		btnRemoveSubCat.setBounds(249, 100, 85, 26);
		panel_1.add(btnRemoveSubCat);
		
		lblRemoveTaxCategory = new JLabel("REMOVE TAX CATEGORY  :");
		lblRemoveTaxCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblRemoveTaxCategory.setBounds(34, 175, 170, 15);
		panel_1.add(lblRemoveTaxCategory);
		
		btnRemoveTaxCat = new JButton("LOAD\r\n");
		btnRemoveTaxCat.setBounds(249, 170, 85, 26);
		panel_1.add(btnRemoveTaxCat);
		
		lblEditTaxPercentage = new JLabel("EDIT TAX PERCENTAGE:");
		lblEditTaxPercentage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEditTaxPercentage.setBounds(33, 242, 170, 15);
		panel_1.add(lblEditTaxPercentage);
		
		btnEditTaxPercent = new JButton("LOAD\r\n");
		btnEditTaxPercent.setBounds(248, 237, 85, 26);
		panel_1.add(btnEditTaxPercent);
		
		JLabel lblEditProduct = new JLabel("EDIT A PRODUCT :");
		lblEditProduct.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEditProduct.setBounds(35, 305, 170, 15);
		panel_1.add(lblEditProduct);
		
		JButton btnEditProduct = new JButton("LOAD\r\n");
		btnEditProduct.setBounds(251, 301, 85, 26);
		panel_1.add(btnEditProduct);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1_1.setBounds(451, 323, 373, 356);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblViewBill = new JLabel("VIEW BILL :");
		lblViewBill.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblViewBill.setBounds(31, 20, 85, 29);
		panel_1_1.add(lblViewBill);
		
		tFieldEnterBillNumber = new JTextField();
		tFieldEnterBillNumber.setColumns(10);
		tFieldEnterBillNumber.setBounds(165, 24, 116, 23);
		panel_1_1.add(tFieldEnterBillNumber);
		
		JButton btnView = new JButton("VIEW");
		btnView.setBounds(291, 22, 72, 26);
		panel_1_1.add(btnView);
		
		lblViewCustomer = new JLabel("VIEW CUSTOMER :");
		lblViewCustomer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblViewCustomer.setBounds(31, 83, 126, 29);
		panel_1_1.add(lblViewCustomer);
		
		btnLoadCustmer = new JButton("VIEW");
		btnLoadCustmer.setBounds(225, 85, 72, 26);
		panel_1_1.add(btnLoadCustmer);
		
		lblEmployeePerformance = new JLabel("EMPLOYEE PERFORMANCE :");
		lblEmployeePerformance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEmployeePerformance.setBounds(31, 143, 185, 29);
		panel_1_1.add(lblEmployeePerformance);
		
		btnLoadEmpPerformance = new JButton("VIEW");
		btnLoadEmpPerformance.setBounds(225, 145, 72, 26);
		panel_1_1.add(btnLoadEmpPerformance);
		
		JLabel lblTotalCollectionFor = new JLabel("TOTAL AMOUNT COLLECTED :");
		lblTotalCollectionFor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTotalCollectionFor.setBounds(31, 214, 185, 29);
		panel_1_1.add(lblTotalCollectionFor);
		
		JButton btnLoadEmpPerformance_1 = new JButton("VIEW");
		btnLoadEmpPerformance_1.setBounds(225, 216, 72, 26);
		panel_1_1.add(btnLoadEmpPerformance_1);
		
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
			
		//Loading Add Product Form		
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddProductFrame apFrame = null;
				try {
					apFrame = new AddProductFrame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				apFrame.setVisible(true);
				

			}
		});
		
		// Button to Add Category 		
		btnAddProdCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CategoryRepository categoryRep = new CategoryRepository();
				try {
					List<String> catNamesList = categoryRep.getCategoryNamesList();
					if(!catNamesList.contains(tFieldCategory.getText().toString()))
					{
						categoryRep.addCategory(tFieldCategory.getText().toString());
						JOptionPane.showMessageDialog(null, "CATEGORY ADDED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						tFieldCategory.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "CATEGORY ALREADY EXISTS", "FAILED", JOptionPane.ERROR_MESSAGE);

					}

				} catch (IOException e1) {

				}
			}
		});
		
		// Button to Load Add Sub Category Frame
		
		btnAddSubCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					AddSubCategoryFrame subFrame = null;
					try {
						subFrame = new AddSubCategoryFrame();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					subFrame.setVisible(true);
			}
		});
		
		// Button to Load Add Tax Category Frame
		
		btnAddTaxCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddTaxCategoryFrame taxFrame = new AddTaxCategoryFrame();
				taxFrame.setVisible(true);
			}
		});	
		
		//Button to Load RemoveACategoryFrame
		
		btnRemoveProdCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RemoveACategoryFrame rcFrame = null;
				try {
					rcFrame = new RemoveACategoryFrame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				rcFrame.setVisible(true);
				
			}
		});
		
		//Button to Load RemoveASubCategory Frame
		
		btnRemoveSubCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RemoveSubCategoryFrame remSubFrame = null;
				try {
					remSubFrame = new RemoveSubCategoryFrame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				remSubFrame.setVisible(true);
			}
		});
		
		// Button to Load RemoveTaxCategory Frame
		
		btnRemoveTaxCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				RemoveTaxCategoryFrame remTaxFrame = null;
				try {
					remTaxFrame = new RemoveTaxCategoryFrame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				remTaxFrame.setVisible(true);
			}
		});
		
		// Button to Edit Percentage of Tax Category
		
		btnEditTaxPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditTaxPercentFrame editTaxFrame = null;
				try {
					editTaxFrame = new EditTaxPercentFrame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				editTaxFrame.setVisible(true);
				
			}
		});
		
		//Button to Load Edit a Product
		
		btnEditProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditProductFrame editProductFrame = null;
				try {
					editProductFrame = new EditProductFrame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				editProductFrame.setVisible(true);
			}
		});
		
		// Button to Load Load Bill Frame
		
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String enteredNumber = tFieldEnterBillNumber.getText();
				if(!enteredNumber.isEmpty())
				{
					billNumbersList.clear();
					StoredBillInfoRepository sbRep = new StoredBillInfoRepository();
					try {
						billNumbersList = sbRep.getListOfStoredBillNumbers();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					if(billNumbersList.contains(enteredNumber))
					{
						BillRepository billRep = new BillRepository();
						Bill bill = null;
						try {
							bill = billRep.loadBillUsingBillNumber(enteredNumber);
							billRep.passCurrentBillDetails(bill);
							LoadBillFrame lbFrame = new LoadBillFrame();
							lbFrame.setVisible(true);
						} catch (IOException e1) {

							e1.printStackTrace();
						}						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "INVALID BILL NUMBER", "ERROR", JOptionPane.OK_OPTION);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "BILL NUMBER EMPTY", "ERROR", JOptionPane.OK_OPTION);
				}
				
				tFieldEnterBillNumber.setText("");
			}
		});
		
		// Button to Load View Customer Details Frame
		
		btnLoadCustmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewCustomerDetailFrame vcFrame = new ViewCustomerDetailFrame();
				vcFrame.setVisible(true);
			}
		});
		
		// Button to Load View Employee Performance Frame
		
		btnLoadEmpPerformance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeePerformanceFrame empPerFrame = new EmployeePerformanceFrame();
				empPerFrame.setVisible(true);
			}
		});
		
		//Button to Get Active Collection of the Store for the Day
		
		btnLoadEmpPerformance_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BillRepository billRepository = new BillRepository();
				double total = 0;
				try {
					total = billRepository.getShopsOneDayCollection();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "TOTAL AMOUNT COLLECTED FOR CURRENT WORKING DAY : " + total);
			}
		});
		
		
	}
}
