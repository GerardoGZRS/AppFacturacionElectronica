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
public class BeanPrecio {

    public int getPaquete() {
        return paquete;
    }

    public void setPaquete(int paquete) {
        this.paquete = paquete;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    int paquete;
    int folio;
    String archivo;
    float costo;
    public BeanPrecio(int paquete, int folio, String archivo, float costo){
        super();
        this.paquete=paquete;
        this.folio=folio;
        this.archivo=archivo;
        this.costo=costo;
    }
}
