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
    public partial class FormGestionUsuario : Form
    {
        public FormGestionUsuario()
        {
            InitializeComponent();
            estadoBotones(0);
            toolStripButton2.Enabled = false;
            toolStripButton3.Enabled = false;
        }

        private void estadoBotones(int n)
        {
            switch (n)
            {
                case 0:
                    textBox1.Enabled = false;
                    textBox2.Enabled = false;
                    textBox3.Enabled = false;
                    textBox4.Enabled = false;
                    textBox5.Enabled = false;
                    textBox6.Enabled = false;
                    textBox7.Enabled = false;
                    textBox8.Enabled = false;
                    dateTimePicker1.Enabled = false;
                    comboBox4.Enabled = false;
                    break;
                case 1:
                    textBox1.Enabled = true;
                    textBox2.Enabled = true;
                    textBox3.Enabled = true;
                    textBox4.Enabled = true;
                    textBox6.Enabled = true;
                    textBox5.Enabled = true;
                    textBox7.Enabled = true;
                    textBox8.Enabled = true;
                    dateTimePicker1.Enabled = true;
                    comboBox4.Enabled = true;
                    break;
                default:
                    break;
            }
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            estadoBotones(1);
            toolStripButton1.Enabled = false;
            toolStripButton2.Enabled = true;
            toolStripButton3.Enabled = true;
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            estadoBotones(0);
            textBox1.Text = null;
            textBox2.Text = null;
            textBox3.Text = null;
            textBox4.Text = null;
            textBox5.Text = null;
            textBox6.Text = null;
            textBox7.Text = null;
            textBox8.Text = null;
            dateTimePicker1.Value = DateTime.Now;
            comboBox4.SelectedItem = null;
            comboBox4.Enabled = false;
            toolStripButton1.Enabled = true;
            toolStripButton2.Enabled = false;
            toolStripButton3.Enabled = false;
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            estadoBotones(0);
            toolStripButton1.Enabled = true;
            toolStripButton2.Enabled = false;
            toolStripButton3.Enabled = false;

            string inDNI = textBox6.Text;
            string inNombres = textBox1.Text;
            string inApPat = textBox2.Text;
            string inApMat = textBox3.Text;
            DateTime inFecha = new DateTime();
            inFecha = dateTimePicker1.Value;
            string inPassword = textBox4.Text;
            int index = 4 - comboBox4.SelectedIndex;

            //Usuario newUser = new Usuario();



            //UsuarioBL userBL = new UsuarioBL();
            //userBL.registrarUsuario(newUser);
        }

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            FormBuscarUsuario form = new FormBuscarUsuario();
            Hide();
            form.Owner = this;
            form.ShowDialog();
        }
    }
}
