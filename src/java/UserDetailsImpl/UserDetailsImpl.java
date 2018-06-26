package UserDetailsImpl;
import DbConfig.MyConnection;
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
        
       
        
        
      
        
        try
        {
            con=MyConnection.getCon();
             st = con.createStatement();
            
            String str = "insert into users(useremail,username,userstatus,userpassword,useraddress,usermobile)"
                         + " values('"+userDetails.getUserEmail()+"','"+userDetails.getUserName()+"','"+userDetails.getUserStatus()+"','"+userDetails.getUserPassword()+"','"+userDetails.getUserAddress()+"','"+userDetails.getUserMobile()+"')";
           
                    
                    
                    
            
            System.out.println("**********************");
            
            
            System.out.println("**********************");
            System.out.println("QUERY");
          
            
            System.out.println("str = " + str);
            
            System.out.println("**********************");
            System.out.println("**********************");
            
            
            
            st.executeUpdate(str);
            
            con.close();
            
            
            
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
        
          List<UserDetails> list1 = new ArrayList<UserDetails>();
          
        
        try{
            con = null;
        con = MyConnection.getCon();
            st= con.createStatement();
            rs= st.executeQuery(" select * from users");
            
           
            System.out.println(" From getAllusers");
               while (rs.next())
               {
                   
                    UserDetails userDetails = new UserDetails();
                    String userEmail = rs.getString(1);
                    String userName = rs.getString(2);
                     String userStatus = rs.getString(3);
                      String userPassword = rs.getString(4);
                      String userAddress = rs.getString(5);
                      
                      
                    
                    userDetails.setUserEmail(userEmail);
                    userDetails.setUserName(userName);
                     userDetails.setUserStatus(userStatus);
                      userDetails.setUserPassword(userPassword);
                       userDetails.setUserAddress(userAddress);
                       
                    list1.add(userDetails);
               }
               
               
               return list1;
               
        }catch(Exception e){
       
             return null;
        }
       
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

