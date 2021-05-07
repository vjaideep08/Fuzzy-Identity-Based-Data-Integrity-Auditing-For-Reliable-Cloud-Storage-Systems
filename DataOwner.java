import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import java.util.*;

public class DataOwner implements ActionListener {
	JFrame jf;
	Container c;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JButton b1, b2, b3, b4, b5, b6,b2m;
	JScrollPane sp;
	JTextArea ta;
	JTextField t1, t2, t3;
	MenuBar mbr;
	Menu file;
	MenuItem item,item2;
	Border b11, b22, b33;
	File path;
	JComboBox jb;
	Object type;
	String selItem,mac;
	Cipher encoder;
	Key prKey;
	int rank;
	JLabel ownername;
	JTextField ownertext;
	
	public static Key pubKey;
	public Font f = new Font("Times new roman", Font.BOLD, 16);
	String keyWord = "ef50a0ef2c3e3a5fdf803ae9752c8c66";
	
	DataOwner(String name) {
		jf = new JFrame("Data Owner :: A Novel Scheduling Mechanism For Hybrid Cloud Systems");
		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(141,170,161));
		
		mbr = new MenuBar();
		file = new Menu("View Owner Files");
		item= new MenuItem("View Owner Files");
		item.addActionListener(this);
		file.add(item);
		
		item2= new MenuItem("View Audit Result");
		item2.addActionListener(this);
//		file.add(item2);
//		
		mbr.add(file);
		jf.setMenuBar(mbr);
		
		ownername = new JLabel("Owner Name");
		ownername.setFont(f);
		ownername.setBounds(70, 100, 120, 30);
		c.add(ownername);
		
		ownertext = new JTextField();
		ownertext.setBounds(70, 130, 120, 30);
		ownertext.setFont(f);
		ownertext.setText(name);
		ownertext.setEditable(false);
		
		c.add(ownertext);


		ta = new JTextArea();
		ta.setColumns(100);
		ta.setRows(100);

		sp = new JScrollPane();
		sp.setViewportView(ta);
		sp.setBounds(305, 130, 315, 250);

		b1 = new JButton("Browse");
		b2 = new JButton("Upload File");
		b3 = new JButton("Verify");
		b4 = new JButton("Update Block");
		b5 = new JButton("Purchase");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		b1.setBackground(Color.YELLOW);
		b2.setBackground(Color.YELLOW);
		b3.setBackground(Color.YELLOW);
		b4.setBackground(Color.YELLOW);
		b5.setBackground(Color.YELLOW);
		
//		item.addActionListener(this);

		b1.setBounds(70, 190, 120, 30);
		b2.setBounds(70, 250, 120, 30);
		b3.setBounds(70, 310, 120, 30);
		b4.setBounds(70, 370, 120, 30);
		b5.setBounds(95, 430, 120, 30);
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("DataOwner.png"));
		JLabel title = new JLabel();
		title.setIcon(banner);
		title.setBounds(5, 10,  750,450);
		
		
		
		c.add(sp);
//		c.add(l1);
		
//		c.add(l2);
		c.add(b1);
		c.add(b2);
//		c.add(b3);
//		c.add(b4);
//		c.add(b5);
    	c.add(title);
