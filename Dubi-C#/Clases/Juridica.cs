using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Juridica : Persona
    {
        protected string razonSocial;
        protected string nombre;
        protected string ruc;
        protected DateTime fechaAniversario;

        public Juridica() : base() { }

        public Juridica(string idPersona, string email, string telefono, string razonSocial, string nombre, string ruc, DateTime fechaAniversario,string direccion)
        : base(idPersona, email, telefono,direccion)
        {
            this.RazonSocial = razonSocial;
            this.Nombre = nombre;
            this.Ruc = ruc;
            this.FechaAniversario = fechaAniversario;
        }
        
        public string RazonSocial { get => razonSocial; set => razonSocial = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Ruc { get => ruc; set => ruc = value; }
        public DateTime FechaAniversario { get => fechaAniversario; set => fechaAniversario = value; }
    }
}