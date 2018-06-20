using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class OrdenProduccion
    {
        private int idProducto;
        private string nombreProd;
        private int cantidad;

        public OrdenProduccion()
        {

        }
        public OrdenProduccion(int idProducto, string nombreProd, int cantidad)
        {
            this.IdProducto = idProducto;
            this.NombreProd = nombreProd;
            this.Cantidad = cantidad;
        }

        public int IdProducto { get => idProducto; set => idProducto = value; }
        public string NombreProd { get => nombreProd; set => nombreProd = value; }
        public int Cantidad { get => cantidad; set => cantidad = value; }
    }
}
