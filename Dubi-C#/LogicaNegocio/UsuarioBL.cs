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
    public class UsuarioBL
    {
        private UsuarioDA accesoDatos;

        public UsuarioBL() { accesoDatos = new UsuarioDA(); }

        public int registrarUsuario(Usuario u)
        {
            return accesoDatos.registrarUsuario(u);
        }

        public BindingList<Usuario> listarUsuarios()
        {
            return accesoDatos.listarUsuarios();
        }
        public BindingList<Usuario> listarTodosUsuarios()
        {
            return accesoDatos.listarTodosUsuarios();
        }

        public void eliminarUsuario(string id)
        {
            accesoDatos.eliminarUsuario(id);
        }

        public int modificarUsuario(Usuario user)
        {
            return accesoDatos.modificarUsuario(user);
        }
    }
}