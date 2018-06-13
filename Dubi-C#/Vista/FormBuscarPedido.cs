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
namespace Vista
{
    public partial class FormBuscarPedido : Form
    {
        private Pedido pedidoSeleccionado;
        private PedidoBL logicaNegocio;
        public FormBuscarPedido()
        {
            InitializeComponent();
            logicaNegocio = new PedidoBL();
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.DataSource = logicaNegocio.listarPedidos();
        }

        public Pedido PedidoSeleccionado { get => pedidoSeleccionado; set => pedidoSeleccionado = value; }

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();            
        }

        private void button6_Click(object sender, EventArgs e)
        {
            PedidoSeleccionado = (Pedido)dataGridView1.CurrentRow.DataBoundItem;
            DialogResult = DialogResult.OK;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBox1.Text)) dataGridView1.DataSource = logicaNegocio.listarPedidos();
            else dataGridView1.DataSource = logicaNegocio.filtrarPedidos(textBox1.Text);
            dataGridView1.Update();
            dataGridView1.Refresh();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("¿Seguro que desea cancelar este pedido?", "Mensaje", MessageBoxButtons.OKCancel);
            if (res == DialogResult.OK)
            {
                PedidoSeleccionado = (Pedido)dataGridView1.CurrentRow.DataBoundItem;
                PedidoBL pedidoBL = new PedidoBL();
                pedidoBL.cancelarPedido(PedidoSeleccionado.IdPedido);
                dataGridView1.Rows.RemoveAt(dataGridView1.CurrentRow.Index);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("¿Seguro que desea pasar a produccion este pedido?", "Mensaje", MessageBoxButtons.OKCancel);
            if (res == DialogResult.OK)
            {
                PedidoSeleccionado = (Pedido)dataGridView1.CurrentRow.DataBoundItem;
                PedidoBL pedidoBL = new PedidoBL();
                pedidoBL.avanzarPedido(PedidoSeleccionado.IdPedido);
                dataGridView1.Rows.RemoveAt(dataGridView1.CurrentRow.Index);
            }
        }
    }
}
