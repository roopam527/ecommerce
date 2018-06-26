
package DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection 
{

   static Connection con;
    
    public static Connection getCon()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/EommerceDB","user1","admin");
        
         return con;   
        }
        catch(Exception e)
        {
            return null;
        }
            
    }
    
}
