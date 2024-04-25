package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  STUDENT MANAGEMENT SYSTEM");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/studimg.jpg"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(138, 10, 546, 200);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		ImageIcon imag = new ImageIcon(this.getClass().getResource("/addstud.jpg"));
		btnNewButton.setIcon(imag);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	addstudent l = new addstudent();
			    l.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(83, 326, 159, 159);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		ImageIcon image = new ImageIcon(this.getClass().getResource("/operation.jpg"));
		btnNewButton_1.setIcon(image);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	operations m = new operations();
			    m.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(330, 326, 159, 159);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		ImageIcon imagee = new ImageIcon(this.getClass().getResource("/stud.jpg"));
		btnNewButton_1_1.setIcon(imagee);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	showstudent m = new showstudent();
			    m.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(564, 326, 201, 159);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("ADD STUDENT");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(108, 508, 110, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("OPERATION");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(359, 508, 110, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("SHOW STUDENTS");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(591, 508, 168, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	Login m = new Login();
			    m.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2.setBounds(370, 572, 85, 21);
		contentPane.add(btnNewButton_2);
		
	}
}
