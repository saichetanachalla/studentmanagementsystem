package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;


public class showstudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showstudent frame = new showstudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public showstudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("DISPLAY STUDENTS LIST");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					String qry = "select * from student";
					ResultSet rs = stmt.executeQuery(qry);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String id, stdName, stdFathername, stdMotherName, stdBlood, stdPhone, stdCity, stdclass;
					while(rs.next())
					{
						id = rs.getString(1);
						stdName = rs.getString(2);
						stdFathername = rs.getString(3);
						stdMotherName = rs.getString(4);
						stdBlood = rs.getString(5);
						stdPhone = rs.getString(6);
						stdCity = rs.getString(7);
						stdclass = rs.getString(8);
						String[] row = {id,stdName, stdFathername, stdMotherName, stdBlood, stdPhone, stdCity, stdclass};
						model.addRow(row);
					}
					stmt.close();
					con.close();
					
				}
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(168, 400, 220, 39);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 937, 346);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	home l = new home();
			    l.setVisible(true);
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(641, 400, 220, 39);
		contentPane.add(btnBack);
	}
}
