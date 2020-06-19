/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.LinkedList;
import Vista.BeanComentario;
import java.sql.SQLException;

/**
 *
 * @author JAANP
 */
public class Comentario {
    public static boolean insertarcomentario(BeanComentario comentario){
        boolean alta = false;
        try {
            Conexion c =new Conexion();
            Connection con = c.getConexion();
            if(con !=null){
                Statement st;
                st = con.createStatement();
                    st.executeUpdate("INSERT INTO comentario VALUES(null,'"+comentario.getNombre()+"','"+comentario.getCorreo()+"','"+comentario.getEmpresa()+"','"+comentario.getTelefono()+"','"+comentario.getComentario()+"')");
                    alta = true;
                    st.close();
                    con.close();
            }else{
                alta = false;
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            alta= false;
            e.printStackTrace();
        }
        return alta;
    }
}