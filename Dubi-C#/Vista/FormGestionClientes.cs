using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
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
            this.panel1.Visible = false;
            this.panel2.Visible = false;
            this.estadoBotones(0);            
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

        private void toolStripButton1_Click(object sender, EventArgs e)
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

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Juridica")
            {
                FormBuscarClienteJuridico buscar = new FormBuscarClienteJuridico();
                if (buscar.ShowDialog() == DialogResult.OK)
                {
                    textBox14.Text = buscar.ClienteSeleccionado.IdPersona;
                    textBox6.Text = buscar.ClienteSeleccionado.RazonSocial;
                    textBox7.Text = buscar.ClienteSeleccionado.Nombre;
                    textBox8.Text = buscar.ClienteSeleccionado.Ruc;
                    textBox9.Text = buscar.ClienteSeleccionado.Telefono;
                    textBox10.Text = buscar.ClienteSeleccionado.Email;
                    dateTimePicker2.Value = buscar.ClienteSeleccionado.FechaAniversario;
                    textBox13.Text = buscar.ClienteSeleccionado.Direccion;
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
                    textBox11.Text = buscar.ClienteSeleccionado.Dni;
                    textBox1.Text = buscar.ClienteSeleccionado.Nombre;
                    textBox2.Text = buscar.ClienteSeleccionado.ApPat;
                    textBox3.Text = buscar.ClienteSeleccionado.ApMat;
                    textBox4.Text = buscar.ClienteSeleccionado.Email;
                    textBox12.Text = buscar.ClienteSeleccionado.Direccion;
                    textBox5.Text = buscar.ClienteSeleccionado.Telefono;
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

        private void estadoBotones(int n) {
            switch (n)
            {
                case 0:
                    textBox1.Enabled = false;
                    textBox2.Enabled = false;
                    textBox3.Enabled = false;
                    textBox4.Enabled = false;
                    textBox5.Enabled = false;
                    dateTimePicker1.Enabled = false;
                    textBox6.Enabled = false;
                    textBox7.Enabled = false;
                    textBox8.Enabled = false;
                    textBox9.Enabled = false;
                    textBox10.Enabled = false;
                    textBox11.Enabled = false;
                    textBox12.Enabled = false;
                    textBox13.Enabled = false;
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox3.Text = "";
                    textBox4.Text = "";
                    textBox5.Text = "";
                    textBox6.Text = "";
                    textBox7.Text = "";
                    textBox8.Text = "";
                    textBox9.Text = "";
                    textBox10.Text = "";
                    textBox11.Text = "";
                    textBox12.Text = "";
                    textBox13.Text = "";
                    textBox14.Text = "";
                    textBox14.Enabled = false;
                    dateTimePicker2.Enabled = false;
                    toolStripButton1.Enabled = true;
                    toolStripButton2.Enabled = false;
                    toolStripButton3.Enabled = false;
                    toolStripButton4.Enabled = true;

                    break;
                case 1:
                    textBox1.Enabled = true;
                    textBox2.Enabled = true;
                    textBox3.Enabled = true;
                    textBox4.Enabled = true;
                    textBox5.Enabled = true;
                    dateTimePicker1.Enabled = true;
                    textBox6.Enabled = true;
                    textBox7.Enabled = true;
                    textBox8.Enabled = true;
                    textBox9.Enabled = true;
                    textBox10.Enabled = true;
                    textBox11.Enabled = true;
                    textBox12.Enabled = true;
                    textBox13.Enabled = true;
                    textBox14.Enabled = false;
                    dateTimePicker2.Enabled = true;
                    toolStripButton1.Enabled = false;
                    toolStripButton2.Enabled = true;
                    toolStripButton3.Enabled = true;
                    toolStripButton4.Enabled = false;
                    break;
                case 2:
                    textBox1.Enabled = true;
                    textBox2.Enabled = true;
                    textBox3.Enabled = true;
                    textBox4.Enabled = true;
                    textBox5.Enabled = true;
                    dateTimePicker1.Enabled = true;
                    textBox6.Enabled = true;
                    textBox7.Enabled = true;
                    textBox8.Enabled = true;
                    textBox9.Enabled = true;
                    textBox10.Enabled = true;
                    textBox11.Enabled = true;
                    textBox12.Enabled = true;
                    textBox13.Enabled = true;
                    dateTimePicker2.Enabled = true;
                    toolStripButton1.Enabled = false;
                    toolStripButton2.Enabled = true;
                    toolStripButton3.Enabled = true;
                    toolStripButton1.Enabled = false;
                    break;

            }

        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            this.estadoBotones(0);
        }

        

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            
            if (textBox14.Text == "")
            {
                if (comboBox1.Text == "Juridica")
                {                    
                    if (textBox6.Text != "" && textBox7.Text != "" && textBox8.Text != "" && textBox9.Text != ""
                        && textBox10.Text != "" && textBox13.Text != "")
                    {
                        Juridica c = new Juridica();
                        c.RazonSocial = textBox6.Text;
                        c.Nombre = textBox7.Text;
                        c.Ruc = textBox8.Text;
                        c.Telefono = textBox9.Text;
                        c.Email = textBox10.Text;
                        c.Direccion = textBox13.Text;
                        c.FechaAniversario = dateTimePicker2.Value;
                        if (v.verificarNombre(c.RazonSocial) == 0) { MessageBox.Show("Razon Social invalida"); return; }
                        if (v.verificarNombre(c.Nombre) == 0) { MessageBox.Show("Nombre invalida"); return; }
                        if (v.verificarNumero(c.Ruc) == 0) { MessageBox.Show("RUC invalido"); return; }
                        if (v.verificarNumero(c.Telefono) == 0) { MessageBox.Show("Telefono invalido"); return; }


                        int id = logicaNegocio.registrarClienteJuridico(c);
                        this.estadoBotones(0);
                        MessageBox.Show("Cliente registrado satisfactoriamente");
                    }
                    else {
                        MessageBox.Show("Faltan llenar campos");
                    }                    
                }
                else
                {
                    if (textBox1.Text != "" && textBox2.Text != "" && textBox3.Text != "" && textBox4.Text != ""
                        && textBox5.Text != "" && textBox11.Text != "" && textBox12.Text != "" &&
                        (radioButton1.Checked == true || radioButton2.Checked == true))
                    {
                        Natural c = new Natural();
                        c.Nombre = textBox1.Text;
                        c.Dni = textBox11.Text;
                        c.ApPat = textBox2.Text;
                        c.ApMat = textBox3.Text;
                        c.Email = textBox4.Text;
                        c.Telefono = textBox5.Text;
                        c.FechaNac = dateTimePicker1.Value;
                        c.Direccion = textBox12.Text;
                        if (radioButton1.Checked == true) c.Sexo = 'M';
                        else if (radioButton2.Checked == true) c.Sexo = 'F';


                        if (v.verificarNumero(c.Dni) == 0) { MessageBox.Show("DNI invalid0"); return; }
                        if (v.verificarNombre(c.Nombre) == 0) { MessageBox.Show("Nombre  invalido"); return; }
                        if (v.verificarNombre(c.ApMat) == 0) { MessageBox.Show("Apellido materno invalido"); return; }
                        if (v.verificarNombre(c.ApPat) == 0) { MessageBox.Show("Apellido paterno invalido"); return; }
                        if (v.verificarNumero(c.Telefono) == 0) { MessageBox.Show("Telefono  invalido"); return; }

                        int id = logicaNegocio.registrarClienteNatural(c);
                        this.estadoBotones(0);
                        MessageBox.Show("Cliente registrado satisfactoriamente");
                    }
                    else {
                        MessageBox.Show("Faltan llenar campos");
                    }
                }  
            }
            else {
                if (comboBox1.Text == "Juridica")
                {
                    Juridica c = new Juridica();
                    c.RazonSocial = textBox6.Text;
                    c.Nombre = textBox7.Text;
                    c.Ruc = textBox8.Text;
                    c.Telefono = textBox9.Text;
                    c.Email = textBox10.Text;
                    c.Direccion = textBox13.Text;
                    c.IdPersona = textBox14.Text;
                    c.FechaAniversario = dateTimePicker2.Value;

                    if (v.verificarNombre(c.RazonSocial) == 0) { MessageBox.Show("Razon Social invalida"); return; }
                    if (v.verificarNombre(c.Nombre) == 0) { MessageBox.Show("Nombre invalida"); return; }
                    if (v.verificarNumero(c.Ruc) == 0) { MessageBox.Show("RUC invalido"); return; }
                    if (v.verificarNumero(c.Telefono) == 0) { MessageBox.Show("Telefono invalido"); return; }

                    logicaNegocio.actualizarClienteJuridico(c);
                    this.estadoBotones(0);
                }
                else
                {
                    Natural c = new Natural();
                    c.Nombre = textBox1.Text;
                    c.Dni = textBox11.Text;
                    c.ApPat = textBox2.Text;
                    c.ApMat = textBox3.Text;
                    c.Email = textBox4.Text;
                    c.Telefono = textBox5.Text;
                    c.FechaNac = dateTimePicker1.Value;
                    c.Direccion = textBox12.Text;
                    c.IdPersona = textBox14.Text;
                    if (radioButton1.Checked == true) c.Sexo = 'M';
                    else if (radioButton2.Checked == true) c.Sexo = 'F';

                    if (v.verificarNumero(c.Dni) == 0) { MessageBox.Show("DNI invalid0"); return; }
                    if (v.verificarNombre(c.Nombre) == 0) { MessageBox.Show("Nombre  invalido"); return; }
                    if (v.verificarNombre(c.ApMat) == 0) { MessageBox.Show("Apellido materno invalido"); return; }
                    if (v.verificarNombre(c.ApPat) == 0) { MessageBox.Show("Apellido paterno invalido"); return; }
                    if (v.verificarNumero(c.Telefono) == 0) { MessageBox.Show("Telefono  invalido"); return; }

                    logicaNegocio.actualizarClienteNatural(c);
                    this.estadoBotones(0);
                }
                MessageBox.Show("Cliente actualizado satisfactoriamente");
            }
            

        }
        
    }
}
