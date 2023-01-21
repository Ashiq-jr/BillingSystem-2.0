package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import category.Category;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
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

	public ManagerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		// Loading Add Category of Product		
		btnAddProdCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Category category = new Category();
				try {
					List<String> catNamesList = category.getCategoryNamesList();
					if(!catNamesList.contains(tFieldCategory.getText().toString()))
					{
						category.addCategory(tFieldCategory.getText().toString());
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
	}
}
