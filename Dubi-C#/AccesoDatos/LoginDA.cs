using MySql.Data.MySqlClient;
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

        public int ValidarUsuario(string user, string password)
        {
            Conexion conexion = new Conexion();
            if (conexion.IsConnected())
            {
                MySqlCommand comando = new MySqlCommand();
                comando.CommandText = String.Format("SELECT * FROM USUARIOS WHERE ID_USUARIO = \"{0}\" AND CONTRASENHA = \"{1}\"", user,password);
                comando.Connection = conexion.Connection;
                try{
                    int mysqlint = int.Parse(comando.ExecuteScalar().ToString());
                    conexion.Close();
                    return 1;
                }
                catch(Exception e)
                {
                    conexion.Close();
                    return 0;
                }
            }
            else { return -1; }
        }
    }
}
