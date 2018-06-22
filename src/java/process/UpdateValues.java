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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dotnet1
 */
public class UpdateValues extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            int index= Integer.parseInt(request.getParameter("cid"));
            UserDetailsDAO userDetailsDAO = new  UserDetailsImpl();
             UserDetails list = userDetailsDAO.getUserByIndex(index);
             
             list.setUserEmail(request.getParameter("email"));
             list.setUserName(request.getParameter("name"));
             list.setUserAddress(request.getParameter("address"));
             list.setUserPassword(request.getParameter("password"));
             list.setUserMobile(request.getParameter("mobile"));
             
  //       PrintWriter out = response.getPrintWriter();
              
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
                
                
                out.println("<td>   <a href='deleteServelt?cid='"+i+"> Delete  </a> </td>");
                
                i++;
                out.println("</tr>");
            }
             
            
            out.println("</table>");
            
            
            out.println("</div>");
            
            
        }catch(Exception e){
               PrintWriter out = response.getWriter();
               out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

}
