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

        public BindingList<Natural> listarClientesNaturales() {
            BindingList<Natural> lista = new BindingList<Natural>();
            lista = accesoDatos.listarClienteNatural();
            return lista;
        }

        public BindingList<Juridica> listarClientesJuridicos()
        {
            BindingList<Juridica> lista = new BindingList<Juridica>();
            lista = accesoDatos.listarClienteJuridico();
            return lista;
        }

        public void actualizarClienteNatural(Natural c) {
            accesoDatos.actualizarClienteNatural(c);
        }


        public void actualizarClienteJuridico(Juridica c) {
            accesoDatos.actualizarClienteJuridico(c);
        }
        public void eliminarCliente(string id) {
            accesoDatos.eliminarCliente(id);
        }

    }
}
