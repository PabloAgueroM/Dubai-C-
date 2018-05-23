using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Clases;
using MySql.Data.MySqlClient;

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
                comando.Parameters.Add("_ID_PERSONA", MySqlDbType.Int32).Direction = System.Data.ParameterDirection.Output;

                int check = comando.ExecuteNonQuery();
                con.Close();
                if (check == 1) return Int32.Parse(comando.Parameters["_ID_PERSONA"].Value.ToString());
                else return 0;
            }
            return -1;
        }

    }
}
