using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AccesoDatos;
using Clases;
namespace LogicaNegocio
{
    public class ProductoBL
    {
        private ProductoDA accesoDatos;

        public ProductoBL() {
            accesoDatos = new ProductoDA();
        }

        public BindingList<Producto> listarProductos() {
            return accesoDatos.listarProductos();
        }


    }
}
