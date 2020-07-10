package report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jar.CustomizedUtility;

public class Report {
  public static void list_of_vendor() {
	 Connection con=CustomizedUtility.getConnected();
	 
	 PreparedStatement prp;
	 ResultSet rs;
	 
	String QRY="select * from Vendor_details";
	
	try {
		prp=con.prepareStatement(QRY);
		rs=prp.executeQuery();
		while(rs.next()) {
			System.out.println("list_of_vendor");
			System.out.println("ven_id=="+rs.getInt("ven_id")+"    ven_name=="+rs.getString("ven_name"));
		}
	}catch(Exception e) {e.printStackTrace();}	
  }
  
  public static void total_list_item_cost() {
		 Connection con=CustomizedUtility.getConnected();
		 PreparedStatement prp;
		 ResultSet rs;
		 
		String QRY1="select  item_Name, unit_Cost from item_details inner join Unit_Cost1 "
						+ "on item_details.itemId=Unit_Cost1.itemId";
		
		try {
			prp=con.prepareStatement(QRY1);
			rs=prp.executeQuery();
			while(rs.next()) {
				System.out.println("itemDetails");
				System.out.println("item_Name=="+rs.getString("item_Name")+"    unit_Cost=="+rs.getInt("unit_Cost"));
			}
		}catch(Exception e) {e.printStackTrace();}	
	  }
	 
	  public static void item_des() {
		  Connection con=CustomizedUtility.getConnected();
			 PreparedStatement prp;
			 ResultSet rs;
			 
String QRY2="select ven_Name,item_Name,item_Quantity, unit_Cost from Vendor_details, item_details,quantity,Unit_Cost1 inner joins ven_Name on Vendor_details.ven_Id=item_details.ven_Id AND quantity.ven_Id=Unit_Cost1.ven_Id";

			try {
				prp=con.prepareStatement(QRY2);
				rs=prp.executeQuery();
				while(rs.next()) {
					System.out.println("itemDes");
					System.out.println("ven_Name=="+rs.getString("ven_Name")+"   item_Name=="+rs.getString("item_Name")+"  item_Quantity=="+rs.getInt("item_Quantity")+"    unit_Cost=="+rs.getInt("unit_Cost"));
				}
			}catch(Exception e) {e.printStackTrace();}	
		  }
	  
	}
  
  
  
  

