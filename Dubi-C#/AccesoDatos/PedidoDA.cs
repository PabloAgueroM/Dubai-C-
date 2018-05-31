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
    public class PedidoDA
    {
        public int registrarPedido(Pedido p, BindingList<DetallePedido> detalles)
        {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "REGISTRAR_PEDIDO_PRODUCTO";
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
                foreach (DetallePedido d in detalles) {
                    d.IdPedido = p.IdPedido;
                    this.registrarDetallePedido(d);
                }
                con.Close();
                if (check == 1) return Int32.Parse(comando.Parameters["_ID_PEDIDO"].Value.ToString());
                else return 0;

            }
            return -1;
        }

        public void registrarDetallePedido(DetallePedido d) {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "REGISTRAR_DETALLE_PEDIDO_PRODUCTO";
                comando.Connection = con.Connection;
                comando.Parameters.Add("_NUM_ORDEN", MySqlDbType.Int32).Value = d.IdPedido;
                comando.Parameters.Add("_CANTIDAD_PRODUCTO", MySqlDbType.Int32).Value = d.Cantidad;
                comando.Parameters.Add("_IMPORTE_TOTAL_PRODUCTO", MySqlDbType.Int32).Value = d.Subtotal;
                comando.Parameters.Add("_ID_PRODUCTO", MySqlDbType.Int32).Value = d.Producto.Id;               

                int check = comando.ExecuteNonQuery();
                con.Close();

            }
        }

        public BindingList<Pedido> listarPedidos() {
            BindingList<Pedido> lista = new BindingList<Pedido>();
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_PEDIDOS";
                comando.Connection = con.Connection;
                MySqlDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    Pedido n = new Pedido();
                    n.IdPedido = reader.GetInt32("ID_PEDIDO_P").ToString();
                    n.IdUsuario = reader.GetInt32("ID_EMPLEADO").ToString();
                    n.IdCliente = reader.GetInt32("ID_CLIENTE").ToString();
                    n.FechaEntrega = reader.GetDateTime("FECHA_ENTREGA");
                    n.ImporteTotal = (float)reader.GetDecimal("IMPORTE_TOTAL");
                    n.Cuenta = (float)reader.GetDecimal("A_CUENTA_PED");
                    n.Saldo = (float)reader.GetDecimal("SALDO_PED");
                    if (reader.GetDecimal("IGV") > 0) n.Igv = true;
                    else n.Igv = false;                   

                    lista.Add(n);

                }
                con.Close();
            }
            return lista;
        }

        public BindingList<DetallePedido> listarDetallesPedido(string id) {
            BindingList<DetallePedido> lista = new BindingList<DetallePedido>();
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_DETALLES_PEDIDO";
                comando.Parameters.Add("_ID_PEDIDO", MySqlDbType.Int32).Value = id;
                comando.Connection = con.Connection;
                MySqlDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    DetallePedido n = new DetallePedido();
                    n.IdDetalle = reader.GetInt32("ID_DETALLE_ORDEN").ToString();
                    n.IdPedido = id;
                    n.Cantidad = reader.GetInt32("CANT_PRODUCTO");
                    n.Subtotal = (float)reader.GetDecimal("IMPORTE_TOTAL");
                    n.Producto.Id = reader.GetInt32("ID_PRODUCTO").ToString();
                    lista.Add(n);

                }
                con.Close();
            }
            return lista;
        }

        public BindingList<Pedido> filtrarPedidos(string id)
        {
            BindingList<Pedido> lista = new BindingList<Pedido>();
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "FILTRAR_PEDIDOS";
                comando.Parameters.Add("_ID_CLIENTE", MySqlDbType.Int32).Value = id;
                comando.Connection = con.Connection;
                MySqlDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    Pedido n = new Pedido();
                    n.IdPedido = reader.GetInt32("ID_PEDIDO_P").ToString();
                    n.IdUsuario = reader.GetInt32("ID_EMPLEADO").ToString();
                    n.IdCliente = reader.GetInt32("ID_CLIENTE").ToString();
                    n.FechaEntrega = reader.GetDateTime("FECHA_ENTREGA");
                    n.ImporteTotal = (float)reader.GetDecimal("IMPORTE_TOTAL");
                    n.Cuenta = (float)reader.GetDecimal("A_CUENTA_PED");
                    n.Saldo = (float)reader.GetDecimal("SALDO_PED");
                    if (reader.GetDecimal("IGV") > 0) n.Igv = true;
                    else n.Igv = false;

                    lista.Add(n);

                }
                con.Close();
            }
            return lista;
        }


    }
}
