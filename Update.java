package report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.jar.CustomizedUtility;

public class Update {
  public static void update_mobile() {
	  Scanner sc=new Scanner (System.in);
	  Connection con=CustomizedUtility.getConnected();
		 PreparedStatement prp;
   System.out.println("enter mobile number");
   String mob_no= sc.next();
   System.out.println("enter valid id number");
   int id=sc.nextInt();
		 
		String QRY="update  Vendor_details set ven_MobileNo=? where ven_Id=?";
		
		try {
			prp=con.prepareStatement(QRY);
			prp.setString(1, mob_no);
			prp.setInt(2, id);
			prp.executeUpdate();
	
			
			System.out.println(" Mobile updated......");
		}catch(Exception e) {e.printStackTrace();}	
		sc.close();
	  }
  }

