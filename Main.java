package fooddelivery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main extends JFrame{

	private JFrame frame;
	 int uid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main window = new Main(uid);
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
	public Main(int id) {
		uid=id;
		System.out.println(id);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 153));
		frame.setBounds(100, 100, 1078, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Fuditem = new JLabel("FOOD ITEMS");
		Fuditem.setBounds(428, 10, 206, 38);
		Fuditem.setFont(new Font("STSong", Font.BOLD, 20));
		frame.getContentPane().add(Fuditem);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(23, 58, 186, 155);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rosemary\\OneDrive\\Pictures\\biriyani_nw.jpg"));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(23, 372, 224, 177);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rosemary\\OneDrive\\Pictures\\burgernw.jpg"));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(408, 58, 186, 155);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Rosemary\\OneDrive\\Pictures\\porottanw.jpg"));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(428, 394, 160, 155);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Rosemary\\OneDrive\\Pictures\\shawarmanw.jpg"));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(787, 58, 221, 155);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Rosemary\\OneDrive\\Pictures\\chicken_currynw.jpg"));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(787, 378, 221, 165);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Rosemary\\Downloads\\noodles.jpg"));
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("Chicken Biriyani");
		lblNewLabel_8.setBounds(23, 221, 153, 24);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Parotta");
		lblNewLabel_8_1.setBounds(408, 223, 153, 24);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("Chicken Curry");
		lblNewLabel_8_2.setBounds(787, 221, 153, 24);
		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_8_2);
		
		String s[]={"1","2","3","4","5","6","7","8","9","10"};
		JComboBox comboBox = new JComboBox(s);
		comboBox.setBounds(168, 225, 41, 21);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(s);
		comboBox_1.setBounds(554, 225, 40, 21);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(s);
		comboBox_2.setBounds(966, 225, 42, 21);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox(s);
		comboBox_3.setBounds(206, 572, 41, 21);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox(s);
		comboBox_4.setBounds(570, 556, 34, 21);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox(s);
		comboBox_5.setBounds(978, 556, 42, 21);
		frame.getContentPane().add(comboBox_5);
		
		JLabel lblNewLabel_6 = new JLabel("Burger");
		lblNewLabel_6.setBounds(33, 559, 95, 17);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Shawarma");
		lblNewLabel_7.setBounds(412, 556, 95, 17);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Noodles");
		lblNewLabel_9.setBounds(787, 552, 126, 24);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.setBounds(23, 247, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","Rose12");
					Statement stmt=con.createStatement();
					String query="select count(OID) from orders";
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int oid=rs.getInt(1);
					int newoid=oid+1;
					String query1="insert into orders values('"+newoid+"','"+uid+"','"+110+"','Chicken Biriyani','"+comboBox.getSelectedItem().toString()+"')";
					System.out.println(query);
					System.out.println(query1);
					int i=stmt.executeUpdate(query1);
					if(i!=0)
					{
						JOptionPane.showMessageDialog(null,"Chicken Biriyani ordered");
						frame.setVisible(false);
						new Details(i).setVisible(true);
						//frame.setVisible(false);
					}else
					{
						JOptionPane.showMessageDialog(null,"Chicken Biriyani ordered");
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}
					
				}catch(Exception e2)
				{
					System.out.print(e2);
				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buy");
		btnNewButton_1.setBounds(408, 247, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","Rose12");
					Statement stmt=con.createStatement();
					String query="select count(OID) from orders";
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int oid=rs.getInt(1);
					int newoid=oid+1;
					String query1="insert into orders values('"+newoid+"','"+uid+"','"+12+"','Parotta','"+comboBox_1.getSelectedItem().toString()+"')";
					System.out.println(query);
					System.out.println(query1);
					int i=stmt.executeUpdate(query1);
					if(i!=0)
					{
						JOptionPane.showMessageDialog(null,"Parotta ordered");
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}else
					{
						JOptionPane.showMessageDialog(null,"Parotta ordered");	
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}
				}catch(Exception e2)
				{
					System.out.print(e2);
				}
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Buy");
		btnNewButton_2.setBounds(787, 247, 85, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","Rose12");
					Statement stmt=con.createStatement();
					String query="select count(OID) from orders";
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int oid=rs.getInt(1);
					int newoid=oid+1;
					String query1="insert into orders values('"+newoid+"','"+uid+"','"+75+"','Chicken Curry','"+comboBox_2.getSelectedItem().toString()+"')";
					System.out.println(query);
					System.out.println(query1);
					int i=stmt.executeUpdate(query1);
					if(i!=0)
					{
						JOptionPane.showMessageDialog(null,"Chicken curry ordered");
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}else
					{
						JOptionPane.showMessageDialog(null,"Chicken curry ordered");	
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}
				}catch(Exception e2)
				{
					System.out.print(e2);
				}
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buy");
		btnNewButton_3.setBounds(23, 586, 85, 21);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","Rose12");
					Statement stmt=con.createStatement();
					String query="select count(OID) from orders";
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int oid=rs.getInt(1);
					int newoid=oid+1;
					String query1="insert into orders values('"+newoid+"','"+uid+"','"+125+"','Burger','"+comboBox_3.getSelectedItem().toString()+"')";
					System.out.println(query);
					System.out.println(query1);
					int i=stmt.executeUpdate(query1);
					if(i!=0)
					{
						JOptionPane.showMessageDialog(null,"Burger ordered");
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}else
					{
						JOptionPane.showMessageDialog(null,"Burger ordered");	
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}
				}catch(Exception e2)
				{
					System.out.print(e2);
				}
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Buy");
		btnNewButton_4.setBounds(408, 583, 85, 21);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","Rose12");
					Statement stmt=con.createStatement();
					String query="select count(OID) from orders";
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int oid=rs.getInt(1);
					int newoid=oid+1;
					String query1="insert into orders values('"+newoid+"','"+uid+"','"+105+"','Shawarma','"+comboBox_4.getSelectedItem().toString()+"')";
					System.out.println(query);
					System.out.println(query1);
					int i=stmt.executeUpdate(query1);
					if(i!=0)
					{
						JOptionPane.showMessageDialog(null,"Shawarma ordered");
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}else
					{
						JOptionPane.showMessageDialog(null,"Shawarma ordered");	
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}
				}catch(Exception e2)
				{
					System.out.print(e2);
				}
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Buy");
		btnNewButton_5.setBounds(787, 586, 85, 21);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","Rose12");
					Statement stmt=con.createStatement();
					String query="select count(OID) from orders";
					ResultSet rs=stmt.executeQuery(query);
					rs.next();
					int oid=rs.getInt(1);
					int newoid=oid+1;
					String query1="insert into orders values('"+newoid+"','"+uid+"','"+120+"','Noodles','"+comboBox_5.getSelectedItem().toString()+"')";
					System.out.println(query);
					System.out.println(query1);
					int i=stmt.executeUpdate(query1);
					if(i!=0)
					{
						JOptionPane.showMessageDialog(null,"Noodles ordered");
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}else
					{
						JOptionPane.showMessageDialog(null,"Noodles ordered");
						frame.setVisible(false);
						new Details(i).setVisible(true);
					}
				}catch(Exception e2)
				{
					System.out.print(e2);
				}
			}
		});
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_10 = new JLabel("Cash on delivery only");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_10.setBounds(875, 18, 145, 24);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Price : 110/- per piece");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(23, 278, 149, 31);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_11_1 = new JLabel("Price : 12/- per piece");
		lblNewLabel_11_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_11_1.setBounds(412, 278, 149, 31);
		frame.getContentPane().add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11_2 = new JLabel("Price : 75/- per piece");
		lblNewLabel_11_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_11_2.setBounds(787, 278, 149, 31);
		frame.getContentPane().add(lblNewLabel_11_2);
		
		JLabel lblNewLabel_11_3 = new JLabel("Price : 125/- per piece");
		lblNewLabel_11_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_11_3.setBounds(23, 617, 149, 31);
		frame.getContentPane().add(lblNewLabel_11_3);
		
		JLabel lblNewLabel_11_4 = new JLabel("Price : 105/- per piece");
		lblNewLabel_11_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_11_4.setBounds(408, 614, 149, 31);
		frame.getContentPane().add(lblNewLabel_11_4);
		
		JLabel lblNewLabel_11_5 = new JLabel("Price : 120/- per piece");
		lblNewLabel_11_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_11_5.setBounds(787, 617, 149, 31);
		frame.getContentPane().add(lblNewLabel_11_5);
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
