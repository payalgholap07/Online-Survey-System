package survey;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;


public class PanelAdds extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public PanelAdds() {
		setSize(525,525);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Survey");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(185, 10, 219, 40);
		add(lblNewLabel);

		
		JLabel lblNewLabel_1 = new JLabel("Add Question:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(53, 58, 136, 26);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Option1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(53, 136, 114, 26);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Option2");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(53, 214, 68, 32);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Option3");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(53, 297, 102, 20);
		add(lblNewLabel_4);

		
		JLabel lblNewLabel_5 = new JLabel("Option4");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(53, 369, 68, 26);
		add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(191, 459, 143, 32);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(63, 84, 400, 42);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(63, 161, 202, 43);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(59, 247, 208, 40);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(63, 319, 202, 40);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(63, 399, 202, 40);
		add(textField_4);
		textField_4.setColumns(10);
	}

}

