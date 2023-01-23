package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import product.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.IOException;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditTaxPercentFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel TaxCategory;
	private JComboBox<String> cBoxTaxCategory;
	private JLabel lblPercentage;
	private JTextField tFieldPercentage;
	private JButton btnUpdate;
	
	static List<TaxCategory> taxCatList = new ArrayList<TaxCategory>();

	
	public EditTaxPercentFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("EDIT TAX PERCENTAGE");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 15, 416, 28);
		contentPane.add(lblTitle);
		
		TaxCategory = new JLabel("TAX CATEGORY :");
		TaxCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		TaxCategory.setBounds(92, 76, 139, 28);
		contentPane.add(TaxCategory);
		
		cBoxTaxCategory = new JComboBox<String>();
		cBoxTaxCategory.setBounds(241, 78, 85, 27);
		contentPane.add(cBoxTaxCategory);
		
		lblPercentage = new JLabel("PERCENTAGE :");
		lblPercentage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPercentage.setBounds(92, 135, 139, 28);
		contentPane.add(lblPercentage);
		
		tFieldPercentage = new JTextField();
		tFieldPercentage.setBounds(241, 135, 85, 27);
		contentPane.add(tFieldPercentage);
		tFieldPercentage.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(164, 199, 85, 28);
		contentPane.add(btnUpdate);
		
		
		// Adding Tax Categories to ComboBox
		
		TaxCategoryRepository catRep = new TaxCategoryRepository();
		taxCatList = catRep.loadTaxcategory();
		cBoxTaxCategory.removeAllItems();
		for(TaxCategory x : taxCatList)
		{
			cBoxTaxCategory.addItem(x.getName());
		}
		cBoxTaxCategory.setSelectedItem(null);
		
		// To Show the Present Value of Selected Tax Category
		
		cBoxTaxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cBoxTaxCategory.getSelectedItem() != null)
				{
					tFieldPercentage.setText("");
					for(TaxCategory x : taxCatList)
					{
						if(x.getName().equals(cBoxTaxCategory.getSelectedItem().toString()))
						{
							tFieldPercentage.setText(String.valueOf(x.getValue()));
						}
					}
				}
			}
		});
		
		// Button to Update the Value of Tax Category
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cBoxTaxCategory.getSelectedItem() != null && tFieldPercentage.getText() != null)
				{
					String catName = cBoxTaxCategory.getSelectedItem().toString();
					int index = cBoxTaxCategory.getSelectedIndex();
					double percent = Double.parseDouble(tFieldPercentage.getText());
					TaxCategory taxCategory = new TaxCategory(catName, percent);
					TaxCategoryRepository taxRep = new TaxCategoryRepository();
					try {
						taxRep.editTaxCategory(taxCategory, index);
						JOptionPane.showMessageDialog(null, "TAX CATEGORY UPDATED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					cBoxTaxCategory.setSelectedItem(null);
					tFieldPercentage.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "EMPTY BOXES", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		
		
	}
}
