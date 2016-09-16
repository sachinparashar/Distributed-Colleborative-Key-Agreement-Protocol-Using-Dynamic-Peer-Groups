
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.sql.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry .*;
import java.io.*;

public class Member extends JFrame
{
	


	JTree	t=null;
	DefaultTreeModel model=null;
	private ArrayList content=new ArrayList();
	private DefaultMutableTreeNode  root;
	private	DefaultMutableTreeNode  child1; 
	private DefaultMutableTreeNode  child2; 
	private int tab=0;
	private JTabbedPane jTabbedPane1;
	private JPanel contentPane;


	static public   JList jList7;	
	private JScrollPane jScrollPane7;
	private JButton SEND;
	private JButton SENDALL; 
	private JPanel jPanel6;
	private JButton DELETEE; 
	private JButton LOGOFF; 

	
	private JTextField jTextField4;
	private JButton jButton3;
	private JButton jButton4;

	private JPanel jPanel1;
	private JLabel jLabel2; 
	private JList jList1; 
	private JList jList2; 
	private JButton OPEN;
	private JButton DELETE; 


	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2; 
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane4;
	int memberCount=1;

	private JComboBox jComboBox2;
	private JButton jButton6;
	private JPanel jPanel2;
	private JPanel jPanel10; 
	private JOptionPane p1; 
	
	private JLabel jLabel3;	
	AddInter obj; 

	private JPanel jPanel3;
	private JPanel vreq;
	private JPanel sreq;
	private JList viewreq;
	private JList sendreq;
	private JButton SEND1;
	private JButton SENDALL1;
	private JButton DELETE1;
	private JButton DELETEALL1;
	String sendreqvalue;
	String viewreqvalue;
	
	
	String query;
	
     
        ResultSet rs, rs1, rs2;
    
	private JLabel jLabel1; 
	String serverName = "192.168.173.1";
	int serverPort = 7000;
	Registry reg;
	public Member() 
	{
		super();
		
		try
		{
			reg = LocateRegistry.getRegistry(serverName,serverPort);
			obj=(AddInter)reg.lookup("key");
		
		}
		catch (Exception e1)
		{
			System.out.println(e1);
		}   

		initializeComponent();
		t=new JTree(model);
		
                JScrollPane  jScrollPane1 = new JScrollPane(); 
                jScrollPane1.setViewportView(t); 
		
		jScrollPane1.updateUI();
		jScrollPane1.repaint();
    	        addComponent(jPanel3, jScrollPane1, 10,7,366,333);
		addComponent(jPanel3, DELETEE, 82,389,83,28); 
		addComponent(vreq, jScrollPane3, 10,7,366,333);
		addComponent(sreq, jScrollPane4, 10,7,366,333);
		addComponent(jPanel3, LOGOFF, 265,391,83,28); 
		loadTree();
        	this.setVisible(true);
		this.setTitle(Login.username);

	}
                                                           
