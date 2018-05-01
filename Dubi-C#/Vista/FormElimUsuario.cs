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
        BindingList<Usuario> usuarios = new BindingList<Usuario>();
        public FormElimUsuario(BindingList<Usuario> usuarios)
        {
            InitializeComponent();
            this.usuarios = usuarios;
            dataGridView1.DataSource = this.usuarios;
            dataGridView1.AutoResizeColumns();
            dataGridView1.AutoResizeRows();
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
