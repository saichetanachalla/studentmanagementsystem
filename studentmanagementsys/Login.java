package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.ResultSet;
import java.awt.Color;

public class Login {

	private JFrame frame;
	String uname,pwd;
	private JTextField txtUser;
	private JPasswordField txtPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.setBounds(100, 100, 487, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(127, 419, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					String sql = "Select * from admin where mail='"+ txtUser.getText()+"' and password='"+txtPwd.getText()+"'";
				    ResultSet rs = stmt.executeQuery(sql);
				    if(rs.next())
				    {
				    	frame.dispose();
				    	home p = new home();
					    p.setVisible(true);
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(btnNewButton, "invalid credentials");
				    }
				}
				/*uname = txtUser.getText();
				pwd = txtPwd.getText();
				if(uname.equalsIgnoreCase("chetana")&&pwd.equals("1234"))
				{
					JOptionPane.showMessageDialog(btnNewButton, "successfully logged in");
				    Placingorder p = new Placingorder();
				    p.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "invalid credentials");
				}*/
				catch(Exception exc) {exc.printStackTrace();}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(274, 419, 85, 21);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setText(null);
				txtPwd.setText(null);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Name");
		lblNewLabel_1_1.setBounds(110, 315, 98, 13);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setBounds(110, 359, 98, 13);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtUser = new JTextField();
		txtUser.setBounds(274, 313, 96, 19);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(274, 357, 98, 19);
		frame.getContentPane().add(txtPwd);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/loginimg.jpeg"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(132, 10, 227, 235);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
		
	}
}
