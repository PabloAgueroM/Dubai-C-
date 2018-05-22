using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Juridica : Persona
    {
        protected string idJuridica;
        protected string razonSocial;
        protected string nombre;
        protected string ruc;
        protected DateTime fechaAniversario;

        public Juridica() : base() { }

        public Juridica(string idPersona, string email, string telefono, string idJuridica, string razonSocial, string nombre, string ruc, DateTime fechaAniversario)
        : base(idPersona, email, telefono)
        {
            this.IdJuridica = idJuridica;
            this.RazonSocial = razonSocial;
            this.Nombre = nombre;
            this.Ruc = ruc;
            this.FechaAniversario = fechaAniversario;
        }

        public string IdJuridica { get => idJuridica; set => idJuridica = value; }
        public string RazonSocial { get => razonSocial; set => razonSocial = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Ruc { get => ruc; set => ruc = value; }
        public DateTime FechaAniversario { get => fechaAniversario; set => fechaAniversario = value; }
    }
}
