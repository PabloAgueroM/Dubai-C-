/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Pablo Agüero
 */
public class Insumo extends ProductoGenerico{
    private double stockMinimo;
    private ArrayList<ProveedorxInsumo> proveedores;
    
    public Insumo(){
        proveedores = new ArrayList<ProveedorxInsumo>();
    }
        
    public void setStockMinimo(double stockMinimo){
        this.stockMinimo = stockMinimo;
    }
    
    public double getStockMinimo(){
        return stockMinimo;
    }
    
    public void setProveedoresXInsumo(ArrayList<ProveedorxInsumo> lista){
        proveedores = lista;
    }
    
    public ArrayList<ProveedorxInsumo> getProveedoresXInsumo(){
        return proveedores;
    }
    
    public void añadirProveedorXInsumo(ProveedorxInsumo pXi){
        proveedores.add(pXi);
    }
    
}
