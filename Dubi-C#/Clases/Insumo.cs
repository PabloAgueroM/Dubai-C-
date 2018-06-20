using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    public class Insumo:ProductoGenerico
    {
        private int stockMin;

        public Insumo() { }

        public Insumo(int stockMin)
        {
            this.stockMin = stockMin;
        }

        public int StockMin { get => stockMin; set => stockMin = value; }
    }
}
