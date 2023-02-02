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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddTaxCategoryFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblCategoryName;
	private JLabel lblTitle;
	private JLabel lblPercent;
	private JTextField tFieldTaxName;
	private JTextField tFieldTaxPercent;

	public AddTaxCategoryFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 464, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("ADD TAX CATEGORY");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 440, 43);
		contentPane.add(lblTitle);
		
		lblCategoryName = new JLabel("Category Name :");
		lblCategoryName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblCategoryName.setBounds(68, 87, 180, 34);
		contentPane.add(lblCategoryName);
		
		lblPercent = new JLabel("Percentage :");
		lblPercent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPercent.setBounds(68, 154, 180, 34);
		contentPane.add(lblPercent);
		
		tFieldTaxName = new JTextField();
		tFieldTaxName.setBounds(203, 87, 187, 27);
		contentPane.add(tFieldTaxName);
		tFieldTaxName.setColumns(10);
		
		tFieldTaxPercent = new JTextField();
		tFieldTaxPercent.setColumns(10);
		tFieldTaxPercent.setBounds(203, 154, 187, 27);
		contentPane.add(tFieldTaxPercent);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(180, 218, 85, 34);
		contentPane.add(btnAdd);
		
		
		//Button to Add New tax Category
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tFieldTaxPercent.getText().toString().isEmpty() || tFieldTaxName.getText().toString().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "EMPTY FIELDS", "ERROR", JOptionPane.OK_OPTION );
				}
				else {
					
					String taxName = tFieldTaxName.getText().toUpperCase();
					double taxPercent = Double.parseDouble(tFieldTaxPercent.getText());
					
					TaxCategory tax = new TaxCategory(taxName, taxPercent);
					TaxCategoryRepository taxRep = new TaxCategoryRepository();
					try {
						
						List<String> nameList = taxRep.getTaxCategoryNamesList();
						if(!nameList.contains(taxName))
						{
							taxRep.addTaxCategory(tax);
							JOptionPane.showMessageDialog(null, "TAX CATEGORY ADDED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
							tFieldTaxName.setText("");
							tFieldTaxPercent.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "TAX CATEGORY EXISTS", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}

				
			}
		});
	}
}
