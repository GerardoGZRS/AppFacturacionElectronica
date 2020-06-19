/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Empleado;
import Vista.BeanEmpleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author JAANP
 */
@WebServlet(name = "ServletEliminarEmpleado", urlPatterns = {"/ServletEliminarEmpleado"})
public class ServletEliminarEmpleado extends HttpServlet {

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
       String idEmp =request.getParameter("idEmpl");
       String rfc;
       
       Conexion con=new Conexion();
Connection c= con.getConexion();
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT RFC FROM EMPRESA E INNER JOIN EMPLEADO M ON E.IDEMPRESA=M.IDEMPRESA WHERE IDEMPLEADO="+idEmp+"");  
       
 if(!idEmp.equalsIgnoreCase("")){
  
boolean sw = Empleado.eliminarEmpleado(Integer.parseInt(idEmp));
if(sw){
    while(rs.next()){
        rfc=rs.getString(1);
    out.println("<center>");
    out.println("<h2>El empleado a sido eliminado del sistema</h2>");
    out.println("<td><a href=\"empresa.jsp?rfc="+rfc+"\">Regresar a la pagina principal</a></td>" ); 
    out.println("</center>");
    }
         } else {  
    while(rs.next()){
        rfc=rs.getString(1);
    out.println("<center>");
    out.println("<h2>No se pudo completar tu operacion</h2>");
    out.println("<td><a href=\"empresa.jsp?rfc="+rfc+"\">Regresar a la pagina principal</a></td>" ); 
    out.println("</center>");
    }
                 }
        
 }   
           
        }catch(Exception ex){
            ex.printStackTrace();
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

