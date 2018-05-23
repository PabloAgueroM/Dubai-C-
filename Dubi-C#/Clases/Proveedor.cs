using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Proveedor : Juridica
    {
        protected string idProveedor;
        protected Natural representante;

        public string IdProveedor { get => idProveedor; set => idProveedor = value; }
        public Natural Representante { get => representante; set => representante = value; }

        public Proveedor() { }

        public Proveedor(string idProveedor, Natural representante)
        {
            this.IdProveedor = idProveedor;
            this.Representante = representante;
        }
    }
}
