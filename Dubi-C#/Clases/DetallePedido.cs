using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class DetallePedido
    {
        private Producto producto;
        private string idPedido;
        private string idDetalle;
        private int cantidad;
        private float subtotal;
        public DetallePedido() {
            this.producto = new Producto();
        }

        public DetallePedido(Producto idProducto, string idPedido, string idDetalle, int cantidad, float subtotal)
        {
            this.producto = idProducto;
            this.idPedido = idPedido;
            this.idDetalle = idDetalle;
            this.cantidad = cantidad;
            this.subtotal = subtotal;
        }


        public string Talla { get => Producto.Talla.ToString(); set => Producto.Talla.ToString(); }
        public string PrecioProducto { get => Producto.Precio.ToString(); set => Producto.Precio.ToString(); }
        public string NombreProducto { get => Producto.Nombre; set => Producto.Nombre = value; }
        public string IdProducto { get => Producto.Id; set => Producto.Id = value; }
        public Producto Producto { get => producto; set => producto = value; }
        public string IdPedido { get => idPedido; set => idPedido = value; }
        public string IdDetalle { get => idDetalle; set => idDetalle = value; }
        public int Cantidad { get => cantidad; set => cantidad = value; }
        public float Subtotal { get => subtotal; set => subtotal = value; }
    }
}
