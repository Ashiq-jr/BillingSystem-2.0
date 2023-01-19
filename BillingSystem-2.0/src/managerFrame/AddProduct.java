package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import category.Category;
import subCategory.SubCategory;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblName;
	private JLabel lblCategory;
	private JLabel lblPrice;
	private JLabel lblTaxCat;
	private JTextField tFieldName;
	private JTextField tFieldPrice;
	private JComboBox<String> cBoxCategory;
	private JComboBox<String> cBoxTaxCat;
	private JButton btnAdd;
	private JButton btnReset;
	private JLabel lblSubCategory;
	private JComboBox<String> cBoxSubCategory;
	static List<Category> categoryList;
	static List<SubCategory> subCategoryList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public AddProduct() throws IOException {
		setTitle("ADD PRODUCT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("ADD PRODUCT");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 525, 53);
		contentPane.add(lblTitle);
		
		lblName = new JLabel("NAME\r\n :");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblName.setBounds(76, 184, 131, 28);
		contentPane.add(lblName);
		
		lblCategory = new JLabel("CATEGORY\r\n :");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCategory.setBounds(76, 81, 131, 28);
		contentPane.add(lblCategory);
		
		lblPrice = new JLabel("PRICE\r\n :");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPrice.setBounds(76, 244, 131, 28);
		contentPane.add(lblPrice);
		
		lblTaxCat = new JLabel("TAX CATEGORY\r\n :");
		lblTaxCat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTaxCat.setBounds(76, 298, 131, 28);
		contentPane.add(lblTaxCat);
		
		tFieldName = new JTextField();
		tFieldName.setBounds(242, 186, 189, 28);
		contentPane.add(tFieldName);
		tFieldName.setColumns(10);
		
		tFieldPrice = new JTextField();
		tFieldPrice.setColumns(10);
		tFieldPrice.setBounds(242, 244, 189, 28);
		contentPane.add(tFieldPrice);
		
		cBoxCategory = new JComboBox<String>();
		cBoxCategory.setBounds(242, 81, 189, 28);
		contentPane.add(cBoxCategory);
		
		cBoxTaxCat = new JComboBox<String>();
		cBoxTaxCat.setBounds(242, 298, 189, 28);
		contentPane.add(cBoxTaxCat);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(138, 366, 85, 34);
		contentPane.add(btnAdd);
		
		btnReset = new JButton("RESET\r\n");
		btnReset.setBounds(300, 366, 85, 34);
		contentPane.add(btnReset);
		
		lblSubCategory = new JLabel("SUB CATEGORY\r\n :");
		lblSubCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSubCategory.setBounds(76, 133, 131, 28);
		contentPane.add(lblSubCategory);
		
		cBoxSubCategory = new JComboBox<String>();
		cBoxSubCategory.setBounds(242, 135, 189, 28);
		contentPane.add(cBoxSubCategory);
		
		//Adding Values to Category ComboBox
		
		Category category = new Category();
		categoryList = category.loadCategory();
		cBoxCategory.removeAllItems();
		for(Category x : categoryList)
		{
			cBoxCategory.addItem(x.getName());
		}
		cBoxCategory.setSelectedItem(null);
		
		//Adding Values to SubCategory Combobox
		
		cBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp = cBoxCategory.getSelectedItem().toString();
				SubCategory subCategory = new SubCategory();
				try {
					subCategoryList = subCategory.loadSubCategory();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				cBoxSubCategory.removeAllItems();
				for(SubCategory x : subCategoryList)
				{
					if(x.getCategory().getName().equals(temp))
					{
						cBoxSubCategory.addItem(x.getName());
					}
						
				}
				cBoxSubCategory.setSelectedItem(null);
			}
		});

		
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
