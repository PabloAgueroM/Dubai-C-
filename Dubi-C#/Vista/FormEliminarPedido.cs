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
    public partial class FormEliminarPedido : Form
    {
        private BindingList<Pedido> pedidos = new BindingList<Pedido>();
        public FormEliminarPedido(BindingList<Pedido> pedidos)
        {
            InitializeComponent();
            this.pedidos = pedidos;
            dataGridView1.DataSource = this.pedidos;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Pedido productoSeleccionado = (Pedido)dataGridView1.CurrentRow.DataBoundItem;
            pedidos.Remove(productoSeleccionado);
            dataGridView1.DataSource = pedidos;
        }
    }
}
