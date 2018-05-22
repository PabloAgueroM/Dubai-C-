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
    public partial class FormBuscarUsuario : Form
    {
        Usuario usuarioSeleccionado;
        public FormBuscarUsuario()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            usuarioSeleccionado = (Usuario)dataGridView1.CurrentRow.DataBoundItem;
        }

        private void FormBuscarUsuario_FormClosed(object sender, FormClosedEventArgs e)
        {
            Owner.Show();
        }
    }
}