	private void initializeComponent()
	{
		
		
		DELETEE = new JButton(); 
 		LOGOFF = new JButton(); 
		jTabbedPane1 = new JTabbedPane();
		contentPane = (JPanel)this.getContentPane();
		
		jList7 = new JList();
		jScrollPane7 = new JScrollPane(jList7,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		SEND = new JButton();
		SENDALL = new JButton(); 
		jPanel6 = new JPanel();

		jLabel1 = new JLabel();
		DELETE = new JButton();
		jList1 = new JList();
		jList2 = new JList(); 
		

        try
        {
	    String s = "select memname from tree where s1 is null";
            obj = (AddInter)reg.lookup("key");
           
            jList7.setListData(obj.getMemberNames(s).toArray());
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }




                DELETE1 = new JButton();
                DELETEALL1 = new JButton();
		jScrollPane1 = new JScrollPane(); 
		jScrollPane2 = new JScrollPane();
		jScrollPane3 = new JScrollPane();
		jScrollPane4 = new JScrollPane();
		jTextField4 = new JTextField();
		jButton3 = new JButton();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel(); 
		jButton4 = new JButton();
		jPanel1 = new JPanel();
		int treeCount1=0;
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		jComboBox2 = new JComboBox();
		
		p1= new JOptionPane();

		OPEN = new JButton(); 
		jButton6 = new JButton();
		
		jPanel2 = new JPanel();
		
		jPanel3 = new JPanel();
		vreq = new JPanel();
		sreq = new JPanel();
		viewreq = new JList();
		sendreq = new JList();
		SEND1 = new JButton();
		SENDALL1 = new JButton();
		jScrollPane4 = new JScrollPane(sendreq,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane3 = new JScrollPane(viewreq,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane1.setViewportView(jList1); 
		jScrollPane3.setViewportView(viewreq);
		jScrollPane4.setViewportView(sendreq);
		
		
		jPanel10 = new JPanel(); 
		
		 

		DELETE.setText("DELETE"); 


		jList7.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e)
			{
				jList7_valueChanged(e);
			}

		});
		viewreq.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e)
			{
				viewreq_valueChanged(e);
			}

		});
		sendreq.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e)
			{
				sendreq_valueChanged(e);
			}

		});
		
		DELETE1.setText("DELETE");
		DELETE1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DELETE1_actionPerformed(e);
			}

		});
		DELETEALL1.setText("DELETE ALL");
		DELETEALL1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DELETEALL1_actionPerformed(e);
			}

		});
		SEND.setText("SEND");
		SEND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SEND_actionPerformed(e);
			}

		});

		SENDALL.setText("SEND ALL"); 
 		SENDALL.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				SENDALL_actionPerformed(e); 
 			} 
  
 		}); 
		
 		SEND1.setText("SEND");
		SEND1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SEND1_actionPerformed(e);
			}

		});

		SENDALL1.setText("SEND ALL"); 
 		SENDALL1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				SENDALL1_actionPerformed(e); 
 			} 
  
 		}); 
		

 		DELETEE.setText("DELETE"); 
 		DELETEE.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				DELETEE_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		LOGOFF.setText("LOG OFF"); 
 		LOGOFF.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				LOGOFF_actionPerformed(e); 
 			} 
  
 		}); 

 		
 		
 		
 		DELETE.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				DELETE_actionPerformed(e); 
 			} 
  
 		}); 
 		



		jList1.addListSelectionListener(new ListSelectionListener() { 
 			public void valueChanged(ListSelectionEvent e) 
 			{ 
 				jList1_valueChanged(e); 
 			} 
  
 		}); 
		jScrollPane2.setViewportView(jList2); 
		jList2.addListSelectionListener(new ListSelectionListener() { 
 			public void valueChanged(ListSelectionEvent e) 
 			{ 
 				jList2_valueChanged(e); 
 			} 
  
 		}); 
 		
			
		
 		jLabel3.setText("FILES"); 
 		jPanel10.setLayout(null); 
 		addComponent(jPanel10, jLabel1, 72,115,92,28); 
		addComponent(jPanel10, jLabel3, 253,129,197,18); 
		addComponent(jPanel10, jLabel2, 66,26,187,18); 
		addComponent(jPanel10, OPEN, 311,384,83,28); 
		addComponent(jPanel10, DELETE, 114,380,83,28); 
 		addComponent(jPanel10, jScrollPane1, 70,165,400,182); 



 		jPanel6.setLayout(null); 
		addComponent(jPanel6, SEND, 311,384,83,28); 
		addComponent(jPanel6, SENDALL, 114,380,100,28); 
 		addComponent(jPanel6, jScrollPane7, 70,165,400,182); 
 		sreq.setLayout(null); 
		addComponent(sreq, SEND1, 250,384,83,28); 
		addComponent(sreq, SENDALL1, 100,380,100,28);
		
 		addComponent(sreq, jScrollPane4, 70,165,400,182);
 		
 		vreq.setLayout(null); 
 		addComponent(vreq, DELETE1, 250,384,83,28); 
		addComponent(vreq, DELETEALL1, 100,380,100,28);
		
		addComponent(vreq, jScrollPane3, 70,165,400,182);
 		
		try
		{
			

		  query="SELECT members FROM tree";
			
			Iterator it=obj.getMember(query).iterator();
			
			
			while(it.hasNext())
			{
				
				String s1=(String)it.next();

				
				jComboBox2.addItem(s1);
				jComboBox2.setSelectedIndex(0);
				
			} 
			
			
			Vector storeCount=new Vector();
		
			int endCount=0;
			
            }
		   

		catch(Exception e)
		{
			e.printStackTrace();
		System.out.println("Exception occurred" + e);
		}
		

		
		jPanel10.setLayout(null); 
		
		jTabbedPane1.addTab("VIEW GROUP", jPanel3);
		jTabbedPane1.addTab("VIEW  FILES", jPanel10);
		jTabbedPane1.addTab("SEND  FILES", jPanel6);
		jTabbedPane1.add("VIEW REQUEST", vreq);
		jTabbedPane1.add("SEND REQUEST", sreq);
		jTabbedPane1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				jTabbedPane1_stateChanged(e);
			}

		});
		
		contentPane.setLayout(null);
		addComponent(contentPane, jTabbedPane1, -3,-2,580,527);
		
		jTextField4.setHorizontalAlignment(JTextField.LEFT);
		jTextField4.setDragEnabled(true);
		jTextField4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField4_actionPerformed(e);
			}

		});
		
		jButton3.setText("Add");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_actionPerformed(e);
			}

		});
		
		DELETE.setText("Delete");


 		DELETE.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				DELETE_actionPerformed(e); 
 			} 
  
 		}); 

 		








		OPEN.setText("OPEN"); 
 		OPEN.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				OPEN_actionPerformed(e); 
 			} 
  
 		}); 

			
			 
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton4_actionPerformed(e);
			}

		});
		
		jPanel1.setLayout(null);
		addComponent(jPanel1, jTextField4, 231,78,107,21);
		addComponent(jPanel1, jButton3, 132,167,83,28);
		addComponent(jPanel1, jButton4, 233,165,83,28);
		addComponent(jPanel10, jLabel2, 66,26,187,18); 
