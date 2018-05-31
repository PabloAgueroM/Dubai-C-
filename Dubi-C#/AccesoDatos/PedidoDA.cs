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
    }
}
