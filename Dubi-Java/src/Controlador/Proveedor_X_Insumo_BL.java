
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.Proveedor_X_Insumo_DA;
import Modelo.Insumo;
import Modelo.ProveedorxInsumo;
import java.sql.SQLException;

/**
 *
 * @author Pablo
 */
public class Proveedor_X_Insumo_BL {
    private Proveedor_X_Insumo_DA accesoDatos;
    
    public Proveedor_X_Insumo_BL(){
        accesoDatos = new Proveedor_X_Insumo_DA();
    }
    
    public void registrarProveedorXInsumo(int idInsumo,ProveedorxInsumo pXi,int activo) throws SQLException{
        accesoDatos.registrarProveedorXInsumo(idInsumo,pXi,activo);
    }
    
    public void modificarProveedorXInsumo(int idInsumo,ProveedorxInsumo pXi,int activo) throws SQLException{
        accesoDatos.modificarProveedorXInsumo(idInsumo,pXi,activo);
    }
    
    public int validarProveedorXInsumo(int idInsumo,int idProveedor) throws SQLException{
        return accesoDatos.validarProveedorXInsumo(idInsumo, idProveedor);
    }
}
