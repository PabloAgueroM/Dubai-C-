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
    public partial class FormGestionClientes : Form
    {
        private BindingList<Cliente> listaClientes = new BindingList<Cliente>();
        public FormGestionClientes()
        {
            InitializeComponent();

            Cliente c1 = new Natural("Miguel", "Angel", "Guanira", "asdasd@pucp.pe", "123456");
            Cliente c2 = new Natural("Bruno", "Dias", "Bruu", "asd@asd.com", "12333333");
            listaClientes.Add(c1);
            listaClientes.Add(c2);
        }
        private void button1_Click(object sender, EventArgs e)
        {
            FormRegCliente ingresar = new FormRegCliente();
            ingresar.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {

            FormModificarCliente modificar = new FormModificarCliente(listaClientes);            
            modificar.ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            FormEliminarCliente eliminar = new FormEliminarCliente(listaClientes);
            eliminar.ShowDialog();
        }
    }
}
