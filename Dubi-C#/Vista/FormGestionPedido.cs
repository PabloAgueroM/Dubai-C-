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
            Pedido p1 = new Pedido("01","1234","4321","001","01/01/2018",new DateTime(2018,11,11),200.0f,122.3f,122.22f,true);
            Pedido p2 = new Pedido("00151238", "4561235", "985159", "953213000", "05/12/2017", new DateTime(2018, 09, 15), 6.89f, 9.65f, 10.56f, true);

            pedidos.Add(p1);
            pedidos.Add(p2);

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
