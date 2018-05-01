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
    public partial class FormMostrarUsuarios : Form
    {
        BindingList<Usuario> usuarios = new BindingList<Usuario>();
        public FormMostrarUsuarios(BindingList<Usuario> usuarios)
        {
            InitializeComponent();
            this.usuarios = usuarios;
            dataGridView1.DataSource = this.usuarios;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Dispose();
        }
    }
}
