using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class DetallePedido
    {
        private string producto;
        private int cantidad;
        private float subtotal;
        public DetallePedido() { }
        public DetallePedido(string producto, int cantidad, float subtotal) {
            this.Producto = producto;
            this.cantidad = cantidad;
            this.Subtotal = subtotal;
        }

        public float Subtotal { get => subtotal; set => subtotal = value; }
        public int Cantidad { get => cantidad; set => cantidad = value; }
        public string Producto { get => producto; set => producto = value; }
    }
}
