using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Usuario
    {
        private int id;
        private String nombre;
        private String apPat;
        private String apMat;
        private DateTime fechaNac;
        private String password;
        private String tipo;

        public Usuario(int id, string nombre, string apPat, string apMat, DateTime fechaNac, string password, string tipo)
        {
            this.Id = id;
            this.Nombre = nombre;
            this.ApPat = apPat;
            this.ApMat = apMat;
            this.FechaNac = fechaNac;
            this.Password = password;
            this.Tipo = tipo;
        }

        public int Id { get => id; set => id = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string ApPat { get => apPat; set => apPat = value; }
        public string ApMat { get => apMat; set => apMat = value; }
        public DateTime FechaNac { get => fechaNac; set => fechaNac = value; }
        public string Password { get => password; set => password = value; }
        public string Tipo { get => tipo; set => tipo = value; }
    }
}
