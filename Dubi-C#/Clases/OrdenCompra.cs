using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class OrdenCompra
    {
        private string idPedido;
        private string idProveedor;
        private string idUsuario;
        private DateTime fechaEntrega;
        private float costoTotal;
        private float costoNeto;
        private bool igv;
        private string estado;

        public OrdenCompra()
        {
        }

        public OrdenCompra(string idPedido, string idProveedor, string idUsuario, DateTime fechaEntrega, float costoTotal, float costoNeto, bool igv, string estado)
        {
            this.idPedido = idPedido;
            this.idProveedor = idProveedor;
            this.idUsuario = idUsuario;
            this.fechaEntrega = fechaEntrega;
            this.costoTotal = costoTotal;
            this.costoNeto = costoNeto;
            this.igv = igv;
            this.estado = estado;
        }

        public string IdPedido { get => idPedido; set => idPedido = value; }
        public string IdProveedor { get => idProveedor; set => idProveedor = value; }
        public string IdUsuario { get => idUsuario; set => idUsuario = value; }
        public DateTime FechaEntrega { get => fechaEntrega; set => fechaEntrega = value; }
        public float CostoTotal { get => costoTotal; set => costoTotal = value; }
        public float CostoNeto { get => costoNeto; set => costoNeto = value; }
        public bool Igv { get => igv; set => igv = value; }
        public string Estado { get => estado; set => estado = value; }
    }
}
