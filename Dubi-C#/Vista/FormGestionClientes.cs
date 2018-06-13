using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;
using Clases;
using LogicaNegocio;
namespace Vista
{
    public partial class FormGestionClientes : Form
    {
        private ClienteBL logicaNegocio;
        private BindingList<Persona> listaClientes = new BindingList<Persona>();
        private verificador v = new verificador();
        public FormGestionClientes()
        {
            InitializeComponent();
            logicaNegocio = new ClienteBL();
            panel1.Visible = false;
            panel2.Visible = false;
            comboBox1.SelectedIndex = 0;
<<<<<<< HEAD
            estadoBotones(0);
            dateTimePicker1.MaxDate = DateTime.Now.AddYears(-18);
            dateTimePicker1.MinDate = DateTime.Now.AddYears(-100);
            dateTimePicker2.MaxDate = DateTime.Now;
            dateTimePicker2.MinDate = DateTime.Now.AddYears(-80);
=======
            this.estadoBotones(0);
>>>>>>> d49e51953174916b79dae6dd442fe7ccfbce1f1e
        }


        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Juridica")
            {
                panel2.Visible = true;
                panel1.Visible = false;
                comboBox1.Text = "Juridica";
            }
            else
            {
                panel1.Visible = true;
                panel2.Visible = false;
                comboBox1.Text = "Natural";
            }
        }

        private void estadoBotones(int n) {
            switch (n)
            {
                case 0:
                    textNombreN.Enabled = false;
                    textApPat.Enabled = false;
                    textApMat.Enabled = false;
                    textEmailN.Enabled = false;
                    textTelefonoN.Enabled = false;
                    dateTimePicker1.Enabled = false;
                    textRazon.Enabled = false;
                    textNombreJ.Enabled = false;
                    textRuc.Enabled = false;
                    textTelefonoJ.Enabled = false;
                    textEmailJ.Enabled = false;
                    txtDni.Enabled = false;
                    textDireccionN.Enabled = false;
                    textDireccionJ.Enabled = false;
                    textNombreN.Text = "";
                    textApPat.Text = "";
                    textApMat.Text = "";
                    textEmailN.Text = "";
                    textTelefonoN.Text = "";
                    textRazon.Text = "";
                    textNombreJ.Text = "";
                    textRuc.Text = "";
                    textTelefonoJ.Text = "";
                    textEmailJ.Text = "";
                    txtDni.Text = "";
                    textDireccionN.Text = "";
                    textDireccionJ.Text = "";
                    textBox14.Text = "";
                    textBox14.Enabled = false;
                    dateTimePicker2.Enabled = false;
                    button2.Enabled = true;
                    button3.Enabled = false;
                    button4.Enabled = false;
                    button6.Enabled = true;

                    break;
                case 1:
                    textNombreN.Enabled = true;
                    textApPat.Enabled = true;
                    textApMat.Enabled = true;
                    textEmailN.Enabled = true;
                    textTelefonoN.Enabled = true;
                    dateTimePicker1.Enabled = true;
                    textRazon.Enabled = true;
                    textNombreJ.Enabled = true;
                    textRuc.Enabled = true;
                    textTelefonoJ.Enabled = true;
                    textEmailJ.Enabled = true;
                    txtDni.Enabled = true;
                    textDireccionN.Enabled = true;
                    textDireccionJ.Enabled = true;
                    textBox14.Enabled = false;
                    dateTimePicker2.Enabled = true;
                    button2.Enabled = false;
                    button3.Enabled = true;
                    button4.Enabled = true;
                    button6.Enabled = false;
                    break;
                case 2:
                    textNombreN.Enabled = true;
                    textApPat.Enabled = true;
                    textApMat.Enabled = true;
                    textEmailN.Enabled = true;
                    textTelefonoN.Enabled = true;
                    dateTimePicker1.Enabled = true;
                    textRazon.Enabled = true;
                    textNombreJ.Enabled = true;
                    textRuc.Enabled = true;
                    textTelefonoJ.Enabled = true;
                    textEmailJ.Enabled = true;
                    txtDni.Enabled = true;
                    textDireccionN.Enabled = true;
                    textDireccionJ.Enabled = true;
                    dateTimePicker2.Enabled = true;
                    button2.Enabled = false;
                    button3.Enabled = true;
                    button4.Enabled = true;
                    button6.Enabled = false;
                    break;

            }

        }
        
