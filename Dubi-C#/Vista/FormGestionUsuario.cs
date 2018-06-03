using Clases;
using LogicaNegocio;
using System;
using System.Drawing;
using System.Text.RegularExpressions;
using System.Windows.Forms;

namespace Vista
{
    public partial class FormGestionUsuario : Form
    {
        private bool modificar;
        private string idPersona;

        public FormGestionUsuario()
        {
            InitializeComponent();
            estadoBotones(0);
            button3.Enabled = false;
            button4.Enabled = false;
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
                    textBox1.Text = null;
                    textBox2.Text = null;
                    textBox3.Text = null;
                    textBox4.Text = null;
                    textBox5.Text = null;
                    textBox6.Text = null;
                    textBox7.Text = null;
                    textBox8.Text = null;
                    textBox9.Text = null;
                    textBox10.Text = null;
                    dateTimePicker1.Enabled = false;
                    dateTimePicker1.Value = DateTime.Now;
                    comboBox4.Enabled = false;
                    comboBox4.SelectedItem = null;
                    radioButton1.Enabled = false;
                    radioButton1.Checked = false;
                    radioButton2.Enabled = false;
                    radioButton2.Checked = false;
                    button1.Enabled = false;
                    button2.Enabled = true;
                    button3.Enabled = false;
                    button4.Enabled = false;
                    button6.Enabled = true;
                    label14.Hide();
                    label15.Hide();
                    break;
                case 1:
                    label13.Hide();
                    if (modificar == true) label15.Show();
                    else if (modificar == false) label14.Show();
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
                    radioButton1.Enabled = true;
                    radioButton2.Enabled = true;
                    button1.Enabled = true;
                    button2.Enabled = false;
                    button3.Enabled = true;
                    button4.Enabled = true;
                    button6.Enabled = false;
                    break;
                default:
                    break;
            }
        }

        private void textBox6_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\d{8}$");
            if (!rgx.IsMatch(textBox6.Text)) textBox6.ForeColor = Color.Red;
            else textBox6.ForeColor = Color.Black;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {  
            Regex rgx = new Regex(@"^[\p{L}\s'.-]+$");
            if (!rgx.IsMatch(textBox1.Text)) textBox1.ForeColor = Color.Red;
            else textBox1.ForeColor = Color.Black;
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^[\p{L}\s'.-]+$");
            if (!rgx.IsMatch(textBox2.Text)) textBox2.ForeColor = Color.Red;
            else textBox2.ForeColor = Color.Black;
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^[\p{L}\s'.-]+$");
            if (!rgx.IsMatch(textBox3.Text)) textBox3.ForeColor = Color.Red;
            else textBox3.ForeColor = Color.Black;
        }

        private void textBox7_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$");
            if (!rgx.IsMatch(textBox7.Text)) textBox7.ForeColor = Color.Red;
            else textBox7.ForeColor = Color.Black;
        }

        private void textBox8_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\d{9}$");
            if (!rgx.IsMatch(textBox8.Text)) textBox8.ForeColor = Color.Red;
            else textBox8.ForeColor = Color.Black;
        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^[A-Za-z0-9]{8,}$");
            if (!rgx.IsMatch(textBox5.Text)) textBox5.ForeColor = Color.Red;
            else textBox5.ForeColor = Color.Black;
        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^[A-Za-z0-9]{8,}$");
            if (!rgx.IsMatch(textBox4.Text)) textBox4.ForeColor = Color.Red;
            else textBox4.ForeColor = Color.Black;
        }

