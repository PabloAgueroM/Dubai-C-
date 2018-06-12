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
    public partial class FormBuscarPersonaNatural : Form
    {

        private ClienteBL logicaNegocio;
        private Natural clienteSeleccionado;
        private BindingList<Natural> naturales = new BindingList<Natural>();

        public FormBuscarPersonaNatural()
        {
            InitializeComponent();
            logicaNegocio = new ClienteBL();
            comboBox1.SelectedIndex = 0;
            dataGridView1.AutoGenerateColumns = false;
            naturales = logicaNegocio.listarPersonasNaturales();
            dataGridView1.DataSource = naturales;
        }

        public Natural ClienteSeleccionado { get => clienteSeleccionado; set => clienteSeleccionado = value; }

        private void button6_Click(object sender, EventArgs e)
        {
            clienteSeleccionado = (Natural)dataGridView1.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }
        

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();
        }


        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Natural> filtro = new BindingList<Natural>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Natural n in naturales)
                    if (n.Dni.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Natural n in naturales)
                    if (n.Nombre.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 3)
            {
                foreach (Natural u in naturales)
                    if (u.ApPat.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 4)
            {
                foreach (Natural u in naturales)
                    if (u.ApMat.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            dataGridView1.DataSource = filtro;
        }

        private void textBox1_TextChanged_1(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Natural> filtro = new BindingList<Natural>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Natural n in naturales)
                    if (n.Dni.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Natural n in naturales)
                    if (n.Nombre.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 3)
            {
                foreach (Natural u in naturales)
                    if (u.ApPat.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 4)
            {
                foreach (Natural u in naturales)
                    if (u.ApMat.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            dataGridView1.DataSource = filtro;
        }
    }
}
