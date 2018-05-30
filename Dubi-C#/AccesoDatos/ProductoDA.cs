using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Clases;
using MySql.Data.MySqlClient;

namespace AccesoDatos
{
    public class ProductoDA
    {
        public BindingList<Producto> listarProductos() {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_PRODUCTOS";
                comando.Connection = con.Connection;

                MySqlDataReader reader = comando.ExecuteReader();

                BindingList<Producto> lista = new BindingList<Producto>();

                while (reader.Read())
                {
                    Producto u = new Producto();
                    u.Id = reader.GetString("ID_PRODUCTO");
                    u.Nombre = reader.GetString("NOMBRE");
                    u.Descripcion = reader.GetString("DESCRIPCION");
                    u.Color = reader.GetString("COLOR");
                    u.Precio = reader.GetDouble("PRECIO");
                    u.StockActual = reader.GetInt32("STOCK_ACTUAL");
                    u.Activo1 = reader.GetInt32("ACTIVO");
                    u.Talla = reader.GetChar("TALLA");

                    lista.Add(u);
                }

                con.Close();
                return lista;
            }
            return null;
        }


    }
}
