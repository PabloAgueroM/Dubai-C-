﻿using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AccesoDatos
{
    public class LoginDA
    {
        public LoginDA() { }

        public void inicioSesion(string user)
        {
            Conexion conexion = new Conexion();
            if (conexion.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandText = String.Format("UPDATE USUARIO SET ENLINEA = 1  WHERE ID_USUARIO = \"{0}\"", user);
                comando.Connection = conexion.Connection;
                try
                {
                    comando.ExecuteNonQuery();
                    conexion.Close();
                }
                catch (Exception)
                {
                    conexion.Close();
                }
            }
        }

        public void cerrarSesion(string user)
        {
            Conexion conexion = new Conexion();
            if (conexion.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandText = String.Format("UPDATE USUARIO SET ENLINEA = 0  WHERE ID_USUARIO = \"{0}\"", user);
                comando.Connection = conexion.Connection;
                try
                {
                    comando.ExecuteNonQuery();
                    conexion.Close();
                }
                catch (Exception)
                {
                    conexion.Close();
                }
            }
        }

        public int ValidarUsuario(string user, string password)
        {
            Conexion conexion = new Conexion();
            if (conexion.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandText = String.Format("SELECT * FROM USUARIO WHERE ID_USUARIO = \"{0}\" AND CONTRASENHA = \"{1}\" AND ACTIVO=1", user, password);
                comando.Connection = conexion.Connection;
                try{
                    int mysqlint = int.Parse(comando.ExecuteScalar().ToString());

                    inicioSesion(user);

                    conexion.Close();
                    return 1;
                }
                catch (Exception)
                {
                    conexion.Close();
                    return 0;
                }
            }
            else { return -1; }
        }

        public int ObtenerNivelUsuario(string id)
        {
            Conexion conexion = new Conexion();
            if (conexion.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandText = String.Format("SELECT TIPO_USUARIO FROM USUARIO WHERE ID_USUARIO = '{0}' AND ACTIVO=1", id);
                comando.Connection = conexion.Connection;
                try
                {
                    MySqlDataReader reader =  comando.ExecuteReader();
                    int nivel = 0;
                    if (reader.Read()) nivel = reader.GetInt32("TIPO_USUARIO");
                    conexion.Close();
                    return nivel;
                }
                catch (Exception)
                {
                    conexion.Close();
                    return 0;
                }
            }
            else { return -1; }
        }
    }
}
