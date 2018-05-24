/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesalmacen;

/**
 *
 * @author alulab14
 */
public class Almacen extends Ubicacion{
    
    private int IdAlmacen;
    private int capacidad;

    /**
     * @return the IdAlmacen
     */
    
    public Almacen(int IdAlmacen, int Capacidad, int IdUbicacion, int Ubigeo, String Direccion){
        super(IdUbicacion,Ubigeo,Direccion);
        this.IdAlmacen = IdAlmacen;
        this.capacidad = Capacidad;        
    }
    
    public int getIdAlmacen() {
        return IdAlmacen;
    }

    /**
     * @param IdAlmacen the IdAlmacen to set
     */
    public void setIdAlmacen(int IdAlmacen) {
        this.IdAlmacen = IdAlmacen;
    }

    /**
     * @return the Capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param Capacidad the Capacidad to set
     */
    public void setCapacidad(int Capacidad) {
        this.capacidad = Capacidad;
    }
    
    
        
}
