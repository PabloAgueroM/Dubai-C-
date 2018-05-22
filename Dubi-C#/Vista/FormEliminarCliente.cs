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
    public partial class FormEliminarCliente : Form
    {
        public FormEliminarCliente(BindingList<Persona> listaCliente)
        {
            InitializeComponent();
            dataGridView1.DataSource = listaCliente;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormEliminarCliente2 verificacion = new FormEliminarCliente2();
            verificacion.ShowDialog();
        }
    }
}
