/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
/**
 *
 * @author Pablo
 */
public class ProveedorxInsumo {
    private Proveedor proveedor;
    private double precio;
    
    public ProveedorxInsumo(Proveedor proveedor, double precio){
        this.proveedor = proveedor;
        this.precio = precio;
    }

    public ProveedorxInsumo() {
       
    }
    
    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor; 
    }
    
    public Proveedor getProveedor(){
        return this.proveedor;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public double getPrecio(){
        return precio;
    }
}
