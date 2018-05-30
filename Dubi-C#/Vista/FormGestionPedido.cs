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
        private Producto productoSeleccionado = new Producto();
        private float total = 0;

        public FormGestionPedido()
        {
            InitializeComponent();            
            dataGridView1.AutoGenerateColumns = false;
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
                    button1.Enabled = true;
                    button5.Enabled = false;
                    dateTimePicker1.Enabled = true;
                    break;
                case 2:
                    textBox5.Text = "";
                    textBox6.Text = "";
                    textBox7.Text = "";
                    textBox8.Text = "";
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
            var itemToRemove = detalles.ToList();
            foreach (DetallePedido d in itemToRemove) {
                detalles.Remove(d);
            }
        }

        private void button10_Click(object sender, EventArgs e)
        {
            FormBuscarProducto buscar = new FormBuscarProducto();
            if (buscar.ShowDialog() == DialogResult.OK)
            {
                this.productoSeleccionado = buscar.ProductoSeleccionado;
                textBox5.Text = buscar.ProductoSeleccionado.Id;
                textBox6.Text = buscar.ProductoSeleccionado.Nombre;
                textBox7.Text = buscar.ProductoSeleccionado.Precio.ToString();

            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox5.Text == "")
            { MessageBox.Show("Debe seleccionar un producto", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return; }
            if (textBox8.Text == "") { MessageBox.Show("Debe seleccionar una cantidad", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return; }
            DetallePedido d = new DetallePedido();
            d.Producto = this.productoSeleccionado;
            d.Cantidad = Convert.ToInt32(textBox8.Text);
            d.Subtotal = d.Cantidad * Convert.ToSingle(textBox7.Text);
            detalles.Add(d);
            this.estadoBotones(2);
            total = total + d.Subtotal;
            textBox9.Text = "S/. " + total.ToString();
        }
    }
}
