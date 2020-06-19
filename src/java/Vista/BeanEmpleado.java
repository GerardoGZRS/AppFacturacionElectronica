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
public class BeanEmpleado {
    int IdEmpleado;
    String Nombre;
    String Paterno;
    String Materno;
    String Especialidad;
    String Cargo;
    String Correo;
    String Contrasenia;
    int IdEmpresa;

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPaterno() {
        return Paterno;
    }

    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    public String getMaterno() {
        return Materno;
    }

    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }
    public BeanEmpleado(int IdEmpleado, String Nombre, String Paterno, String Materno, String Especialidad, String Cargo, String correo, String Contrasenia, int IdEmpresa){
        super();
        this.IdEmpleado=IdEmpleado;
        this.Nombre=Nombre;
        this.Paterno=Paterno;
        this.Materno=Materno;
        this.Especialidad=Especialidad;
        this.Cargo=Cargo;
        this.Correo=correo;
        this.Contrasenia=Contrasenia;
        this.IdEmpresa=IdEmpresa;
    }
}
