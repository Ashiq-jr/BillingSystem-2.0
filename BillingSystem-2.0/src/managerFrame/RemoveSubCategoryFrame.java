package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import category.Category;
import category.CategoryRepository;
import subCategory.SubCategory;
import subCategory.SubCategoryRepository;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveSubCategoryFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCategory;
	private JComboBox<String> cBoxCategory;
	private JComboBox<String> cBoxSubCategory;
	private JLabel lblSubCategory;
	private JButton btnNewButton;
	
	static List<Category> catList = new ArrayList<Category>();
	static List<SubCategory> subList = new ArrayList<SubCategory>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveSubCategoryFrame frame = new RemoveSubCategoryFrame();
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
	public RemoveSubCategoryFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("REMOVE SUB CATEGORY");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 418, 42);
		contentPane.add(lblTitle);
		
		lblCategory = new JLabel("CATEGORY : ");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCategory.setBounds(75, 107, 127, 32);
		contentPane.add(lblCategory);
		
		cBoxCategory = new JComboBox<String>();
		cBoxCategory.setBounds(212, 109, 179, 32);
		contentPane.add(cBoxCategory);
		
		cBoxSubCategory = new JComboBox<String>();
		cBoxSubCategory.setBounds(212, 165, 179, 32);
		contentPane.add(cBoxSubCategory);
		
		lblSubCategory = new JLabel("SUB CATEGORY : ");
		lblSubCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSubCategory.setBounds(75, 163, 127, 32);
		contentPane.add(lblSubCategory);
		
		btnNewButton = new JButton("REMOVE");
		btnNewButton.setBounds(168, 244, 85, 32);
		contentPane.add(btnNewButton);
		
		//Adding Categories to Combobox
		
		 CategoryRepository catRep = new CategoryRepository();
		 catList = catRep.loadCategory();
		 cBoxCategory.removeAllItems();
		 for(Category x : catList)
		 {
			 cBoxCategory.addItem(x.getName());
		 }
		 cBoxCategory.setSelectedItem(null);
		 
		 //Adding Sub Categories to ComboBox
		 
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
					}
				}
			});
			
			// Button to Remove A SubCategory
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
	}
}

