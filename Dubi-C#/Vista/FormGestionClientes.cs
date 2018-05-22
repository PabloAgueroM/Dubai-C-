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
        private BindingList<Persona> listaClientes = new BindingList<Persona>();
        public FormGestionClientes()
        {
            InitializeComponent();
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
