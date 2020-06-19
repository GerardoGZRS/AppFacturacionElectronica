/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

/**
*
 * @author Gerardo
 */
/**
 * Desing Pattern - Singleton
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class Conexion {

    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author DIN
 */
/**
 * Desing Pattern - Singleton
 */




    private static Conexion instance;
private  static String database, user, password;
private Connection connection;
private  Statement statement;


    private Conexion() throws ClassNotFoundException{
        Conexion.database= "";
        Conexion.user= "";
        Conexion.password="";


        Class.forName("com.mysql.jdbc.Driver");
    }

    public static  Conexion getInstance(String database,
            String user,
            String password) throws ClassNotFoundException{
        if(instance == null){
           instance = new Conexion();
        }
        Conexion.database = database;
        Conexion.user = user;
        Conexion.password = password;

        return instance;
    }

    public boolean open(){
        String url= "jdbc:mysql://127.0.0.1:3306/"
                + Conexion.database;
       try{
        this.connection = DriverManager.getConnection(url,user,password);
        this.statement = this.connection.createStatement();
    } catch (SQLException ex){
        return false;
    }
return true;
    }//fin de open


    public ResultSet readData(String query)
throws SQLException{
return this.statement.executeQuery(query);

    }
    public void updateData(String sql) throws  SQLException{
        this.statement.executeUpdate(sql);
    }

    @Override
    protected void finalize() throws Throwable {
        this.connection.close();
        this.statement.close();
        super.finalize();
    }
}//fin de la clase Singledbconnection
