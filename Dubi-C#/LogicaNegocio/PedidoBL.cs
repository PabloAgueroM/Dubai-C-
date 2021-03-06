﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AccesoDatos;
using Clases;
using System.ComponentModel;

namespace LogicaNegocio
{
    public class PedidoBL
    {
        private PedidoDA accesoDatos;

        public PedidoBL() {
            accesoDatos = new PedidoDA();
        }

        public int registrarPedido(Pedido p, BindingList<DetallePedido> detalles) {
            return accesoDatos.registrarPedido(p, detalles);
        }

        public BindingList<Pedido> listarPedidos()
        {
            return accesoDatos.listarPedidos();
        }

        public BindingList<DetallePedido> listarDetallesPedido(string id) {
            return accesoDatos.listarDetallesPedido(id);
        }

        public BindingList<Pedido> filtrarPedidos(string id)
        {
            return accesoDatos.filtrarPedidos(id);
        }

        public int cancelarPedido(string id)
        {
            return accesoDatos.cancelarPedido(id);
        }

        public Producto buscarProducto(string id)
        {
            return accesoDatos.buscarProducto(id);
        }

        public Persona buscarCliente(string id)
        {
            return accesoDatos.buscarCliente(id);
        }

        public void actualizarPedido(Pedido p, BindingList<DetallePedido> detalles)
        {
            accesoDatos.actualizarPedido(p, detalles);
        }

        public void avanzarPedido(Pedido p)
        {
             accesoDatos.avanzarPedido(p);
        }

    }
}
