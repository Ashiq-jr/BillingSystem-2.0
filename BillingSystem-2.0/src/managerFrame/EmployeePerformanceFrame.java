package managerFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import employee.Employee;
import employee.EmployeePerformance;
import employee.EmployeeRepository;
import employee.Performance;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class EmployeePerformanceFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCollection;
	private JLabel lblPerformance;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblShowName;
	private JLabel lblToday;
	private JLabel lblThisWeek;
	private JLabel lblThisMonth;
	private JLabel lblTodayCollection;
	private JLabel lblTodayPerformance;
	private JLabel lblWeeklyCollection;
	private JLabel lblWeeklyPerformance;
	private JLabel lblMonthlyCollection;
	private JLabel lblMonthlyPerformance;
	private JTextField tFieldId;

	public EmployeePerformanceFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("EMPLOYEE PERFROMANCE");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 454, 42);
		contentPane.add(lblTitle);
		
		lblCollection = new JLabel("COLLECTION");
		lblCollection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblCollection.setBounds(189, 178, 117, 35);
		contentPane.add(lblCollection);
		
		lblPerformance = new JLabel("PERFORMANCE");
		lblPerformance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPerformance.setBounds(332, 178, 117, 35);
		contentPane.add(lblPerformance);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblId.setBounds(78, 64, 117, 35);
		contentPane.add(lblId);
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblName.setBounds(78, 136, 117, 35);
		contentPane.add(lblName);
		
		lblShowName = new JLabel("");
		lblShowName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblShowName.setBounds(189, 136, 117, 35);
		contentPane.add(lblShowName);
		
		lblToday = new JLabel("TODAY :");
		lblToday.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblToday.setBounds(78, 221, 117, 35);
		contentPane.add(lblToday);
		
		lblThisWeek = new JLabel("THIS WEEK :");
		lblThisWeek.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblThisWeek.setBounds(78, 278, 117, 35);
		contentPane.add(lblThisWeek);
		
		lblThisMonth = new JLabel("THIS MONTH :");
		lblThisMonth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblThisMonth.setBounds(78, 345, 117, 35);
		contentPane.add(lblThisMonth);
		
		lblTodayCollection = new JLabel("");
		lblTodayCollection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTodayCollection.setBounds(189, 221, 117, 35);
		contentPane.add(lblTodayCollection);
		
		lblTodayPerformance = new JLabel("");
		lblTodayPerformance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTodayPerformance.setBounds(332, 221, 117, 35);
		contentPane.add(lblTodayPerformance);
		
		lblWeeklyCollection = new JLabel("");
		lblWeeklyCollection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblWeeklyCollection.setBounds(189, 278, 117, 35);
		contentPane.add(lblWeeklyCollection);
		
		lblWeeklyPerformance = new JLabel("");
		lblWeeklyPerformance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblWeeklyPerformance.setBounds(332, 278, 117, 35);
		contentPane.add(lblWeeklyPerformance);
		
		lblMonthlyCollection = new JLabel("");
		lblMonthlyCollection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblMonthlyCollection.setBounds(189, 345, 117, 35);
		contentPane.add(lblMonthlyCollection);
		
		lblMonthlyPerformance = new JLabel("");
		lblMonthlyPerformance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblMonthlyPerformance.setBounds(332, 345, 117, 35);
		contentPane.add(lblMonthlyPerformance);
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.setBounds(189, 400, 91, 38);
		contentPane.add(btnNewButton);
		
		tFieldId = new JTextField();
		tFieldId.setBounds(149, 70, 165, 26);
		contentPane.add(tFieldId);
		tFieldId.setColumns(10);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setBounds(332, 69, 78, 26);
		contentPane.add(btnLoad);
		
		
		//Button to Load Performance
		
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tFieldId.getText().toString().isEmpty())
				{
					int id = Integer.parseInt(tFieldId.getText());
					EmployeeRepository empRep = new EmployeeRepository();
					boolean idExists = false;
					try {
						idExists = empRep.checkIfIdExists(id);
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					}
					
					
					if(idExists)
					{
						String name = "";
						try {
							name = empRep.getNameUsingId(id);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						
						EmployeePerformance performance = new EmployeePerformance();
						double dailyAmount = 0;
						double weeklyAmount = 0;
						double monthlyAmount = 0;					
						Performance dailyPerformance = null;
						Performance weeklyPerformance = null;
						Performance monthlyPerformance = null;
						
						try {
							
							dailyAmount = performance.getTodaysCollection(id);
							weeklyAmount = performance.getThisWeeksCollection(id);
							monthlyAmount = performance.getThisMonthsCollection(id);
							dailyPerformance = performance.getToadysPerformance(id);
							weeklyPerformance = performance.getThisWeeksPerformance(id);
							monthlyPerformance = performance.getThisMonthsPerformance(id);
							
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						lblShowName.setText(name);
						lblTodayCollection.setText(String.valueOf(dailyAmount));
						lblWeeklyCollection.setText(String.valueOf(weeklyAmount));
						lblMonthlyCollection.setText(String.valueOf(monthlyAmount));
						lblTodayPerformance.setText(dailyPerformance.toString());
						lblWeeklyPerformance.setText(weeklyPerformance.toString());
						lblMonthlyPerformance.setText(monthlyPerformance.toString());
					}
					
					else 
					{
						JOptionPane.showMessageDialog(null, "INVALID ID", "ERROR", JOptionPane.OK_OPTION);
					}
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "EMPTY FIELDS", "ERROR", JOptionPane.OK_OPTION);
				}
					
				
				
			}
		});
		
		// Button to Clear Screen
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tFieldId.setText("");
				lblShowName.setText("");
				lblTodayCollection.setText("");
				lblTodayPerformance.setText("");
				lblWeeklyCollection.setText("");
				lblWeeklyPerformance.setText("");
				lblMonthlyCollection.setText("");
				lblMonthlyPerformance.setText("");
			}
		});
		 
	}
}
