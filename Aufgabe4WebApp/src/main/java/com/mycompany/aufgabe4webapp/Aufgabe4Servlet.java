/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aufgabe4webapp;


import com.mycompany.aufgabe4.City;
import com.mycompany.aufgabe4.UnsupportedCountryException;
import com.mycompany.aufgabe4.Weather;
import com.mycompany.aufgabe4.WeatherRetriever;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Verena Rabea
 */
@WebServlet(name = "Aufgabe4Servlet", urlPatterns = {"/Aufgabe4Servlet"})
public class Aufgabe4Servlet extends HttpServlet {

    // private static final Logger LOG = LogManager.getLogger("Servlet");
    
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
            out.println("<title>Servlet Aufgabe4Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Aufgabe4Servlet at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
        
           final PrintWriter out =response.getWriter();
        WeatherRetriever retr = new WeatherRetriever();
         try {
            Weather weather = retr.retrieve(new City("Bochum", "Germany"));
           out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("<meta charset=UTF-8>");
					out.println("<title>Wetter in</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h1>Wetter in </h1>");
					out.println("<br>");
					out.println( weather.toString());
					out.println("<br>");
					out.println("</body>");
					out.println("</html>");
        }
        catch (UnsupportedCountryException e) {
           
        }
      
					
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
