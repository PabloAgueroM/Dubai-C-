using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using LogicaNegocio;
using Clases;
namespace Vista
{
    public partial class FormBuscarClienteJuridico : Form
    {
        private ClienteBL logicaNegocio;
        private Juridica clienteSeleccionado;
        public FormBuscarClienteJuridico()
        {
            InitializeComponent();
            logicaNegocio = new ClienteBL();
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.DataSource = logicaNegocio.listarClientesJuridicos();
        }

        public Juridica ClienteSeleccionado { get => clienteSeleccionado; set => clienteSeleccionado = value; }
        

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("¿Seguro que desea eliminar este cliente?", "Mensaje", MessageBoxButtons.OKCancel);
            if (res == DialogResult.OK)
            {
                Juridica c = (Juridica)dataGridView1.CurrentRow.DataBoundItem;
                logicaNegocio.eliminarCliente((c.IdPersona).ToString());
                dataGridView1.Rows.RemoveAt(dataGridView1.CurrentRow.Index);
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            clienteSeleccionado = (Juridica)dataGridView1.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("¿Seguro que desea eliminar este cliente?", "Mensaje", MessageBoxButtons.OKCancel);
            if (res == DialogResult.OK)
            {
                Juridica c = (Juridica)dataGridView1.CurrentRow.DataBoundItem;
                logicaNegocio.eliminarCliente((c.IdPersona).ToString());
                dataGridView1.Rows.RemoveAt(dataGridView1.CurrentRow.Index);
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();
        }
    }
}
