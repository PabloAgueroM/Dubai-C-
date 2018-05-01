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
    public partial class FormDetallePedido : Form
    {
        private DetallePedido detalle = new DetallePedido();
        private float precioUnitario;

        public DetallePedido Detalle { get => detalle; set => detalle = value; }

        public FormDetallePedido()
        {
            InitializeComponent();
            textBox1.Enabled = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormBuscarProd buscarProd = new FormBuscarProd();
            if (buscarProd.ShowDialog() == DialogResult.OK) {
                textBox1.Text = buscarProd.ProductoSeleccionado.Descripcion;
                precioUnitario = buscarProd.ProductoSeleccionado.Precio;
            }



        }

        private void Aceptar_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "" || textBox3.Text == "" || textBox2.Text == "") MessageBox.Show("Faltan llenar campos");
            else {
                
                detalle.Cantidad = Int32.Parse(textBox2.Text);
                detalle.Producto = textBox1.Text;
                detalle.Subtotal = detalle.Cantidad * precioUnitario;
                this.DialogResult = DialogResult.OK;
                Dispose();

            }
        }
    }
}
