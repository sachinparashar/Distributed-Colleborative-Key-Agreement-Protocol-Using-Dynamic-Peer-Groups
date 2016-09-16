import java.sql.*;
import java.io.*;
import java.net.*;
import java.math.BigInteger;
import java.util.*;
import java.math.*;
import java.rmi.*;
import java.rmi.registry.*;


public class GenerateKey 
{
	static double groupkey=0;
AddInter obj; 
Registry reg;
String serverName = "192.168.173.1";
int serverPort = 7000;
public GenerateKey()
	{




try
{
	
reg = LocateRegistry.getRegistry(serverName,serverPort);
obj=(AddInter)reg.lookup("key");

String query="select members from tree where  s1 IS NULL";

Iterator it=obj.getMember(query).iterator();
int i=1;
int j=0;
int a[]=new int[30];
double pubkey[]=new double[30];
double prikey[]=new double[30];

int mem[]= new int[30];
int child1[]=new int[30];
int child2[]=new int[30];
Primitive pos=new Primitive();
double primenumber=(double)Primitive.a;

while (it.hasNext())
{
a[j]=Integer.parseInt((String)it.next());
	newkey nk=new newkey();


String prikey1=newkey.fd;


prikey[j]=Double.parseDouble(prikey1);
int prkey=(int)prikey[j];


 BigDecimal a1 = new BigDecimal(primenumber);


double primeroot=(double)Primitive.count;

BigDecimal a2 = new BigDecimal(primeroot);


BigDecimal a3=a2.pow(prkey);

BigDecimal a5=new BigDecimal(primenumber);

BigDecimal a4=a3.remainder(a5);

pubkey[j]=a4.doubleValue();


j++;
groupkey=prkey;
}

for(int count=0;count<j;count++)
	{
String query1="update tree set prikey="+prikey[count]+", pubkey="+pubkey[count]+" where members="+a[count];

obj.dataUpdate(query1);
}

String query2="select members, s1,s2 from tree where s1 is not null or s2 is not null";


Iterator it1=obj.getChilds(query2).iterator();
 int gen=0;
 while(it1.hasNext())
	{
    mem[gen]=Integer.parseInt((String)it1.next());
		child1[gen]=Integer.parseInt((String)it1.next());
		child2[gen]=Integer.parseInt((String)it1.next());
   

++gen;

	}

for(int scount=--gen;scount>=0;--scount)
	{

		String exequery="select pubkey from tree where members="+ child1[scount];
		Iterator it2=obj.getKey(exequery).iterator();


           
		   double cpubkey=Double.parseDouble((String)it2.next());

		   String exequery1="select prikey from tree where members="+child2[scount];

		Iterator it3=obj.getKey(exequery1).iterator();
           
  double cprikey=Double.parseDouble((String)it3.next());
   		   
BigDecimal p1=new BigDecimal(cpubkey);

BigDecimal p3=p1.pow((int)cprikey);
BigDecimal p5=new BigDecimal(primenumber);
BigDecimal p4=p3.remainder(p5);


double privatekey=p4.doubleValue();



BigDecimal aa2 = new BigDecimal(Primitive.count);

BigDecimal aa3=aa2.pow((int)privatekey);

BigDecimal aa5=new BigDecimal(primenumber);

BigDecimal aa4=aa3.remainder(aa5);


double publickey=aa4.doubleValue();


String exequery3="update tree set pubkey="+publickey+", prikey="+privatekey+" where members="+mem[scount];

obj.dataUpdate(exequery3);

	groupkey=privatekey;
	}

int count=0;
double prkey=groupkey*12345;
String finall="update tree set prikey="+prkey+" where members="+count;


obj.dataUpdate(finall);

String exequery4="update tree set grokey="+prkey;
obj.dataUpdate(exequery4);
}
catch (Exception e)
{
System.out.println(e);

}

	}

public static void main(String args[])
{


}
}
