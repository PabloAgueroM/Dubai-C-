using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Natural : Cliente
    {
        private string nombre;
        private string apellidoP;
        private string apellidoM;

        public Natural(string _nombres, string _apellidoP, string _apellidoM, string _email, string _telefono) : base(_email, _telefono){
            this.nombre = _nombres;
            this.apellidoP  = _apellidoP;
            this.apellidoM = _apellidoM;
        }

        public string getNombre() { return nombre; }
        public string getapellidoP() { return apellidoP; }
        public string getapellidoM() { return apellidoM; }
    }
}
