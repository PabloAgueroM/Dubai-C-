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
    public partial class FromGestionarProduccion : Form
    {
        private Pedido pedidoSeleccionado;
        private PedidoBL logicaNegocio;
        private OrdenProduccionBL logicaNegocio2;
        private BindingList<Pedido> pedidos = new BindingList<Pedido>();
        private BindingList<OrdenProduccion> ordenes = new BindingList<OrdenProduccion>();
        public FromGestionarProduccion()
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;
            logicaNegocio = new PedidoBL();
            logicaNegocio2 = new OrdenProduccionBL();
            comboBox1.SelectedIndex = 0;
            dataGridView1.AutoGenerateColumns = false;
            dataGridView2.AutoGenerateColumns = false;
            pedidos = logicaNegocio.listarPedidos();
            dataGridView1.DataSource = pedidos; 
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
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

        private void btnMostrarOrdenes_Click(object sender, EventArgs e)
        {
            pedidoSeleccionado = (Pedido)dataGridView1.CurrentRow.DataBoundItem;
            int id = int.Parse(pedidoSeleccionado.IdPedido);

            // int id_orden = logicaNegocio2.obtenerIdOrden(id);

            ordenes = logicaNegocio2.listarOrdenesProduccion(id);

            dataGridView2.DataSource = ordenes;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Owner.Show();
            Dispose();
        }

        
    }
}
