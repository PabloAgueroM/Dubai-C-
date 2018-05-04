using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Usuario : Persona
    {
        private int idUsuario;
        private int tipoUsuario;
        private String password;
        private int estadoU;

        public Usuario(int id, string dni, string nombre, string apPat, string apMat, char sexo, DateTime fechaNac, int estadoP, int idUsuario, int tipoUsuario, string password, int estadoU) : base(id, dni, nombre, apPat, apMat, sexo, fechaNac, estadoP)

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
