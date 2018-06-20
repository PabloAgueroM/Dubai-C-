using Clases;
using LogicaNegocio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Vista
{
    public partial class FormBuscarProveedor : Form
    {

        private OrdenCompraBL logicaNegocio;
        private Proveedor proveedorSeleccionado;
        private BindingList<Proveedor> proveedores = new BindingList<Proveedor>();
        public FormBuscarProveedor()
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;
            logicaNegocio = new OrdenCompraBL();
            comboBox1.SelectedIndex = 0;
            dataGridView1.AutoGenerateColumns = false;
            proveedores = logicaNegocio.listarProveedores();
            dataGridView1.DataSource = proveedores;
        }

        public Proveedor ProveedorSeleccionado { get => proveedorSeleccionado; set => proveedorSeleccionado = value; }

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            ProveedorSeleccionado = (Proveedor)dataGridView1.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Proveedor> filtro = new BindingList<Proveedor>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Proveedor n in proveedores)
                    if (n.Ruc.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Proveedor n in proveedores)
                    if (n.RazonSocial.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 3)
            {
                foreach (Proveedor n in proveedores)
                    if (n.Nombre.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            dataGridView1.DataSource = filtro;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Proveedor> filtro = new BindingList<Proveedor>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Proveedor n in proveedores)
                    if (n.Ruc.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Proveedor n in proveedores)
                    if (n.RazonSocial.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 3)
            {
                foreach (Proveedor n in proveedores)
                    if (n.Nombre.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            dataGridView1.DataSource = filtro;
        }
    }
}
