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
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();
        }


        private void button1_Click(object sender, EventArgs e)
        {
            
            if (String.IsNullOrEmpty(textBox1.Text) || String.IsNullOrEmpty(textBox2.Text))
            {
                MessageBox.Show("Error: Falta llenar algun campo");
            }
            //else if(){
            //    MessageBox.Show("Usuario o contraseña incorrecta");
            //}
            else
            {
                Hide();
                MainForm menu = new MainForm();
                menu.Show();
                menu.Owner = this;
                FormCollection fc = Application.OpenForms;
                                
            }
        }
    }
}
