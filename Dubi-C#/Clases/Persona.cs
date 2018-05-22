using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Persona
    {
        protected string idPersona;
        protected string email;
        protected string telefono;

        public string IdPersona { get => idPersona; set => idPersona = value; }
        public string Email { get => email; set => email = value; }
        public string Telefono { get => telefono; set => telefono = value; }

        public Persona() { }

        public Persona(string idPersona, string email, string telefono)
        {
            this.idPersona = idPersona;
            this.email = email;
            this.telefono = telefono;
        }
    }
}
