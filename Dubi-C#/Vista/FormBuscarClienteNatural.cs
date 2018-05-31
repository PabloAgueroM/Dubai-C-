using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Clases;
using LogicaNegocio;

namespace Vista
{
    public partial class FormBuscarClienteNatural : Form
    {
        private ClienteBL logicaNegocio;
        private Natural clienteSeleccionado;
        public FormBuscarClienteNatural()
        {
            InitializeComponent();
            logicaNegocio = new ClienteBL();
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.DataSource = logicaNegocio.listarClientesNaturales();

        }

        public Natural ClienteSeleccionado { get => clienteSeleccionado; set => clienteSeleccionado = value; }
        
        

        private void button6_Click(object sender, EventArgs e)
        {
            clienteSeleccionado = (Natural)dataGridView1.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("¿Seguro que desea eliminar este cliente?", "Mensaje", MessageBoxButtons.OKCancel);
            if (res == DialogResult.OK)
            {
                Natural c = (Natural)dataGridView1.CurrentRow.DataBoundItem;
                logicaNegocio.eliminarCliente((c.IdPersona).ToString());
                dataGridView1.Rows.RemoveAt(dataGridView1.CurrentRow.Index);
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            BindingList<Natural> filtro = new BindingList<Natural>();

            foreach (Natural n in logicaNegocio.listarClientesNaturales())
            {
                if (n.Nombre.Contains(textBox1.Text.ToUpper()))
                {
                    filtro.Add(n);
                }
            }
            dataGridView1.DataSource = filtro;
        }
    }
}
