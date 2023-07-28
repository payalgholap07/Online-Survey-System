package survey;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Addsurvey {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Selectopt() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addsurvey window = new Addsurvey();
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
	public Addsurvey() {
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
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 868, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(21, 94, 770, 527);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Survey");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adds a =new Adds();
				a.addsrvy();
			}
		});
//		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
//		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(87, 220, 192, 56);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Survey");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Viewsurvey v =new Viewsurvey();
				v.vsry();
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
//		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_1.setBounds(469, 220, 192, 56);
		panel.add(btnNewButton_1);
		
//		JButton btnNewButton_2 = new JButton("Feedback");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Msurvey m = new Msurvey();
//				m.NewScreen();
//			}
//		});
//		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
//		btnNewButton_2.setBounds(319, 385, 152, 49);
//		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Online Survey");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		lblNewLabel.setBounds(336, 20, 218, 41);
		frame.getContentPane().add(lblNewLabel);
		
	}

}
