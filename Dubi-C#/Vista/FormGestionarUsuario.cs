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
    public partial class FormGestionarUsuario : Form
    {
        BindingList<Usuario> usuarios = new BindingList<Usuario>();

        public FormGestionarUsuario(BindingList<Usuario> usuarios)
        {
            InitializeComponent();
            this.usuarios = usuarios;
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormRegUsuario VentanaRegistrarUsuario = new FormRegUsuario();
            VentanaRegistrarUsuario.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            FormModUsuario VentanaModificarUsuario = new FormModUsuario(usuarios);
            VentanaModificarUsuario.ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            FormElimUsuario VentanaEliminarUsuario = new FormElimUsuario(usuarios);
            VentanaEliminarUsuario.ShowDialog();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Dispose();
        }
    }
}
