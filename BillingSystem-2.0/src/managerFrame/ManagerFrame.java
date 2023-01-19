package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblAddProduct;
	private JLabel lblAddCategory;
	private JLabel lblAddTaxCategory;
	private JButton btnLoadAddProd;
	private JButton btnAddProdCat;
	private JButton btnAddTaxCat;
	private JLabel lblTitle;

	public ManagerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(129, 115, 578, 173);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblAddProduct = new JLabel("ADD PRODUCT  :");
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblAddProduct.setBounds(121, 23, 186, 29);
		panel.add(lblAddProduct);
		
		lblAddCategory = new JLabel("ADD PRODUCT CATEGORY  :");
		lblAddCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblAddCategory.setBounds(121, 69, 186, 29);
		panel.add(lblAddCategory);
		
		lblAddTaxCategory = new JLabel("ADD TAX CATEGORY  :");
		lblAddTaxCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblAddTaxCategory.setBounds(121, 119, 186, 29);
		panel.add(lblAddTaxCategory);
		
		btnLoadAddProd = new JButton("LOAD");
		btnLoadAddProd.setBounds(354, 23, 85, 26);
		panel.add(btnLoadAddProd);
		
		btnAddProdCat = new JButton("LOAD");
		btnAddProdCat.setBounds(354, 69, 85, 26);
		panel.add(btnAddProdCat);
		
		btnAddTaxCat = new JButton("LOAD");
		btnAddTaxCat.setBounds(354, 119, 85, 26);
		panel.add(btnAddTaxCat);
		
		lblTitle = new JLabel("MANAGER OPERATIONS");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 831, 77);
		contentPane.add(lblTitle);
	}
}
