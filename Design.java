
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.*;
import java.util.*;
import java.rmi.registry.*;

public class Design extends JFrame
{
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
static 	String name;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JPasswordField jPasswordField1;
	private JButton jButton1;
	private JButton jButton2;
	private JOptionPane p1; 
	private JPanel contentPane;
	Registry reg;
	String serverName = "192.168.173.1";
	int serverPort = 7000;
	int treeValue;
	
AddInter obj; 

	public Design(int treeCount)
	{
		super();
		initializeComponent(treeCount);
		

		this.setVisible(true);
		this.setTitle("Design");
	}

	private void initializeComponent(int treeCount)
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
	jPasswordField1 = new JPasswordField(); 
		jButton1 = new JButton();
		jButton2 = new JButton();
		contentPane = (JPanel)this.getContentPane();
	p1= new JOptionPane();
	try
	{
		reg = LocateRegistry.getRegistry(serverName,serverPort);
	obj=(AddInter)reg.lookup("key");	
	}
	catch (Exception e)
	{
		e.printStackTrace();

	}
	
		
		jLabel1.setText("Member");
		
		jLabel2.setText("User Name");
		treeValue=treeCount;
		Integer set=new Integer(treeCount);
		jTextField1.setText(set.toString());
		
		jLabel3.setText("Password");
		
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		
		jTextField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField2_actionPerformed(e);
			}

		});
		
		jPasswordField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jPasswordField1_actionPerformed(e);
			}

		});
		
		jButton1.setText("Set");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		
		jButton2.setText("Reset");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}

		});
		
		contentPane.setLayout(null);
		
		addComponent(contentPane, jLabel2, 78,65,100,18);
		addComponent(contentPane, jLabel3, 77,102,60,18);
		
		addComponent(contentPane, jTextField2, 201,65,100,22);
		addComponent(contentPane, jPasswordField1, 201,103,100,22);
		addComponent(contentPane, jButton1, 92,154,83,28);
		addComponent(contentPane, jButton2, 190,154,83,28);
		
		this.setTitle("Design - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(368, 251));
	}
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	
	private void jTextField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");
		
	}

	private void jTextField2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField2_actionPerformed(ActionEvent e) called.");
		
	}

	private void jPasswordField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField3_actionPerformed(ActionEvent e) called.");
		
}
     
	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		

String user=jTextField2.getText().trim();
String pass1=jPasswordField1.getText().trim();
String query="select memname, pass from tree where memname='"+user+"' and pass='"+pass1+"'";
try
{
if(obj.getAuthentication(query))
		{



			JOptionPane.showMessageDialog(this,"Already username and password is available","Warning...",JOptionPane.OK_CANCEL_OPTION);
			jTextField2.setText("");
			jPasswordField1.setText("");
			jTextField2.setFocusable(true);
	
		}
		else
		{
 name=jTextField2.getText();
String pass=jPasswordField1.getText();
String query1="update tree set memname ='"+name+"', pass ='"+pass+"' where members="+treeValue;


String grkey="";
try
{
	long start = System.currentTimeMillis();
obj.dataUpdate(query1);	
Thread.sleep(1000);

GenerateKey gk=new GenerateKey();
long end = System.currentTimeMillis();
Thread.sleep(1000);
long diff = end - start;
String timediff = String.valueOf(diff);
String q123 = "insert into tree1 (memname, time_diff) values('"+name+"', '"+timediff+"')";
obj.addmem(q123);


String getgroupkey="select grokey from tree";
Iterator it=obj.getGroupKey(getgroupkey).iterator();


if(it.hasNext())
		{
	System.out.println("++++++++++++++++");
grkey=(String)it.next();
		}

	 
	 p1.showMessageDialog(this, "GROUP KEY   " + grkey,null, JOptionPane.OK_CANCEL_OPTION);
	dispose();
	new Login();
}
catch (Exception e1)

{
	
	
}








		}

	
}
catch (Exception ee)
{
	ee.printStackTrace();
}

	
	}

	private void jButton2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		
		jTextField2.setText("");
			jPasswordField1.setText("");
			jTextField2.setFocusable(true);

	}



	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		
	}



}
