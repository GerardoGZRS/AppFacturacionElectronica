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
import java.util.LinkedList;
import Vista.BeanPrecio;
import Modelo.Precio;
/**
 *
 * @author JAANP
 */
@WebServlet(name = "ServletConsultaPrecio", urlPatterns = {"/ServletConsultaPrecio"})
public class ServletConsultaPrecio extends HttpServlet {

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
        LinkedList<BeanPrecio> listaPre = new LinkedList<BeanPrecio>(Precio.ListaPrecio());
        try{
            if(listaPre.size()>0){
                out.println("<center>");
                out.println("<h1>Paquetes de folio para facturación</h1>");
                out.println("<br>");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>Paquete</th>");
                out.println("<th>N° Folio</th>");
                out.println("<th>PDFyXML</th>");
                out.println("<th>Precio</th>");
                out.println("<th></th>");
                out.println("</tr>");
                for(int i=0; i<listaPre.size();i++){
                out.println("<tr>");
                out.println("<td>"+listaPre.get(i).getPaquete()+"</td>");
                out.println("<td>"+listaPre.get(i).getFolio()+"</td>");
                out.println("<td>"+listaPre.get(i).getArchivo()+"</td>");
                out.println("<td>$"+ listaPre.get(i).getCosto()+"</td>");
                out.println("<td><input style=\" background: #333; font-family: Arial;\n" +
"font-size: 15pt;\n" +
"    border-radius: 7px; \n" +
"    color: white;\"type=\"submit\" id=\"contrata\"value=\"Contratanos\""+listaPre.get(i).getPaquete()+" ></td>");
                out.println("</tr>");
                
                out.println("</center>");
                }
            }else{
                out.println("No se encontro datos");
            }
     
    }finally{
            
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
