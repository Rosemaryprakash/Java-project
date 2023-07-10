package fooddelivery;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Registration extends JFrame{

	private JFrame frame;
	private JTextField name;
	private JTextField housename;
	private JTextField street;
	private JTextField landmark;
	private JTextField mobile;
	private JTextField pin;
	private JTextField email;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Registration window = new Registration();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 811, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Registration = new JLabel("Registration");
		Registration.setBounds(109, 44, 169, 21);
		Registration.setFont(new Font("Segoe UI", Font.BOLD, 17));
		frame.getContentPane().add(Registration);
		
		JLabel lblNewLabel_2 = new JLabel("Name  :");
		lblNewLabel_2.setBounds(109, 123, 117, 35);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("House Name :");
		lblNewLabel_3.setBounds(109, 157, 133, 27);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Street :");
		lblNewLabel_4.setBounds(109, 194, 103, 13);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Landmark :");
		lblNewLabel_5.setBounds(109, 217, 103, 21);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mobile Number :");
		lblNewLabel_6.setBounds(109, 248, 145, 20);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Pin Code :");
		lblNewLabel_7.setBounds(109, 278, 107, 21);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Email id :");
		lblNewLabel_8.setBounds(109, 309, 117, 21);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_8);
		
		name = new JTextField();
		name.setBounds(247, 133, 154, 19);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		housename = new JTextField();
		housename.setBounds(247, 163, 154, 19);
		frame.getContentPane().add(housename);
		housename.setColumns(10);
		
		street = new JTextField();
		street.setBounds(247, 193, 154, 19);
		frame.getContentPane().add(street);
		street.setColumns(10);
		
		landmark = new JTextField();
		landmark.setBounds(247, 222, 154, 19);
		landmark.setColumns(10);
		frame.getContentPane().add(landmark);
		
		mobile = new JTextField();
		mobile.setBounds(247, 251, 154, 19);
		mobile.setColumns(10);
		frame.getContentPane().add(mobile);
		
		pin = new JTextField();
		pin.setBounds(247, 281, 154, 19);
		pin.setColumns(10);
		frame.getContentPane().add(pin);
		
		email = new JTextField();
		email.setBounds(247, 312, 154, 19);
		email.setColumns(10);
		frame.getContentPane().add(email);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setBounds(109, 340, 103, 16);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(247, 341, 154, 19);
		frame.getContentPane().add(passwordField);
		
		
		JButton Registerbutton = new JButton("Register");
		Registerbutton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(Registerbutton);
		Registerbutton.setBounds(161, 385, 127, 21);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rosemary\\Downloads\\lunchboxes-color-table-flat-lay-healthy-food-delivery-160387657.jpg"));
		lblNewLabel.setBounds(10, 10, 809, 489);
		frame.getContentPane().add(lblNewLabel);
		
		Registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String pass= new String(passwordField.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","Rose12");
					Statement stmt=con.createStatement();
					String query="select count(userid) from users";

					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int uid=rs.getInt(1);
					int newuid=uid+1;
					String sql="insert into users values(?,?,?,?,?,?,?,?,?)"; 
					
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, newuid);
					ps.setString(2, name.getText());
					ps.setString(3, housename.getText());
					ps.setString(4, street.getText());
					ps.setString(5, landmark.getText());
					ps.setInt(6, Integer.parseInt(pin.getText()));
					ps.setString(7, email.getText());
					ps.setString(8, pass);
					ps.setInt(9, Integer.parseInt(mobile.getText()));
					System.out.println(ps);
					try
					{                                 
						int i=ps.executeUpdate(); 
						System.out.println(i);
						if(i!=0)
						{
							JOptionPane.showMessageDialog(null,"Data Saved");	
							frame.setVisible(false);
							new FoodDelivery().setVisible(true);
							//frame.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Data not Saved");
						}
						
					}catch(Exception e1) {
						System.out.println(e1);	
					}
					
				}
				catch(Exception e2) {}
			}
		});
		frame.setVisible(true);
	}

//	public void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}
}
