﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using Clases;

namespace AccesoDatos
{
    public class UsuarioDA
    {
        public int registrarUsuario(Usuario u)
        {
            Conexion con = new Conexion();
            if (con.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "REGISTRAR_USUARIO";
                comando.Connection = con.Connection;
                comando.Parameters.Add("_NOMBRE", MySqlDbType.VarChar).Value = u.Nombre;
                comando.Parameters.Add("_DNI", MySqlDbType.VarChar).Value = u.Dni;
                comando.Parameters.Add("_AP_PATERNO", MySqlDbType.VarChar).Value = u.ApPat;
                comando.Parameters.Add("_AP_MATERNO", MySqlDbType.VarChar).Value = u.ApMat;
                comando.Parameters.Add("_TELEFONO", MySqlDbType.VarChar).Value = u.Telefono;
                comando.Parameters.Add("_EMAIL", MySqlDbType.VarChar).Value = u.Email;
                comando.Parameters.Add("_DIRECCION", MySqlDbType.VarChar).Value = u.Direccion;
                comando.Parameters.Add("_SEXO", MySqlDbType.VarChar).Value = u.Sexo;
                comando.Parameters.Add("_FECHA_NAC", MySqlDbType.Date).Value = u.FechaNac;
                comando.Parameters.Add("_ESTADOP", MySqlDbType.Int32).Value = 1;
                comando.Parameters.Add("_TIPO_USUARIO", MySqlDbType.Int32).Value = u.TipoUsuario;
                comando.Parameters.Add("_CONTRASENHA", MySqlDbType.VarChar).Value = u.Password;
                comando.Parameters.Add("_ESTADOU", MySqlDbType.Int32).Value = u.EstadoU;
                comando.Parameters.Add("_ID_OUT", MySqlDbType.Int32).Direction = System.Data.ParameterDirection.Output;

                int check = comando.ExecuteNonQuery();
                con.Close();
                if (check == 1) return Int32.Parse(comando.Parameters["_ID_OUT"].Value.ToString());
                return 0;
            }
            return -1;
        }
    }
}
