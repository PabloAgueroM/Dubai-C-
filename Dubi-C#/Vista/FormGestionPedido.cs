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
    public partial class FormGestionPedido : Form
    {
        private BindingList<Pedido> pedidos = new BindingList<Pedido>();
        public FormGestionPedido()
        {
            InitializeComponent();
            //Cambiar formato de fecha
            

        }

        private void button1_Click(object sender, EventArgs e)
        {
            FormIngresarPedido ingresar = new FormIngresarPedido();
            if (ingresar.ShowDialog() == DialogResult.OK)
            {
                pedidos.Add(ingresar.Pedido);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            FormModificarPedido modificar = new FormModificarPedido(pedidos);
            modificar.ShowDialog();
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            FormEliminarPedido eliminar = new FormEliminarPedido(pedidos);
            eliminar.ShowDialog();
        }

        private void FormGestionPedido_FormClosed(object sender, FormClosedEventArgs e)
        {
            
        }
    }
}
