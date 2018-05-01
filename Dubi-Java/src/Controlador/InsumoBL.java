/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.InsumoDA;
import Modelo.Insumo;
import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class InsumoBL {
    private InsumoDA accesoDatos;
    
    public InsumoBL(){
        accesoDatos = new InsumoDA();
    }
    
    public void registrarInsumo(Insumo i){
        accesoDatos.registrarInsumo(i);
    }
    
    public void eliminarInsumo(Insumo i){
        accesoDatos.eliminarInsumo(i);
    }
    
    public void modificarInsumo(Insumo i){
        accesoDatos.modificarInsumo(i);
    }
    
    public ArrayList<Insumo> listarInsumos(){
        return accesoDatos.listarInsumos();
    }
}
