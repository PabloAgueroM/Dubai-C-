using System;
using Clases;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Vista
{
    public partial class FormAdminUsuario : Form
    {
        private BindingList<Usuario> usuarios = new BindingList<Usuario>();
        public FormAdminUsuario()
        {
            InitializeComponent();
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            FormGestionUsuario VentanaGestionarUsuario = new FormGestionUsuario();
            VentanaGestionarUsuario.ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            FormMostrarUsuarios VentanaUsuarios = new FormMostrarUsuarios();
            VentanaUsuarios.ShowDialog();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Owner.Show();
            Dispose();
        }

        private void FormAdminUsuario_FormClosed(object sender, FormClosedEventArgs e)
        {
            Owner.Show();
        }
    }
}