        private void button2_Click(object sender, EventArgs e)
        {
            this.estadoBotones(1);
            if (comboBox1.Text == "Juridica")
            {
                panel2.Visible = true;
                panel1.Visible = false;
                comboBox1.Text = "Juridica";
            }
            else
            {
                panel1.Visible = true;
                panel2.Visible = false;
                comboBox1.Text = "Natural";
            }


        }

        private void button6_Click(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Juridica")
            {
                FormBuscarClienteJuridico buscar = new FormBuscarClienteJuridico();
                if (buscar.ShowDialog() == DialogResult.OK)
                {
                    textBox14.Text = buscar.ClienteSeleccionado.IdPersona;
                    textRazon.Text = buscar.ClienteSeleccionado.RazonSocial;
                    textNombreJ.Text = buscar.ClienteSeleccionado.Nombre;
                    textRuc.Text = buscar.ClienteSeleccionado.Ruc;
                    textTelefonoJ.Text = buscar.ClienteSeleccionado.Telefono;
                    textEmailJ.Text = buscar.ClienteSeleccionado.Email;
                    dateTimePicker2.Value = buscar.ClienteSeleccionado.FechaAniversario;
                    textDireccionJ.Text = buscar.ClienteSeleccionado.Direccion;
                    this.estadoBotones(2);
                    panel2.Visible = true;
                    panel1.Visible = false;
                    comboBox1.Text = "Juridica";

                }
            }
            else
            {
                FormBuscarClienteNatural buscar = new FormBuscarClienteNatural();
                if (buscar.ShowDialog() == DialogResult.OK)
                {
                    textBox14.Text = buscar.ClienteSeleccionado.IdPersona;
                    txtDni.Text = buscar.ClienteSeleccionado.Dni;
                    textNombreN.Text = buscar.ClienteSeleccionado.Nombre;
                    textApPat.Text = buscar.ClienteSeleccionado.ApPat;
                    textApMat.Text = buscar.ClienteSeleccionado.ApMat;
                    textEmailN.Text = buscar.ClienteSeleccionado.Email;
                    textDireccionN.Text = buscar.ClienteSeleccionado.Direccion;
                    textTelefonoN.Text = buscar.ClienteSeleccionado.Telefono;
                    dateTimePicker1.Value = buscar.ClienteSeleccionado.FechaNac;
                    if (buscar.ClienteSeleccionado.Sexo == 'M') radioButton1.Checked = true;
                    else radioButton2.Checked = true;
                    this.estadoBotones(2);
                    panel1.Visible = true;
                    panel2.Visible = false;
                    comboBox1.Text = "Natural";
                }
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.estadoBotones(0);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (textBox14.Text == "")
            {
                if (comboBox1.Text == "Juridica")
                {
                    int datosValidos = validarDatosJuridico();
                    if (datosValidos > 0)
                    {
                        if (datosValidos == 1) MessageBox.Show("Corregir los campos con letra roja", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else if (datosValidos == 2) MessageBox.Show("Faltan llenar campos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else if (datosValidos == 5) MessageBox.Show("Revisar la fecha de nacimiento", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        return;
                    }

                    Juridica c = new Juridica();
                    c.RazonSocial = textRazon.Text.ToUpper();
                    c.Nombre = textNombreJ.Text.ToUpper();
                    c.Ruc = textRuc.Text;
                    c.Telefono = textTelefonoJ.Text;
                    c.Email = textEmailJ.Text;
                    c.Direccion = textDireccionJ.Text;
                    c.FechaAniversario = dateTimePicker2.Value;
                        
                    int id = logicaNegocio.registrarClienteJuridico(c);
                    this.estadoBotones(0);
                    MessageBox.Show("Cliente registrado correctamente");
                }
                else
                {
                    int datosValidos = validarDatosNatural();
                    if (datosValidos > 0) {
                        if (datosValidos == 1) MessageBox.Show("Corregir los campos con letra roja", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else if (datosValidos == 2) MessageBox.Show("Faltan llenar campos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else if (datosValidos == 3) MessageBox.Show("Falta seleccionar el sexo", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else if (datosValidos == 5) MessageBox.Show("Revisar la fecha de nacimiento", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        return;
                    }
                    
                    Natural c = new Natural();
                    c.Nombre = textNombreN.Text.ToUpper();
                    c.Dni = txtDni.Text;
                    c.ApPat = textApPat.Text.ToUpper();
                    c.ApMat = textApMat.Text.ToUpper();
                    c.Email = textEmailN.Text;
                    c.Telefono = textTelefonoN.Text;
                    c.FechaNac = dateTimePicker1.Value;
                    c.Direccion = textDireccionN.Text;
                    if (radioButton1.Checked == true) c.Sexo = 'M';
                    else if (radioButton2.Checked == true) c.Sexo = 'F';

                    int id = logicaNegocio.registrarClienteNatural(c);
                    this.estadoBotones(0);
                    MessageBox.Show("Cliente registrado correctamente");
                    
                }
            }
            else
            {
                if (comboBox1.Text == "Juridica")
                {
                    int datosValidos = validarDatosJuridico();
                    if (datosValidos > 0)
                    {
                        if (datosValidos == 1) MessageBox.Show("Corregir los campos con letra roja", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else if (datosValidos == 2) MessageBox.Show("Faltan llenar campos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else if (datosValidos == 5) MessageBox.Show("Revisar la fecha de nacimiento", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        return;
                    }

                    Juridica c = new Juridica();
                    c.RazonSocial = textRazon.Text.ToUpper();
                    c.Nombre = textNombreJ.Text.ToUpper();
                    c.Ruc = textRuc.Text;
                    c.Telefono = textTelefonoJ.Text;
                    c.Email = textEmailJ.Text;
                    c.Direccion = textDireccionJ.Text;
                    c.IdPersona = textBox14.Text;
                    c.FechaAniversario = dateTimePicker2.Value;

                    logicaNegocio.actualizarClienteJuridico(c);
                    this.estadoBotones(0);

                }
                else
                {
                    int datosValidos = validarDatosNatural();
                    if (datosValidos > 0)
                    {
                        if (datosValidos == 1) MessageBox.Show("Corregir los campos con letra roja", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else if (datosValidos == 2) MessageBox.Show("Faltan llenar campos", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else if (datosValidos == 3) MessageBox.Show("Falta seleccionar el sexo", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        else if (datosValidos == 5) MessageBox.Show("Revisar la fecha de nacimiento", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        return;
                    }
                    Natural c = new Natural();
                    c.Nombre = textNombreN.Text.ToUpper();
                    c.Dni = txtDni.Text;
                    c.ApPat = textApPat.Text.ToUpper();
                    c.ApMat = textApMat.Text.ToUpper();
                    c.Email = textEmailN.Text;
                    c.Telefono = textTelefonoN.Text;
                    c.FechaNac = dateTimePicker1.Value;
                    c.Direccion = textDireccionN.Text;
                    c.IdPersona = textBox14.Text;
                    if (radioButton1.Checked == true) c.Sexo = 'M';
                    else if (radioButton2.Checked == true) c.Sexo = 'F';

                    logicaNegocio.actualizarClienteNatural(c);
                    this.estadoBotones(0);
                }
                MessageBox.Show("Cliente actualizado satisfactoriamente");
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void textBox11_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\d{8}$");
            if (!rgx.IsMatch(txtDni.Text)) txtDni.ForeColor = Color.Red;
            else txtDni.ForeColor = Color.Black;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^[\p{L}\s'.-]+$");
            if (!rgx.IsMatch(textNombreN.Text)) textNombreN.ForeColor = Color.Red;
            else textNombreN.ForeColor = Color.Black;
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^[\p{L}\s'.-]+$");
            if (!rgx.IsMatch(textApPat.Text)) textApPat.ForeColor = Color.Red;
            else textApPat.ForeColor = Color.Black;
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^[\p{L}\s'.-]+$");
            if (!rgx.IsMatch(textApMat.Text)) textApMat.ForeColor = Color.Red;
            else textApMat.ForeColor = Color.Black;
        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$");
            if (!rgx.IsMatch(textEmailN.Text)) textEmailN.ForeColor = Color.Red;
            else textEmailN.ForeColor = Color.Black;
        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\d{9}$");
            if (!rgx.IsMatch(textTelefonoN.Text)) textTelefonoN.ForeColor = Color.Red;
            else textTelefonoN.ForeColor = Color.Black;
        }

        private int validarDatosNatural()
        {
            if (textNombreN.ForeColor == Color.Red || textApPat.ForeColor == Color.Red ||
                textApMat.ForeColor == Color.Red || textEmailN.ForeColor == Color.Red ||
                txtDni.ForeColor == Color.Red || textDireccionN.ForeColor == Color.Red ||
                textTelefonoN.ForeColor == Color.Red)
                return 1;

            if (String.IsNullOrWhiteSpace(textNombreN.Text) || String.IsNullOrWhiteSpace(textApPat.Text) ||
                String.IsNullOrWhiteSpace(textApMat.Text) || String.IsNullOrWhiteSpace(textEmailN.Text) ||
                String.IsNullOrWhiteSpace(textTelefonoN.Text) || String.IsNullOrWhiteSpace(txtDni.Text) ||
                String.IsNullOrWhiteSpace(textDireccionN.Text))
                return 2;

            if (radioButton1.Checked == false && radioButton2.Checked == false) return 3;
            if ((int)((DateTime.Now - dateTimePicker1.Value).TotalDays) > 25550) return 5;

            return 0;
        }

        private int validarDatosJuridico()
        {
            if (textNombreJ.ForeColor == Color.Red || textRazon.ForeColor == Color.Red ||
                textRuc.ForeColor == Color.Red || textEmailJ.ForeColor == Color.Red ||
                textDireccionJ.ForeColor == Color.Red || textTelefonoJ.ForeColor == Color.Red)
                return 1;

            if (String.IsNullOrWhiteSpace(textNombreJ.Text) || String.IsNullOrWhiteSpace(textRuc.Text) ||
                String.IsNullOrWhiteSpace(textRazon.Text) || String.IsNullOrWhiteSpace(textEmailJ.Text) ||
                String.IsNullOrWhiteSpace(textTelefonoJ.Text) ||  String.IsNullOrWhiteSpace(textDireccionJ.Text))
                return 2;

            if ((int)((DateTime.Now - dateTimePicker2.Value).TotalDays) > 25550) return 5;

            return 0;
        }

        private void textRazon_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^[\p{L}\s'.-]+$");
            if (!rgx.IsMatch(textRazon.Text)) textRazon.ForeColor = Color.Red;
            else textRazon.ForeColor = Color.Black;
        }

        private void textNombreJ_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^[\p{L}\s'.-]+$");
            if (!rgx.IsMatch(textNombreJ.Text)) textNombreJ.ForeColor = Color.Red;
            else textNombreJ.ForeColor = Color.Black;
        }

        private void textRuc_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\d{10}$");
            if (!rgx.IsMatch(textRuc.Text)) textRuc.ForeColor = Color.Red;
            else textRuc.ForeColor = Color.Black;
        }

        private void textEmailJ_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$");
            if (!rgx.IsMatch(textEmailJ.Text)) textEmailJ.ForeColor = Color.Red;
            else textEmailJ.ForeColor = Color.Black;
        }

        private void textTelefonoJ_TextChanged(object sender, EventArgs e)
        {
            Regex rgx = new Regex(@"^\d{9}$");
            if (!rgx.IsMatch(textTelefonoJ.Text)) textTelefonoJ.ForeColor = Color.Red;
            else textTelefonoJ.ForeColor = Color.Black;
        }
        
    }
}
