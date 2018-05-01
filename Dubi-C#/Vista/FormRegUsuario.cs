using System;
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
    public partial class FormRegUsuario : Form
    {
        public FormRegUsuario()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
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
                MessageBox.Show("Nuevo usuario registrado:\nID: \nContraseña: " + textBox4.Text );
                Dispose();
            }
        }

        
    }
}