addComponent(jPanel10, OPEN, 311,384,83,28); 
		
		jComboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jComboBox2_actionPerformed(e);
			}

		});
		
		jButton6.setText("Add Sibling Member");
		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton6_actionPerformed(e);
			}

		});
		
		jPanel2.setLayout(null);
		addComponent(jPanel2, jComboBox2, 216,70,100,22);
		addComponent(jPanel2, jButton6, 194,144,144,28);
		
		jPanel3.setLayout(null);
		
		this.setTitle("Member - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(577, 546));
		
		
	
		
		
		
		
	}

	
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}




	private void jList1_valueChanged(ListSelectionEvent e) 
 	{ 
 		System.out.println("\njList1_valueChanged(ListSelectionEvent e) called."); 
 		if(!e.getValueIsAdjusting()) 
 		{ 
 			Object o = jList1.getSelectedValue(); 
 			System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
 			
 			 
 		} 
 	} 
	private void sendreq_valueChanged(ListSelectionEvent e) 
 	{ 
 		System.out.println("\njList1_valueChanged(ListSelectionEvent e) called."); 
 		if(!e.getValueIsAdjusting()) 
 		{ 
 			Object o = sendreq.getSelectedValue(); 
 			sendreqvalue = o.toString();
 			System.out.println(">>" + ((o==null)? "null" : sendreqvalue) + " is selected."); 
 			
 		} 
 	} 
	private void viewreq_valueChanged(ListSelectionEvent e) 
 	{ 
 		System.out.println("\njList1_valueChanged(ListSelectionEvent e) called."); 
 		if(!e.getValueIsAdjusting()) 
 		{ 
 			Object o = viewreq.getSelectedValue(); 
 			viewreqvalue = o.toString();
 			System.out.println(">>" + ((o==null)? "null" : viewreqvalue) + " is selected."); 
 			
 			 
 		} 
 	} 









	private void DELETEE_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nDELETEE_actionPerformed(ActionEvent e) called."); 
 		
