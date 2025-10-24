import java.sql.*;
public class Farmer_verification {
   
   static java.util.Scanner sc=new java.util.Scanner(System.in);
    public static void main(String[] args) {
    

    verify();
      
        
    }
    
    static void verify(){
        try{
       
      
     
         String query="UPDATE farmer f JOIN register r ON f.aadhar = r.adhar AND f.landlord = r.landlord SET f.status = 'approved'";



       

                 System.out.println("would you like to update the data\n enter 1 for update\nenter 2 for not update ");
                 int choice=sc.nextInt();

                 switch(choice){
                    case 1:
                 DatabaseConnection.updateData(query); 
                 break;
                   default :
                   System.out.println("not update");
                 }



        }

            
         
        

        
    
    
    
    catch(Exception se){
        System.out.println(se);
    }

    }
}

    

