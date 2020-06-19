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
import Vista.BeanEmpresa;
import java.sql.SQLException;
/**
 *
 * @author FORZEN
 */
public class Empresa {
    public static LinkedList<BeanEmpresa> listaempresa(){
        LinkedList<BeanEmpresa> listaEm=new LinkedList<>();
        BeanEmpresa bnEmpresa=null;
        try{
            Conexion c=new Conexion();
            Connection con=c.getConexion();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM empresa");
            
            while(rs.next()){
                bnEmpresa = new BeanEmpresa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
                listaEm.add(bnEmpresa);
            }
            rs.close();
            st.close();
            con.close();
            c.cerrarConexion();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return listaEm;
    }
    public static BeanEmpresa buscarEmpresa(int Idempresa){
        BeanEmpresa bnEmpresas = null;
        try{
        Conexion con = new Conexion();
            Connection c = con.getConexion();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM EMPRESA WHERE idempresa="+Idempresa+"");
            while(rs.next()){
                bnEmpresas = new BeanEmpresa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
            }
            rs.close();
            st.close();
            c.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bnEmpresas;
    }
    public static boolean insertarempresa(BeanEmpresa empresa){
        boolean alta = false;
        try {
            Conexion c =new Conexion();
            Connection con = c.getConexion();
            if(con !=null){
                Statement st;
                st = con.createStatement();
                    st.executeUpdate("INSERT INTO EMPRESA VALUES(null,'"+empresa.getEmpresa()+"','"+empresa.getRazon()+"','"+empresa.getRFC()+"','"+empresa.getRegimen()+"','"+empresa.getCalle()+"',"+empresa.getExterior()+","+empresa.getInterior()+",'"+empresa.getColonia()+"','"+empresa.getCodigo_postal()+"','"+empresa.getEstado()+"','"+empresa.getMunicipio()+"','"+empresa.getPaquete()+"','"+empresa.getNombre()+"','"+empresa.getCorreo()+"','"+empresa.getContrasenia()+"','"+empresa.getTelefono()+"')");
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
    public static boolean modificar(BeanEmpresa empresa){
        boolean alta = false;
        try {
            Conexion c =new Conexion();
            Connection con = c.getConexion();
            if(con !=null){
                Statement st;
                st = con.createStatement();
                    st.executeUpdate("update empresa set nomempresa='"+empresa.getEmpresa()+"',"
                            + " razon='"+empresa.getRazon()+"', rfc='"+empresa.getRFC()+"', "
                            + "regimen='"+empresa.getRegimen()+"', calle='"+empresa.getCalle()+"',"
                            + " numexterior="+empresa.getExterior()+", numinterior="+empresa.getInterior()+","
                            + " colonia='"+empresa.getColonia()+"', codigo_portal='"+empresa.getCodigo_postal()+"',"
                            + " estado='"+empresa.getEstado()+"', municipio='"+empresa.getMunicipio()+"', "
                            + "paquete='"+empresa.getPaquete()+"', nombrepersonal='"+empresa.getNombre()+"',"
                            + " correo='"+empresa.getCorreo()+"', contrasenia='"+empresa.getContrasenia()+"',"
                            + " telefono='"+empresa.getTelefono()+"' WHERE idempresa="+empresa.getIdempresa()+"");
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
    public static boolean eliminarEmpresa(int idEmpresa){
        boolean borrado = false;
        try{
        Conexion c =new Conexion();
            Connection con = c.getConexion();
            if(con !=null){
                Statement st;
                st = con.createStatement();
                
                if(idEmpresa>0){
                
      st.executeUpdate("DELETE FROM empresa WHERE idempresa = '"+ idEmpresa +"'");
                    borrado = true;
                
                }else{
                    borrado = false;
                }
      st.close();
      con.close();
            }else{
                borrado = false;
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            borrado = false;
            e.printStackTrace();
        }
        return borrado;
    }
}
