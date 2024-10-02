
package com.database;

//import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.util.ArrayList;

public class AnalysisRecord {
    
    public static ArrayList<ArrayList<String>> top10Food()
    {
//        ArrayList<ArrayList<String>> a = new ArrayList();
//        try
//        {
//            Connection con = DbConnect.takeConnection();
//            String query = "select sum(quantity),item_name from orders group by item_name order by item_name desc limit 10";
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next())
//            {
//                ArrayList<String> b = new ArrayList<>();
//                b.add(rs.getString(1));
//                b.add(rs.getString(2));
//                a.add(b);
//            }
//            con.close();
//            
//        }
//        catch(Exception e)
//                {
//                    e.printStackTrace();
//                }
//        return a;
//   }
              ArrayList<ArrayList<String>> a = new ArrayList<>();
    try {
        Connection con = DbConnect.takeConnection();
        //String query = "SELECT SUM(quantity), item_name FROM orders GROUP BY item_name ORDER BY SUM(quantity) DESC LIMIT 10";
        String query = "SELECT SUM(quantity), item_name FROM orders GROUP BY item_name ORDER BY item_name DESC LIMIT 10";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        // Process each row of the result set
        while (rs.next()) {
            ArrayList<String> b = new ArrayList<>();
            b.add(rs.getString(1)); // Quantity sold
            b.add(rs.getString(2)); // Item name
            
            // Add this row to the main list
            a.add(b);
        }
        
        // Close the connection
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return a; // Return the list with top 10 food data
 }
}
