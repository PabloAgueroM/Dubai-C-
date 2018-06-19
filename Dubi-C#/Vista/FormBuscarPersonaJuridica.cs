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
    public partial class FormBuscarPersonaJuridica : Form
    {

        private ClienteBL logicaNegocio;
        private Juridica clienteSeleccionado;
        private BindingList<Juridica> juridicas = new BindingList<Juridica>();
        public FormBuscarPersonaJuridica()
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;
            logicaNegocio = new ClienteBL();
            comboBox1.SelectedIndex = 0;
            dataGridView1.AutoGenerateColumns = false;
            juridicas = logicaNegocio.listarPersonasJuridicas();
            dataGridView1.DataSource = juridicas;
        }

        public Juridica ClienteSeleccionado { get => clienteSeleccionado; set => clienteSeleccionado = value; }

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            ClienteSeleccionado = (Juridica)dataGridView1.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Juridica> filtro = new BindingList<Juridica>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Juridica n in juridicas)
                    if (n.Ruc.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Juridica n in juridicas)
                    if (n.RazonSocial.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 3)
            {
                foreach (Juridica u in juridicas)
                    if (u.Nombre.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            dataGridView1.DataSource = filtro;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Juridica> filtro = new BindingList<Juridica>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Juridica n in juridicas)
                    if (n.Ruc.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Juridica n in juridicas)
                    if (n.RazonSocial.Contains(textBox1.Text.ToUpper())) filtro.Add(n);
            }
            else if (comboBox1.SelectedIndex == 3)
            {
                foreach (Juridica u in juridicas)
                    if (u.Nombre.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            dataGridView1.DataSource = filtro;
        }
    }
}
