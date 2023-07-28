package survey;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Adds {

	private JFrame frame;
	private JTextField question;
	private JTextField op1;
	private JTextField op2;
	private JTextField op3;
	private JTextField op4;

	/**
	 * Launch the application.
	 */
	public static void addsrvy() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adds window = new Adds();
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
	public Adds() {
		initialize();
		Connect();
	
	}
	
	

	Connection con;
	PreparedStatement pat;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/survey", "root","");
		}
		catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
		}
		catch (SQLException ex) {
			 ex.printStackTrace();	
		}
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Question:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(60, 40, 138, 32);
		frame.getContentPane().add(lblNewLabel);
		
		question = new JTextField();
		question.setBounds(81, 82, 526, 39);
		frame.getContentPane().add(question);
		question.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Option1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(60, 131, 138, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		op1 = new JTextField();
		op1.setBounds(81, 161, 275, 39);
		frame.getContentPane().add(op1);
		op1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Option2:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(60, 210, 113, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		op2 = new JTextField();
		op2.setBounds(81, 246, 275, 39);
		frame.getContentPane().add(op2);
		op2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Option3:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(60, 297, 113, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		op3 = new JTextField();
		op3.setBounds(81, 329, 275, 39);
		frame.getContentPane().add(op3);
		op3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Option4:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_4.setBounds(60, 378, 107, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		op4 = new JTextField();
		op4.setBounds(81, 414, 275, 39);
		frame.getContentPane().add(op4);
		op4.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ques ,opt1,opt2,opt3,opt4;
				ques = question.getText();
				opt1 = op1.getText();
				opt2 = op2.getText();
				opt3 = op3.getText();
				opt4 = op4.getText();
				
				try {
					pat = con.prepareStatement("insert into adds(question,opt1,opt2,opt3,opt4)values(?,?,?,?,?)");
					pat.setString(1, ques);
					pat.setString(2, opt1);
					pat.setString(3, opt2);
					pat.setString(4, opt3);
					pat.setString(5, opt4);
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Submitted Successfully");
					question.setText("");
					op1.setText("");
					op2.setText("");
					op3.setText("");
					op4.setText("");
					question.requestFocus();
			}
				catch (SQLException e1) {
					e1.printStackTrace();
			
			}
			}			
			});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setBounds(271, 471, 107, 32);
		frame.getContentPane().add(btnNewButton);
//		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
//		btnNewButton.setBounds(292, 380, 150, 44);
//		panel.add(btnNewButton);
	
	}
}
