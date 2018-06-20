using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Clases;
using System.ComponentModel;
using MySql.Data.MySqlClient;

namespace AccesoDatos
{
    public class OrdenCompraDA
    {
        public int registrarOrdenCompra(OrdenCompra p, BindingList<DetalleOrdenCompra> detalles)
        {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                /*
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "REGISTRAR_ORDEN_COMPRA";
                comando.Connection = con.Connection;
                comando.Parameters.Add("_ID_EMPLEADO", MySqlDbType.Int32).Value = p.IdUsuario;
                comando.Parameters.Add("_ID_CLIENTE", MySqlDbType.Int32).Value = p.IdCliente;
                comando.Parameters.Add("_FECHA_ENTREGA", MySqlDbType.Date).Value = p.FechaEntrega;
                comando.Parameters.Add("_IMPORTE_TOTAL", MySqlDbType.Decimal).Value = p.ImporteTotal;
                comando.Parameters.Add("_A_CUENTA_PED", MySqlDbType.Decimal).Value = p.Cuenta;
                comando.Parameters.Add("_SALDO_PED", MySqlDbType.Decimal).Value = p.Saldo;
                comando.Parameters.Add("_IGV", MySqlDbType.Decimal).Value = p.Igv;

                comando.Parameters.Add("_ID_PEDIDO", MySqlDbType.Int32).Direction = System.Data.ParameterDirection.Output;
                int check = comando.ExecuteNonQuery();
                p.IdPedido = comando.Parameters["_ID_PEDIDO"].Value.ToString();
                foreach (DetalleOrdenCompra d in detalles)
                {
                    d.IdPedido = p.IdPedido;
                    this.registrarDetalleOrdenCompra(d);
                }
                con.Close();
                if (check == 1) return Int32.Parse(comando.Parameters["_ID_PEDIDO"].Value.ToString());
                else return 0;
                */
            }
            return -1;
        }

        public BindingList<Proveedor> listarProveedores()
        {
            
            BindingList<Proveedor> lista = new BindingList<Proveedor>();
            
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_PROVEEDORES";
                comando.Connection = con.Connection;
                MySqlDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    Proveedor n = new Proveedor();
                    n.Email = reader.GetString("_EMAIL");
                    n.FechaAniversario = reader.GetDateTime("_FECHA_ANIVERSARIO");
                    n.IdPersona = reader.GetInt32("_ID_PERSONA").ToString();
                    n.IdProveedor = reader.GetInt32("_ID_PROVEEDOR").ToString();
                    n.Nombre = reader.GetString("_NOMBRE");
                    n.RazonSocial = reader.GetString("_RAZON_SOCIAL");
                    n.Representante.Nombre = reader.GetString("_NOMBRE_REP");
                    n.Ruc = reader.GetString("_RUC");
                    n.Telefono = reader.GetString("_TELEFONO");

                    lista.Add(n);

                }
                con.Close();
            }
            
            return lista;
        }


    }
}
