
package UserDetailsDAO;

import UserDetails.UserDetails;
import java.util.List;




public interface UserDetailsDAO {
        public boolean addUser(UserDetails userDetails);
        public boolean deleteUser(UserDetails userDetails);
        public List<UserDetails> getAllUser();
        public UserDetails getUserByEmail(String email);
        public UserDetails getUserByIndex(int index);
        public boolean updateUser(UserDetails userDetails);
        public boolean changeStatus(UserDetails userDetails);
}

    
