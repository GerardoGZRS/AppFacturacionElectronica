
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
import Vista.BeanEmpresa;
import Modelo.Empresa;
/**
 *
 * @author FORZEN
 */
@WebServlet(name = "ServletConsultarEmpresa", urlPatterns = {"/ServletConsultarEmpresa"})
public class ServletConsultarEmpresa extends HttpServlet {

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
        LinkedList<BeanEmpresa> listaE=new LinkedList<>(Empresa.listaempresa());
        try{
            
            /* TODO output your page here. You may use following sample code. */
        if(listaE.size()>0){
            out.println("<center>");
            out.println("<h1>Lista de empresa</h1>");
            out.println("<table border=\"1\" id=\"tbem\">");
            out.println("<tr>");
            out.println("<th>RFC</th>");
            out.println("<th>Nombre de la empresa</th>");
            out.println("<th>Razon social</th>");
            out.println("<th>RFC</th>");
            out.println("<th>Régimen</th>");
            out.println("<th>Calle</th>");
            out.println("<th>Numero exterior</th>");
            out.println("<th>Numero interior</th>");
            out.println("<th>Colonia</th>");
            out.println("<th>Codigo postal</th>");
            out.println("<th>Estado</th>");
            out.println("<th>Municipio</th>");
            out.println("<th>Paquetes</th>");
            out.println("<th>Nombre del administrador</th>");
            out.println("<th>Contraseña</th>");
            out.println("<th>Correo</th>");
            out.println("<th>Telefono</th>");
            out.println("</tr>");
            
            for(int i=0;i<listaE.size();i++){
                out.println("<tr>");
                out.println("<td>"+listaE.get(i).getIdempresa()+"</td>");
                out.println("<td>"+listaE.get(i).getEmpresa()+"</td>");
                out.println("<td>"+listaE.get(i).getRazon()+"</td>");
                out.println("<td>"+listaE.get(i).getRFC()+"</td>");
                out.println("<td>"+listaE.get(i).getRegimen()+"</td>");
                out.println("<td>"+listaE.get(i).getCalle()+"</td>");
                out.println("<td>"+listaE.get(i).getExterior()+"</td>");
                out.println("<td>"+listaE.get(i).getInterior()+"</td>");
                out.println("<td>"+listaE.get(i).getColonia()+"</td>");
                out.println("<td>"+listaE.get(i).getCodigo_postal()+"</td>");
                out.println("<td>"+listaE.get(i).getEstado()+"</td>");
                out.println("<td>"+listaE.get(i).getMunicipio()+"</td>");
                out.println("<td>"+listaE.get(i).getPaquete()+"</td>");
                out.println("<td>"+listaE.get(i).getNombre()+"</td>");
                out.println("<td>"+listaE.get(i).getCorreo()+"</td>");
                out.println("<td>"+listaE.get(i).getContrasenia()+"</td>");
                out.println("<td>"+listaE.get(i).getTelefono()+"</td>");
                out.println("<td><a href=\"JSP/ActualizarEmpresa.jsp?idE="+ listaE.get(i).getIdempresa()+"\">Actualizar</a></td>");
                out.println("<td><a href=\"ServletEliminarEmpresa?idE="+listaE.get(i).getIdempresa()+"\">Eliminar</a></td>");
                out.println("</tr>");
            }
            }else{
             out.println("No se mostraron los registros");       
                    }
            
            out.println("</table>");
            out.println("<br/>");
            out.println("</center>");
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
