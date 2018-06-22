
package UserDetailsImpl;

import UserDetails.UserDetails;
import java.util.List;
import UserDetailsDAO.UserDetailsDAO;
import UserDetails.UserDetails;
import java.util.ArrayList;


public class UserDetailsImpl  implements UserDetailsDAO
{
    
    
   static  List<UserDetails> list = new ArrayList<UserDetails>();
     
        



    @Override
    public boolean addUser(UserDetails userDetails) {
        
        
        list.add(userDetails);
        
        System.out.println(" Add Method ");
        
        return true;
    }

    @Override
    public boolean deleteUser(UserDetails userDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

