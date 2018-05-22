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
    public partial class FormModificarCliente : Form
    {
        private BindingList<Persona> listaClientes = new BindingList<Persona>();
        public FormModificarCliente(BindingList<Persona> listaCliente)
        {
            InitializeComponent();
            this.listaClientes = listaCliente;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            FormBuscarCliente listadoClientes = new FormBuscarCliente(listaClientes);
            if (listadoClientes.ShowDialog() == DialogResult.OK) {

            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Dispose();
        }
    }
}
