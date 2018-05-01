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
    public partial class Form4 : Form
    {
        private BindingList<Cliente> listaClientes = new BindingList<Cliente>();
        public Form4(BindingList<Cliente> listaCliente)
        {
            InitializeComponent();
            this.listaClientes = listaCliente;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form5 listadoClientes = new Form5(listaClientes);
            if (listadoClientes.ShowDialog() == DialogResult.OK) {

            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Dispose();
        }
    }
}
