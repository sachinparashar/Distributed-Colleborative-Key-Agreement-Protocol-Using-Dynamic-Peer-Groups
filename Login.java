
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.sql.*;


public class Login extends JFrame
{
	
	private JLabel USERNAME;
	private JLabel PASSWORD;
	static public JTextField USERVALUE;
	private JPasswordField jPasswordField1;
	private JButton SIGNUP;
	private JButton SIGNIN;
	private JPanel contentPane;
static 	String username;

	String serverName = "192.168.173.1";
	int serverPort = 7000;
	

AddInter obj;
	public Login()
	{
		super();
		initializeComponent();
		
		this.setVisible(true);
		this.setTitle("Login");
	}

	
	private void initializeComponent()
	{
try
{
	Registry reg = LocateRegistry.getRegistry(serverName,serverPort);
	obj=(AddInter)reg.lookup("key");

 	
//	System.out.println("Entering the values to the list box");

//		jList2.setListData(obj.getMemberNames(que1).toArray());
}
catch (Exception e1)
{
	System.out.println(e1);
}   

		USERNAME = new JLabel();
		PASSWORD = new JLabel();
		USERVALUE = new JTextField();
		jPasswordField1 = new JPasswordField();
		SIGNUP = new JButton();
		SIGNIN = new JButton();
		contentPane = (JPanel)this.getContentPane();

 



		
		USERNAME.setText("USER NAME");
		
		PASSWORD.setText("PASSWORD");
		USERVALUE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				USERVALUE_actionPerformed(e);
			}

		});
		
		jPasswordField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jPasswordField1_actionPerformed(e);
			}

		});
		
		SIGNUP.setText("SIGN UP");
		SIGNUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SIGNUP_actionPerformed(e);
			}

		});
		
		SIGNIN.setText("SIGN IN");
		SIGNIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SIGNIN_actionPerformed(e);
			}

		});
		
		contentPane.setLayout(null);
		addComponent(contentPane, USERNAME, 183,182,100,22);
		addComponent(contentPane, PASSWORD, 181,220,100,22);
		addComponent(contentPane, USERVALUE, 296,185,120,21);
		addComponent(contentPane, jPasswordField1, 296,218,118,22);
		addComponent(contentPane, SIGNUP, 300,274,83,28);
		addComponent(contentPane, SIGNIN, 194,275,83,28);
		
		this.setTitle("LOGIN");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(600, 600));
	}

		private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	
	public void USERVALUE_actionPerformed(ActionEvent e)
	{
		System.out.println("\nUSERVALUE_actionPerformed(ActionEvent e) called.");
		

	}

	private void jPasswordField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njPasswordField1_actionPerformed(ActionEvent e) called.");
		

	}
	
 	private void LOGOFF_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nLOGOFF_actionPerformed(ActionEvent e) called."); 
 		
  
 	} 

	private void SIGNUP_actionPerformed(ActionEvent e)
	{
		System.out.println("\nSIGNUP_actionPerformed(ActionEvent e) called.");
		
		try
		{
				int treecount=obj.getMembers("select members from tree where s1 is null and s2 is null");


				Design des=new Design(treecount);
		
		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
		//new NewUser();
		dispose();

		String query1="";

	}

	private void SIGNIN_actionPerformed(ActionEvent e)
	{
		System.out.println("\nSIGNIN_actionPerformed(ActionEvent e) called.");
		
		//new Member();
 username=USERVALUE.getText().trim();
String pass=jPasswordField1.getText().trim();
String query="select memname, pass from tree where memname='"+username+"' and pass='"+pass+"'";
try
{
if(obj.getAuthentication(query))
		{
	new Member();
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Invalid username and password","Warning...",JOptionPane.OK_CANCEL_OPTION);
			USERVALUE.setText("");
			jPasswordField1.setText("");
			USERVALUE.setFocusable(true);
		}
		dispose();

	
}
catch (Exception ee)
{
	ee.printStackTrace();
}

	}


	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new Login();
	}



}
