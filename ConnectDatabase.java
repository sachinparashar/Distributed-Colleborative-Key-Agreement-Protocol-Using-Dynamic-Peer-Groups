import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public  class ConnectDatabase

{
	static Statement st1;
public ConnectDatabase()

{

try
{

	Class.forName("oracle.jdbc.driver.OracleDriver");
	
Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	  st1=con1.createStatement();
	}
	catch(Exception e)
	{
		System.out.println("exception" + e );
	}
}

}	
	
	



