package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import category.Category;
import category.CategoryRepository;
import product.Product;
import product.ProductRepository;
import product.Status;
import product.TaxCategory;
import product.TaxCategoryRepository;
import subCategory.SubCategory;
import subCategory.SubCategoryRepository;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditProductFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCategory;
	private JComboBox<String> cBoxCategory;
	private JLabel lblSubCategory;
	private JComboBox<String> cBoxSubCategory;
	private JLabel lblProduct;
	private JComboBox<String> cBoxProduct;
	private JButton btnNewButton;
	private JLabel lblUnitPrice;
	private JComboBox<String> cBoxTaxCategory;
	private JLabel lblTaxCategory;
	private JComboBox<String> cBoxStatus;
	private JLabel lblStatus;
	private JTextField tFieldUnitPrice;
	private JButton btnUpdate;
	
	static List<Category> catList = new ArrayList<Category>();
	static List<SubCategory> subList = new ArrayList<SubCategory>();
	static List<Product> prodList = new ArrayList<Product>();
	static List<TaxCategory> taxList = new ArrayList<TaxCategory>();
	static Status[] statusList;

	public EditProductFrame() throws IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("EDIT PRODUCT");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 456, 38);
		contentPane.add(lblTitle);
		
		lblCategory = new JLabel("CATEGORY : ");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblCategory.setBounds(86, 79, 150, 27);
		contentPane.add(lblCategory);
		
		cBoxCategory = new JComboBox<String>();
		cBoxCategory.setBounds(222, 79, 162, 27);
		contentPane.add(cBoxCategory);
		
		lblSubCategory = new JLabel("SUB CATEGORY : ");
		lblSubCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblSubCategory.setBounds(86, 130, 150, 27);
		contentPane.add(lblSubCategory);
		
		cBoxSubCategory = new JComboBox<String>();
		cBoxSubCategory.setBounds(222, 130, 162, 27);
		contentPane.add(cBoxSubCategory);
		
		lblProduct = new JLabel("PRODUCT : ");
		lblProduct.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblProduct.setBounds(86, 186, 150, 27);
		contentPane.add(lblProduct);
		
		cBoxProduct = new JComboBox<String>();
		cBoxProduct.setBounds(222, 186, 162, 27);
		contentPane.add(cBoxProduct);
		
		btnNewButton = new JButton("LOAD");
		btnNewButton.setBounds(184, 246, 85, 27);
		contentPane.add(btnNewButton);
		
		lblUnitPrice = new JLabel("UNIT PRICE : ");
		lblUnitPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblUnitPrice.setBounds(86, 311, 150, 27);
		contentPane.add(lblUnitPrice);
		
		cBoxTaxCategory = new JComboBox<String>();
		cBoxTaxCategory.setBounds(222, 380, 139, 27);
		contentPane.add(cBoxTaxCategory);
		
		lblTaxCategory = new JLabel("TAX CATEGORY : ");
		lblTaxCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTaxCategory.setBounds(86, 380, 150, 27);
		contentPane.add(lblTaxCategory);
		
		cBoxStatus = new JComboBox<String>();
		cBoxStatus.setBounds(222, 446, 139, 27);
		contentPane.add(cBoxStatus);
		
		lblStatus = new JLabel("STATUS : ");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblStatus.setBounds(86, 446, 150, 27);
		contentPane.add(lblStatus);
		
		tFieldUnitPrice = new JTextField();
		tFieldUnitPrice.setBounds(222, 311, 139, 24);
		contentPane.add(tFieldUnitPrice);
		tFieldUnitPrice.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(184, 508, 85, 27);
		contentPane.add(btnUpdate);
		
		// Adding Categories to Category ComboBox
		
		CategoryRepository categoryRep = new CategoryRepository();
		List<Category> catList = categoryRep.loadCategory();
		cBoxCategory.removeAllItems();
		for(Category x : catList)
		{
			cBoxCategory.addItem(x.getName().toString());
		}
		cBoxCategory.setSelectedItem(null);
		
		// Adding SubCategories to ComboBox
		
		cBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cBoxCategory.getSelectedItem() != null)
				{
					String catName = cBoxCategory.getSelectedItem().toString();
					SubCategoryRepository subRep = new SubCategoryRepository();
					
					 try {
						subList = subRep.loadSubCategory();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					 cBoxSubCategory.removeAllItems();
					for(SubCategory x : subList)
					{
						if(x.getCategory().getName().equals(catName))
						{
							cBoxSubCategory.addItem(x.getName());
						}
						
					}
					cBoxSubCategory.setSelectedItem(null);
					cBoxProduct.removeAllItems();
				}
			}
		});
		
		// Adding Product Names to ComboBox
		
		cBoxSubCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cBoxSubCategory.getSelectedItem() != null)
				{
					prodList.clear();
					String subName = cBoxSubCategory.getSelectedItem().toString();
					ProductRepository pr = new ProductRepository();
					try {
						prodList = pr.getListOfProducts();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					cBoxProduct.removeAllItems();
					for(Product x : prodList)
					{
						if(x.getSubCategory().getName().equals(subName))
						{
							cBoxProduct.addItem(x.getName());
						}
					}
					cBoxProduct.setSelectedItem(null);
					
				}
			}
		});
		
		// Button to Load the Details of the product
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cBoxProduct.getSelectedItem() != null && cBoxCategory.getSelectedItem() != null && cBoxSubCategory.getSelectedItem() != null)
				{
					String name = cBoxProduct.getSelectedItem().toString();					
					prodList.clear();
				
					ProductRepository pr = new ProductRepository();
					try {
						prodList = pr.getListOfProducts();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					String taxCategory = "";
					String status = "";
					for(Product x : prodList)
					{
						if(x.getName().equals(name))
						{
							tFieldUnitPrice.setText(String.valueOf(x.getUnitPrice()));
							taxCategory = x.getTaxCategory().getName();
							status = x.getStatus().name();
						}
					}
					
					// Filling TaxCategories in ComboBox and setting the Selected index
					
					TaxCategoryRepository tp = new TaxCategoryRepository();
					taxList.clear();
					cBoxTaxCategory.removeAllItems();
					try {
						taxList = tp.loadTaxcategory();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					for(TaxCategory x : taxList)
					{
						cBoxTaxCategory.addItem(x.getName());
					}
					cBoxTaxCategory.setSelectedItem(taxCategory);
					
					// Filling the List of Status in the ComboBox and Setting Selected index
					
					cBoxStatus.removeAllItems();
					statusList = Status.values();				
					for(Status x : statusList)
					{
						cBoxStatus.addItem(x.name());
					}
					cBoxStatus.setSelectedItem(status);
		
				}
				
				else {
					JOptionPane.showMessageDialog(null, "EMPTY FIRLDS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}

		});
		
		//Button to Update the Product Info
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductRepository prodRep = new ProductRepository();
				String name = cBoxProduct.getSelectedItem().toString();
				String cat = cBoxCategory.getSelectedItem().toString();
				Category category = new Category(cat);
				String subCat = cBoxSubCategory.getSelectedItem().toString();
				SubCategory subCategory = new SubCategory(category, subCat);
				double price =Double.parseDouble(tFieldUnitPrice.getText());
				String tax = cBoxTaxCategory .getSelectedItem().toString();
				String status = cBoxStatus.getSelectedItem().toString();
				TaxCategoryRepository taxRep = new TaxCategoryRepository();
				double taxValue = 0;
				try {
					 taxValue = taxRep.getTaxValue(tax);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				TaxCategory taxCategory = new TaxCategory(tax, taxValue);
				
				int id = 0;
				try {
					id = prodRep.getIdUsingName(name);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Product product = new Product(id, name, category, subCategory, price, taxCategory, Status.valueOf(status) );
				try {
					prodRep.editProduct(product);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				cBoxCategory.setSelectedItem(null);
				cBoxSubCategory.setSelectedItem(null);
				cBoxProduct.setSelectedItem(null);
				tFieldUnitPrice.setText("");
				cBoxTaxCategory.setSelectedItem(null);
				cBoxStatus.setSelectedItem(null);
				
				
				
				
			}
		});
	}

}
