using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Clases;
using AccesoDatos;
using System.ComponentModel;

namespace LogicaNegocio
{
    public class OrdenCompraBL
    {
        private OrdenCompraDA accesoDatos;

        public OrdenCompraBL()
        {
            accesoDatos = new OrdenCompraDA();
        }


        public int registrarOrdenCompra(OrdenCompra p, BindingList<DetalleOrdenCompra> detalles)
        {
            return accesoDatos.registrarOrdenCompra(p, detalles);
        }

        public BindingList<Proveedor> listarProveedores()
        {
            return accesoDatos.listarProveedores();
        }


    }
}
