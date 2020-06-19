/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet.Factura;

import Entities.Comprobante;
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
public class GuardarComprobante extends HttpServlet {

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
      
            String id_comprobante, concepto, valorUnitario, descripción, unidad,
                    cantidad, IEPS, Subtotal, Iva, Total;
            id_comprobante = request.getParameter("txtId");
            concepto = request.getParameter("txtConcepto");
            valorUnitario = request.getParameter("txtValorUnitario");
            descripción = request.getParameter("txtDescripcion");
            unidad= request.getParameter("txtUnidad");
            cantidad = request.getParameter("txtCantidad");
            IEPS = request.getParameter("txtIEPS");
            Subtotal = request.getParameter("txtSubtotal");
            Iva = request.getParameter("txtIva");
            Total = request.getParameter("txtTotal");
            
            Comprobante obj = new Comprobante(id_comprobante, concepto, valorUnitario, 
                    descripción, unidad, cantidad, IEPS, Subtotal, Iva, Total);
            
            String memsaje = obj.save();
            out.println(memsaje);
            
             
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
    }
}