try
{


	       obj.deleteMember(Login.username);
	       
		   GenerateKey gkey=new GenerateKey();
		   System.exit(0);
}
catch (Exception dele)

{
	dele.printStackTrace();
}
} 
	private void DELETE1_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nDELETE1_actionPerformed(ActionEvent e) called."); 
 		
 		try
 		{
 		String dq = "update tree1 set request=replace(request,'"+viewreqvalue+"#','') where memname='"+Login.username.trim()+"'";
 		obj.deleteRequest(dq);
 		JOptionPane.showMessageDialog(null, "Corresponding request is Deleted");
 		}catch(Exception de){de.printStackTrace();}
 		
 	}
	private void DELETEALL1_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nDELETEALL1_actionPerformed(ActionEvent e) called."); 
 		
 		try{
 			String dqall = "update tree1 set request='' where memname='"+Login.username.trim()+"'";
 			obj.deleteRequestAll(dqall);
 			JOptionPane.showMessageDialog(null, "All Request are Deleted");
 		}catch(Exception deall){deall.printStackTrace();}
 		
 	}
	private void SEND1_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nSEND1_actionPerformed(ActionEvent e) called."); 
 		
 		try
 		{
 		String uname = Login.username.trim();
 		String qr = "select * from tree1 where memname='"+sendreqvalue+"'"; 
 		String un = obj.getRequest123(qr);
 		String rvalue="";
 		System.out.println("wwwwwwwwwwwwwwwwww"+un);
 		if(un == null)
 		{
 			rvalue = uname+"#";
 		}
 		else
 		{
 			rvalue = un+uname+"#";
 		}
 		String requpdate = "update tree1 set request='"+rvalue+"'"+"where memname='"+sendreqvalue+"'";
 		System.out.println(requpdate);
 		obj.requestUpdate(requpdate);
 		JOptionPane.showMessageDialog(null, "Request is Send");
 		}catch(Exception ereq)
 		{ereq.printStackTrace();}
 		
 		
 	}
	private void SENDALL1_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nSENDALL1_actionPerformed(ActionEvent e) called."); 
 		
 		try
 		{
 		String qrs = "update tree1 set request=request+'"+Login.username.trim()+"#' where memname!='"+Login.username.trim()+"'";
 		obj.sendRequestAll(qrs);
 		JOptionPane.showMessageDialog(null, "Request is Send To All");
 		}catch(Exception see){}
 	}
 	private void LOGOFF_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nLOGOFF_actionPerformed(ActionEvent e) called."); 
 		 

		
		System.exit(0);
  
 	} 







		private void DELETE_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nDELETE_actionPerformed(ActionEvent e) called."); 
 		

               try

			   
			   {
				

	int index1=jList1.getSelectedIndex();
	Object ob1=jList1.getSelectedValue();
	String value=ob1.toString();



StringTokenizer Tok = new StringTokenizer(value);




	System.out.println(Tok.nextToken());



    

	String nextString=Tok.nextToken();




      boolean status=obj.deleteFile(Login.username.trim(),nextString.trim());  
	  DefaultListModel model=new DefaultListModel();
	  jList1.setModel(model);



File f=new File("");
String fname=f.getAbsolutePath()+"\\"+Login.username.trim()+"\\"+nextString.trim();
	
File f1=new File(fname);
System.out.println(fname+f1.delete());
if(f1.isFile())
	System.out.println(fname+f1.delete());
	f1.delete();





	  
 model.remove(index1);


               }
               catch (Exception delfile)
               {
				  
               }





  
 	} 









