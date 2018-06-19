using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;
using AccesoDatos;

namespace Vista
{
    public partial class FormLogin : Form
    {
        private string idActual;
        public FormLogin()
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.FixedSingle;
            AcceptButton = button1;
        }


        private void button1_Click(object sender, EventArgs e)
        {
            
            if (String.IsNullOrEmpty(textBox1.Text) || String.IsNullOrEmpty(textBox2.Text))
            {
                MessageBox.Show("Error: Falta llenar algun campo");
            }
            else
            {
                LoginDA login = new LoginDA();
                int resultado = login.ValidarUsuario(textBox1.Text, textBox2.Text);
                if (resultado == 1)
                {
                    Hide();
                    idActual = textBox1.Text;
                    textBox2.Text = null;
                    int nivelUsuario = login.ObtenerNivelUsuario(idActual);
                    FormMain menu = new FormMain(idActual, nivelUsuario);
                    menu.Show();
                    menu.Owner = this;
                }
                else if(resultado == 0) MessageBox.Show("ID o contraseña incorrecta");           
                else if(resultado == -1) MessageBox.Show("Error en la conexion con la base de datos");
                
            }
        }

        public string userActual()
        {
            return textBox1.Text;
        }
    }
}
