/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;
import Modelo.Insumo;
import Modelo.Proveedor;
import Modelo.ProveedorxInsumo;
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
public class Proveedor_X_Insumo_DA {
    public void registrarProveedorXInsumo(int idInsumo,ProveedorxInsumo pXi,int activo) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection      
                ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cStmt = con.prepareCall("{call REGISTRAR_PROVEEDOR_X_INSUMO(?,?,?,?)}");
            cStmt.setInt("_ID_INSUMO", idInsumo);
            cStmt.setInt("_ID_PROVEEDOR", Integer.parseInt(pXi.getProveedor().getIDProveedor()));
            cStmt.setDouble("_PRECIO_PROVEEDOR", pXi.getPrecio());
            cStmt.setInt("_ACTIVO",activo);

            cStmt.execute();

            con.close();     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarProveedorXInsumo(int idInsumo,ProveedorxInsumo pXi,int activo)throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection      
                ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cStmt = con.prepareCall("{call MODIFICAR_PROVEEDOR_X_INSUMO(?,?,?,?)}");
            cStmt.setInt("_ID_INSUMO", idInsumo);
            cStmt.setInt("_ID_PROVEEDOR", Integer.parseInt(pXi.getProveedor().getIDProveedor()));
            cStmt.setDouble("_PRECIO_PROVEEDOR", pXi.getPrecio());
            cStmt.setInt("_ACTIVO",activo);

            cStmt.execute();

            con.close();     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
