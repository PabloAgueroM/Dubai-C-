using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Persona
    {
        public int idPersona;
        public String dni;
        public String nombre;
        public String apPat;
        public String apMat;
        public char sexo;
        public DateTime fechaNac;
        public int estadoP;

        public int IdPersona { get => idPersona; set => idPersona = value; }
        public string Dni { get => dni; set => dni = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string ApPat { get => apPat; set => apPat = value; }
        public string ApMat { get => apMat; set => apMat = value; }
        public char Sexo { get => sexo; set => sexo = value; }
        public DateTime FechaNac { get => fechaNac; set => fechaNac = value; }
        public int EstadoP { get => estadoP; set => estadoP = value; }

        public Persona(int id, string dni, string nombre, string apPat, string apMat, char sexo, DateTime fechaNac, int estado)
        {
            this.idPersona = id;
            this.dni = dni;
            this.nombre = nombre;
            this.apPat = apPat;
            this.apMat = apMat;
            this.sexo = sexo;
            this.fechaNac = fechaNac;
            this.estadoP = estado;
        }
    }
}
