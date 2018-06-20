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
    public class OrdenProduccionBL
    {
        private OrdenProduccionDA accesoDatos;
        public OrdenProduccionBL()
        {
            accesoDatos = new OrdenProduccionDA();
        }

        public BindingList<OrdenProduccion> listarOrdenesProduccion (int id)
        {
            return accesoDatos.listarOrdenesProduccion(id);
        } 

        public int obtenerIdOrden(int id)
        {
            return accesoDatos.obtenerIdOrden(id);
        }
    }
}
