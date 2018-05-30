/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Insumo;
import Modelo.Proveedor;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Pablo
 */
public class InsumoDA {
    public int registrarInsumo(Insumo i, Proveedor p, double precioProveedor) throws SQLException{
        int idInsumo = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection      
                ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cStmt = con.prepareCall("{call REGISTRAR_INSUMO(?,?,?,?,?,?,?,?,?,?,?)}");
            cStmt.registerOutParameter("_ID_PRODUCTO", java.sql.Types.INTEGER);
            cStmt.setString("_NOMBRE", i.getNombre());
            cStmt.setString("_DESCRIPCION", i.getDescripcion());
            cStmt.setString("_COLOR", i.getColor());
            cStmt.setDouble("_STOCK_MINIMO", i.getStockMinimo());
            cStmt.setDouble("_PRECIO_REFERENCIAL", i.getPrecio());
            cStmt.setInt("_ID_UNIDAD_MEDIDA", i.getUnidad().getId());  
            cStmt.setInt("_ID_TIPO_PRODUCTO", i.getTipo().getId());  
            cStmt.setInt("_ACTIVO", i.isActivo());  
            cStmt.setInt("_ID_PROVEEDOR", Integer.parseInt(p.getIDProveedor())); //Considerar modificaciones en la tabla e incluir el id de proveedor como int
            cStmt.setDouble("_PRECIO_PROVEEDOR", precioProveedor);
            cStmt.execute();
            idInsumo = cStmt.getInt("_ID_PRODUCTO");
            con.close();     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idInsumo;
    }
  
    public ArrayList<Insumo> listarInsumos() throws SQLException{
        ArrayList<Insumo> lista = new ArrayList<Insumo>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cStmt = con.prepareCall("{call LISTAR_INSUMOS()}");
            ResultSet rs = cStmt.executeQuery();
            while (rs.next()){
                Insumo i = new Insumo();
                i.setIdInsumo(rs.getInt("ID_PRODUCTO"));
                i.setNombre(rs.getString("NOMBRE"));
                i.setDescripcion(rs.getString("DESCRIPCION"));
                i.setColor(rs.getString("COLOR"));
                i.setStockMinimo(rs.getInt("STOCK_MINIMO"));
                //Setear Tipo y UMed
                lista.add(i);
            }
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
