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
            this.panel1.Visible = false;
            this.panel2.Visible = false;
            this.estadoBotones(0);
            
        }


        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Juridica")
            {
                panel2.Visible = true;
                panel1.Visible = false;
                comboBox1.Text = "Juridica";
            }
            else
            {
                panel1.Visible = true;
                panel2.Visible = false;
                comboBox1.Text = "Natural";
            }
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            this.estadoBotones(1);
            if (comboBox1.Text == "Juridica")
            {
                panel2.Visible = true;
                panel1.Visible = false;
                comboBox1.Text = "Juridica";
            }
            else
            {
                panel1.Visible = true;
                panel2.Visible = false;
                comboBox1.Text = "Natural";
            }

        }

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            FormEliminarCliente eliminar = new FormEliminarCliente(listaClientes);
            eliminar.ShowDialog();
        }

        private void estadoBotones(int n) {
            switch (n)
            {
                case 0:
                    textBox1.Enabled = false;
                    textBox2.Enabled = false;
                    textBox3.Enabled = false;
                    textBox4.Enabled = false;
                    textBox5.Enabled = false;
                    dateTimePicker1.Enabled = false;
                    textBox6.Enabled = false;
                    textBox7.Enabled = false;
                    textBox8.Enabled = false;
                    textBox9.Enabled = false;
                    textBox10.Enabled = false;
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox3.Text = "";
                    textBox4.Text = "";
                    textBox5.Text = "";
                    textBox6.Text = "";
                    textBox7.Text = "";
                    textBox8.Text = "";
                    textBox9.Text = "";
                    textBox10.Text = "";
                    toolStripButton1.Enabled = true;
                    toolStripButton2.Enabled = false;
                    toolStripButton3.Enabled = false;
                    break;
                case 1:
                    textBox1.Enabled = true;
                    textBox2.Enabled = true;
                    textBox3.Enabled = true;
                    textBox4.Enabled = true;
                    textBox5.Enabled = true;
                    dateTimePicker1.Enabled = true;
                    textBox6.Enabled = true;
                    textBox7.Enabled = true;
                    textBox8.Enabled = true;
                    textBox9.Enabled = true;
                    textBox10.Enabled = true;
                    toolStripButton1.Enabled = false;
                    toolStripButton2.Enabled = true;
                    toolStripButton3.Enabled = true;
                    break;

            }

        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            this.estadoBotones(0);
        }
    }
}
