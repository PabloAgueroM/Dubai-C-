﻿using System;
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
    public partial class FormGestionVentas : Form
    {
        private string idActual;   
        public FormGestionVentas(string id)
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;
            idActual = id;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormGestionClientes actividad = new FormGestionClientes();
            actividad.Owner = this;
            actividad.ShowDialog();
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            FormGestionPedido gestionarPedido = new FormGestionPedido(idActual);
            gestionarPedido.ShowDialog();
            
        }

        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            Owner.Show();
            Dispose();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Close();            
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void button3_Click_1(object sender, EventArgs e)
        {
            FormGestionCompras gestionarPedido = new FormGestionCompras(idActual);
            gestionarPedido.ShowDialog();
        }
    }
}
