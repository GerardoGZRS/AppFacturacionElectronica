/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Empresa;
import Vista.BeanEmpresa;
/**
 *
 * @author JAANP
 */
@WebServlet(name = "ServletEliminarEmpresa", urlPatterns = {"/ServletEliminarEmpresa"})
public class ServletEliminarEmpresa extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try{
       String idEmpre=request.getParameter("idE");
 if(!idEmpre.equalsIgnoreCase("")){
            
     
boolean sw = Empresa.eliminarEmpresa(Integer.parseInt(idEmpre));
if(sw){
    out.println("<center>");
    out.println("<h2>La empresa fue eliminada del sistema</h2>");
    out.println("<td><a href=\"administrador.jsp\">Regresar a la pagina principal</a></td>" ); 
    out.println("</center>");
         } else {   
    out.println("<center>");
    out.println("<h2>No se pudo completar tu operacion</h2>");
    out.println("<td><a href=administrador.jsp\"\">Regresar a la pagina principal</a></td>" ); 
    out.println("</center>");
                 }
        
 }   
           
        } finally {
            out.close();
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

