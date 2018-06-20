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
    public partial class FormGestionCompras : Form
    {
        private BindingList<DetalleOrdenCompra> detalles;
        private OrdenCompra ordenCompra;
        private Insumo insumoSeleccionado = new Insumo();
        private float total = 0;
        private int guardar = 0;
        private string idActual;
        private OrdenCompraBL logicaNegocio;


        public FormGestionCompras(string idActual)
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;


            logicaNegocio = new OrdenCompraBL();
            ordenCompra = new OrdenCompra();
            detalles = new BindingList<DetalleOrdenCompra>();
            this.idActual = idActual;
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.DataSource = detalles;
            estadoBotones(0);
            dateTimePicker1.MinDate = DateTime.Now;
            dateTimePicker1.MaxDate = DateTime.Now.AddYears(+2);
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
                    textBox5.Enabled = false;
                    textBox6.Enabled = false;
                    textBox7.Enabled = false;
                    textBox8.Enabled = false;
                    textBox9.Enabled = false;
                    dateTimePicker1.Enabled = false;

                    textBox3.Text = "";
                    textBox10.Text = "";
                    textBox11.Text = "";
                    textBox5.Text = "";
                    textBox6.Text = "";
                    textBox7.Text = "";
                    textBox8.Text = "";
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

        private void button2_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            this.estadoBotones(0);
            var itemToRemove = detalles.ToList();
            foreach (DetalleOrdenCompra d in itemToRemove)
            {
                detalles.Remove(d);
            }
            total = 0;
        }

        private void button6_Click(object sender, EventArgs e)
        {
            FormBuscarProveedor buscar = new FormBuscarProveedor();
            if (buscar.ShowDialog() == DialogResult.OK)
            {
                textBox3.Text = buscar.ProveedorSeleccionado.Nombre;
                textBox11.Text = buscar.ProveedorSeleccionado.Email;
                textBox10.Text = buscar.ProveedorSeleccionado.Telefono;
                ordenCompra.IdProveedor = buscar.ProveedorSeleccionado.IdPersona;
            }
        }

        private void button10_Click(object sender, EventArgs e)
        {
            FormBuscarProducto buscar = new FormBuscarProducto();
            if (buscar.ShowDialog() == DialogResult.OK)
            {
                //this.insumoSeleccionado = buscar.ProductoSeleccionado;
                textBox5.Text = buscar.ProductoSeleccionado.Id;
                textBox6.Text = buscar.ProductoSeleccionado.Nombre;
                textBox7.Text = buscar.ProductoSeleccionado.Precio.ToString();

            }
            button1.Enabled = true;
            button5.Enabled = true;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBox5.Text))
            { MessageBox.Show("Debe seleccionar un insumo", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return; }
            if (String.IsNullOrWhiteSpace(textBox8.Text)) { MessageBox.Show("Debe ingresar una cantidad", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return; }
            if (textBox8.ForeColor == Color.Red) { MessageBox.Show("Cantidad invalida", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return; }
            if (Convert.ToInt32(textBox8.Text) == 0) { MessageBox.Show("Cantidad debe ser mayor a cero", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return; }
            DetalleOrdenCompra d = new DetalleOrdenCompra();
            d.Insumo = this.insumoSeleccionado;
            d.Cantidad = Convert.ToInt32(textBox8.Text);
            d.Subtotal = d.Cantidad * Convert.ToSingle(textBox7.Text);

            this.estadoBotones(2);
            total = total + d.Subtotal;
            textBox9.Text = total.ToString();

            foreach (DetalleOrdenCompra de in detalles)
            {
                if (d.Insumo.Id == de.Insumo.Id)
                {
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
                DetalleOrdenCompra detalleSeleccionado = (DetalleOrdenCompra)dataGridView1.CurrentRow.DataBoundItem;
                total = total - detalleSeleccionado.Subtotal;
                textBox9.Text = total.ToString();
                detalles.Remove(detalleSeleccionado);
            }
            catch (Exception)
            {
                MessageBox.Show("Debe seleccionar un detalle de la Orden de Produccion", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error); return;
            }
        }

        private int validarDatosPedido()
        {
            if (String.IsNullOrWhiteSpace(textBox3.Text))
                return 2;
            if (total == 0)
                return 5;
            
            if (textBox3.ForeColor == Color.Red )
                return 1;           
            
            return 0;
        }

        private void button8_Click(object sender, EventArgs e)
        {
            int datosValidos = validarDatosPedido();
            if (datosValidos > 0)
            {
                if (datosValidos == 1) MessageBox.Show("Corregir los campos con letra roja", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 2) MessageBox.Show("Debe seleccionar un cliente", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 4) MessageBox.Show("Debe ingresar un monto a cuenta", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 3) MessageBox.Show("Cuenta mayor a total", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 5) MessageBox.Show("Debe registrar detalles del pedido", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            if (guardar == 1)
            {
                
                ordenCompra.FechaEntrega = dateTimePicker1.Value;
                ordenCompra.CostoTotal = Convert.ToSingle(textBox9.Text);
                ordenCompra.CostoNeto = (float)(ordenCompra.CostoTotal * 1.18);
                ordenCompra.IdUsuario = idActual;
                ordenCompra.Igv = true;



                ordenCompra.IdPedido = logicaNegocio.registrarOrdenCompra(ordenCompra, detalles).ToString();
                MessageBox.Show("Pedido registrado correctamente\nID del Pedido: " + ordenCompra.IdPedido);

                estadoBotones(1);


            }
            else if (guardar == 2)
            {
                ordenCompra.FechaEntrega = dateTimePicker1.Value;
                ordenCompra.CostoTotal = Convert.ToSingle(textBox9.Text);
                ordenCompra.CostoNeto = (float)(ordenCompra.CostoTotal * 1.18);
                ordenCompra.IdUsuario = idActual;
                ordenCompra.Igv = true;


                //logicaNegocio.actualizarPedido(pedido, detalles);
                MessageBox.Show("Pedido actualizado correctamente");

                this.estadoBotones(1);
            }
            guardar = 0;

            this.estadoBotones(0);
            var itemToRemove = detalles.ToList();
            foreach (DetalleOrdenCompra d in itemToRemove)
            {
                detalles.Remove(d);
            }
            total = 0;

        }
        
        

        private void textBox8_TextChanged_1(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\d+$");
            if (!rgx.IsMatch(textBox8.Text)) textBox8.ForeColor = Color.Red;
            else textBox8.ForeColor = Color.Black;
        }

        private void dateTimePicker1_ValueChanged_1(object sender, EventArgs e)
        {
            dateTimePicker1.MinDate = DateTime.Now;
        }
    }
}
