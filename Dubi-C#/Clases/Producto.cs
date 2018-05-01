using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{

    public class Producto
    {

        private string id;
        private string descripcion;
        private float precio;
        private int stock;

        public Producto(string _id, string _descripcion, float _precio, int _stock)
        {
            id = _id;
            descripcion = _descripcion;
            precio = _precio;
            stock = _stock;
        }

        public string Id { get => id; set => id = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public float Precio { get => precio; set => precio = value; }
        public int Stock { get => stock; set => stock = value; }
    }
}
