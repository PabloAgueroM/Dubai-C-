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
            estadoBotones(0);
            dateTimePicker1.MinDate = DateTime.Now;
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
                    textBox3.Enabled = false;
                    textBox10.Enabled = false;
                    textBox11.Enabled = false;
                    comboBox1.Enabled = false;
                    textBox5.Enabled = false;
                    textBox6.Enabled = false;
                    textBox7.Enabled = false;
                    textBox8.Enabled = false;
                    textBox2.Enabled = false;
                    textBox9.Enabled = false;
                    checkBox1.Enabled = false;
                    dateTimePicker1.Enabled = false;
                    
                    textBox3.Text = "";
                    textBox10.Text = "";
                    textBox11.Text = "";
                    comboBox1.Text = "";
                    textBox5.Text = "";
                    textBox6.Text = "";
                    textBox7.Text = "";
                    textBox8.Text = "";
                    textBox2.Text = "";
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
                    textBox3.Text = buscar.ClienteSeleccionado.Nombre;
                    textBox11.Text = buscar.ClienteSeleccionado.Email;
                    textBox10.Text = buscar.ClienteSeleccionado.Telefono;
                    pedido.IdCliente = buscar.ClienteSeleccionado.IdPersona;
                }

            }
            else
            {
                FormBuscarPersonaNatural buscar = new FormBuscarPersonaNatural();
                if (buscar.ShowDialog() == DialogResult.OK)
                {                    
                    comboBox1.Text = "Natural";
                    textBox3.Text = buscar.ClienteSeleccionado.Nombre + " " + buscar.ClienteSeleccionado.ApPat + " " + buscar.ClienteSeleccionado.ApMat;
                    textBox11.Text = buscar.ClienteSeleccionado.Email;
                    textBox10.Text = buscar.ClienteSeleccionado.Telefono;
                    pedido.IdCliente = buscar.ClienteSeleccionado.IdPersona;
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
            if (textBox3.ForeColor == Color.Red || textBox2.ForeColor == Color.Red)
                return 1;

            if (String.IsNullOrWhiteSpace(textBox3.Text) || String.IsNullOrWhiteSpace(textBox2.Text))
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
                pedido.Cuenta = Convert.ToSingle(textBox2.Text);
                pedido.FechaEntrega = dateTimePicker1.Value;
                pedido.ImporteTotal = Convert.ToSingle(textBox9.Text);
                pedido.Cuenta = Convert.ToSingle(textBox2.Text);
                pedido.Saldo = pedido.ImporteTotal - pedido.Cuenta;
                pedido.IdUsuario = idActual;
                if (checkBox1.Checked == true) pedido.Igv = true;
                else pedido.Igv = false;


                logicaNegocio.actualizarPedido(pedido, detalles);
                MessageBox.Show("Pedido registrado correctamente");

                this.estadoBotones(1);
            }
            guardar = 0;

            this.estadoBotones(0);
            var itemToRemove = detalles.ToList();
            foreach (DetallePedido d in itemToRemove)
            {
                detalles.Remove(d);
            }
            total = 0;

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
            FormBuscarPedido buscar = new FormBuscarPedido();
            if(buscar.ShowDialog() == DialogResult.OK){
                guardar = 2;
                estadoBotones(1);
                button1.Enabled = true;
                button5.Enabled = true;
                comboBox1.Enabled = false;
                button6.Enabled = false;
                detalles = logicaNegocio.listarDetallesPedido(buscar.PedidoSeleccionado.IdPedido);

                textBox9.Text = buscar.PedidoSeleccionado.ImporteTotal.ToString();
                textBox2.Text = buscar.PedidoSeleccionado.Cuenta.ToString();
                if (buscar.PedidoSeleccionado.Igv == true) checkBox1.Checked = true;
                dateTimePicker1.Value = buscar.PedidoSeleccionado.FechaEntrega;
                total = (float)Convert.ToDecimal(textBox9.Text);

                foreach (DetallePedido detalle in detalles) {
                    detalle.Producto = logicaNegocio.buscarProducto(detalle.Producto.Id);
                }
                dataGridView1.DataSource = detalles;

                Persona p = logicaNegocio.buscarCliente(buscar.PedidoSeleccionado.IdCliente);
                if(p is Natural)
                {
                    comboBox1.SelectedIndex = 0;
                    Natural n = (Natural)p;
                    textBox3.Text = n.Nombre + " " + n.ApPat + " " + n.ApMat;
                    textBox11.Text = n.Email;
                    textBox10.Text = n.Telefono;
                    pedido.IdCliente = buscar.PedidoSeleccionado.IdCliente;
                }
                else
                {
                    comboBox1.SelectedIndex = 1;
                    Juridica n = (Juridica)p;
                    textBox3.Text = n.Nombre;
                    textBox11.Text = n.Email;
                    textBox10.Text = n.Telefono;
                    pedido.IdCliente = buscar.PedidoSeleccionado.IdCliente;
                }
            }
        }
    }
}
