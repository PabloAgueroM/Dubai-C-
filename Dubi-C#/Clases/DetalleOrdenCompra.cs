using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class DetalleOrdenCompra
    {
        private Insumo insumo;
        private string idOrden;
        private string idDetalle;
        private int cantidad;
        private float subtotal;

        public DetalleOrdenCompra()
        {
        }

        public DetalleOrdenCompra(Insumo insumo, string idOrden, string idDetalle, int cantidad, float subtotal)
        {
            this.insumo = insumo;
            this.idOrden = idOrden;
            this.idDetalle = idDetalle;
            this.cantidad = cantidad;
            this.subtotal = subtotal;
        }

        public Insumo Insumo { get => insumo; set => insumo = value; }
        public string IdOrden { get => idOrden; set => idOrden = value; }
        public string IdDetalle { get => idDetalle; set => idDetalle = value; }
        public int Cantidad { get => cantidad; set => cantidad = value; }
        public float Subtotal { get => subtotal; set => subtotal = value; }
    }
}
