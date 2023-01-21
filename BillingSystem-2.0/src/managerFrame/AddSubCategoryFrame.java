package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import category.Category;
import subCategory.SubCategory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.IOException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddSubCategoryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tFieldSubCategory;
	private JLabel lblTitle;
	private JLabel lblCategory;
	private JComboBox<String> cBoxCategory;
	private JLabel lblSubCategory;
	private JButton btnAdd;

	public AddSubCategoryFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("ADD SUB CATEGORY");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setBounds(10, 10, 416, 41);
		contentPane.add(lblTitle);
		
		lblCategory = new JLabel("CATEGORY :");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblCategory.setBounds(66, 76, 171, 31);
		contentPane.add(lblCategory);
		
		cBoxCategory = new JComboBox();
		cBoxCategory.setBounds(217, 80, 150, 25);
		contentPane.add(cBoxCategory);
		
		lblSubCategory = new JLabel("SUB CATEGORY :");
		lblSubCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblSubCategory.setBounds(66, 139, 136, 25);
		contentPane.add(lblSubCategory);
		
		tFieldSubCategory = new JTextField();
		tFieldSubCategory.setBounds(217, 139, 150, 25);
		contentPane.add(tFieldSubCategory);
		tFieldSubCategory.setColumns(10);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(169, 194, 85, 31);
		contentPane.add(btnAdd);
		
		
		//Addding Categories to the Category ComboBox
		
		Category category = new Category();
		List<Category> list = category.loadCategory();
		cBoxCategory.removeAllItems();
		for(Category x : list)
		{
			cBoxCategory.addItem(x.getName().toString());
		}
		cBoxCategory.setSelectedItem(null);
		
		//Button to Add New Sub Category
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String catName = cBoxCategory.getSelectedItem().toString();
				Category category = new Category(catName);
				String subName = tFieldSubCategory.getText().toUpperCase();
				SubCategory subCategory = new SubCategory(category,subName);
				try {
					List<String> nameList = subCategory.getNameList();
					if(!nameList.contains(subName))
					{
						subCategory.addSubCategory(subCategory);
						JOptionPane.showMessageDialog(null, "SUB CATEGORY ADDED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						tFieldSubCategory.setText("");
						cBoxCategory.setSelectedItem(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "SUB CATEGORY EXISTS", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
