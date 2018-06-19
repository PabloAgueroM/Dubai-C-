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
using LogicaNegocio;

namespace Vista
{
    public partial class FormMostrarUsuarios : Form
    {
        BindingList<Usuario> usuarios = new BindingList<Usuario>();
        public FormMostrarUsuarios()
        {
            InitializeComponent();
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;

            UsuarioBL userBL = new UsuarioBL();
            usuarios = userBL.listarUsuarios();

            dataGridView1.DataSource = usuarios;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Dispose();
        }
    }
}
