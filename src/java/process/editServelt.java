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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dotnet1
 */
public class editServelt extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editServelt</title>");            
            out.println("</head>");
            out.println("<body>");
           
            String strindex = request.getParameter("cid");
            out.println("Current ID is "+strindex);
            int index = Integer.parseInt(strindex);
            
             UserDetailsDAO userDetailsDAO = new  UserDetailsImpl();
             UserDetails list = userDetailsDAO.getUserByIndex(index);
//             String url = "UpdateValues?cid="+index
//                     +"email="+getElementById('email')
//                     +"mobile="+"getElementById('mobile')"
//             +"Password="+"getElementById('Password')"
//             +"Address="+getElementById('Address')+
//             "Name="+getElementById('Name');
             out.println("<form action='UpdateValues?>"
                     + "<br/> Email :<input type='text' name='email' id='email' value='"+list.getUserEmail()+"'/>");
             out.println("<br/>Mobile :<input type='text' name='mobile' id='mobile' value ='"+list.getUserMobile()+"'/>");
             out.println("<br/>Password: <input type='text' name='password' id='password' value ='"+list.getUserPassword()+"'/>");
             out.println("<br/>Address:<input type='text' name='address' id='address' value ='"+list.getUserAddress()+"'/>");
             out.println("<br/>Name:<input type='text' name='name' id='Name' value ='"+list.getUserName()+"'/>");
             out.println("<br/>Index:<input type='text' name='cid' value='"+index+"'/>");
             out.println("<input type='submit' value='Update'/></form>");
             
             
             
            
            
            
            
            
            out.println("</body>");
            out.println("</html>");
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
