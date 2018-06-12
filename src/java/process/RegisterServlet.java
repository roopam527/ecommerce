/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import UserDetails.UserDetails;
import UserDetailsDAO.UserDetailsDAO;
import UserDetailsImpl.UserDetailsImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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



                
        
        
        String  strEmail =null;
        PrintWriter out=null;
        try 
        {
            out = response.getWriter();
            
            
             strEmail = request.getParameter("email");
            
             out.println(strEmail);
             
            
            UserDetails user = new UserDetails();
            user.setUserEmail(strEmail);
            
            UserDetailsDAO userDetailsDAO = new  UserDetailsImpl();
            userDetailsDAO.addUser(user);
            
            
            
            List <UserDetails>ulist   = userDetailsDAO.getAllUser();
            
            Iterator item=ulist.iterator();
            
            while(item.hasNext())
            {
                
                UserDetails u =(UserDetails) item.next();
                out.print("Email "+ u.getUserEmail());
                out.print(u.getUserMobile());
                
                
            }
            
            
            
            
            
            
            
            
                    
               
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
