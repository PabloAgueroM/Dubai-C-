using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AccesoDatos;
using Clases;
using System.ComponentModel;

namespace LogicaNegocio
{
    public class ClienteBL
    {
        private ClienteDA accesoDatos;

        public ClienteBL()
        {
            accesoDatos = new ClienteDA();
        }

        public int registrarClienteNatural(Natural c) {
            return accesoDatos.registrarClienteNatural(c);
        }

        public int registrarClienteJuridico(Juridica c)
        {
            return accesoDatos.registrarClienteJuridico(c);
        }

        public BindingList<Persona> listarClientes() {
            BindingList<Persona> lista = new BindingList<Persona>();
            return lista;
        }

        public void modificarCliente() {

        }


        public void eliminarCliente() {

        }


    }
}
