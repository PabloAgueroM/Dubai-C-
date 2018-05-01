using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Pedido
    {

        private string _IDPedido;
        private string _IDCliente;
        private string _IDUsuario;
        private string _IDOrdenProduccion;
        private string _FechaRegistro;
        private DateTime _FechaEntrega;
        private float _ImporteTotal;
        private float _Saldo;
        private float _Cuenta;
        private bool _IGV;

        public string IDPedido { get { return _IDPedido; } set { _IDPedido = value; } }
        public string IDCliente { get { return _IDCliente; } set { _IDCliente = value; } }
        public string IDUsuario { get { return _IDUsuario; } set { _IDUsuario = value; } }
        public string IDOrdenProduccion { get { return _IDOrdenProduccion; } set { _IDOrdenProduccion = value; } }
        public string FechaRegistro { get { return _FechaRegistro; } set { _FechaRegistro = value; } }
        public DateTime FechaEntrega { get { return _FechaEntrega; } set { _FechaEntrega = value; } }
        public float ImporteTotal { get { return _ImporteTotal; } set { _ImporteTotal = value; } }
        public float Saldo { get { return _Saldo; } set { _Saldo = value; } }
        public float Cuenta { get { return _Cuenta; } set { _Cuenta = value; } }
        public bool IGV { get { return _IGV; } set { _IGV = value; } }

        public Pedido()
        {

        }

        public Pedido(string _IDPedido, string _IDCliente, string _IDUsuario, string _IDOrdenProduccion, string _FechaRegistro,
                        DateTime _FechaEntrega, float _ImporteTotal, float _Saldo, float _Cuenta, bool _IGV)
        {
            this._IDPedido = _IDPedido;
            this._IDCliente = _IDCliente;
            this._IDUsuario = _IDUsuario;
            this._IDOrdenProduccion = _IDOrdenProduccion;
            this._FechaRegistro = _FechaRegistro;
            this._FechaEntrega = _FechaEntrega;
            this._ImporteTotal = _ImporteTotal;
            this._Saldo = _Saldo;
            this._Cuenta = _Cuenta;
            this._IGV = _IGV;
        }


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
