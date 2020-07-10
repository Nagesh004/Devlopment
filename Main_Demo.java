import java.sql.SQLException;
import java.util.Scanner;

import report.Report;
import report.Update;

public class Main_Demo {

	public static void main(String[] args) throws SQLException {
    Scanner sc= new Scanner(System.in);
    System.out.println("1. vendor signUp   2.reports    3.update mobile");
    System.out.println("enter ur choice");
	int  num=sc.nextByte();
		
		
		switch(num){
		case 1:
			
			System.out.println("enter ur userName");
			String userName=sc.next();
			System.out.println("enter ur password");
			String password=sc.next();
			
			if(userName.equals("admin") && password.equals("admin"))
				
			{System.out.println("Vendor Signup Sucessfully.......");
				Vendor_Signup.vendor_Sign();
			
			}
			
			else
			System.out.println("Vendor Signup unSucessful please enter valid userName and password.......");
				
		break;
		case 2 :
			System.out.println("1.list_of_vendor");
		
			System.out.println("2.itemDetails");
			System.out.println("3.itemDes");

		    System.out.println("enter ur choice");
              num=sc.nextInt();
			switch(num){
			case 1:
				Report.list_of_vendor();
				
	            break;  
			case 2:
				Report.total_list_item_cost();
				break;
			case 3:
				Report.item_des();	
				break;}
			
		case 3:
			System.out.println("update mobile number");
			Update.update_mobile();
			
			
			
	}sc.close();
  }
}
