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

    public partial class FormGestionPedido : Form
    {
        private BindingList<DetallePedido> detalles = new BindingList<DetallePedido>();
        private Pedido pedido = new Pedido();
        public FormGestionPedido()
        {
            InitializeComponent();
            dataGridView1.DataSource = detalles;
            this.estadoBotones(0);
        }
        private void estadoBotones(int n)
        {
            switch (n)
            {
                case 0:
                    button8.Enabled = false;
                    button7.Enabled = false;
                    button6.Enabled = false;
                    button10.Enabled = false;
                    button1.Enabled = false;
                    button5.Enabled = false;
                    textBox1.Enabled = false;
                    textBox3.Enabled = false;
                    textBox10.Enabled = false;
                    textBox11.Enabled = false;
                    comboBox1.Enabled = false;
                    textBox5.Enabled = false;
                    textBox6.Enabled = false;
                    textBox7.Enabled = false;
                    textBox8.Enabled = false;
                    textBox2.Enabled = false;
                    textBox4.Enabled = false;
                    textBox9.Enabled = false;
                    checkBox1.Enabled = false;
                    dateTimePicker1.Enabled = false;

                    textBox1.Text = "";
                    textBox3.Text = "";
                    textBox10.Text = "";
                    textBox11.Text = "";
                    comboBox1.Text = "";
                    textBox5.Text = "";
                    textBox6.Text = "";
                    textBox7.Text = "";
                    textBox8.Text = "";
                    textBox2.Text = "";
                    textBox4.Text = "";
                    textBox9.Text = "";
                    break;
                case 1:
                    button6.Enabled = true;
                    button10.Enabled = true;
                    textBox8.Enabled = true;
                    textBox4.Enabled = true;
                    checkBox1.Enabled = true;
                    comboBox1.Enabled = true;
                    button8.Enabled = true;
                    button7.Enabled = true;
                    button4.Enabled = false;
                    break;
                default:
                    break;
            }
        }

        private void button9_Click(object sender, EventArgs e)
        {
            this.estadoBotones(1);
        }

        private void button6_Click(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Juridica")
            {
                FormBuscarPersonaJuridica buscar = new FormBuscarPersonaJuridica();
                if (buscar.ShowDialog() == DialogResult.OK)
                {                    
                    comboBox1.Text = "Juridica";
                    textBox1.Text = buscar.ClienteSeleccionado.IdPersona;
                    textBox3.Text = buscar.ClienteSeleccionado.Nombre;
                    textBox11.Text = buscar.ClienteSeleccionado.Email;
                    textBox10.Text = buscar.ClienteSeleccionado.Telefono;

                }

            }
            else
            {
                FormBuscarPersonaNatural buscar = new FormBuscarPersonaNatural();
                if (buscar.ShowDialog() == DialogResult.OK)
                {                    
                    comboBox1.Text = "Natural";
                    textBox1.Text = buscar.ClienteSeleccionado.IdPersona;
                    textBox3.Text = buscar.ClienteSeleccionado.Nombre;
                    textBox11.Text = buscar.ClienteSeleccionado.Email;
                    textBox10.Text = buscar.ClienteSeleccionado.Telefono;

                }
            }
        }

        private void button7_Click(object sender, EventArgs e)
        {
            this.estadoBotones(0);
        }

        private void button10_Click(object sender, EventArgs e)
        {

        }

    }
}
