using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Pedido
    {

        private string idPedido;
        private string idCliente;
        private string idUsuario;
        private DateTime fechaEntrega;
        private float importeTotal;
        private float saldo;
        private float cuenta;
        private bool igv;


        public Pedido() { }
        public Pedido(string idPedido, string idCliente, string idUsuario, DateTime fechaEntrega, float importeTotal, float saldo, float cuenta, bool igv)
        {
            this.idPedido = idPedido;
            this.idCliente = idCliente;
            this.idUsuario = idUsuario;
            this.fechaEntrega = fechaEntrega;
            this.importeTotal = importeTotal;
            this.saldo = saldo;
            this.cuenta = cuenta;
            this.igv = igv;
        }

        public string IdPedido { get => idPedido; set => idPedido = value; }
        public string IdCliente { get => idCliente; set => idCliente = value; }
        public string IdUsuario { get => idUsuario; set => idUsuario = value; }
        public DateTime FechaEntrega { get => fechaEntrega; set => fechaEntrega = value; }
        public float ImporteTotal { get => importeTotal; set => importeTotal = value; }
        public float Saldo { get => saldo; set => saldo = value; }
        public float Cuenta { get => cuenta; set => cuenta = value; }
        public bool Igv { get => igv; set => igv = value; }



        /*
        public void MostrarDatosPedido()
        {
            Console.Write("ID Pedido: " + this.IDPedido + "\n" + "Aqui se imprime el cliente y el usuario segun sus id\n" +
                          "Fecha Registro: " + (this.FechaRegistro).ToString("HH:mm dd/MM/yyyy") + "\n" +
                          "Fecha Entrega Aproximada: " + (this.FechaEntrega).ToString("HH:mm dd/MM/yyyy") + "\n" +
                          "ImporteTotal: " + this.ImporteTotal + "\n" +
                          "Saldo: " + this.Saldo + "\n" +
                          "Cuenta: " + this.Cuenta + "\n" +
                          "ID Orden de Produccion asociado: " + this.IDOrdenProduccion + "\n" +
                          "Aqui va el detalle del pedido\n");
        }
        */
    }
}
