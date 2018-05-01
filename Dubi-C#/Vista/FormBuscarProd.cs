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
    
    public partial class FormBuscarProd : Form
    {
        private BindingList<Producto> productos = new BindingList<Producto>();
        private Producto productoSeleccionado;
        private string descripcion;
        public FormBuscarProd()
        {
            InitializeComponent();
            Producto p1 = new Producto("01", "Camisa talla M", 20.0f, 28);
            Producto p2 = new Producto("02", "Blusa talla S", 50.0f, 10);
            Producto p3 = new Producto("03", "Polo simple de talla estanadar", 30.0f, 50);
            productos.Add(p1);
            productos.Add(p2);
            productos.Add(p3);

            dataGridView1.DataSource = productos;
        }

        public Producto ProductoSeleccionado { get => productoSeleccionado; set => productoSeleccionado = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }

        private void button1_Click(object sender, EventArgs e)
        {
            productoSeleccionado = (Producto)dataGridView1.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;

        }
    }
}
