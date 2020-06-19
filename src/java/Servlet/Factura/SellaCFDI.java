/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet.Factura;

import Entities.Comprobante;
import Entities.Factura;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumnos
 */
public class SellaCFDI extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String folio_fiscal, LugarExpedicion,
                    Hora_FechaExpedicion, no_certDigital, Hora_FechaCerti,
                    Rfc, Rfc_Rec, id_comprobante;
            int no_SerCertificado;
            folio_fiscal = "";
            no_SerCertificado = 0;
            LugarExpedicion = request.getParameter("txtLE");
            Hora_FechaExpedicion = request.getParameter("txtFecha");
            no_certDigital = "";
            Hora_FechaCerti = "";
            Rfc = request.getParameter("comboEmisor");
            Rfc_Rec = request.getParameter("comboDinamico");
            id_comprobante = request.getParameter("comboComprobante");
            
            Factura obj = new Factura(folio_fiscal, no_SerCertificado, LugarExpedicion, Hora_FechaExpedicion, no_certDigital, Hora_FechaCerti, Rfc, Rfc_Rec, id_comprobante);
            String mensaje = obj.guardarFactura();
            out.println(mensaje);
           
            
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
