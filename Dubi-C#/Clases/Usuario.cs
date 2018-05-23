using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Usuario : Natural
    {
        protected int idUsuario;
        protected int tipoUsuario;
        protected String password;
        protected int estadoU;

        public Usuario() { }
        public Usuario(string idPersona, string email, string telefono, string dni, string nombre, string apPat, string apMat, char sexo, DateTime fechaNac, int idUsuario, int tipoUsuario, string password, int estadoU)
        : base(idPersona, email, telefono, dni, nombre, apPat, apMat, sexo, fechaNac)
        {
            this.idUsuario = idUsuario;
            this.tipoUsuario = tipoUsuario;
            this.password = password;
            this.estadoU = estadoU;
        }

        public int IdUsuario { get => idUsuario; set => idUsuario = value; }
        public int TipoUsuario { get => tipoUsuario; set => tipoUsuario = value; }
        public string Password { get => password; set => password = value; }
        public int EstadoU { get => estadoU; set => estadoU = value; }
    }
}
