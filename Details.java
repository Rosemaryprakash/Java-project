package fooddelivery;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Details extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	int usid;
	private JLabel Price;
	private JTextField textField_4;

	public Details(int i) {
		usid=i;
		initialize();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details window = new Details();
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
	public Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(35, 44, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(149, 41, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("email");
		lblNewLabel_1.setBounds(35, 80, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 77, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("item");
		lblNewLabel_2.setBounds(35, 117, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(149, 114, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("quantity");
		lblNewLabel_3.setBounds(35, 153, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(149, 150, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		Price = new JLabel("Price");
		Price.setBounds(35, 190, 45, 13);
		frame.getContentPane().add(Price);
		
		textField_4 = new JTextField();
		textField_4.setBounds(149, 187, 96, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","Rose12");
			Statement stmt=con.createStatement();
			String query="select * from users where userid='"+usid+"'";
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				textField.setText(rs.getString(2));
				textField_1.setText(rs.getString(7));
			}
			String query1="select * from orders where userid='"+usid+"'";
			ResultSet rst=stmt.executeQuery(query);
			if(rst.next())
			{
				textField_2.setText(rs.getString(4));
				textField_3.setText(rs.getString(5));
				//int price=rs.getInt(5*6);
				//textField_4.setText(Integer.parseInt(query1, rs.getInt(5*6)));
			}
			
		}
		catch(Exception e3) {}
	}

//	public void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}
}
