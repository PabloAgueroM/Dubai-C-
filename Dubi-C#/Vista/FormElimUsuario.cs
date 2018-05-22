using System;
using Clases;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Vista
{
    public partial class FormElimUsuario : Form
    {
        Usuario usuarioSeleccionado;
        public FormElimUsuario()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Estas seguro que deseas eliminar este usuario del sistema?", "Confirmacion", MessageBoxButtons.OKCancel) == DialogResult.OK)
            {
                usuarioSeleccionado = (Usuario)dataGridView1.CurrentRow.DataBoundItem;
                MessageBox.Show("Usuario eliminado correctamente");
            };
            
        }
    }
}
