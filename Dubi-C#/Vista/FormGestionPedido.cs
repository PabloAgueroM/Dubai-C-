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
using LogicaNegocio;
using System.Text.RegularExpressions;

namespace Vista
{

    public partial class FormGestionPedido : Form
    {
        private BindingList<DetallePedido> detalles;
        private Pedido pedido;
        private Producto productoSeleccionado = new Producto();
        private float total = 0;
        private int guardar = 0;
        private string idActual;
        private PedidoBL logicaNegocio;
        public FormGestionPedido(string idActual)
        {
            InitializeComponent();
            logicaNegocio = new PedidoBL();
            pedido = new Pedido();
            detalles = new BindingList<DetallePedido>();
            this.idActual = idActual;
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.DataSource = detalles;
            comboBox1.SelectedIndex = 0;
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
                    button9.Enabled = true;
                    button4.Enabled = true;
                    this.guardar = 0;
                    break;
                case 1:
                    button9.Enabled = false;
                    button6.Enabled = true;
                    button10.Enabled = true;
                    textBox8.Enabled = true;
                    textBox2.Enabled = true;
                    checkBox1.Enabled = true;
                    comboBox1.Enabled = true;
                    button8.Enabled = true;
                    button7.Enabled = true;
                    button4.Enabled = false;
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
            this.guardar = 1;
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
            total = 0;
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
            button1.Enabled = true;
            button5.Enabled = true;

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox5.Text == "")
            { MessageBox.Show("Debe seleccionar un producto", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return; }
            if (String.IsNullOrWhiteSpace(textBox8.Text)) { MessageBox.Show("Debe seleccionar una cantidad", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return; }
            if (textBox8.ForeColor == Color.Red) { MessageBox.Show("Cantidad invalida", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return; }
            DetallePedido d = new DetallePedido();
            d.Producto = this.productoSeleccionado;
            d.Cantidad = Convert.ToInt32(textBox8.Text);
            d.Subtotal = d.Cantidad * Convert.ToSingle(textBox7.Text);

            this.estadoBotones(2);
            total = total + d.Subtotal;
            textBox9.Text = total.ToString();

            //var itemToRemove = detalles.ToList();
            foreach (DetallePedido de in detalles)
            {
                if (d.Producto.Id == de.Producto.Id) {
                    de.Cantidad = de.Cantidad + d.Cantidad;
                    de.Subtotal = de.Subtotal + d.Subtotal;                    
                    this.estadoBotones(2);
                    dataGridView1.Update();
                    dataGridView1.Refresh();
                    return;
                }
            }
            detalles.Add(d);
        }

        private void button5_Click(object sender, EventArgs e)
        {
            try
            {
                DetallePedido detalleSeleccionado = (DetallePedido)dataGridView1.CurrentRow.DataBoundItem;
                total = total - detalleSeleccionado.Subtotal;
                textBox9.Text = total.ToString();
                detalles.Remove(detalleSeleccionado);
            }
            catch (Exception) {
                MessageBox.Show("Debe seleccionar un detalle del pedido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return;
            }
        }
        private int validarDatosPedido() {
            if (textBox1.ForeColor == Color.Red || textBox2.ForeColor == Color.Red)
                return 1;

            if (String.IsNullOrWhiteSpace(textBox1.Text) || String.IsNullOrWhiteSpace(textBox2.Text))
                return 2;
            
            if ((int)((DateTime.Now - dateTimePicker1.Value).TotalDays) > 0) return 5;            
            return 0;
        }

        

        private void button8_Click(object sender, EventArgs e)
        {
            int datosValidos = validarDatosPedido();
            if (datosValidos > 0)
            {
                if (datosValidos == 1) MessageBox.Show("Corregir los campos con letra roja", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 2) MessageBox.Show("Faltan llenar campos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 5) MessageBox.Show("Revisar la fecha estimada de entrega", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            if (guardar == 1) {
                
                pedido.Cuenta = Convert.ToSingle(textBox2.Text);
                pedido.IdCliente = textBox1.Text;
                pedido.FechaEntrega = dateTimePicker1.Value;
                pedido.ImporteTotal = Convert.ToSingle(textBox9.Text);
                pedido.Cuenta = Convert.ToSingle(textBox2.Text);
                pedido.Saldo = pedido.ImporteTotal - pedido.Cuenta;
                pedido.IdUsuario = idActual;
                if (checkBox1.Checked == true) pedido.Igv = true;
                else pedido.Igv = false;

                pedido.IdPedido = logicaNegocio.registrarPedido(pedido, detalles).ToString();
                MessageBox.Show("Pedido registrado correctamente");

                this.estadoBotones(1);
                
            }
            else if (guardar == 2)
            {

            }
            guardar = 0;
            this.estadoBotones(0);
        }

        private void textBox8_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\d+$");
            if (!rgx.IsMatch(textBox8.Text)) textBox8.ForeColor = Color.Red;
            else textBox8.ForeColor = Color.Black;            
        }
        

        private void dateTimePicker1_ValueChanged(object sender, EventArgs e)
        {
            dateTimePicker1.MinDate = DateTime.Now;
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"([0-9]*[.])?[0-9]+");
            if (!rgx.IsMatch(textBox2.Text)) textBox2.ForeColor = Color.Red;
            else textBox2.ForeColor = Color.Black;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.guardar = 2;
            this.estadoBotones(1);
            FormBuscarPedido buscar = new FormBuscarPedido();
            if(buscar.ShowDialog() == DialogResult.OK){
                //detalles = logicaNegocio.listarDetallesPedido(buscar.PedidoSeleccionado.IdPedido);
                dataGridView1.Update();
                dataGridView1.Refresh();
            }
        }
    }
}
