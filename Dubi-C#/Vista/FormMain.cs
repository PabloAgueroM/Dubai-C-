using AccesoDatos;
using System;
using System.Windows.Forms;

namespace Vista
{
    public partial class FormMain : Form
    {
        private string idActual;
        public FormMain(string id)
        {
            InitializeComponent();
            idActual = id;
        }

        private void button8_Click(object sender, EventArgs e)
        {
            LoginDA cerrar = new LoginDA();
            cerrar.cerrarSesion(idActual);
            Owner.Show();      
            Dispose();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            FormAdminUsuario ventanaUsuarios = new FormAdminUsuario();
            Hide();
            ventanaUsuarios.Owner = this;
            ventanaUsuarios.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormGestionVentas gestionPedidos = new FormGestionVentas();
            gestionPedidos.Owner = this;
            Hide();
            gestionPedidos.ShowDialog();
        }

        private void FormMain_FormClosing(object sender, FormClosingEventArgs e)
        {
            DialogResult res = MessageBox.Show("Salir de esta ventana tambien cerrará la sesión actual ¿Seguro que desea continuar?", "Mensaje", MessageBoxButtons.OKCancel,MessageBoxIcon.Warning);
            if (res == DialogResult.OK)
            {
                LoginDA cerrar = new LoginDA();
                cerrar.cerrarSesion(idActual);
                Owner.Show();
            }
            else
            {
                e.Cancel = true;
            }
        }
    }
}