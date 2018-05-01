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
    public partial class FormModificarPedido : Form
    {
        private BindingList<Pedido> pedidos = new BindingList<Pedido>();
        
        public FormModificarPedido(BindingList<Pedido> pedidos)
        {
            InitializeComponent();
            this.pedidos = pedidos;
            dataGridView1.DataSource = this.pedidos;
        }
        
    }
}
