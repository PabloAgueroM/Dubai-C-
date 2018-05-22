using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class DetallePedido
    {
        private string idProducto;
        private string idPedido;
        private string idDetalle;
        private int cantidad;
        private float subtotal;
        public DetallePedido() { }

        public DetallePedido(string idProducto, string idPedido, string idDetalle, int cantidad, float subtotal)
        {
            this.idProducto = idProducto;
            this.idPedido = idPedido;
            this.idDetalle = idDetalle;
            this.cantidad = cantidad;
            this.subtotal = subtotal;
        }

        public string IdProducto { get => idProducto; set => idProducto = value; }
        public string IdPedido { get => idPedido; set => idPedido = value; }
        public string IdDetalle { get => idDetalle; set => idDetalle = value; }
        public int Cantidad { get => cantidad; set => cantidad = value; }
        public float Subtotal { get => subtotal; set => subtotal = value; }
    }
}
