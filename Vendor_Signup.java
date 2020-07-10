import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.jar.CustomizedUtility;

public class Vendor_Signup {
	int ven_Id;
	String ven_Name;
	Double unit_Cost;
	int item_Quantity;
	Address adr;
	int pin_Code;
	Item_Description descr;
	Double ven_MobileNo;
	
	public static void vendor_Sign() throws SQLException
	
	{
		Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter Vendor_Id:");
		int ven_Id=sc.nextInt();
	
	System.out.println("Enter Vendor_Name:");
	String ven_Name=sc.next();
	
	System.out.println("Enter Unit_Cost:");
	int unit_Cost= sc.nextInt();
	
	System.out.println("Enter Item_Quantity:");
	int item_Quantity=sc.nextInt();
	
	System.out.println("Enter Item_Name:");
	String item_Name=sc.next();
	
	System.out.println("Enter Item_Id:");
	int itemId=sc.nextInt();
	
	System.out.println("Enter Vendor Mobile No:");
	Double ven_MobileNo=sc.nextDouble();	
	
		System.out.println("Enter your addressId:");
		int address_Id=sc.nextInt();
		
		System.out.println("Enter your address ------>City:");
		  String city = sc.next();
		
		System.out.println("Enter State:");
		String state=sc.next();
		
		System.out.println("Enter Country:");
		String country=sc.next();
		
		System.out.println("Enter Pin Code:");
		int pin_Code=sc.nextInt();
	
	
	Connection con=CustomizedUtility.getConnected();
	System.out.println("Connection done...");
	int row=0;
	try {
		PreparedStatement prp;
	
	String INSERT_QUERY = "insert Into Vendor_address values(?,?,?,?)";
	prp = con.prepareStatement(INSERT_QUERY);
	prp.setInt(1,address_Id);
	prp.setString(2,city);
	prp.setString(3,state);
	prp.setString(4,country );
	prp.executeUpdate();
	System.out.println("QUERY INSERTED");
		
	
	
	
	String INSERT_QUERY1 = "insert Into Vendor_details  values(?,?,?,?,?)";
		prp = con.prepareStatement(INSERT_QUERY1);
		prp.setInt(1,ven_Id);
		prp.setString(2,ven_Name);
		prp.setInt(3,address_Id);
		prp.setInt(4,pin_Code );
		prp.setDouble(5,ven_MobileNo);
		prp.executeUpdate();
	System.out.println("QUERY INSERTED1");


	String INSERT_QUERY2 = "insert Into item_details values(?,?,?)";
		prp = con.prepareStatement(INSERT_QUERY2);
		prp.setInt(1,itemId);
	    prp.setInt(2,ven_Id);
		prp.setString(3,item_Name);
		prp.executeUpdate();
	System.out.println("QUERY INSERTED2");


	String INSERT_QUERY3 = "insert Into quantity  values(?,?,?)";
		prp = con.prepareStatement(INSERT_QUERY3);
		prp.setInt(1,item_Quantity);
	    prp.setInt(2,ven_Id);
		prp.setInt(3,itemId);	
		prp.executeUpdate();
	System.out.println("QUERY INSERTED3");

		
	String INSERT_QUERY4 = "insert Into Unit_Cost1 values(?,?,?)";
		prp = con.prepareStatement(INSERT_QUERY4);
		prp.setInt(1,unit_Cost);
	    prp.setInt(2,ven_Id);
		prp.setInt(3,itemId);
		prp.executeUpdate();
	System.out.println("QUERY INSERTED4");

	if( row>0);
		{   System.out.println("Record Inserted Sucessfully......");}
	
	}catch(Exception e) {e.printStackTrace();
	con.rollback();
	}sc.close();
  }	
}
