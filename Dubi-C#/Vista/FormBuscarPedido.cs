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
        private BindingList<Pedido> pedidos = new BindingList<Pedido>();
        public FormBuscarPedido()
        {
            InitializeComponent();

            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;
            logicaNegocio = new PedidoBL();
            comboBox1.SelectedIndex = 0;
            dataGridView1.AutoGenerateColumns = false;
            pedidos = logicaNegocio.listarPedidos();
            dataGridView1.DataSource = pedidos;
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

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Pedido> filtro = new BindingList<Pedido>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Pedido u in pedidos)
                    if (u.IdPedido.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Pedido u in pedidos)
                    if (u.IdCliente.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            dataGridView1.DataSource = filtro;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Pedido> filtro = new BindingList<Pedido>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Pedido u in pedidos)
                    if (u.IdPedido.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Pedido u in pedidos)
                    if (u.IdCliente.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            dataGridView1.DataSource = filtro;
        }
    }
}
