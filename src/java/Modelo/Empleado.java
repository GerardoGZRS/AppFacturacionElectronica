/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import Vista.BeanEmpleado;
import java.sql.SQLException;
/**
 *
 * @author JAANP
 */
public class Empleado {
    
public static LinkedList<BeanEmpleado> ListaEmpleado(){
        BeanEmpleado beanEmpleado = null;
        LinkedList<BeanEmpleado> listaempleado = new LinkedList<>();
        try{
            Conexion con=new Conexion();
            Connection c=con.getConexion();
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM EMPLEADO");
            while(rs.next()){
                beanEmpleado=new BeanEmpleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
                listaempleado.add(beanEmpleado);
            }   
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return listaempleado;
    }
    public static BeanEmpleado Buscarempresa(int idEmpleado){
        BeanEmpleado bnEmpresa = null;
        try {
            Conexion c= new Conexion();
            Connection con =c.getConexion();
            Statement st = con.createStatement();
 ResultSet rs = st.executeQuery(
         "select * from EMPLEADO where IDEMPLEADO='"+idEmpleado+"'");
 while(rs.next()){
     bnEmpresa = new BeanEmpleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
 }
 rs.close();
 st.close();
 c.cerrarConexion();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bnEmpresa;
    }
    
    
    public static boolean insertar(BeanEmpleado empleado){
        boolean alta = false;
        try {
            Conexion c =new Conexion();
            Connection con = c.getConexion();
            if(con !=null){
                Statement st;
                st = con.createStatement();
                    st.executeUpdate("INSERT INTO EMPLEADO VALUES(null,'"+empleado.getNombre()+"','"+empleado.getPaterno()+"','"+empleado.getMaterno()+"','"+empleado.getEspecialidad()+"','"+empleado.getCargo()+"','"+empleado.getCorreo()+"','"+empleado.getContrasenia()+"',"+empleado.getIdEmpresa()+")");
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
     public static boolean modificar(BeanEmpleado empleado){
        boolean alta = false;
        try {
            Conexion c =new Conexion();
            Connection con = c.getConexion();
            if(con !=null){
                Statement st;
                st = con.createStatement();
                    st.executeUpdate("update empleado set nombre='"+empleado.getNombre()+"', paterno='"+empleado.getPaterno()+"', materno='"+empleado.getMaterno()+"', especialidad='"+empleado.getEspecialidad()+"', cargo='"+empleado.getCargo()+"', correo='"+empleado.getCorreo()+"', contrasenia='"+empleado.getContrasenia()+"',idempresa="+empleado.getIdEmpresa()+"  WHERE idempleado="+empleado.getIdEmpleado()+"");
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
      public static boolean eliminarEmpleado(int idEMPL){
        boolean borrado = false;
        try{
        Conexion c =new Conexion();
            Connection con = c.getConexion();
            if(con !=null){
                Statement st;
                st = con.createStatement();
                
                if(idEMPL>0){
                
      st.executeUpdate("DELETE FROM EMPLEADO WHERE idempleado = '"+ idEMPL +"'");
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