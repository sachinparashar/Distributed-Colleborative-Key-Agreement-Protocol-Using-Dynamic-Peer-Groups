import java.rmi.*;
import java.util.*;
public interface AddInter extends Remote
{
	//public void createGui()throws RemoteException;
	public ArrayList getMember(String query) throws RemoteException;// for single member
	public ArrayList getChilds(String  query) throws RemoteException;  // for three
	public ArrayList getChild1(String  query) throws RemoteException;    
	public void dataUpdate(String query) throws RemoteException;  
	public ArrayList getKey(String  query) throws RemoteException;    
	public ArrayList getGroupKey(String  query) throws RemoteException;    
	public ArrayList getMemberNames(String query) throws RemoteException;// for single member
	public void writeFile(String content, String filename, String desname, String username,Date date) throws RemoteException;
	public String[] getFileNames(String username) throws RemoteException;
	public boolean getAuthentication(String query) throws RemoteException;
	public ArrayList getFiles(String username) throws RemoteException;
	public int getMembers(String query) throws RemoteException;
	public String getMemName(String query) throws RemoteException;
	public boolean deleteFile(String username, String filename) throws RemoteException;
	public void writeFileAll(String content, String filename, java.util.Date date, String username) throws RemoteException;
	public void deleteMember(String username) throws RemoteException;
	public ArrayList getMemberNamesList(String query, String username) throws RemoteException;
	public ArrayList getMemberNamesList1(String query123, String username123) throws RemoteException;
	public String getRequest(String qqq)throws RemoteException;
	public String getRequest123(String qqq)throws RemoteException;
	public void requestUpdate(String rq) throws RemoteException;
	public void addmem(String q123) throws RemoteException;
	public void sendRequestAll(String qrs) throws RemoteException;
	public void deleteRequest(String dq) throws RemoteException;
	public void deleteRequestAll(String dqall) throws RemoteException;
}
