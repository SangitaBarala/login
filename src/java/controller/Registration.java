/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Users;
/**
 *
 * @author Sangita Barala
 */
public class Registration extends HttpServlet {

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
        
        PrintWriter obj=response.getWriter();
       // obj.println("hello");
            String[] register_info=
            {request.getParameter("name"),
            request.getParameter("email"),
            request.getParameter("password"),
            request.getParameter("address"),
            request.getParameter("postalCode"),
            request.getParameter("phoneNumber")};
        
        Users user=new Users();
         boolean result=user.registerUser(register_info);
        if(result==true)
        {
             obj.println("User is registered successfully ");
            //request.getRequestDispatcher("/display.jsp").forward(request, response);
        }
        else
        {
            //request.getRequestDispatcher("/Registration.jsp").forward(request, response);
            obj.println("Error- Something went wrong!");
        }
       //obj.println(result);
      
      // response.sendRedirect("display.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */ @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
   
}
