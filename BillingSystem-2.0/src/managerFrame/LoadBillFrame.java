package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import bill.Bill;
import bill.BillRepository;
import bill.PaymentType;
import bill.StoredBillInfoRepository;
import product.ProductInCart;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoadBillFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblBillNumber;
	private JLabel lblDate;
	private JLabel lblCustId;
	private JLabel lblEmpId;
	private JTable table;
	private JLabel lblShowBillNumber;
	private JLabel lblShowDate;
	private JLabel lblShowCustId;
	private JLabel lblShowEmpId;
	private JLabel lblShowPaymentType;
	private JLabel lblTotal;
	private JLabel lblShowTotal;
	private static List<String> billNumbersList = new ArrayList<String>();
	
	public LoadBillFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 927, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("LOAD BILL DETAILS");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setBounds(10, 10, 897, 63);
		contentPane.add(lblTitle);
		
		lblBillNumber = new JLabel("BILL NUMBER :");
		lblBillNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBillNumber.setBounds(37, 114, 171, 32);
		contentPane.add(lblBillNumber);
		
		lblDate = new JLabel("DATE :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDate.setBounds(37, 171, 171, 32);
		contentPane.add(lblDate);
		
		lblCustId = new JLabel("CUSTOMER ID :");
		lblCustId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCustId.setBounds(37, 234, 171, 32);
		contentPane.add(lblCustId);
		
		lblEmpId = new JLabel("EMPLOYEE ID :");
		lblEmpId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblEmpId.setBounds(37, 297, 171, 32);
		contentPane.add(lblEmpId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(434, 113, 468, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		final Object[] row = new Object[5];
		Object[] column = {"S.No", "PRODUCT", "PRICE", "QUANTITY", "NETPRICE"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(80);
		columnModel.getColumn(4).setPreferredWidth(120);
		table.setRowHeight(30);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for(int i = 0; i < model.getColumnCount(); i++)
		{
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		scrollPane.setViewportView(table);
		
		JLabel lblPaymentType = new JLabel("PAYMENT TYPE :");
		lblPaymentType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPaymentType.setBounds(37, 365, 171, 32);
		contentPane.add(lblPaymentType);
		
		lblShowBillNumber = new JLabel("");
		lblShowBillNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblShowBillNumber.setBounds(228, 114, 171, 32);
		contentPane.add(lblShowBillNumber);
		
		lblShowDate = new JLabel("");
		lblShowDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblShowDate.setBounds(228, 171, 171, 32);
		contentPane.add(lblShowDate);
		
		lblShowCustId = new JLabel("");
		lblShowCustId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblShowCustId.setBounds(228, 234, 171, 32);
		contentPane.add(lblShowCustId);
		
		lblShowEmpId = new JLabel("");
		lblShowEmpId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblShowEmpId.setBounds(228, 297, 171, 32);
		contentPane.add(lblShowEmpId);
		
		lblShowPaymentType = new JLabel("");
		lblShowPaymentType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblShowPaymentType.setBounds(228, 365, 171, 32);
		contentPane.add(lblShowPaymentType);
		
		lblTotal = new JLabel("TOTAL :");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTotal.setBounds(683, 459, 90, 32);
		contentPane.add(lblTotal);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(781, 459, 121, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblShowTotal = new JLabel("");
		lblShowTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowTotal.setBounds(10, 0, 90, 32);
		panel.add(lblShowTotal);
		
		//To Load Bill
		
		BillRepository billRep = new BillRepository();
		Bill bill = null;
		bill = billRep.getCurrentBillDetails();
		
		lblShowBillNumber.setText(bill.getNumber());
		lblShowDate.setText(bill.getDate());
		lblShowCustId.setText(String.valueOf(bill.getCustomerId()));
		lblShowEmpId.setText(String.valueOf(bill.getEmpId()));
		lblShowPaymentType.setText(bill.getPayType().toString());
		lblShowTotal.setText(String.valueOf(bill.getTotal()));	
		setTableUsingList(table, row, bill);
	}
	
	
	
	
	public static void setTableUsingList(JTable table,Object[] row, Bill bill )
	{
		List<ProductInCart> list = bill.getProductsinCart();
		int i = 0;
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(ProductInCart x : list)
		{
						
			while(i < list.size())
			{				
				row[0] = x.getS_No();
				row[1] = x.getProduct().getName();
				row[2] = x.getProduct().getUnitPrice();
				row[3] = x.getQuantity();
				row[4] = x.getNetPrice();
				
				model.addRow(row);
				i++;
				break;
			}
		}
		
	}
}
