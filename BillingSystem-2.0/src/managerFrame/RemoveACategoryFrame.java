package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import category.Category;
import category.CategoryRepository;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.IOException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveACategoryFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCategory;
	private JComboBox<String> cBoxCategory;
	private JButton btnRemove;

	public RemoveACategoryFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("REMOVE CATEGORY");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setBounds(10, 10, 386, 36);
		contentPane.add(lblTitle);
		
		lblCategory = new JLabel("CATEGORY :");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblCategory.setBounds(66, 99, 121, 43);
		contentPane.add(lblCategory);
		
		cBoxCategory = new JComboBox<String>();
		cBoxCategory.setBounds(190, 105, 181, 33);
		contentPane.add(cBoxCategory);
		
		btnRemove = new JButton("REMOVE");
		btnRemove.setBounds(151, 172, 104, 27);
		contentPane.add(btnRemove);
		
		//Loading Categories in Combo Box
		
		CategoryRepository categoryRep = new CategoryRepository();
		List<Category> list = categoryRep.loadCategory();
		
		cBoxCategory.removeAllItems();
		for(Category x : list)
		{
			cBoxCategory.addItem(x.getName());
		}
		cBoxCategory.setSelectedItem(null);
				
		//Button to Remove a Category
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String remove = cBoxCategory.getSelectedItem().toString();
				try {
					categoryRep.removeCategory(remove);
					JOptionPane.showMessageDialog(null, "CATEGORY REMOVED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					cBoxCategory.setSelectedItem(null);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "EXCEPTION", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
}
