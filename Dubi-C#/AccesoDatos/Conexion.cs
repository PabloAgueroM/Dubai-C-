using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccesoDatos
{
    public class Conexion
    {
        public Conexion()
        {
        }

        public string Password { get; set; }
        private MySqlConnection connection = null;
        public MySqlConnection Connection
        {
            get { return connection; }
        }

        //private static Conexion _instance = null;
        //public static Conexion Instance()
        //{
        //    if (_instance == null)
        //        _instance = new Conexion();
        //    return _instance;
        //}

        public bool IsConnected()
        {
            if (Connection == null)
            {
                string connstring = "Server=200.16.7.96; database=inf282g5; Username=inf282g5; password=KHjN45; SSLmode = none";
                connection = new MySqlConnection(connstring);
                connection.Open();
            }

            return true;
        }

        public void Close()
        {
            connection.Close();
        }
    }
}
