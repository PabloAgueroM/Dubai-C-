using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{

    public class ProductoGenerico
    {
        private int id;
        private string nombre;
        private string descripcion;
        private string color;
        private double precio;
        private double stockActual;
        private TipoProductoG tipo;
        private UnidadDeMedida unidad;
        private int Activo;

        public ProductoGenerico(int id, string nombre, string descripcion, string color, double precio, double stockActual, TipoProductoG tipo, UnidadDeMedida unidad, int activo)
        {
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.color = color;
            this.precio = precio;
            this.stockActual = stockActual;
            this.tipo = tipo;
            this.unidad = unidad;
            Activo = activo;
        }

        public int Id { get => id; set => id = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public string Color { get => color; set => color = value; }
        public double Precio { get => precio; set => precio = value; }
        public double StockActual { get => stockActual; set => stockActual = value; }
        public TipoProductoG Tipo { get => tipo; set => tipo = value; }
        public UnidadDeMedida Unidad { get => unidad; set => unidad = value; }
        public int Activo1 { get => Activo; set => Activo = value; }
    }
}
