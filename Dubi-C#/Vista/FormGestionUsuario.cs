using Clases;
using LogicaNegocio;
using System;
using System.Windows.Forms;

namespace Vista
{
    public partial class FormGestionUsuario : Form
    {
        public bool modificar;

        public FormGestionUsuario()
        {
            InitializeComponent();
            estadoBotones(0);
            toolStripButton2.Enabled = false;
            toolStripButton3.Enabled = false;
            modificar = false;
        }

        private void estadoBotones(int n)
        {
            switch (n)
            {
                case 0:
                    textBox1.Enabled = false;
                    textBox2.Enabled = false;
                    textBox3.Enabled = false;
                    textBox4.Enabled = false;
                    textBox5.Enabled = false;
                    textBox6.Enabled = false;
                    textBox7.Enabled = false;
                    textBox8.Enabled = false;
                    textBox9.Enabled = false;
                    dateTimePicker1.Enabled = false;
                    comboBox4.Enabled = false;
                    comboBox1.Enabled = false;
                    break;
                case 1:
                    textBox1.Enabled = true;
                    textBox2.Enabled = true;
                    textBox3.Enabled = true;
                    textBox4.Enabled = true;
                    textBox6.Enabled = true;
                    textBox5.Enabled = true;
                    textBox7.Enabled = true;
                    textBox8.Enabled = true;
                    textBox9.Enabled = true;
                    dateTimePicker1.Enabled = true;
                    comboBox4.Enabled = true;
                    comboBox1.Enabled = true;
                    break;
                default:
                    break;
            }
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            estadoBotones(1);
            toolStripButton1.Enabled = false;
            toolStripButton2.Enabled = true;
            toolStripButton3.Enabled = true;
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            estadoBotones(0);
            textBox1.Text = null;
            textBox2.Text = null;
            textBox3.Text = null;
            textBox4.Text = null;
            textBox5.Text = null;
            textBox6.Text = null;
            textBox7.Text = null;
            textBox8.Text = null;
            textBox9.Text = null;
            dateTimePicker1.Value = DateTime.Now;
            comboBox4.SelectedItem = null;
            comboBox4.Enabled = false;
            comboBox1.SelectedItem = null;
            comboBox1.Enabled = false;
            toolStripButton1.Enabled = true;
            toolStripButton2.Enabled = false;
            toolStripButton3.Enabled = false;
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            if (modificar == false)
            {
                string inDNI = textBox6.Text;
                string inNombres = textBox1.Text;
                string inApPat = textBox2.Text;
                string inApMat = textBox3.Text;
                DateTime inFecha = new DateTime();
                inFecha = dateTimePicker1.Value;
                string inPassword = textBox4.Text;
                int index = 4 - (comboBox4.SelectedIndex);
                Console.WriteLine(index);
                int indexSexo = comboBox1.SelectedIndex;
                char inSexo = ' ';
                if (indexSexo == 0) inSexo = 'M';
                else if (indexSexo == 1) inSexo = 'F';
                string inEmail = textBox7.Text;
                string inTelf = textBox8.Text;
                string inDireccion = textBox9.Text;

                Usuario newUser = new Usuario("1", inEmail, inTelf, inDNI, inNombres, inApPat, inApMat, inSexo, inFecha, 1, index, inPassword, 1, inDireccion);

                UsuarioBL userBL = new UsuarioBL();
                int id = userBL.registrarUsuario(newUser);

                MessageBox.Show("Usuario registrado correctamente\nID: " + id);

                estadoBotones(0);
                textBox1.Text = null;
                textBox2.Text = null;
                textBox3.Text = null;
                textBox4.Text = null;
                textBox5.Text = null;
                textBox6.Text = null;
                textBox7.Text = null;
                textBox8.Text = null;
                textBox9.Text = null;
                dateTimePicker1.Value = DateTime.Now;
                comboBox4.SelectedItem = null;
                comboBox4.Enabled = false;
                comboBox1.SelectedItem = null;
                comboBox1.Enabled = false;
                toolStripButton1.Enabled = true;
                toolStripButton2.Enabled = false;
                toolStripButton3.Enabled = false;
            }
            else if(modificar == true)
            {
                string inDNI = textBox6.Text;
                string inNombres = textBox1.Text;
                string inApPat = textBox2.Text;
                string inApMat = textBox3.Text;
                DateTime inFecha = new DateTime();
                inFecha = dateTimePicker1.Value;
                string inPassword = textBox4.Text;
                int index = 4 - (comboBox4.SelectedIndex);
                Console.WriteLine(index);
                int indexSexo = comboBox1.SelectedIndex;
                char inSexo = ' ';
                if (indexSexo == 0) inSexo = 'M';
                else if (indexSexo == 1) inSexo = 'F';
                string inEmail = textBox7.Text;
                string inTelf = textBox8.Text;
                string inDireccion = textBox9.Text;

                Usuario newUser = new Usuario("1", inEmail, inTelf, inDNI, inNombres, inApPat, inApMat, inSexo, inFecha, 1, index, inPassword, 1, inDireccion);

                UsuarioBL userBL = new UsuarioBL();
                int check = userBL.modificarUsuario(newUser);

                MessageBox.Show("Usuario modificado correctamente");

                estadoBotones(0);
                textBox1.Text = null;
                textBox2.Text = null;
                textBox3.Text = null;
                textBox4.Text = null;
                textBox5.Text = null;
                textBox6.Text = null;
                textBox7.Text = null;
                textBox8.Text = null;
                textBox9.Text = null;
                dateTimePicker1.Value = DateTime.Now;
                comboBox4.SelectedItem = null;
                comboBox4.Enabled = false;
                comboBox1.SelectedItem = null;
                comboBox1.Enabled = false;
                toolStripButton1.Enabled = true;
                toolStripButton2.Enabled = false;
                toolStripButton3.Enabled = false;
            }
        }

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            FormBuscarUsuario form = new FormBuscarUsuario();
            Hide();
            form.Owner = this;
            form.ShowDialog();
            if(form.DialogResult == DialogResult.OK)
            {
                modificar = true;
                textBox2.Text = form.UsuarioSeleccionado.ApPat;
                textBox6.Text = form.UsuarioSeleccionado.Dni;
                textBox1.Text = form.UsuarioSeleccionado.Nombre;
                textBox3.Text = form.UsuarioSeleccionado.ApMat;
                dateTimePicker1.Value = form.UsuarioSeleccionado.FechaNac;
                textBox7.Text = form.UsuarioSeleccionado.Email;
                textBox8.Text = form.UsuarioSeleccionado.Telefono;
                textBox9.Text = form.UsuarioSeleccionado.Direccion;
                textBox5.Text = form.UsuarioSeleccionado.Password;
                textBox4.Text = form.UsuarioSeleccionado.Password;
                comboBox4.SelectedIndex = 4 - form.UsuarioSeleccionado.TipoUsuario;
                if (form.UsuarioSeleccionado.Sexo == 'M')
                    comboBox1.SelectedIndex = 0;
                else if (form.UsuarioSeleccionado.Sexo == 'F')
                    comboBox1.SelectedIndex = 1;
                estadoBotones(1);
                toolStripButton1.Enabled = false;
                toolStripButton2.Enabled = true;
                toolStripButton3.Enabled = true;
            }
        }
    }
}
