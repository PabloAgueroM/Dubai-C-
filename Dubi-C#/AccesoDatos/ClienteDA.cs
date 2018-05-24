using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Clases;
using MySql.Data.MySqlClient;
using System.Data.SqlClient;
using System.ComponentModel;
using System.Windows.Forms;

namespace AccesoDatos
{
    public class ClienteDA
    {
        public int registrarClienteNatural(Natural c)
        {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "REGISTRAR_CLIENTE_NATURAL";
                comando.Connection = con.Connection;
                comando.Parameters.Add("_NOMBRE", MySqlDbType.VarChar).Value = c.Nombre;
                comando.Parameters.Add("_DNI", MySqlDbType.VarChar).Value = c.Dni;
                comando.Parameters.Add("_AP_PATERNO", MySqlDbType.VarChar).Value = c.ApPat;
                comando.Parameters.Add("_AP_MATERNO", MySqlDbType.VarChar).Value = c.ApMat;
                comando.Parameters.Add("_SEXO", MySqlDbType.VarChar).Value = c.Sexo;
                comando.Parameters.Add("_FECHA_NAC", MySqlDbType.Date).Value = c.FechaNac;
                comando.Parameters.Add("_TELEFONO", MySqlDbType.VarChar).Value = c.Telefono;
                comando.Parameters.Add("_EMAIL", MySqlDbType.VarChar).Value = c.Email;
                comando.Parameters.Add("_DIRECCION", MySqlDbType.VarChar).Value = c.Direccion;

                comando.Parameters.Add("_ID_PERSONA", MySqlDbType.Int32).Direction = System.Data.ParameterDirection.Output;

                int check = comando.ExecuteNonQuery();
                con.Close();
                if (check == 1) return Int32.Parse(comando.Parameters["_ID_PERSONA"].Value.ToString());
                else return 0;

            }
            return -1;
        }


