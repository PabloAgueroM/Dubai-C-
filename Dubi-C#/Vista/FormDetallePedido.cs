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

        private void Aceptar_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "" || textBox3.Text == "" || textBox2.Text == "") MessageBox.Show("Faltan llenar campos");
            else {
                
                detalle.Cantidad = Int32.Parse(textBox2.Text);
                detalle.IdProducto = textBox1.Text;
                detalle.Subtotal = detalle.Cantidad * precioUnitario;
                this.DialogResult = DialogResult.OK;
                Dispose();

            }
        }
    }
}
