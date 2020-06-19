/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empresa;
import Vista.BeanEmpresa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAANP
 */
@WebServlet(name = "ServletInsertarEmpresa", urlPatterns = {"/ServletInsertarEmpresa"})
public class ServletInsertarEmpresa extends HttpServlet {

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
String IdEmpresa=request.getParameter("idE");
String Empresas=request.getParameter("Empresa");
String Razon=request.getParameter("Razon");
String RFC=request.getParameter("RFC");
String Regimen=request.getParameter("Regimen");
String Calle=request.getParameter("Calle");
String Exterior=request.getParameter("Exterior");
String Interior=request.getParameter("Interior");
String Colonia=request.getParameter("Colonia");
String Codigo_postal=request.getParameter("Codigo");
String Estado=request.getParameter("Estado");
String Municipio=request.getParameter("Municipio");
String Paquete=request.getParameter("Paquete");
String Nombre=request.getParameter("Nombre");
String Correo=request.getParameter("Correo");
String Contrasenia=request.getParameter("Contrasenia");
String Telefono=request.getParameter("Telefono");
            
//favor de no remover el codigo.....

        /*out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet NewServlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>"+IdEmpresa+"</h1>");
        out.println("<h1>"+Empresas+"</h1>");
        out.println("<h1>"+Razon+"</h1>");
        out.println("<h1>"+RFC+"</h1>");
        out.println("<h1>"+Regimen+"</h1>");
        out.println("<h1>"+Calle+"</h1>");
        out.println("<h1>"+Exterior+"</h1>");
        out.println("<h1>"+Interior+"</h1>");
        out.println("<h1>"+Colonia+"</h1>");
        out.println("<h1>"+Codigo_postal+"</h1>");
        out.println("<h1>"+Estado+"</h1>");
        out.println("<h1>"+Municipio+"</h1>");
        out.println("<h1>"+Paquete+"</h1>");
        out.println("<h1>"+Nombre+"</h1>");
        out.println("<h1>"+Correo+"</h1>");
        out.println("<h1>"+Contrasenia+"</h1>");
        out.println("<h1>"+Telefono+"</h1>");
        out.println("</body>");
        out.println("</html>");*/

       if(!IdEmpresa.equalsIgnoreCase("")&&!Empresas.equalsIgnoreCase("")&&
         !Razon.equalsIgnoreCase("")&&!RFC.equalsIgnoreCase("")&&
               !Regimen.equalsIgnoreCase("")&&!Calle.equalsIgnoreCase("")&&
               !Exterior.equalsIgnoreCase("")&&!Interior.equalsIgnoreCase("")&&
                       !Colonia.equalsIgnoreCase("")&&!Codigo_postal.equalsIgnoreCase("")&&
                        !Estado.equalsIgnoreCase("")&&!Municipio.equalsIgnoreCase("")&&
               !Paquete.equalsIgnoreCase("")&&!Nombre.equalsIgnoreCase("")&&!Correo.equalsIgnoreCase("")&&
               !Contrasenia.equalsIgnoreCase("")&&!Telefono.equalsIgnoreCase("")){

           BeanEmpresa beanEmpresa = new BeanEmpresa(Integer.parseInt(IdEmpresa), Empresas, Razon, RFC, Regimen, Calle, Integer.parseInt(Exterior), Integer.parseInt(Interior), Colonia, Codigo_postal, Estado, Municipio, Paquete, Nombre, Correo, Contrasenia, Telefono);
           boolean sw = Empresa.insertarempresa(beanEmpresa);
if(sw){ 
    out.println("<center>");
    out.println("<h2>Usted esta dado de alta en el sistema</h2>");
    out.println("<td><a href=\"index.html\">Regresar a la pagina principal</a></td>" ); 
    out.println("</center>");
         } else {
    out.println("<center>");
    out.println("<h2>No se a podido dar de alta al sistema</h2>");
    out.println("<td><a href=\"index.html\">Regresar a la pagina principal</a></td>" ); 
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
