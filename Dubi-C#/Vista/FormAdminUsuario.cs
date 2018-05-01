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

            Usuario u1 = new Usuario(1, "Martin Arnulfo", "Caro", "Hijar", new DateTime(1998,11,20,0,0,0), "12345", "Vendedor");
            Usuario u2 = new Usuario(2, "Bruno", "Diaz", "Bruuu", DateTime.Now, "12345", "Gerente");
            Usuario u3 = new Usuario(3, "Arian", "Fajardo", "xd", DateTime.Now, "12345", "Administrador de ventas");
            Usuario u4 = new Usuario(4, "Patricio", "Avila", "Patomomo", DateTime.Now, "12345", "Administrador de produccion");
            Usuario u5 = new Usuario(5, "Bruno", "Espesex", "rip Paucar", DateTime.Now, "12345", "Vendedor");

            usuarios.Add(u1);
            usuarios.Add(u2);
            usuarios.Add(u3);
            usuarios.Add(u4);
            usuarios.Add(u5);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Vista.FormGestionarUsuario VentanaGestionarUsuario = new Vista.FormGestionarUsuario(usuarios);
            VentanaGestionarUsuario.ShowDialog();
        }

        private void button4_Click(object sender, EventArgs e)
        {

        }

        private void button5_Click(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            Vista.FormMostrarUsuarios VentanaUsuarios = new Vista.FormMostrarUsuarios(usuarios);
            VentanaUsuarios.ShowDialog();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            
            Owner.Show();
            Dispose();
        }

        
    }
}
