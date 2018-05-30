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
    public partial class FormBuscarProducto : Form
    {
        private ProductoBL logicaNegocio;
        private Producto productoSeleccionado;
        public FormBuscarProducto()
        {
            InitializeComponent();
            logicaNegocio = new ProductoBL();
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.DataSource = logicaNegocio.listarProductos();

        }

        public Producto ProductoSeleccionado { get => productoSeleccionado; set => productoSeleccionado = value; }

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            productoSeleccionado = (Producto)dataGridView1.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }


    }
}
