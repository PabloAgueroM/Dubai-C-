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
        public FormBuscarClienteNatural()
        {
            InitializeComponent();
            logicaNegocio = new ClienteBL();

        }

        public FormBuscarClienteNatural(BindingList<Persona> listaClientes)
        {
            InitializeComponent();
            dataGridView1.DataSource = listaClientes;
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }
    }
}
