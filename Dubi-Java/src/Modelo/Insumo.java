/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Pablo Agüero
 */
public class Insumo extends ProductoGenerico{
    private int idInsumo;
    private int stockMinimo;
    
    public void setIdInsumo(int idInsumo){
        this.idInsumo = idInsumo;
    }
    
    public int getIdInsumo(){
        return idInsumo;
    }
    
    public void setStockMinimo(int stockMinimo){
        this.stockMinimo = stockMinimo;
    }
    
    public int getStockMinimo(){
        return stockMinimo;
    }
}
