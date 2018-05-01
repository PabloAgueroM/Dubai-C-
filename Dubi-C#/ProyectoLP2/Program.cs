using System;
using AccesoDatos;
using Clases;
using Vista;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProyectoLP2
{
    static class Program
    {
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]
        static void Main()
        {
            
            Conexion conexion = Conexion.Instance();
            conexion.DatabaseName = "inf282g5";
            if (conexion.IsConnect())
            {
                Application.EnableVisualStyles();
                Application.SetCompatibleTextRenderingDefault(false);
                Application.Run(new LoginForm());
            }
            else{ MessageBox.Show("Error en la conexion a la base de datos"); }

            

            conexion.Close();
        }
    }
}