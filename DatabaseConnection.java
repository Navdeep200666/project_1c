
import java.sql.*;



class DatabaseConnection{
   static Connection getConnection()throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection();
    return con;
   }
   static int updateData(String query){
      int a=0;
      try{
      Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement(query);
       a= ps.executeUpdate();
      }
      catch(Exception e){
         System.out.println(e);
      }
      return a;
   }
   static ResultSet resultSet(String query)throws Exception{
      
   
      Connection con=getConnection();
      PreparedStatement ps=con.prepareStatement(query);
      ResultSet rs= ps.executeQuery();
      return rs;
      }
      



}
