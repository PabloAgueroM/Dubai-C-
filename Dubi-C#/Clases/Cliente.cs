using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Cliente
    {

        private string id;
        private string email;
        private string telefono;

        public Cliente( string _email, string _telefono)
        {
            email = _email;
            telefono = _telefono;
        }


    }
}
