import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class AddServer 
{
	public static void main(String args[])
	{
	try
	{
	int serverPort = 7001;
	AddInter  ob=new AddImpl();
	Registry reg = LocateRegistry.createRegistry(serverPort);
	reg.rebind("key",ob);
	System.out.println("Hi The Server Is Started.........");
	}
	catch(Exception e)
	{
		System.out.println("Error" +   e);
	}
	
	}
}