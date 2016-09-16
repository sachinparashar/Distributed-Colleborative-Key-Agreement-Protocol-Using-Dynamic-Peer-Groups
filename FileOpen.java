
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;


public class FileOpen extends JFrame
{

	
private JTextArea jTextArea1;
	
private JScrollPane jScrollPane2;
	
private JButton jButton2;
	
private JPanel contentPane;
	

public FileOpen(String content)
	{

super();
		
initializeComponent(content);
		
this.setVisible(true);
		
this.setTitle("FileOpen");
	
}

	
private void initializeComponent(String content)
{
	
	jTextArea1 = new JTextArea();
	
	jScrollPane2 = new JScrollPane();
		
                jButton2 = new JButton();
		
               contentPane = (JPanel)this.getContentPane();

		
		jTextArea1.setText(content);
		
	              jScrollPane2.setViewportView(jTextArea1);
		
		jButton2.setText("CLOSE");
		
                           jButton2.addActionListener(new ActionListener() {
		
	      public void actionPerformed(ActionEvent e)
		
	{
				
                   jButton2_actionPerformed(e);
		
	}

		});
	
			contentPane.setLayout(null);
	  
	addComponent(contentPane, jScrollPane2, 37,25,536,450);
		
addComponent(contentPane, jButton2, 243,486,83,28);
	
			this.setTitle("ss - extends JFrame");
	
	this.setLocation(new Point(0, 0));
		
this.setSize(new Dimension(602, 546));
	}

	
private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{


		c.setBounds(x,y,width,height);
		
container.add(c);
	
}

	 

	private void jButton2_actionPerformed(ActionEvent e)
	
{
		
System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		
	dispose();
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