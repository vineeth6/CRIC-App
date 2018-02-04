

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBConnect {
    private Connection myDBCon;
    private Statement st;
    private ResultSet rs;
    
    public DBConnect()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(Exception e){
            System.err.println("ERROR: "+e);
        }
        try{
            myDBCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sudarshan","student");
            myDBCon.commit();
            st=myDBCon.createStatement();
            
            System.err.println("Database connection success:)");
        } catch(Exception e) {
            System.err.println("ERROR: "+ e);
        }

    }
     public ResultSet getposts(){
        try{
            String query="select * from forum";
            rs=st.executeQuery(query);           
            return rs;
            
        }catch(Exception e){
            System.out.println("Error : "+e);
            return rs;
        }
    }
     public ResultSet getnamefromemailid(String emailid)
     {
        try {
            String query="select name from appuser where emailid='"+emailid+"'";
            rs=st.executeQuery(query);
            return rs;
        } catch (Exception ex) {
            System.out.println("Error: "+ex);
            return rs;
        }
     }
     
     
     public ResultSet emailidpresence(String emailid){
        try{
            String query="select * from appuser where emailid='"+ emailid +"'";
            rs=st.executeQuery(query);
            return rs;
            
        }catch(SQLException e){
            return rs;
        }
    }
    public ResultSet confirmdata(String emailid){
        try{
            String query="select password from appuser where emailid='" +emailid+"'" ;
            rs=st.executeQuery(query);
            return rs;
            
        }catch(Exception e){
            return null;
        }
    }
    public ResultSet checksecurityanswer(String emailid)
    {
        try{
            String query="select forget_password from appuser where emailid='" +emailid+"'";
            rs=st.executeQuery(query);
            return rs;
        }catch(Exception e){
            System.out.println("Security Error");
            return null;
        }
    }
    public void updatepassword(String emailid,String password)
    {
        try{
            String update="update appuser set password='"+password+"' where emailid='"+emailid+"'";
            st.executeUpdate(update);
            myDBCon.commit();
        }catch(Exception e){
            System.out.println("Problem in updation");
        }
    }
    
    public boolean insertdata(String name,String emailid,String password,String forget_password,double vcbalance){
        try{
            String query="insert into appuser values ('" +name+"','"+emailid+"','"+password+"','"+forget_password+"',"+vcbalance+")";
            st.executeQuery(query);
            myDBCon.commit();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean updateforum(String emailid,String date,String description){
        try{
            String query="insert into forum values('"+date+"','"+emailid+"','"+description+"')";
            st.executeQuery(query);
            myDBCon.commit();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
}
