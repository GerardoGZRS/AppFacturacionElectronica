/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author FORZEN
 */
public class BeanEmpresa {
int Idempresa;
String Empresa;
String Razon;
String RFC;
String Regimen;
String Calle;
int Exterior;
int Interior;
String Colonia;
String Codigo_postal;
String Estado;
String Municipio;
String Paquete;
String nombre;
String Correo;
String Contrasenia;

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }
String telefono;

    public int getIdempresa() {
        return Idempresa;
    }

    public void setIdempresa(int Idempresa) {
        this.Idempresa = Idempresa;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getRazon() {
        return Razon;
    }

    public void setRazon(String Razon) {
        this.Razon = Razon;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getRegimen() {
        return Regimen;
    }

    public void setRegimen(String Regimen) {
        this.Regimen = Regimen;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public int getExterior() {
        return Exterior;
    }

    public void setExterior(int Exterior) {
        this.Exterior = Exterior;
    }

    public int getInterior() {
        return Interior;
    }

    public void setInterior(int Interior) {
        this.Interior = Interior;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getCodigo_postal() {
        return Codigo_postal;
    }

    public void setCodigo_postal(String Codigo_postal) {
        this.Codigo_postal = Codigo_postal;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public String getPaquete() {
        return Paquete;
    }

    public void setPaquete(String Paquete) {
        this.Paquete = Paquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public BeanEmpresa(int Idempresa, String Empresa, String Razon, String RFC, String Regimen, String Calle, int Exterior,
                        int Interior, String Colonia, String Codigo_postal, String Estado, String Municipio, String Paquete,
                        String nombre, String Correo,String Contrasenia, String Telefono){
        super();
        this.Idempresa=Idempresa;
        this.Empresa=Empresa;
        this.Razon=Razon;
        this.RFC=RFC;
        this.Regimen=Regimen;
        this.Calle=Calle;
        this.Exterior=Exterior;
        this.Interior=Interior;
        this.Colonia=Colonia;
        this.Codigo_postal=Codigo_postal;
        this.Estado=Estado;
        this.Municipio=Municipio;
        this.Paquete=Paquete;
        this.nombre=nombre;
        this.Correo=Correo;
        this.Contrasenia=Contrasenia;
        this.telefono=Telefono;
    }
}