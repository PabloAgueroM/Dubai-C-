using Clases;
using LogicaNegocio;
using System;
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
    public partial class FormBuscarPersonaNatural : Form
    {

        private ClienteBL logicaNegocio;
        private Natural clienteSeleccionado;
        public FormBuscarPersonaNatural()
        {
            InitializeComponent();
            logicaNegocio = new ClienteBL();
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.DataSource = logicaNegocio.listarPersonasNaturales();
        }

        public Natural ClienteSeleccionado { get => clienteSeleccionado; set => clienteSeleccionado = value; }

        private void button6_Click(object sender, EventArgs e)
        {
            clienteSeleccionado = (Natural)dataGridView1.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }
        

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();
        }
    }
}
