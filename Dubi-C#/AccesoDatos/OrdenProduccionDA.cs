using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.ComponentModel;
using Clases;


namespace AccesoDatos
{
    public class OrdenProduccionDA
    {
        public BindingList<OrdenProduccion> listarOrdenesProduccion(int idOrden)
        {
            BindingList<OrdenProduccion> lista = new BindingList<OrdenProduccion>();
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_DETALLES_ORDEN_PRODUCCION";
                comando.Parameters.Add("_ID_PEDIDO", MySqlDbType.Int32).Value = idOrden;
                comando.Connection = con.Connection;
               MySqlDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    OrdenProduccion orden = new OrdenProduccion();

                    orden.IdProducto = reader.GetInt32("ID_PRODUCTO");
                    orden.NombreProd = reader.GetString("NOMBRE");
                    orden.Cantidad = reader.GetInt32("CANT_PRODUCTO");                                                          
                    lista.Add(orden);

                }
                con.Close();
            }
            return lista;
        }

        public int obtenerIdOrden(int id)
        {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandText = String.Format("SELECT ID_ORDEN_PROD FROM ORDEN_PRODUCCION WHERE ID_PEDIDO_P = '{0}'",id);
                comando.Connection = con.Connection;
                MySqlDataReader reader = comando.ExecuteReader();
                int idOrden = -1;
                if (reader.Read())
                {
                    OrdenProduccion orden = new OrdenProduccion();
                    idOrden = reader.GetInt32("ID_ORDEN_PROD");
                }
                con.Close();
                return idOrden;
            }
            return -1;
        }

    }
}
