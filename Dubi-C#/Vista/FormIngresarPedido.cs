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
    
    public partial class FormIngresarPedido : Form
    {
        private BindingList<DetallePedido> detalles = new BindingList<DetallePedido>();
        private Pedido pedido = new Pedido();
        public FormIngresarPedido()
        {
            InitializeComponent();
            dataGridView1.DataSource = detalles;
        }

        public Pedido Pedido { get => pedido; set => pedido = value; }

        private void button1_Click(object sender, EventArgs e)
        {
            FormDetallePedido d = new FormDetallePedido();
            if (d.ShowDialog() == DialogResult.OK) {
                detalles.Add(d.Detalle);
                dataGridView1.DataSource = detalles;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if(textBox1.Text =="" || textBox2.Text == "" || textBox4.Text == "")
            {
                MessageBox.Show("Faltan llenar Campos");
            }
            else
            {
                Pedido.Cuenta = Convert.ToSingle(textBox2.Text);
                Pedido.FechaEntrega = dateTimePicker1.Value;
                Pedido.IdCliente = textBox1.Text;
                Pedido.Saldo = Convert.ToSingle(textBox4.Text);

                this.DialogResult = DialogResult.OK;
                Dispose();
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            DetallePedido d = (DetallePedido)dataGridView1.CurrentRow.DataBoundItem;
            detalles.Remove(d);
        }
        
    }
}
