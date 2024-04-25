package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class addstudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addstudent frame = new addstudent();
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
	
	public addstudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 616);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(71, 116, 80, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(255, 118, 155, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(255, 170, 155, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(255, 222, 155, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(255, 282, 155, 19);
		contentPane.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(255, 400, 155, 19);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(255, 456, 155, 19);
		contentPane.add(textField_6);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblFathersName.setBounds(71, 166, 126, 22);
		contentPane.add(lblFathersName);
		
		JLabel lblMothersName = new JLabel("Mother's Name");
		lblMothersName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMothersName.setBounds(71, 219, 133, 22);
		contentPane.add(lblMothersName);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCity.setBounds(71, 279, 80, 22);
		contentPane.add(lblCity);
		
		JLabel lblBlood = new JLabel("Blood");
		lblBlood.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBlood.setBounds(71, 336, 80, 22);
		contentPane.add(lblBlood);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPhone.setBounds(71, 397, 80, 22);
		contentPane.add(lblPhone);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblClass.setBounds(71, 453, 80, 22);
		contentPane.add(lblClass);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-"}));
		comboBox.setToolTipText("");
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		comboBox.setBounds(255, 339, 155, 19);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					String stdName = textField.getText();
					String stdBlood = (String) comboBox.getSelectedItem();
					String stdFName = textField_1.getText();
					String stdMName = textField_2.getText();
					String City = textField_3.getText();
					String Phone = textField_5.getText();
					int Class = Integer.parseInt(textField_6.getText());
					String sql = "insert into student (stdName, stdFathername, stdMotherName, stdBlood, stdPhone, stdCity, stdclass)" + "values('"+stdName+"', '"+stdFName+"', '"+stdMName+"', '"+stdBlood+"','"+Phone+"','"+City+"','"+Class+"')";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Data is inserted");
				}catch(Exception p) {
					JOptionPane.showMessageDialog(null, p);}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(119, 529, 97, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	home l = new home();
			    l.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(283, 529, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("ADD STUDENT ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(158, 42, 178, 30);
		contentPane.add(lblNewLabel_1);
	}
}
