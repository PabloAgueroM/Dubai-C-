using System;
using System.Windows.Forms;

namespace Vista
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void button8_Click(object sender, EventArgs e)
        {
            Owner.Show();
            Dispose();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Vista.FormAdminUsuario ventanaUsuarios = new Vista.FormAdminUsuario();
            Hide();
            ventanaUsuarios.Owner = this;
            ventanaUsuarios.ShowDialog();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormGestionVentas gestionPedidos = new FormGestionVentas();
            gestionPedidos.Owner = this;
            Hide();
            gestionPedidos.ShowDialog();
        }

        private void MainForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            Owner.Show();
        }
    }
}