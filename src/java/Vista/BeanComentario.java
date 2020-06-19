/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author JAANP
 */
public class BeanComentario {
    int IdComentario;
    String Nombre;
    String Correo;
    String Empresa;
    String Telefono;
    String Comentario;

    public int getIdComentario() {
        return IdComentario;
    }

    public void setIdComentario(int IdComentario) {
        this.IdComentario = IdComentario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }
    public BeanComentario(int IdComentario, String Nombre, String Correo, String Empresa, String Telefono, String Comentario){
        super();;
        this.IdComentario=IdComentario;
        this.Nombre=Nombre;
        this.Correo=Correo;
        this.Empresa=Empresa;
        this.Telefono=Telefono;
        this.Comentario=Comentario;
    }
}
