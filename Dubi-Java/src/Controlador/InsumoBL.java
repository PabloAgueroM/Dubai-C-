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
import Modelo.ProveedorxInsumo;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsumoBL {
    private InsumoDA accesoDatos;
    
    public InsumoBL(){
        accesoDatos = new InsumoDA();
    }
    
    public int registrarInsumo(Insumo i) throws SQLException{
        return accesoDatos.registrarInsumo(i);
    }
    
    public void modificarInsumo(Insumo i) throws SQLException{
        accesoDatos.modificarInsumo(i);
    }
    
    public void eliminarInsumo(Insumo i) throws SQLException{
        accesoDatos.eliminarInsumo(i);
    }
    
    
    public ArrayList<Insumo> listarInsumos() throws SQLException{
        return accesoDatos.listarInsumos();
    }
    
    public ArrayList<ProveedorxInsumo> listarProveedoresXInsumo(int idInsumo)throws SQLException{
        return accesoDatos.listarProveedoresXInsumo(idInsumo);
    }
}
