/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.BeanComentario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Comentario;

/**
 *
 * @author JAANP
 */
@WebServlet(name = "ServletInsertarComentario", urlPatterns = {"/ServletInsertarComentario"})
public class ServletInsertarComentario extends HttpServlet {

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
String IdComentario="1";
String Nombre=request.getParameter("nombre");
String Correo=request.getParameter("email");
String Empresa=request.getParameter("empresa");
String Telefono=request.getParameter("telefono");
String Comen=request.getParameter("comentario");
            
        //favor de no remover el codigo.....
        /*out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet NewServlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>"+IdComentario+"</h1>");
        out.println("<h1>"+Nombre+"</h1>");
        out.println("<h1>"+Correo+"</h1>");
        out.println("<h1>"+Empresa+"</h1>");
        out.println("<h1>"+Telefono+"</h1>");
        out.println("<h1>"+Comen+"</h1>");
        out.println("</body>");
        out.println("</html>");*/

        if(!IdComentario.equalsIgnoreCase("")&&!Nombre.equalsIgnoreCase("")&&
         !Correo.equalsIgnoreCase("")&&!Empresa.equalsIgnoreCase("")&&
               !Telefono.equalsIgnoreCase("")&&!Comen.equalsIgnoreCase("")){
       

            BeanComentario beanComentario = new BeanComentario(Integer.parseInt(IdComentario), Nombre, Correo, Empresa, Telefono, Comen);
           boolean sw = Comentario.insertarcomentario(beanComentario);
if(sw){ 
    out.println("<center>");
    out.println("<h2>Su comentario a sido enviado correctamente</h2>");
    out.println("<td><a href=\"index.html\">Regresar a la pagina principal</a></td>" ); 
    out.println("</center>");
         } else {
    out.println("<center>");
    out.println("<h2>No se a podido enviar su comentario</h2>");
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

    