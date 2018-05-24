﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Clases;
using LogicaNegocio;

namespace Vista
{
    public partial class FormBuscarClienteNatural : Form
    {
        private ClienteBL logicaNegocio;
        private Natural clienteSeleccionado;
        public FormBuscarClienteNatural()
        {
            InitializeComponent();
            logicaNegocio = new ClienteBL();
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.DataSource = logicaNegocio.listarClientesNaturales();

        }

        public FormBuscarClienteNatural(BindingList<Persona> listaClientes)
        {
            InitializeComponent();
            dataGridView1.DataSource = listaClientes;
        }

        public Natural ClienteSeleccionado { get => clienteSeleccionado; set => clienteSeleccionado = value; }

        private void button1_Click(object sender, EventArgs e)
        {
            clienteSeleccionado = (Natural)dataGridView1.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }
    }
}
