/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Vista.BeanPrecio;
/**
 *
 * @author JAANP
 */
public class Precio {
    public static LinkedList<BeanPrecio> ListaPrecio(){
        LinkedList<BeanPrecio> ListaP=new LinkedList<BeanPrecio>();
        BeanPrecio bnPrecio = null;
        try{
            Conexion c=new Conexion();
            Connection con=c.getConexion();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM PRECIO");
            
            while(rs.next()){
                bnPrecio=new BeanPrecio(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4));
                ListaP.add(bnPrecio);
            }
            rs.close();
            st.close();
            con.close();
            c.cerrarConexion();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ListaP;
    }
}
