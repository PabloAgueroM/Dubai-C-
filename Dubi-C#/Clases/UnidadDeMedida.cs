using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class UnidadDeMedida
    {
        private int id;
        private string nombre;
        private int activo;

        public UnidadDeMedida(int id, string nombre, int activo)
        {
            this.Id = id;
            this.Nombre = nombre;
            this.Activo = activo;
        }

        public int Id { get => id; set => id = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public int Activo { get => activo; set => activo = value; }
    }
}
