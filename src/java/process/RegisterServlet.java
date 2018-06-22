
package process;

import UserDetails.UserDetails;
import UserDetailsDAO.UserDetailsDAO;
import UserDetailsImpl.UserDetailsImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static sun.org.mozilla.javascript.internal.ScriptRuntime.name;

/**
 *
 * @author dotnet1
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
        System.out.println(" ****************************");
        System.out.println(" ****************************");
        System.out.println(" ****************************");
        System.out.println(" niit process ");
        System.out.println(" ****************************");
        System.out.println(" ****************************");
        System.out.println(" ****************************");
        
        
        
        String strMobile;
        String strPassword; 
        String strName;
        String strAddress;
        String  strEmail =null;
        PrintWriter out=null;
         
        try 
        {
            
            out = response.getWriter();
            
      
           strMobile = request.getParameter("usermobile"); 
           strEmail = request.getParameter("email");
           strPassword = request.getParameter("pwd");
           strName = request.getParameter("username");
           strAddress = request.getParameter("useraddress");
           
            
             
             
            
            UserDetails user = new UserDetails();
            user.setUserEmail(strEmail);
            user.setUserAddress(strAddress);
            user.setUserMobile(strMobile);
            user.setUserPassword(strPassword);
            user.setUserName(strName);
            
            UserDetailsDAO userDetailsDAO = new  UserDetailsImpl();
            userDetailsDAO.addUser(user);
      
           
            
         RequestDispatcher rd ;
         
         rd = request.getRequestDispatcher("register.html");
         rd.include(request, response);
         
         
         
            
         
            
            
            
            
            
            
            List <UserDetails>ulist   = userDetailsDAO.getAllUser();
            
            Iterator item=ulist.iterator();
            
            out.println(" <div style='position:relative; left:50px;'>");
            out.println("<table border='2' style='width:800px'> ");
            
            out.println("<tr> ");
            out.println("<th> #index </th> ");
            out.println("<th> email </th> ");
            
                    
                    out.println(" <th> Mobile </th>");
                    out.println(" <th>  Address </th>");
                    out.println(" <th> Name </th>");
                    out.println(" <th> Password </th>");
                    out.println(" <th>  </th>");
                    out.println(" <th>  </th>");
                    
                    
                    
            
            
            out.println("</tr>");
            int i=0;
            
            while(item.hasNext())
            {
                out.println("<tr>");
                
                
                UserDetails u =(UserDetails) item.next();
                out.println(" <td>"+ i + "</td>");
                
                out.println(" <td>"+ u.getUserEmail() + "</td>");
                out.println("<td>"+u.getUserMobile() + "</td>");
                out.println(" <td>"+u.getUserAddress() + "</td>");
                out.println("<td>"+u.getUserName() + "</td>");
                out.println("<td>"+u.getUserPassword() + "</td>");
                
                String url ="editServelt?cid="+i;
                
                out.println("<td>   <a href='"+url+"'> Edit  </a> </td>");
                
                 String urldelete ="deleteServlet?cid="+i;
                out.println("<td>   <a href='"+urldelete+"'> Delete  </a> </td>");
                
                i++;
                out.println("</tr>");
            }
             
            
            out.println("</table>");
            
            
            out.println("</div>");
            
            
            
                    
               
        }
        catch(Exception e)
        {
            
        }
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private UserDetailsDAO UserDetailsImpl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
