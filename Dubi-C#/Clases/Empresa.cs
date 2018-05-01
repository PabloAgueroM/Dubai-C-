using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Empresa:Cliente
    {
        private string razon;
        private string descripcion;


        public Empresa(string razon,string descripcion,string email,string telefono) : base(email, telefono) {
            this.razon = razon;
            this.descripcion = descripcion;
        }

    }
}