        private int validarDatos()
        {
           
            
            if (String.IsNullOrWhiteSpace(textBox1.Text) || String.IsNullOrWhiteSpace(textBox2.Text) ||
                String.IsNullOrWhiteSpace(textBox3.Text) || String.IsNullOrWhiteSpace(textBox4.Text) ||
                String.IsNullOrWhiteSpace(textBox5.Text) || String.IsNullOrWhiteSpace(textBox6.Text) ||
                String.IsNullOrWhiteSpace(textBox7.Text) || String.IsNullOrWhiteSpace(textBox8.Text) ||
                String.IsNullOrWhiteSpace(textBox9.Text))           
                return 2;

            if (textBox1.ForeColor == Color.Red || textBox2.ForeColor == Color.Red ||
               textBox3.ForeColor == Color.Red || textBox6.ForeColor == Color.Red ||
               textBox7.ForeColor == Color.Red || textBox8.ForeColor == Color.Red ||
               textBox5.ForeColor == Color.Red)
                return 1;

            if (radioButton1.Checked == false && radioButton2.Checked == false) return 3;
            if (comboBox4.SelectedIndex < 0) return 4;
            if ((int)((DateTime.Now - dateTimePicker1.Value).TotalDays) > 25550) return 5;
            if (textBox4.Text != textBox5.Text) return 6;
            
            return 0;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("La contraseña debe contener entre 8 y 20 caracteres. Solo se permite letras y numeros","Mensaje",MessageBoxButtons.OK,MessageBoxIcon.Information);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            modificar = false;
            estadoBotones(1);
            button6.Enabled = false;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int datosValidos = validarDatos();
            if (datosValidos > 0)
            {
                if (datosValidos == 1) MessageBox.Show("Corregir los campos con letra roja", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 2) MessageBox.Show("Faltan llenar campos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 3) MessageBox.Show("Falta seleccionar el sexo", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 4) MessageBox.Show("Falta seleccionar el tipo de usuario", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 5) MessageBox.Show("Revisar la fecha de nacimiento", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (datosValidos == 6) MessageBox.Show("Las contraseñas no coinciden", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            if (modificar == false)
            {
                string inDNI = textBox6.Text;
                string inNombres = textBox1.Text.ToUpper();
                string inApPat = textBox2.Text.ToUpper();
                string inApMat = textBox3.Text.ToUpper();
                DateTime inFecha = new DateTime();
                inFecha = dateTimePicker1.Value;
                string inPassword = textBox4.Text;
                int index = 4 - (comboBox4.SelectedIndex);
                char inSexo = ' ';
                if (radioButton1.Checked) inSexo = 'M';
                else if (radioButton2.Checked) inSexo = 'F';
                string inEmail = textBox7.Text;
                string inTelf = textBox8.Text;
                string inDireccion = textBox9.Text;

                Usuario newUser = new Usuario(idPersona, inEmail, inTelf, inDNI, inNombres, inApPat, inApMat, inSexo, inFecha, 1, index, inPassword, 1, inDireccion);

                UsuarioBL userBL = new UsuarioBL();
                int id = userBL.registrarUsuario(newUser);

                MessageBox.Show("Usuario registrado correctamente\nID: " + id);

                estadoBotones(0);
            }
            else if (modificar == true)
            {
                string inDNI = textBox6.Text;
                string inNombres = textBox1.Text.ToUpper();
                string inApPat = textBox2.Text.ToUpper();
                string inApMat = textBox3.Text.ToUpper();
                DateTime inFecha = new DateTime();
                inFecha = dateTimePicker1.Value;
                string inPassword = textBox4.Text;
                int index = 4 - (comboBox4.SelectedIndex);
                char inSexo = ' ';
                if (radioButton1.Checked) inSexo = 'M';
                else if (radioButton2.Checked) inSexo = 'F';
                string inEmail = textBox7.Text;
                string inTelf = textBox8.Text;
                string inDireccion = textBox9.Text;

                Usuario newUser = new Usuario(idPersona, inEmail, inTelf, inDNI, inNombres, inApPat, inApMat, inSexo, inFecha, 1, index, inPassword, 1, inDireccion);
                UsuarioBL userBL = new UsuarioBL();              
                int check = userBL.modificarUsuario(newUser);

                if (check == 0) MessageBox.Show( "Ocurrio un error al realizar la modificacion", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else if (check == -1) MessageBox.Show("No se pudo establecer conexion con la base de datos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else MessageBox.Show("Usuario modificado correctamente", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);

                estadoBotones(0);
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            estadoBotones(0);
            label13.Show();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            FormBuscarUsuario form = new FormBuscarUsuario();
            form.ShowDialog();
            if (form.DialogResult == DialogResult.OK)
            {
                modificar = true;
                idPersona = form.UsuarioSeleccionado.IdPersona;
                textBox10.Text = form.UsuarioSeleccionado.IdUsuario.ToString();
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
                    radioButton1.Checked = true;
                else if (form.UsuarioSeleccionado.Sexo == 'F')
                    radioButton2.Checked = true;
                estadoBotones(1);
            }
        }
    }
}
