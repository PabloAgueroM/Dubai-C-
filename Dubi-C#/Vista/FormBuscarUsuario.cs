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
    public partial class FormBuscarUsuario : Form
    {
        private Usuario usuarioSeleccionado;
        private BindingList<Usuario> usuarios = new BindingList<Usuario>();

        public Usuario UsuarioSeleccionado { get => usuarioSeleccionado; set => usuarioSeleccionado = value; }

        public FormBuscarUsuario()
        {
            InitializeComponent();

            comboBox1.SelectedIndex = 0;
            UsuarioBL userBL = new UsuarioBL();
            usuarioSeleccionado = new Usuario();
            usuarios = userBL.listarTodosUsuarios();

            dataGridView1.DataSource = usuarios;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            UsuarioSeleccionado = (Usuario)dataGridView1.CurrentRow.DataBoundItem;
            DialogResult = DialogResult.OK;
        }
        

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("¿Seguro que desea eliminar este usuario?","Mensaje",MessageBoxButtons.OKCancel);
            if(res == DialogResult.OK)
            {
                Usuario u = (Usuario)dataGridView1.CurrentRow.DataBoundItem;
                UsuarioBL userBL = new UsuarioBL();
                userBL.eliminarUsuario((u.IdUsuario).ToString());
                dataGridView1.Rows.RemoveAt(dataGridView1.CurrentRow.Index);
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Usuario> filtro = new BindingList<Usuario>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Usuario u in usuarios)
                    if (u.Nombre.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Usuario u in usuarios)                
                    if (u.ApPat.Contains(textBox1.Text.ToUpper())) filtro.Add(u);                
            }
            else if (comboBox1.SelectedIndex == 3)
            {
                foreach (Usuario u in usuarios)                
                    if (u.ApMat.Contains(textBox1.Text.ToUpper())) filtro.Add(u);                
            }
            else if (comboBox1.SelectedIndex == 4)
            {
                foreach (Usuario u in usuarios)
                    if (u.Dni.Contains(textBox1.Text.ToUpper())) filtro.Add(u);                
            }
            dataGridView1.DataSource = filtro;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex == 0) return;

            BindingList<Usuario> filtro = new BindingList<Usuario>();

            if (comboBox1.SelectedIndex == 1)
            {
                foreach (Usuario u in usuarios)
                    if (u.Nombre.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 2)
            {
                foreach (Usuario u in usuarios)
                    if (u.ApPat.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 3)
            {
                foreach (Usuario u in usuarios)
                    if (u.ApMat.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            else if (comboBox1.SelectedIndex == 4)
            {
                foreach (Usuario u in usuarios)
                    if (u.Dni.Contains(textBox1.Text.ToUpper())) filtro.Add(u);
            }
            dataGridView1.DataSource = filtro;
        }
    }
}