void OPEN_actionPerformed(ActionEvent e) 
 	{ 	String groupkey="";
 		System.out.println("\nOPEN_actionPerformed(ActionEvent e) called."); 
 		
String quer="select grokey  from tree";
try
{
	
Iterator itt=obj.getGroupKey(quer).iterator();

String grkey="";
if(itt.hasNext())
		{
	
grkey=(String)itt.next();

		}
		
			groupkey=JOptionPane.showInputDialog(this,"Enter the Group Key","");
		if(grkey.equals(groupkey))
	{
			int index=jList1.getSelectedIndex();
			FileOpen object=new FileOpen((String)content.get(index));
	}
	else
	{
JOptionPane.showInputDialog(this,"Check your Group key","");
	}

		
	
}
catch (Exception ee)
{
	ee.printStackTrace();

}  




		
  
 	} 

		private void jList2_valueChanged(ListSelectionEvent e) 
 	{ 
 		System.out.println("\njList2_valueChanged(ListSelectionEvent e) called."); 
 		if(!e.getValueIsAdjusting()) 
 		{ 
try
{
		Object o = jList2.getSelectedValue(); 
 			System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
		
}
catch (Exception e3)
{
	e3.printStackTrace();
}
 			
 			 
 		} 
 	} 



	
	private void jTabbedPane1_stateChanged(ChangeEvent e)
	{


	if(jTabbedPane1.getSelectedIndex()==0)
			loadTree();


	
       ++tab;
		try
		{

obj=(AddInter)reg.lookup("key");

String quer="select grokey  from tree";
String grkey="";
double gkey=GenerateKey.groupkey;
try
{
Iterator itt=obj.getGroupKey(quer).iterator();


if(itt.hasNext())
		{
	
grkey=(String)itt.next();

		}
jLabel2.setText("GROUP KEY  " + grkey);




	
}
catch (Exception exec)
{
	exec.printStackTrace();
}















ArrayList list=new ArrayList();
		Iterator data=obj.getFiles(Login.username).iterator();
		while(data.hasNext())
		{
			list.add(data.next());
			content.add(data.next());
		}
		jList1.setListData(list.toArray());
		



			String que1="select memname from tree where s1 is null";

			
		
		jList7.setListData(obj.getMemberNamesList(que1, Login.username).toArray());
		String q123 = "select memname from tree where s1 is null";
		ArrayList lll = obj.getMemberNamesList1(q123, Login.username);
		System.out.println(lll);
		sendreq.setListData(lll.toArray());

		System.out.println("\njTabbedPane1_stateChanged(ChangeEvent e) called." + tab);
		
		
		
		String qqq = "select * from tree1 where memname = '"+Login.username+"'";
		String request = obj.getRequest(qqq);
		
		ArrayList arreq = new ArrayList();
		StringTokenizer stk = new StringTokenizer(request, "#");
		
		while(stk.hasMoreTokens())
		{
			String sss = stk.nextToken();
			
			arreq.add(sss);
		}
		viewreq.setListData(arreq.toArray());
		
		
		}
		catch(Exception ee)
		{
		}

	}
