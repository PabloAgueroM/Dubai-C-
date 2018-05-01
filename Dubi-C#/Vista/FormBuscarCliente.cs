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
namespace Vista
{
    public partial class FormBuscarCliente : Form
    {
        public FormBuscarCliente()
        {
            InitializeComponent();
        }

        public FormBuscarCliente(BindingList<Cliente> listaClientes)
        {
            InitializeComponent();
            dataGridView1.DataSource = listaClientes;
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }
    }
}
