/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet.Factura;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "FormularioComprobante", urlPatterns = {"/FormularioComprobante"})
public class FormularioComprobante extends HttpServlet {

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
               String id_comprobante, concepto, cantidad, unidad, descripcion, valorUnitario, IEPS, Subtotal, Iva, Total;
       id_comprobante = request.getParameter("txtId");
       concepto = request.getParameter("txtConcepto");
       cantidad = request.getParameter("txtCantidad");
       unidad = request.getParameter("txtUnidad");
       descripcion = request.getParameter("txtDescripcion");
       valorUnitario = request.getParameter("txtValorUnitario");
        int var1 = Integer.parseInt(cantidad);
        int var2 = Integer.parseInt(valorUnitario);
        
        
        //IEPS 3%
        int var3;
        var3 = var1 * var2;
        float IEPS1;
               IEPS1 = (float) (var3 * .03);
        IEPS = ""+ IEPS1;
        //Calcular subtotal
        float sb;
        sb=  (float)(var3) + IEPS1;
        Subtotal = "" + sb;
        //Iva 16%
        float IV;
        IV = (float) (sb * .16);
        Iva = "" + IV;
        //Total 
        float tt;
        tt = (float) (sb+IV);
        Total = "" + tt;

        PrintWriter out = response.getWriter();
        try {
            out.println("<form method=\"POST\"");
            out.println("<fieldset>"); 
            out.println("<legend>Formulario Comprobante</legend>"
                    + "<table>"
                    + "<tr>\n" +
"                        <td>\n" +
"                            <label for=\"txtId\">Id del comprobante</label>\n" +
"                        </td>\n" +
"                        <td>\n" +
"                            <input  value='"+id_comprobante+"' type=\"text\" id=\"txtId\" name=\"txtId\" required=\"\">\n" +
"                        </td>\n" +
"                    </tr>"
                    + "<tr>\n" +
"                        <td>\n" +
"                            <label for=\"txtConcepto\">Concepto: </label>\n" +
"                        </td>\n" +
"                        <td>\n" +
"                            <input value='"+concepto+"' type=\"text\" id=\"txtConcepto\" name=\"txtConcepto\" required=\"\">\n" +
"                        </td>\n" +
"                    </tr>"
                    + "<tr>\n" +
"                        <td>\n" +
"                            <label for=\"txtCantidad\">Cantidad: </label>\n" +
"                        </td>\n" +
"                        <td>\n" +
"                            <input value='"+cantidad+"' type=\"text\" name=\"txtCantidad\" id=\"txtCantidad\" required=\"\">\n" +
"                        </td>\n" +
"                    </tr>"
                    + "<tr>\n" +
"                        <td>\n" +
"                            <label for=\"txtUnidad\">Unidad</label>\n" +
"                        </td>\n" +
"                        <td>\n" +
"                            <input value='"+unidad+"' type=\"text\" name=\"txtUnidad\" id=\"txtUnidad\" required=\"\">\n" +
"                        </td>\n" +
"                    </tr>"
                    + "<tr>\n" +
"                        <td>\n" +
"                            <label for=\"txtDescripcion\">Descripción</label>\n" +
"                        </td>\n" +
"                        <td>\n" +
"                            <input value='"+descripcion+"' type=\"text\" id=\"txtDescripcion\" name=\"txtDescripcion\" required=\"\">\n" +
"                        </td>\n" +
"                    </tr>"
                    + "<tr>\n" +
"                        <td>\n" +
"                            <label for=\"txtValorUnitario\">Valor Unitario: </label>\n" +
"                        </td>\n" +
"                        <td>\n" +
"                            <input value='"+valorUnitario+"' type=\"text\" id=\"txtValorUnitario\" name=\"txtValorUnitario\" required=\"\">\n" +
"                        </td>\n" +
"                    </tr>"
                    + "<tr>\n" +
"                        <td>\n" +
"                            <label for=\"txtIEPS\">IEPS: </label>\n" +
"                        </td>\n" +
"                        <td>\n" +
"                            <input value='"+IEPS+"' type=\"text\" id=\"txtIEPS\" name=\"txtIEPS\" required=\"\">\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>\n" +
"                            <label for=\"txtSubtotal\">Subtotal: </label>\n" +
"                        </td>\n" +
"                        <td>\n" +
"                            <input value='"+Subtotal+"' type=\"text\" id=\"txtSubtotal\" name=\"txtSubtotal\" required=\"\">\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>\n" +
"                            <label for=\"txtIva\">Iva:</label>\n" +
"                        </td>\n" +
"                        <td>\n" +
"                            <input value='"+Iva+"' type=\"text\" id=\"txtIva\" name=\"txtIva\" required=\"\">\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>\n" +
"                            <label for=\"txtTotal\">Total: </label>\n" +
"                        </td>\n" +
"                        <td>\n" +
"                            <input value='"+Total+"' type=\"text\" id=\"txtTotal\" name=\"txtTotal\" required=\"\">\n" +
"                        </td>\n" +
"                    </tr>");
             out.println("<tr><td><input type=\"submit\" value=\"Enviar\" formaction=\"/Factufacil/GuardarComprobante\"></td></tr>"
                     + "</table>");
             out.println("</fieldset>");
                     out.println("</form>");

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
