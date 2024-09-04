import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JavaCard {

	private JFrame frame;
	private JTextField name;
	private JTextField edition;
	private JTextField price;
	private JTextField id2;

	/**
	 * Launch the application.
	 */

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCard window = new JavaCard();
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
	public JavaCard() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/javacurd", "root","");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex) 
	        {
	               ex.printStackTrace();
	        }
	    }
	
	 public void table_load()
	 {
	     try 
	     {
	     pst = con.prepareStatement("select * from book");
	     rs = pst.executeQuery();
	     table.setModel(DbUtils.resultSetToTableModel(rs));
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
		frame.setBounds(100, 100, 892, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book shop");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel.setBounds(339, 10, 371, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 96, 388, 274);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 34, 211, 46);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Edition");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 117, 211, 46);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(10, 207, 211, 46);
		panel.add(lblNewLabel_1_2);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setBackground(new Color(255, 255, 255));
		name.setBounds(207, 38, 157, 31);
		panel.add(name);
		name.setColumns(10);
		
		edition = new JTextField();
		edition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		edition.setColumns(10);
		edition.setBackground(Color.WHITE);
		edition.setBounds(207, 121, 157, 31);
		panel.add(edition);
		
		price = new JTextField();
		price.setFont(new Font("Tahoma", Font.PLAIN, 20));
		price.setColumns(10);
		price.setBackground(Color.WHITE);
		price.setBounds(207, 207, 157, 31);
		panel.add(price);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getName = name.getText().toString();
				String getPrice = price.getText();
				String getEdition = edition.getText();
				 try {
				        pst = con.prepareStatement("insert into book(name,edition,price)values(?,?,?)");
				        pst.setString(1, getName);
				        pst.setString(2, getEdition);
				        pst.setString(3, getPrice);
				        pst.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
				        table_load();
					
					name.setText("");
					edition.setText("");
					price.setText("");
					name.requestFocus();
				}catch(Exception es) {
					es.printStackTrace();
				}
			}
		});
		save.setFont(new Font("Tahoma", Font.PLAIN, 24));
		save.setBackground(Color.CYAN);
		save.setBounds(20, 378, 109, 37);
		frame.getContentPane().add(save);
		
		JButton exit = new JButton("Exit");
		exit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		exit.setBackground(Color.CYAN);
		exit.setBounds(144, 380, 109, 37);
		frame.getContentPane().add(exit);
		
		JButton clear = new JButton("Clear");
		clear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		clear.setBackground(Color.CYAN);
		clear.setBounds(270, 380, 109, 37);
		frame.getContentPane().add(clear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 425, 452, 97);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Book id");
		lblNewLabel_1_1_1.setBounds(26, 27, 146, 20);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_1_1);
		
		id2 = new JTextField(); 
		id2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				  
                try {
                     
                       String id = id2.getText();
                           pst = con.prepareStatement("select name,edition,price from book where id = ?");
                           pst.setString(1, id);
                           ResultSet rs = pst.executeQuery();
                       if(rs.next()==true)
                       {
                    	   String name1 = rs.getString(1);
                           String edition1 = rs.getString(2);
                           String price1 = rs.getString(3);
                           
                           name.setText(name1);
                           edition.setText(edition1);
                           price.setText(price1);
   
   
                       }   
                       else
                       {
                    	   name.setText("");
                    	   edition.setText("");
                    	   price.setText("");
                            
                       }
                   } 
               
                catch (SQLException ex) {
                      
                   }
           
			}
		});
		id2.setBounds(240, 20, 176, 31);
		id2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		id2.setColumns(10);
		id2.setBackground(Color.WHITE);
		panel_1.add(id2);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String getId = id2.getText();
				

				
				try {
					pst = con.prepareStatement("delete from book where id = ?");
					pst.setString(1, getId);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "deleted");
					table_load();
					name.setText("");
					edition.setText("");
					price.setText("");
					name.requestFocus();
				}
				catch(Exception e5) {
					e5.printStackTrace();
				}
			}
		});
		delete.setFont(new Font("Tahoma", Font.PLAIN, 24));
		delete.setBackground(Color.CYAN);
		delete.setBounds(679, 425, 141, 71);
		frame.getContentPane().add(delete);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getName= name.getText();
				String getEdition = edition.getText();
				String getId = id2.getText();
				String getPrice = price.getText();
				
				try {
					pst = con.prepareStatement("update book set name= ?,edition=?,price=? where id =?");
					
					pst.setString(1, getName);
					pst.setString(2, getEdition);
					pst.setString(3, getPrice);
					pst.setString(4, getId);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "updated");
					table_load();
					name.setText("");
					edition.setText("");
					price.setText("");
					name.requestFocus();
					
				}catch(Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		update.setFont(new Font("Tahoma", Font.PLAIN, 24));
		update.setBackground(Color.CYAN);
		update.setBounds(528, 425, 141, 71);
		frame.getContentPane().add(update);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(420, 100, 440, 300); // Adjust size and position as needed
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//			}
//		));
	}
}
