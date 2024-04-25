package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class operations extends JFrame {

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
					operations frame = new operations();
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
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	private JTextField textField_4;
	private JTextField textField_7;
	
	public operations() {
		super("student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   STUDENT DETAILS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(165, 22, 205, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(86, 109, 78, 17);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(317, 107, 156, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Father's Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(86, 160, 125, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mother's Name");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(86, 209, 133, 17);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("City");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(86, 263, 78, 17);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Blood");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(86, 310, 78, 17);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Phone");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(86, 360, 78, 17);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Class");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(86, 407, 78, 17);
		contentPane.add(lblNewLabel_1_6);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(317, 158, 156, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(317, 207, 156, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(317, 261, 156, 19);
		contentPane.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(317, 358, 156, 19);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(317, 405, 156, 19);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton(" Search");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon image = new ImageIcon(this.getClass().getResource("/s.jpg"));
		btnNewButton.setIcon(image);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					int stdId = Integer.parseInt(textField_7.getText());
					String sql = "SELECT * FROM STUDENT WHERE id = '"+stdId+"'";
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						textField.setText(rs.getString("stdName"));
						textField_1.setText(rs.getString("stdFathername"));
						textField_2.setText(rs.getString("stdMotherName"));
						textField_4.setText(rs.getString("stdBlood"));
						textField_5.setText(rs.getString("stdPhone"));
						textField_3.setText(rs.getString("stdCity"));
						textField_6.setText(String.format("%s", rs.getInt("stdclass")));
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Record not found");
					}
				}catch(Exception k){JOptionPane.showMessageDialog(null,e);}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(36, 450, 133, 59);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.setBackground(new Color(128, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(141, 557, 96, 21);
		contentPane.add(btnNewButton_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(317, 308, 156, 19);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_7 = new JLabel("id");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_7.setBounds(86, 70, 78, 17);
		contentPane.add(lblNewLabel_1_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(317, 64, 156, 19);
		contentPane.add(textField_7);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					int stdId = Integer.parseInt(textField_7.getText());
					String sql = "DELETE FROM student WHERE id = '"+stdId+"'";
					stmt.executeUpdate(sql);
					
					setVisible(false);
					showstudent obj = new showstudent();
					obj.setVisible(true);
				}
			catch(Exception b) {JOptionPane.showMessageDialog(null, b);}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(217, 450, 133, 59);
		contentPane.add(btnDelete);
		
		JButton btnNewButton_1_1 = new JButton("BACK");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	home m = new home();
			    m.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1_1.setBackground(new Color(128, 255, 255));
		btnNewButton_1_1.setBounds(333, 558, 96, 21);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					int stdId = Integer.parseInt(textField_7.getText());
					String stdName = textField.getText();
					String stdBlood = (String) textField_4.getText();
					String stdFName = textField_1.getText();
					String stdMName = textField_2.getText();
					String City = textField_3.getText();
					String Phone = textField_5.getText();
					int Class = Integer.parseInt(textField_6.getText());
					String sql = "UPDATE STUDENT SET stdName='"+stdName+"',stdFathername='"+stdFName+"',stdMotherName='"+stdMName+"', stdBlood='"+stdBlood+"', stdPhone='"+Phone+"', stdCity='"+City+"', stdclass='"+Class+"' WHERE id = '"+stdId+"' ";
					int rowsAffected = stmt.executeUpdate(sql);
		            if (rowsAffected > 0) {
		                JOptionPane.showMessageDialog(null, "Data updated successfully");
		            } else {
		                JOptionPane.showMessageDialog(null, "Failed to update data");
		            }
		            con.close(); // Close the connection
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter valid numeric values for ID and Class");
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "SQL error: " + ex.getMessage());
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(394, 450, 133, 59);
		contentPane.add(btnUpdate);
	}
}
