/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import AccesoDatos.ProveedorDA;
import Modelo.*;
import java.util.ArrayList;
/**
 *
 * @author Carlos
 */
public class ProveedorBL {
    private ProveedorDA accesoDatos;
    public ProveedorBL(){
        accesoDatos = new ProveedorDA();
    }
    
    public void registrarProveedor(Proveedor p){
        accesoDatos.registrarProveedor(p);
    }
    public void ModificarProveedor(Proveedor p){
        accesoDatos.modificarProveedor(p);
    }
    public void eliminarProveedor(Proveedor p){
        accesoDatos.eliminarProveedor(p);
    }
    public ArrayList<Proveedor> listarProveedor(){
        return accesoDatos.listarProveedor();
    }
    
}
