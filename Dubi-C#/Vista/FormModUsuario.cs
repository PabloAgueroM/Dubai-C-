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
    public partial class FormModUsuario : Form
    {
        Usuario usuarioSeleccionado;
        BindingList<Usuario> usuarios = new BindingList<Usuario>();
        public FormModUsuario(BindingList<Usuario> usuarios)
        {
            InitializeComponent();
            this.usuarios = usuarios;
            dataGridView1.DataSource = this.usuarios;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            usuarioSeleccionado = (Usuario)dataGridView1.CurrentRow.DataBoundItem;
            FormModUsuario2 form = new FormModUsuario2(usuarioSeleccionado);
            form.Owner = this;
            form.ShowDialog();
            if(form.DialogResult == DialogResult.OK)
            {
                dataGridView1.Update();
                dataGridView1.Refresh();
            }   
        }
    }
}
