using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AccesoDatos;
using Clases;

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

        public int listarUsuarios()
        {
            return 0;
        }
    }
}