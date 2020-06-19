/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet.Factura;

import Entities.Emisor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DIN-CB03-PC
 */
public class EmisorGuardar extends HttpServlet {

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
        try {
            String Rfc, Razon_Social, Regimen, Calle, NumInt, NumExt, Colonia, Codigo_Postal, Municipio, Estado, Pais;
        Rfc = request.getParameter("txtRfc");
        Razon_Social = request.getParameter("txtRazonSocial");
        Regimen = request.getParameter("txtRegimen");
        Calle = request.getParameter("txtCalle");
        NumInt = request.getParameter("txtNumInt");
        NumExt = request.getParameter("txtNumExt");
        Colonia = request.getParameter("txtColonia");
        Codigo_Postal = request.getParameter("txtCodigoPostal");
        Municipio = request.getParameter("txtMunicipio");
        Estado = request.getParameter("txtEstado");
        Pais = request.getParameter("txtPais");
        
        Emisor obj = new Emisor(Rfc, Razon_Social,Regimen ,Calle, NumInt, NumExt, Colonia, Codigo_Postal, Municipio, Estado, Pais);
        String mensaje = obj.guardar();
        out.println(mensaje);
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
