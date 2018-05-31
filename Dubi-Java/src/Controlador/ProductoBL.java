/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.ProductoDA;
import Modelo.InsumoxProducto;
import Modelo.Producto;
import Modelo.TipoProductoG;
import Modelo.UnidadDeMedida;
import java.util.ArrayList;

/**
 *
 * @author Katherine Espinoza 20122127
 */
public class ProductoBL {
    private ProductoDA accesoDatos;
    
    public ProductoBL(){
        accesoDatos=new ProductoDA();
    }
    public void agregarProducto(Producto p){
        accesoDatos.registrarProducto(p);
    }
    public void modificarProducto(Producto p){
        accesoDatos.modificarInsumo(p);
    }
    public void eliminarProducto(Producto p){
        p.setActivo(0);
        accesoDatos.modificarInsumo(p);
    }
    public ArrayList<Producto> listarProductos(){
        return accesoDatos.listarProductos();
    }
    public ArrayList<TipoProductoG> listarTipoProducto(){
        return accesoDatos.listarTipoProducto();
    }    
    public ArrayList<UnidadDeMedida> listarUnidades(){
        return accesoDatos.listarUnidadMedida();
    }
    public void agregarInsumoXProducto(int idProducto,InsumoxProducto ip){
        accesoDatos.agregarInsumoXProducto(idProducto,ip);
    }
    public void modificarInsumoXProducto(int idProducto,InsumoxProducto ip){
        accesoDatos.modificarInsumoXProducto(idProducto, ip);
    }
    public void eliminarInsumoXProducto(int idProducto,int idInsumo) {
        accesoDatos.eliminarInsumoXProducto(idProducto, idInsumo);
    }
    public ArrayList<InsumoxProducto> listarInsumoXProducto(int idProducto) {
        return accesoDatos.listarInsumoXProducto(idProducto);
    }
}
