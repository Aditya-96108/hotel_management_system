
import java.sql.*;
public class conn{
    Connection c;
    Statement s;
    public conn(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","ADITYA@a123");
            s =c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        new conn();
    }
}