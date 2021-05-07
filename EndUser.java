import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EndUser implements ActionListener 
{
	JFrame jf;
	Container c;
	JPanel p1,p2;	
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4;
	int rank; 
	JLabel mg1, mg2, mg3, mg4, mg5, mg6, mg7, mg8, mg9, mg10, g11, g22, g33,g44, g55, g66, g77,l8,l9;
	ImageIcon banner;
	JTextArea ta;
	JScrollPane sp;
	String name;
	MenuBar mbr;
	Menu file;
	MenuItem  item2,trust;
	String keyw="";
	@SuppressWarnings("deprecation")
	EndUser(String name)
	{
		jf = new JFrame("End User::A Novel Scheduling Mechanism For Hybrid Cloud Systems");
		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		mbr = new MenuBar();
		file = new Menu("File");
		item2 = new MenuItem("Search Cloud Files");
		item2.addActionListener(this);
		
		trust = new MenuItem("Find Trustworthy Files");
		trust.addActionListener(this);
		
		file.add(item2);
		file.add(trust);
		mbr.add(file);
//		jf.setMenuBar(mbr);
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("EndUser.png"));
		JLabel title = new JLabel();
		title.setIcon(banner);
		title.setBounds(10, 0,  630,450);
		
		
		l1=new JLabel("User Name");
		l1.setBounds(50, 50, 100, 30);
		
		l2=new JLabel("File Name");
		l2.setBounds(50, 115, 100, 30);
		
		l3=new JLabel("Secret Key");
		l3.setBounds(50, 175, 100, 30);
		
		String user=name;
		t1 = new JTextField();
		t1.setBounds(50, 80, 100, 30);
		t1.setText(user);
		t1.setEditable(false);
		
		t2 = new JTextField();
		t2.setBounds(50, 140, 100, 30);
		
		t3 = new JTextField();
		t3.setBounds(50, 200, 100, 30);
		
		b1 = new JButton("Req-SK");
		b1.setBounds(50, 250, 100, 30);
		b1.addActionListener(this);
		
		b2 = new JButton("Download");
		b2.setBounds(50, 300, 100, 30);
		b2.addActionListener(this);
		
		b3 = new JButton("K Nearest Search");
		b3.setBounds(150, 380, 150, 30);
		b3.addActionListener(this);
		
		b4 = new JButton("Keyword Search");
		b4.setBounds(350, 380, 150, 30);
		b4.addActionListener(this);
		
		ta = new JTextArea();
		ta.setColumns(100);
		ta.setRows(100);
		
		sp = new JScrollPane();
		sp.setViewportView(ta);
		sp.setBounds(275, 80, 240, 230);
		
//		ImageIcon banner = new ImageIcon(this.getClass().getResource("end.png"));
//		JLabel title = new JLabel();
//		title.setIcon(banner);
//		title.setBounds(0, -70,  950,570);
		
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(sp);
		c.add(b2);
		c.add(b1);
//		c.add(b3);
//		c.add(b4);
		
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.add(title);
///		c.add(l5);
//		c.add(username);
		jf.setSize(660,490);
		jf.show();
		
	}


	public void actionPerformed(ActionEvent e1)
	{
		Object o = e1.getSource();
		
		
		if(o==b1)
		{
			try {
			String file =t2.getText();
			if(file.equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(null, "Enter The File Name");
				
				
			}
			else
			{
				String[] dsn = { "Select", "CS1", "CS2", "CS3"};
				
				 keyw = (String) JOptionPane.showInputDialog(null,
						"Select Cloud Server", " CloudServer",
						JOptionPane.QUESTION_MESSAGE, null,  dsn,  dsn[0]);
				 
				 String ip = JOptionPane.showInputDialog(null,"Enter Data Server Ip Address");
					
					Socket g = new Socket(ip,4747);
					DataOutputStream d = new DataOutputStream(g.getOutputStream());
					d.writeUTF(file);
					d.writeUTF(keyw);
					
										
					DataInputStream dis = new DataInputStream(g.getInputStream());
					
					String msg = dis.readUTF();
					String sk = dis.readUTF();
					
					if(msg.equalsIgnoreCase("key"))
					{
						JOptionPane.showMessageDialog(null, "Got Secret Key");
						t3.setText(sk);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "File Doesn't Exist");
					}
					
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(o == b2)
		{
						
			 String user = t1.getText();
			 String file = t2.getText();
			 String sk = t3.getText();
			 try
			 {
					if(file.equalsIgnoreCase("") || sk.equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(null, "Enter The File Name & Secret Key");
					}
					else
					{
						 String ip = JOptionPane.showInputDialog(null,"Enter Data Server Ip Address");
						 
						 Socket cn2 = new Socket(ip,9999);
						  DataOutputStream oos2 = new DataOutputStream(cn2.getOutputStream());
						  
						  oos2.writeUTF(user);
						  oos2.writeUTF(file);
						  oos2.writeUTF(sk);
						  oos2.writeUTF(keyw);
						  
						  DataInputStream din = new DataInputStream(cn2.getInputStream());
						  
						  String msg =  din.readUTF();
						  String content =  din.readUTF();
						  
						  if(msg.equalsIgnoreCase("success"))
							{
								ta.setText(content);
									
								String str = ta.getText();
								FileOutputStream fos = new FileOutputStream("EndUser/"+ file);
								fos.write(str.getBytes());
								System.out.println("Received Successfully");
									  
								 JOptionPane.showMessageDialog(null, "File Downloaded Successfully");
							}
						  if(msg.equalsIgnoreCase("failure"))
							{
								JOptionPane.showMessageDialog(null, "File Name / Seret Key Mismatch \n You Are An Attacker");
							} 
					}  
				  
			 }catch(Exception e2)
			 {
				 e2.printStackTrace();
			 }
		}
				
		}
	public static void main(String[] args) {
	
		new EndUser("a");
	}
}