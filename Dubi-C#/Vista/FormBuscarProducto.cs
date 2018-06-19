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
        private BindingList<Producto> productos = new BindingList<Producto>();
        public FormBuscarProducto()
        {
            InitializeComponent();
            logicaNegocio = new ProductoBL();
            dataGridView1.AutoGenerateColumns = false;
            productos = logicaNegocio.listarProductos();
            dataGridView1.DataSource = productos;

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

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Producto> filtro = new BindingList<Producto>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Producto u in productos)
                    if (u.Id.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Producto u in productos)
                    if (u.Nombre.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 3)
            {
                foreach (Producto u in productos)
                    if ((u.Talla + "").Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }

            dataGridView1.DataSource = filtro;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Producto> filtro = new BindingList<Producto>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Producto u in productos)
                    if (u.Id.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Producto u in productos)
                    if (u.Nombre.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 3)
            {
                foreach (Producto u in productos)
                    if ((u.Talla+"").Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }

            dataGridView1.DataSource = filtro;
        }
    }
}
