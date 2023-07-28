package survey;

import java.sql.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import onlines.On.PanelButtonMouseAdapter;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class Survey {

	private JFrame frame1 ;
	private JTextField name;
	private JTextField uname;
	private JTextField password;
	private JTextField cpass;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Survey window = new Survey();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Survey() {
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
			
		}
		catch (SQLException ex) {
			
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(Color.DARK_GRAY);
		frame1.setBackground(Color.PINK);
		frame1.getContentPane().setForeground(Color.PINK);
		frame1.setBounds(100, 100, 760, 611);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Online Survey");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 32));
		lblNewLabel.setBounds(233, 10, 254, 56);
		frame1.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 72, 726, 469);
		frame1.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(61, 53, 94, 26);
		panel.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(71, 89, 451, 35);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(61, 134, 124, 26);
		panel.add(lblNewLabel_2);
		
		uname = new JTextField();
		uname.setBounds(71, 177, 451, 35);
		panel.add(uname);
		uname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(66, 224, 119, 35);
		panel.add(lblNewLabel_3);
		
		password = new JTextField();
		password.setBounds(76, 271, 197, 35);
		panel.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(420, 231, 206, 26);
		panel.add(lblNewLabel_4);
		
		cpass = new JTextField();
		cpass.setBounds(420, 272, 225, 34);
		panel.add(cpass);
		cpass.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namee, unamee,passwordd,cpasswd; 
				namee = name.getText();
				unamee = uname.getText();
				passwordd = password.getText();
				cpasswd = cpass.getText();
				
				try {
					pat = con.prepareStatement("insert into form(name,uname,password,cpass)values(?,?,?,?)");
					pat.setString(1, namee);
					pat.setString(2, unamee);
					pat.setString(3, passwordd);
					pat.setString(4, cpasswd);
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Submitted Successfully");
					name.setText("");
					uname.setText("");
					password.setText("");
					cpass.setText("");
//					name.requestFocus();
					
					Addsurvey a =new Addsurvey();
					a.Selectopt();
//					Msurvey m = new Msurvey();
//					m.NewScreen();
					
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(292, 380, 150, 44);
		panel.add(btnNewButton);
	}
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		 public void mouseEntered(MouseEvent e) {
			 panel.setBackground(new Color(112,128,144));
		 }
		 @Override
		 public void mouseExited(MouseEvent e) {
			 panel.setBackground(new Color(47,79,79));
		 }
		 @Override
		 public void mousePressed(MouseEvent e) {
			 panel.setBackground(new Color(60,179,113));
		 }
		 @Override
		 public void mouseReleased(MouseEvent e) {
			 panel.setBackground(new Color(112,128,144));
		 }
}}