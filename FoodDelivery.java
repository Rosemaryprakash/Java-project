package fooddelivery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FoodDelivery extends JFrame{

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodDelivery window = new FoodDelivery();
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
	public FoodDelivery() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 518, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(203, 248, 124, 65);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 31));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(142, 304, 132, 33);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(253, 314, 141, 19);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setBounds(142, 353, 85, 18);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setBounds(253, 355, 141, 19);
		frame.getContentPane().add(password);
		
		JButton loginbutton = new JButton("Login");
		loginbutton.setBounds(201, 403, 73, 21);
		loginbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","Rose12");
					Statement stmt=con.createStatement();
					String query1="select * from users where UEMAIL='"+username.getText()+"' and UPASS='"+password.getText()+"'";
					System.out.println(query1);
					ResultSet rs = stmt.executeQuery(query1);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Successfully");
						frame.setVisible(false);
						Main mn=new Main(rs.getInt("USERID"));
						System.out.println(rs.getInt("USERID"));
						mn.setVisible(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Login Failed: please check username or password");
					}
					
				}
				catch(Exception e4)
				{}
				
			}
		});
		frame.getContentPane().add(loginbutton);
		
		JButton signupbutton = new JButton("Signup");
		signupbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Registration().setVisible(true);
				frame.setVisible(false);
				
			}
		});
		signupbutton.setBounds(201, 435, 85, 21);
		frame.getContentPane().add(signupbutton);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Rosemary\\Downloads\\project (1).jpg"));
		lblNewLabel_3.setBounds(10, 10, 498, 479);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