//		c.add(title);
		jf.setSize(770,530);
		jf.show();
		
	
	}

	class PortListener implements Runnable {
			
			int port;

			public PortListener(int port) {
				this.port = port;
			}

			public void run() {
				try{
				Class.forName("com.mysql.jdbc.Driver");
				Dbcon db=new Dbcon();
				Connection connect=db.getConnection();
				Socket s;
				 
			 
				}catch (Exception e) {
						e.printStackTrace();
				}
			}
	}
	public void actionPerformed(ActionEvent e) {
		String strline = "";
		Object o = e.getSource();
		if (o == item) {

			try
			{
				ViewOwnerFiles v = new ViewOwnerFiles();
				v.setSize(600, 400);
				v.setVisible(true);
				
			}catch (Exception e5) {
				// TODO: handle exception
			}
		}
		if (o == item2) {

			try
			{
				String ip = JOptionPane.showInputDialog(null, "Enter Verifier IP Address");
				Socket stm=new Socket(ip,1777);
				ObjectOutputStream dos3=new ObjectOutputStream(stm.getOutputStream());
				dos3.writeObject("request"); 
				
				
				ObjectInputStream ins=new ObjectInputStream(stm.getInputStream());
				Vector a1=(Vector) ins.readObject();
				System.out.println(a1);
				
//				ViewAuditResult1 v = new ViewAuditResult1(a1);
//				v.setSize(600,400);
//				v.setVisible(true);
				
			}catch (Exception e5) {
				// TODO: handle exception
			}
		}
		
		if (o == b1) {
			JFileChooser chooser = new JFileChooser("Database");
			try {
				File f = new File(new File("filename.txt").getCanonicalPath());
				chooser.setSelectedFile(f);
			} catch (IOException e1) {
			}

			int retval = chooser.showOpenDialog(b1);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File field = chooser.getSelectedFile();
				
				path = chooser.getSelectedFile();
			}

			File curFile = chooser.getSelectedFile();
			try {
				FileInputStream fstream = new FileInputStream(curFile);
				DataInputStream ins = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						ins));
				StringBuffer buffer = new StringBuffer();

				while ((strline = br.readLine()) != null) {
//					System.out.println(strline);
					buffer.append(strline + "\n");
				}
				ta.setText(buffer.toString());
				
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(o == b5)
		{
			try{
				
			}catch (Exception e3) {
				// TODO: handle exception
			}
		}
		if(o == b3)
		{}
		if(o == b4)
		{}
		if (o == b2) {
			try {
				Dbcon db = new Dbcon();
				Connection connect =db.getConnection();
				Statement stmt = connect.createStatement();
				
				String owner = ownertext.getText();
				String content=AES.encrypt(ta.getText(),keyWord);
			
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				
				Date d = new Date();
				
				String dt = sd.format(d);
					 
				Random r=new Random();
				
				String newkey=String.valueOf(r.nextInt(10000));
				
				String fname = JOptionPane.showInputDialog(null,"Enter the file name");
				
				String[] dsn = { "Select", "CS1", "CS2", "CS3"};
				
				 String keyw = (String) JOptionPane.showInputDialog(null,
						"Select Cloud Server", " CloudServer",
						JOptionPane.QUESTION_MESSAGE, null,  dsn,  dsn[0]);
				 
				String ip = JOptionPane.showInputDialog(null,"Enter Cloud Server Ip Address");
				
				PrintStream out = null;
				try {
				    out = new PrintStream(new FileOutputStream("Owner\\"+fname));
				    out.print(content);
				}
				finally {
				    if (out != null) out.close();
				}
//				
				String query1 = "insert into Owner values('"+owner+"','"+fname+"','"+newkey+"','"+keyw+"','"+dt+"')";
				stmt.executeUpdate(query1);
				
				Socket soc = new Socket(ip,1234);
				DataOutputStream dout1 = new DataOutputStream(soc.getOutputStream());
				
				dout1.writeUTF(owner);
				dout1.writeUTF(fname);
				dout1.writeUTF(newkey);
				dout1.writeUTF(keyw);
				dout1.writeUTF(content);
				dout1.writeUTF(dt);
				
				DataInputStream din1 = new DataInputStream(soc.getInputStream());
				
				String msg1 = din1.readUTF();
				System.out.println(msg1);
				
				if(msg1.equalsIgnoreCase("success"))
				{
					JOptionPane.showMessageDialog(null, "File Stored Successfully \n Message From "+keyw);
				}
				if(msg1.equalsIgnoreCase("reset"))
				{
					System.out.println(msg1);
					
					Socket sock = new Socket(ip,3009);
					DataOutputStream dout11 = new DataOutputStream(sock.getOutputStream());
					
					dout11.writeUTF(owner);
					dout11.writeUTF(fname);
					dout11.writeUTF(newkey);
					dout11.writeUTF(keyw);
					dout11.writeUTF(content);
					dout11.writeUTF(dt);

					DataInputStream din11 = new DataInputStream(sock.getInputStream());
					String msg11 = din11.readUTF();
					//System.out.println(msg11);
					
					if(msg11.equalsIgnoreCase("success"))
					{
						JOptionPane.showMessageDialog(null, "File Stored Successfully \n Message From "+keyw);
					}
					
					
				}
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
		}
			
	}


	public static void main(String[] args) {
		
		new DataOwner("a");
		
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

}
