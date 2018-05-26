/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.PedidoDA;
import Modelo.Estado;
import Modelo.Pedido;
import java.util.ArrayList;

/**
 *
 * @author alulab14
 */
public class PedidoBL {
    private PedidoDA accesoDatos;
    public PedidoBL(){
        accesoDatos=new PedidoDA();
    }
    public void registrarPedido(Pedido p){
        accesoDatos.registrarPedido(p);
    }    
    public ArrayList<Pedido> listarPedido(){        
        return accesoDatos.listarPedidos();
    }
    public void cancelarPedido(Pedido p){
        p.setEstado(Estado.CANCELADO);
        accesoDatos.modificarPedido(p);
    }
    public void producirPedido(Pedido p){        
        p.setEstado(Estado.EN_PRODUCCION);
        accesoDatos.modificarPedido(p);
    }
    public void entregarPedido(Pedido p){        
        p.setEstado(Estado.ENTREGADO);
        accesoDatos.modificarPedido(p);
    }
}
