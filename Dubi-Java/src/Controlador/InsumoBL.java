/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo Aguero
 */
package Controlador;

import AccesoDatos.InsumoDA;
import Modelo.Insumo;
import Modelo.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsumoBL {
    private InsumoDA accesoDatos;
    
    public InsumoBL(){
        accesoDatos = new InsumoDA();
    }
    
    public int registrarInsumo(Insumo i,Proveedor p, double precio) throws SQLException{
        return accesoDatos.registrarInsumo(i,p,precio);
    }
    
    public ArrayList<Insumo> listarInsumos() throws SQLException{
        return accesoDatos.listarInsumos();
    }
}
