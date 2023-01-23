package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import product.TaxCategory;
import product.TaxCategoryRepository;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.IOException;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveTaxCategoryFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblInfo;
	private JLabel lblTaxCategory;
	private JComboBox<String> cBoxTaxCategory;
	private JButton btnNewButton;
	
	List<TaxCategory> taxList = new ArrayList<TaxCategory>();

	
	public RemoveTaxCategoryFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInfo = new JLabel("REMOVE TAX CATEGORY");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(10, 0, 404, 39);
		contentPane.add(lblInfo);
		
		lblTaxCategory = new JLabel("TAX CATEGORY :");
		lblTaxCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTaxCategory.setBounds(43, 115, 137, 26);
		contentPane.add(lblTaxCategory);
		
		cBoxTaxCategory = new JComboBox<String>();
		cBoxTaxCategory.setBounds(205, 113, 167, 32);
		contentPane.add(cBoxTaxCategory);
		
		btnNewButton = new JButton("REMOVE");
		btnNewButton.setBounds(141, 197, 99, 32);
		contentPane.add(btnNewButton);
		
		// Adding Tax Categories to ComboBox
		
		TaxCategoryRepository taxRep = new TaxCategoryRepository();
		taxList.clear();
		taxList = taxRep.loadTaxcategory();
		
		cBoxTaxCategory.removeAllItems();
		for(TaxCategory x : taxList)
		{
			cBoxTaxCategory.addItem(x.getName());
		}
		cBoxTaxCategory.setSelectedItem(null);
		
		// Button to Remove Selected Tax Category
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cBoxTaxCategory.getSelectedItem() != null)
				{
					String taxName = cBoxTaxCategory.getSelectedItem().toString();
					TaxCategoryRepository taxRep = new TaxCategoryRepository();
					try {
						taxRep.removeTaxCategory(taxName);
						JOptionPane.showMessageDialog(null, "TAX CATEGORY REMOVED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					cBoxTaxCategory.setSelectedItem(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "PLEASE SELECT A CATEGORY", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
	}

}
