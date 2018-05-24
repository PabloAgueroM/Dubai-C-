using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class verificador
    {
        public int verificarNombre(string s)
        {
            int contador = 0;
            foreach (char c in s)
            {
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) contador++;
            }
            if (contador == s.Length) return 1;
            else return 0;
        }

        public int verificarNumero(string s) {
            int contador = 0;
            foreach (char c in s)
            {
                if ((c >= '0' && c <= '9') ) contador++;
            }
            if (contador == s.Length) return 1;
            else return 0;
        }
        





    }
}