        public int registrarClienteJuridico(Juridica c)
        {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "REGISTRAR_CLIENTE_JURIDICO";
                comando.Connection = con.Connection;
                comando.Parameters.Add("_RAZON", MySqlDbType.VarChar).Value = c.RazonSocial;
                comando.Parameters.Add("_RUC", MySqlDbType.VarChar).Value = c.Ruc;
                comando.Parameters.Add("_NOMBRE", MySqlDbType.VarChar).Value = c.Nombre;
                comando.Parameters.Add("_TELEFONO", MySqlDbType.VarChar).Value = c.Telefono;
                comando.Parameters.Add("_EMAIL", MySqlDbType.VarChar).Value = c.Email;
                comando.Parameters.Add("_DIRECCION", MySqlDbType.VarChar).Value = c.Direccion;
                comando.Parameters.Add("_FECHA_ANIVERSARIO", MySqlDbType.Date).Value = c.FechaAniversario;
                comando.Parameters.Add("_ID_PERSONA", MySqlDbType.Int32).Direction = System.Data.ParameterDirection.Output;

                int check = comando.ExecuteNonQuery();
                con.Close();
                if (check == 1) return Int32.Parse(comando.Parameters["_ID_PERSONA"].Value.ToString());
                else return 0;
            }
            return -1;
        }


        public BindingList<Natural> listarClienteNatural()
        {
            BindingList<Natural> lista = new BindingList<Natural>();

            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_CLIENTE_NATURAL";
                comando.Connection = con.Connection;
                MySqlDataReader reader = comando.ExecuteReader();
                while (reader.Read()) {
                    Natural n = new Natural();
                    n.ApMat = reader.GetString("AP_MATERNO");
                    n.ApPat = reader.GetString("AP_PATERNO");
                    n.Direccion = reader.GetString("DIRECCION");
                    n.Dni = reader.GetString("DNI");
                    n.Email = reader.GetString("EMAIL");
                    n.FechaNac = (DateTime)reader.GetMySqlDateTime("FECHA_NACIMIENTO");
                    n.IdPersona = reader.GetInt32("ID_PERSONA").ToString();
                    n.Nombre = reader.GetString("NOMBRE");
                    n.Sexo = reader.GetChar("SEXO");
                    n.Telefono = reader.GetString("TELEFONO");
                    lista.Add(n);

                }
                con.Close();
            }
            return lista;
        }

        public BindingList<Juridica> listarClienteJuridico()
        {
            BindingList<Juridica> lista = new BindingList<Juridica>();

            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_CLIENTE_JURIDICO";
                comando.Connection = con.Connection;
                MySqlDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    Juridica n = new Juridica();
                    n.Direccion = reader.GetString("DIRECCION");
                    n.Email = reader.GetString("EMAIL");
                    n.FechaAniversario = (DateTime)reader.GetMySqlDateTime("FECHA_ANIVERSARIO");
                    n.IdPersona = reader.GetInt32("ID_PERSONA").ToString();
                    n.Nombre = reader.GetString("NOMBRE");
                    n.RazonSocial = reader.GetString("RAZON_SOCIAL");
                    n.Ruc = reader.GetString("RUC");
                    n.Telefono = reader.GetString("TELEFONO");
                    lista.Add(n);

                }
                con.Close();
            }
            return lista;
        }


        public void actualizarClienteNatural(Natural c) {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "ACTUALIZAR_CLIENTE_NATURAL";
                comando.Connection = con.Connection;
                comando.Parameters.Add("_NOMBRE", MySqlDbType.VarChar).Value = c.Nombre;
                comando.Parameters.Add("_DNI", MySqlDbType.VarChar).Value = c.Dni;
                comando.Parameters.Add("_AP_PATERNO", MySqlDbType.VarChar).Value = c.ApPat;
                comando.Parameters.Add("_AP_MATERNO", MySqlDbType.VarChar).Value = c.ApMat;
                comando.Parameters.Add("_SEXO", MySqlDbType.VarChar).Value = c.Sexo;
                comando.Parameters.Add("_FECHA_NAC", MySqlDbType.Date).Value = c.FechaNac;
                comando.Parameters.Add("_TELEFONO", MySqlDbType.VarChar).Value = c.Telefono;
                comando.Parameters.Add("_EMAIL", MySqlDbType.VarChar).Value = c.Email;
                comando.Parameters.Add("_DIRECCION", MySqlDbType.VarChar).Value = c.Direccion;
                comando.Parameters.Add("_ID_PERSONA", MySqlDbType.Int32).Value = Convert.ToInt32(c.IdPersona);
                comando.ExecuteNonQuery();
                con.Close();
            }

        }


        public void actualizarClienteJuridico(Juridica c)
        {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "ACTUALIZAR_CLIENTE_JURIDICO";
                comando.Connection = con.Connection;
                comando.Parameters.Add("_RAZON", MySqlDbType.VarChar).Value = c.RazonSocial;
                comando.Parameters.Add("_RUC", MySqlDbType.VarChar).Value = c.Ruc;
                comando.Parameters.Add("_NOMBRE", MySqlDbType.VarChar).Value = c.Nombre;
                comando.Parameters.Add("_TELEFONO", MySqlDbType.VarChar).Value = c.Telefono;
                comando.Parameters.Add("_EMAIL", MySqlDbType.VarChar).Value = c.Email;
                comando.Parameters.Add("_DIRECCION", MySqlDbType.VarChar).Value = c.Direccion;
                comando.Parameters.Add("_FECHA_ANIVERSARIO", MySqlDbType.Date).Value = c.FechaAniversario;
                comando.Parameters.Add("_ID_PERSONA", MySqlDbType.Int32).Value = c.IdPersona;

                int check = comando.ExecuteNonQuery();
                con.Close();
            }
        }

        public void eliminarCliente(string id) {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandText = String.Format("UPDATE PERSONA SET ACTIVO = 0  WHERE ID_PERSONA = \"{0}\"", id);
                comando.Connection = con.Connection;
                comando.ExecuteNonQuery();
                con.Close();
            }
        }
        


    }
}
