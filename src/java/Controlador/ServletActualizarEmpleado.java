/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Vista.BeanEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author JAANP
 */
@WebServlet(name = "ServletActualizarEmpleado", urlPatterns = {"/ServletActualizarEmpleado"})
public class ServletActualizarEmpleado extends HttpServlet {

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
String IdEmpleado=request.getParameter("idEmple");
String Nombre=request.getParameter("nombre");
String Paterno=request.getParameter("paterno");
String Materno=request.getParameter("materno");
String Especialidad=request.getParameter("especialidad");
String Cargo=request.getParameter("cargo");
String Correo=request.getParameter("correo");
String Contrasenia=request.getParameter("contrasenia");
String IdEmpresa=request.getParameter("idEmpre");
String rfc;

Conexion con=new Conexion();
Connection c= con.getConexion();
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("SELECT RFC FROM EMPRESA WHERE IDEMPRESA="+IdEmpresa+"");
            
//favor de no remover el codigo.....
        /*out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet NewServlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>"+IdEmpleado+"</h1>");
        out.println("<h1>"+Nombre+"</h1>");
        out.println("<h1>"+Paterno+"</h1>");
        out.println("<h1>"+Materno+"</h1>");
        out.println("<h1>"+Especialidad+"</h1>");
        out.println("<h1>"+Cargo+"</h1>");
        out.println("<h1>"+Correo+"</h1>");
        out.println("<h1>"+Contrasenia+"</h1>");
        out.println("<h1>"+IdEmpresa+"</h1>");
        out.println("</body>");
        out.println("</html>");*/

       if(!IdEmpleado.equalsIgnoreCase("")&&!Nombre.equalsIgnoreCase("")&&
         !Paterno.equalsIgnoreCase("")&&!Materno.equalsIgnoreCase("")&&
               !Especialidad.equalsIgnoreCase("")&&!Cargo.equalsIgnoreCase("")&&
               !Correo.equalsIgnoreCase("")&&!Contrasenia.equalsIgnoreCase("")&&
                       !IdEmpresa.equalsIgnoreCase("")){

           BeanEmpleado beanEmpleado = new BeanEmpleado(Integer.parseInt(IdEmpleado), Nombre, Paterno, Materno, Especialidad, Cargo, Correo, Contrasenia, Integer.parseInt(IdEmpresa));
           boolean sw = Empleado.modificar(beanEmpleado);
if(sw){ 
     while (rs.next()) {
                 rfc=rs.getString(1);
                 
    out.println("<center>");
    out.println("<h2>Se ha actualizado el registro</h2>");
    out.println("<td><a href=\"empresa.jsp?rfc="+rfc+"\">Regresar a la pagina principal</a></td>" ); 
    out.println("</center>");
     }
         } else {
    while (rs.next()) {
                 rfc=rs.getString(1);
    out.println("<center>");
    out.println("<h2>Se ha actualizado el regoistro</h2>");
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
