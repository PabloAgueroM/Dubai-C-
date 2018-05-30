using System;
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

    }
}
