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
    public partial class FormRegCliente : Form
    {
        public FormRegCliente()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (radioButton1.Checked)
            {
                if (textBox1.Text == "" || textBox2.Text == "" || textBox3.Text == "" || textBox4.Text == ""
                    || textBox5.Text == "")
                    MessageBox.Show("Error: Falta llenar campos");
                else
                {
                    MessageBox.Show("Cliente registrado satisfactoriamente");
                    this.Dispose();
                }
            }
            else
            {
                if (textBox6.Text == "" || textBox7.Text == "" || textBox8.Text == "" || textBox9.Text =="" || textBox10.Text == "")
                    MessageBox.Show("Error: Falta llenar campos");
                else
                {
                    MessageBox.Show("Cliente registrado satisfactoriamente");
                    this.Dispose();
                }
            }
        }
        

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Enabled = true;
            textBox2.Enabled = true;
            textBox3.Enabled = true;
            textBox4.Enabled = true;
            textBox5.Enabled = true;
            dateTimePicker1.Enabled = true;
            textBox6.Enabled = false;
            textBox7.Enabled = false;
            textBox8.Enabled = false;
            textBox10.Enabled = false;
            textBox9.Enabled = false;

        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            textBox1.Enabled = false;
            textBox2.Enabled = false;
            textBox3.Enabled = false;
            textBox4.Enabled = false;
            textBox5.Enabled = false;
            dateTimePicker1.Enabled = false;
            textBox6.Enabled = true;
            textBox7.Enabled = true;
            textBox8.Enabled = true;
            textBox10.Enabled = true;
            textBox9.Enabled = true;

        }
    }
}