public void loadTree()
	{
	try
	{
		
	
		root=null;
			child1=null;
			child2=null;
 HashMap hm=new HashMap();
String query2="select members, s1, s2 from tree";
				 
// this 			rs2=ConnectDatabase.st1.executeQuery(query2);
Iterator it=obj.getChilds(query2).iterator();
// this ResultSetMetaData rsmd=rs2.getMetaData();
// this int colCount=rsmd.getColumnCount();
			
            while(it.hasNext())
            {
            	
            	String tree1=(String)it.next();
            
               	String tree2=(String)it.next();
            	
            	String tree3=(String)it.next();
            	
            
            	
            	if(tree1==null |tree2==null | tree3==null)
            	           			
            	{
            		
            		
            		
            	}
            	
            	else
            	{
					

            		       
               
					 String treeName1="Node: " +tree1; 
					 String treeName2="Node: "+tree2; 
					 					String  treeName3= "Node: "+tree3; 
										 
                       	int numTree1=Integer.parseInt(tree1);
						
                    if(numTree1==0)
					{
					 root = new DefaultMutableTreeNode(treeName1, true);
					 
                     String nodename1="select memname from tree where members="+tree1;
                        root.setUserObject(obj.getMemName(nodename1));
					
					child1 = new DefaultMutableTreeNode(treeName2, true);
					                     String nodename2="select memname from tree where members="+tree2;
										   child1.setUserObject(obj.getMemName(nodename2));
					
					 child2 = new DefaultMutableTreeNode(treeName3, true);
					                      String nodename3="select memname from tree where members="+tree3;
										    child2.setUserObject(obj.getMemName(nodename3));
					root.add(child1);
					
                          root.add(child2);

hm.put(treeName1,root);
                       hm.put(treeName2,child1);
hm.put(treeName3,child2);

					}
					else
					{
                  DefaultMutableTreeNode dd=( DefaultMutableTreeNode)hm.get(treeName1);
String nodename1="select memname from tree where members="+tree1;
                        dd.setUserObject(obj.getMemName(nodename1));



                 child1=new DefaultMutableTreeNode(treeName2, true);
                
				                    String nodename2="select memname from tree where members="+tree2;
										   child1.setUserObject(obj.getMemName(nodename2));
				
				 
				 
				 child2=new DefaultMutableTreeNode(treeName3, true);  
				 	                      String nodename3="select memname from tree where members="+tree3;
										    child2.setUserObject(obj.getMemName(nodename3));
				
hm.put(treeName2,child1);
hm.put(treeName3,child2);
                  dd.add(child1);
				  dd.add(child2);




					}
				
				
                                           


            	}		
            		

					


            	}

		model=new DefaultTreeModel(root);


model.nodeStructureChanged( root );
t.setModel(model);

				
			root=null;
                   jScrollPane1.revalidate();
					
		}

		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	private void jTextField4_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField4_actionPerformed(ActionEvent e) called.");
		
	}

	private void jButton3_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton3_actionPerformed(ActionEvent e) called.");
		try
		{
		int num1=Integer.parseInt(jTextField4.getText());
		query= "INSERT INTO tree (members) values ("+num1+")";
int i=ConnectDatabase.st1.executeUpdate(query);
obj.dataUpdate(query);
		
		jComboBox2.removeAllItems();
		
		
		
		query="SELECT members FROM tree";
		
			Iterator it=obj.getMember(query).iterator();
		
		
	
		while(it.hasNext())
		{
			
			String s1=(String)it.next();
			
			
			jComboBox2.addItem(s1);
			jComboBox2.setSelectedIndex(0);
			
		} 
		
		
		}
		catch(Exception e1)
		{
			System.out.println("Exception occurred"+ e1);
		}
	
	
		
		
		

	}

	private void jButton4_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton4_actionPerformed(ActionEvent e) called.");
		

	}




