/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alulab14
 */
public class Ubicacion {
    
    private int IdUbicacion;
    private int Ubigeo;
    private String Direccion;

    /**
     * @return the IdUbicacion
     */
    
    public Ubicacion(int IdUbicacion, int Ubigeo, String Direccion){
        this.Ubigeo = Ubigeo;
        this.Direccion = Direccion;
        this.IdUbicacion = IdUbicacion;
    }
    
    public int getIdUbicacion() {
        return IdUbicacion;
    }

    /**
     * @param IdUbicacion the IdUbicacion to set
     */
    public void setIdUbicacion(int IdUbicacion) {
        this.IdUbicacion = IdUbicacion;
    }

    /**
     * @return the Ubigeo
     */
    public int getUbigeo() {
        return Ubigeo;
    }

    /**
     * @param Ubigeo the Ubigeo to set
     */
    public void setUbigeo(int Ubigeo) {
        this.Ubigeo = Ubigeo;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    
    
}
