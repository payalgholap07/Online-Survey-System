package survey;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class Viewsurvey {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void vsry() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewsurvey window = new Viewsurvey();
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
	public Viewsurvey() {
		initialize();
		Connect();
		table_load();
	}

	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	private JTable table;
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
	
	public void table_load()
	{
	    try 
	    {
	    pat = con.prepareStatement("select * from adds");
	    rs = pat.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));
//	    	Viewsurvey v = con.createStatement();
	} 
	    catch (SQLException e) 
	     {
	        e.printStackTrace();
	  } 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 53, 508, 373);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		frame.setBounds(100, 100, 691, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		Addsurvey v = con.createStatement();
//		String query = "select * from adds";
//		ResultSet r = v.
		
	}
}