public  void jList7_valueChanged(ListSelectionEvent e)
	{
		System.out.println("\njList1_valueChanged(ListSelectionEvent e) called.");
		if(!e.getValueIsAdjusting())
		{
			Object o = jList7.getSelectedValue();
			System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");
			
			
		}
	}




	private void SENDALL_actionPerformed(ActionEvent e) 
 	{ 
		String groupkey="";
 		System.out.println("\nSENDALL_actionPerformed(ActionEvent e) called."); 
 		
String quer="select grokey  from tree";
try
{
	
Iterator itt=obj.getGroupKey(quer).iterator();

String grkey="";
if(itt.hasNext())
		{
	
grkey=(String)itt.next();

		}
		
			groupkey=JOptionPane.showInputDialog(this,"Enter the Group Key","");
		if(grkey.equals(groupkey))
	{
			

JFileChooser jfilechooser = new JFileChooser();
        int i = jfilechooser.showOpenDialog(this);
        System.out.println((new StringBuilder()).append(i).append("   ").append(0).toString());
            
        if(i == 0)
            
            {

                File file = jfilechooser.getSelectedFile();
                String s1 = file.getName();
                FileInputStream fileinputstream = new FileInputStream(file);
                byte abyte0[] = new byte[fileinputstream.available()];
                fileinputstream.read(abyte0);
                String s2 = new String(abyte0);
              
                obj.writeFileAll(s2, s1, new java.util.Date(), Login.username);
				
				}


	}
	else
	{
JOptionPane.showInputDialog(this,"Check your Group key","");
	}

		
	
}
catch (Exception ee)
{
	ee.printStackTrace();

}  





  
 	} 
	private void SEND_actionPerformed(ActionEvent e)
	{
		String groupkey="";

		System.out.println("\nSEND_actionPerformed(ActionEvent e) called.");



String quer="select grokey  from tree";
try
{
	
Iterator itt=obj.getGroupKey(quer).iterator();

String grkey="";
if(itt.hasNext())
		{
	
grkey=(String)itt.next();

		}
		
			groupkey=JOptionPane.showInputDialog(this,"Enter the Group Key","");
		if(grkey.equals(groupkey))
	{
			
				
JFileChooser jfilechooser = new JFileChooser();
        int i = jfilechooser.showOpenDialog(this);
        System.out.println((new StringBuilder()).append(i).append("   ").append(0).toString());

        if(i == 0)
		{
                Object obj1 = jList7.getSelectedValue();
                String s = obj1.toString();
				
                File file = jfilechooser.getSelectedFile();
                String s1 = file.getName();

                FileInputStream fileinputstream = new FileInputStream(file);
                byte abyte0[] = new byte[fileinputstream.available()];
               
				BufferedInputStream input = new BufferedInputStream(fileinputstream);
         input.read(abyte0,0,abyte0.length);
                String s2 =new String(abyte0) ;
                System.out.println(s2);   
                obj.writeFile(s2, s1, Login.username,s, new java.util.Date());
           				
				
				
		}		
				
				
				
				}
	else
	{
JOptionPane.showInputDialog(this,"Check your Group key","");
	}

		
	
}
catch (Exception ee)
{
	ee.printStackTrace();

}  




























            try
            {
 }
            catch(Exception exception)
            {
                System.out.println(exception);
            }
    






	}








	private void jComboBox2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njComboBox2_actionPerformed(ActionEvent e) called.");
		
		Object o = jComboBox2.getSelectedItem();
		System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");
		
		
	}

	private void jButton6_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton6_actionPerformed(ActionEvent e) called.");
	
		
		try
		{
   

String upquery="select members from tree where  s1 IS NULL";
Iterator itmem=obj.getMember(upquery).iterator();
int getfirstmem=Integer.parseInt((String)itmem.next());

			
			
			

int num1=getfirstmem;
		query="SELECT s1, s2 FROM tree WHERE (members="+num1+")";
		
        Iterator it=obj.getChild1(query).iterator();

		
		int sibling1;
		int sibling2;
		String sib1;
		String sib2;
		
		
		while(it.hasNext()==true)
		{
			
			
			if((sib1=(String)it.next())==null)
			{
			
              
				int treeCount=num1*2;
				
											query="update tree set s1="+treeCount+" where members ="+ num1;
					
					obj.dataUpdate(query);
	query="INSERT INTO tree (members) values ("+treeCount+")";
		
						Integer mem=new Integer(treeCount);
						String strmem=mem.toString();
						jComboBox2.addItem(strmem);
//   this			int addsib11=ConnectDatabase.st1.executeUpdate(query);
		obj.dataUpdate(query);				              
		   
			
			  login(treeCount);
			  break;
			   
			}
			else
			{
			
			
				if((sib2=(String)it.next())==null)
				{
			
					
					int treeCount=num1*2+1;
					
					query="update tree set s2="+treeCount+" where members ="+ num1;
// this 			int addsib2=ConnectDatabase.st1.executeUpdate(query);
		
					obj.dataUpdate(query);
					query="INSERT INTO tree (members) values ("+treeCount+")";
// this 		int addsib22=ConnectDatabase.st1.executeUpdate(query);
obj.dataUpdate(query);
					Integer mem1=new Integer(treeCount);
					String strmem1=mem1.toString();
					
					jComboBox2.addItem(strmem1);
						
					//Design desi=new Design();
					
					
					login(treeCount);
				
				}
				else
				{
					
					
					p1.showMessageDialog(this, "The node is already having two members","MyTitle",JOptionPane.OK_CANCEL_OPTION);

				}
				break;

			}
			
			
			}
		
				

			
			
		 
		

		
		
		
		
		

	


		}
		catch(Exception e1)
		{
			System.out.println("Exception occurred"+ e1);
		}
	
		
		
		
	}

	



void login(int treeCount)
	{
Design d1=new Design(treeCount);


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
		new Member();
	}



}
