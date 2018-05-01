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
    public partial class FormModUsuario2 : Form
    {
        private Usuario usuario;

        public FormModUsuario2(Usuario usuarioSeleccionado)
        {
            InitializeComponent();
            usuario = usuarioSeleccionado;
            textBox1.Text = usuarioSeleccionado.Nombre;
            textBox2.Text = usuarioSeleccionado.ApPat;
            textBox3.Text = usuarioSeleccionado.ApMat;
            textBox4.Text = usuarioSeleccionado.Password;
            textBox5.Text = usuarioSeleccionado.Password;
            dateTimePicker1.Value = usuarioSeleccionado.FechaNac;
            comboBox4.Text = usuarioSeleccionado.Tipo;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            usuario.Nombre = textBox1.Text;
            usuario.ApPat = textBox2.Text;
            usuario.ApMat = textBox3.Text;
            usuario.Password = textBox4.Text;
            usuario.FechaNac = dateTimePicker1.Value;
            usuario.Tipo = comboBox4.Text;

            if (String.IsNullOrEmpty(textBox1.Text) || String.IsNullOrEmpty(textBox2.Text) || String.IsNullOrEmpty(textBox3.Text) || String.IsNullOrEmpty(textBox4.Text)
                || String.IsNullOrEmpty(textBox5.Text))
            {
                MessageBox.Show("Error: Faltan llenar campos");
            }
            else if (textBox4.Text != textBox5.Text)
            {
                MessageBox.Show("Error: Las contraseñas no coinciden");
            }
            else
            {
                MessageBox.Show("Usuario modificado exitosamente");
                DialogResult = DialogResult.OK;
                Dispose();
            }
        }
    }
}
