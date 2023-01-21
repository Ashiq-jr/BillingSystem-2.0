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

	public ManagerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(129, 115, 578, 217);
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
		
		JLabel lblAddTaxCat = new JLabel("ADD TAX CATEGORY  :");
		lblAddTaxCat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblAddTaxCat.setBounds(44, 166, 186, 29);
		panel.add(lblAddTaxCat);
		
		JButton btnAddTaxCat = new JButton("LOAD\r\n");
		btnAddTaxCat.setBounds(242, 168, 85, 26);
		panel.add(btnAddTaxCat);
		
		lblTitle = new JLabel("MANAGER OPERATIONS");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 831, 77);
		contentPane.add(lblTitle);
		
		
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
	}
}
