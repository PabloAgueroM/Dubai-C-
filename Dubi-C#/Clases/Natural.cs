using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Natural : Persona
    {
        protected string dni;
        protected string nombre;
        protected string apPat;
        protected string apMat;
        protected char sexo;
        protected DateTime fechaNac;

        public string Dni { get => dni; set => dni = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string ApPat { get => apPat; set => apPat = value; }
        public string ApMat { get => apMat; set => apMat = value; }
        public char Sexo { get => sexo; set => sexo = value; }
        public DateTime FechaNac { get => fechaNac; set => fechaNac = value; }

        public Natural() : base() { }

        public Natural(string idPersona, string email, string telefono, string dni, string nombre, string apPat, string apMat, char sexo, DateTime fechaNac,string direccion)
        : base(idPersona, email, telefono,direccion)
        {
            this.dni = dni;
            this.nombre = nombre;
            this.apPat = apPat;
            this.apMat = apMat;
            this.sexo = sexo;
            this.fechaNac = fechaNac;
        }
    }
}