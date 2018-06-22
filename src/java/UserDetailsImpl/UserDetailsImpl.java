package UserDetailsImpl;
import UserDetails.UserDetails;
import java.util.List;
import UserDetailsDAO.UserDetailsDAO;
import UserDetails.UserDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


public class UserDetailsImpl  implements UserDetailsDAO
{
    
    
   static  List<UserDetails> list = new ArrayList<UserDetails>();
     
   
   Connection con;
   ResultSet rs;
   Statement st;
   
   
   
   
        



    @Override
    public boolean addUser(UserDetails userDetails) {
        
   
        
        
        
        
        
        
        
        list.add(userDetails);
        
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/EommerceDB","user1","admin");
            st = con.createStatement();
            
            String str = "insert into users"
                    + "(useremail,username,userstatus,"
                    + "userpassword,useraddress,usermobile"
                    + ",userrole) "
                    + "values( '"+userDetails.getUserEmail()+","
                    +userDetails.getUserName()+","
                    +userDetails.getUserStatus()+","
                    +userDetails.getUserPassword()+","
                    +userDetails.getUserAddress()+","
                    +userDetails.getUserMobile()+","+userDetails.getUserRole()+"')";
            
            st.executeQuery(str);
            
            
            
            
            System.out.println(" Driver Configured & connected");
            
            
            
            
            
        }
        catch(Exception e)
        {
            
         System.out.println("Eror in configuring database"+e);
            
        }
        
        
        
        
        System.out.println(" Add Method ");
        
        return true;
    }

    @Override
    public boolean deleteUser(UserDetails userDetails) {
         List <UserDetails>ulist   = this.getAllUser();
        Iterator item=ulist.iterator();
        while(item.hasNext()){
             UserDetails u =(UserDetails) item.next();
            if(userDetails.userEmail.equals(u.userEmail)){
                item.remove();
                  return true;
            }
        }
      return false;
    }

    @Override
    public List<UserDetails> getAllUser() {
        return list;
    }

    @Override
    public UserDetails getUserByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public UserDetails getUserByIndex(int index)
    {
        
        UserDetails curlist = list.get(index);
        return curlist;
     }
    
    
    @Override
    public boolean updateUser(UserDetails userDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean changeStatus(UserDetails userDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}  

