/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Kenny-pc
 */
public class MejorCliente {
    private String name;
    private float montoTotal;
    private String fechaUltEnt;
    
    
    public MejorCliente(String name, float monto, String fecha){
        setName(name);
        setMontoTotal(monto);
        setFechaUltEnt(fecha);
    }

    public MejorCliente() {
        
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the montoTotal
     */
    public float getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * @return the fechaUltEnt
     */
    public String getFechaUltEnt() {
        return fechaUltEnt;
    }

    /**
     * @param fechaUltEnt the fechaUltEnt to set
     */
    public void setFechaUltEnt(String fechaUltEnt) {
        this.fechaUltEnt = fechaUltEnt;
    }
    
}
