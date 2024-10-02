
package com.database;
import java.sql.*;


public class DbConnect {
    
    public static Connection takeConnection()
    {
        Connection con = null;
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
             String path = "jdbc:mysql://localhost:3306/billing";
             String user = "root";
             String pass = "bhopal";
             
             con = DriverManager.getConnection(path, user, pass);
        }
            catch(Exception e)
            {
                e.printStackTrace();
            }
             return con; 
    }
}
