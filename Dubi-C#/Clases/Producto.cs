using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Producto : ProductoGenerico
    {
        private char talla;

        public Producto(int id, string nombre, string descripcion, string color, double precio, double stockActual, TipoProductoG tipo, UnidadDeMedida unidad, int activo,char talla) : base(id, nombre, descripcion, color, precio, stockActual, tipo, unidad, activo)
        {
            this.talla = talla;
        }

        public char Talla { get => talla; set => talla = value; }
    }

}
