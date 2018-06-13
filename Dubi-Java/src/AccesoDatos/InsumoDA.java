/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Insumo;
import Modelo.Proveedor;
import Modelo.ProveedorxInsumo;
import Modelo.TipoProductoG;
import Modelo.UnidadDeMedida;

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
    
    public UnidadDeMedida buscarUnidadMedida(int idUnidadMedida) throws SQLException{
        UnidadDeMedida um = new UnidadDeMedida();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection      
                ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cStmt = con.prepareCall("{call BUSCA_UNIDAD_MEDIDA(?,?,?)}");
            cStmt.registerOutParameter("_NOMBRE", java.sql.Types.VARCHAR);
            cStmt.registerOutParameter("_ACTIVO", java.sql.Types.TINYINT);
            cStmt.setInt("_ID_UNIDAD_MEDIDA", idUnidadMedida);
 
            cStmt.execute();
            String nombre = cStmt.getString("_NOMBRE");
            int activo = cStmt.getInt("_ACTIVO");
            um.setId(idUnidadMedida);
            um.setNombre(nombre);
            um.setActivo(activo);
            con.close();     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return um;
    }
    
    public TipoProductoG buscarTipoProductoG(int idTipoProducto) throws SQLException{
        TipoProductoG tp = new TipoProductoG();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection      
                ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cStmt = con.prepareCall("{call BUSCA_TIPO_PRODUCTO(?,?,?)}");
            cStmt.registerOutParameter("_NOMBRE", java.sql.Types.VARCHAR);
            cStmt.registerOutParameter("_ACTIVO", java.sql.Types.TINYINT);
            cStmt.setInt("_ID_TIPO_PRODUCTO", idTipoProducto);
 
            cStmt.execute();
            String nombre = cStmt.getString("_NOMBRE");
            int activo = cStmt.getInt("_ACTIVO");
            tp.setId(idTipoProducto);
            tp.setNombre(nombre);
            tp.setActivo(activo);
            con.close();     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tp;
    }
    
    
    public int registrarInsumo(Insumo i) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection      
                ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cStmt = con.prepareCall("{call REGISTRAR_INSUMO(?,?,?,?,?,?,?,?,?)}");
            cStmt.registerOutParameter("_ID_PRODUCTO", java.sql.Types.INTEGER);
            cStmt.setString("_NOMBRE", i.getNombre());
            cStmt.setString("_DESCRIPCION", i.getDescripcion());
            cStmt.setString("_COLOR", i.getColor());
            cStmt.setDouble("_STOCK_MINIMO", i.getStockMinimo());
            cStmt.setDouble("_PRECIO_REFERENCIAL", i.getPrecio());
            cStmt.setInt("_ID_UNIDAD_MEDIDA", i.getUnidad().getId());  
            cStmt.setInt("_ID_TIPO_PRODUCTO", i.getTipo().getId());  
            cStmt.setInt("_ACTIVO", i.isActivo());  
            cStmt.execute();
            i.setId(cStmt.getInt("_ID_PRODUCTO"));
            con.close();     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i.getId();
    }
  
    public void modificarInsumo(Insumo i)throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection      
                ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cStmt = con.prepareCall("{call MODIFICAR_INSUMO(?,?,?,?,?,?,?,?)}");
            cStmt.setInt("_ID_PRODUCTO", i.getId());
            cStmt.setString("_NOMBRE", i.getNombre());
            cStmt.setString("_DESCRIPCION", i.getDescripcion());
            cStmt.setString("_COLOR", i.getColor());
            cStmt.setDouble("_STOCK_MINIMO", i.getStockMinimo());
            cStmt.setDouble("_PRECIO_REFERENCIAL", i.getPrecio());
            cStmt.setInt("_ID_UNIDAD_MEDIDA", i.getUnidad().getId());  
            cStmt.setInt("_ID_TIPO_PRODUCTO", i.getTipo().getId());  
            cStmt.setInt("_ID_INSUMO", java.sql.Types.INTEGER); 
            cStmt.execute();
            con.close();     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarInsumo(Insumo i)throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection      
                ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cStmt = con.prepareCall("{call ELIMINAR_INSUMO(?)}");
            cStmt.setInt("_ID_PRODUCTO", java.sql.Types.INTEGER); 
            cStmt.execute();
            con.close();     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                i.setId(rs.getInt("ID_INSUMO"));
                i.setNombre(rs.getString("NOMBRE"));
                i.setDescripcion(rs.getString("DESCRIPCION"));
                i.setColor(rs.getString("COLOR"));
                i.setPrecio(rs.getDouble("PRECIO"));
                i.setStockMinimo(rs.getDouble("STOCK_MINIMO"));
                i.setActivo(rs.getInt("ACTIVO"));
                int idTipoPro = rs.getInt("ID_TIPO_PRODUCTO");
                int idUniMed = rs.getInt("ID_UNIDAD_MEDIDA");
                TipoProductoG tp = buscarTipoProductoG(idTipoPro);
                i.setTipo(tp);
                UnidadDeMedida um = buscarUnidadMedida(idUniMed);
                i.setUnidad(um);
                //Setear Tipo y UMed
                lista.add(i);
            }
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public ArrayList<ProveedorxInsumo> listarProveedoresXInsumo(int idInsumo) throws SQLException{
        ProveedorDA proveedorDa = new ProveedorDA();
        ArrayList<ProveedorxInsumo> lista = new ArrayList<ProveedorxInsumo>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cStmt = con.prepareCall("{call LISTAR_PROVEEDOR_X_INSUMO(?)}");
            cStmt.setInt("_ID_INSUMO", idInsumo);
            ResultSet rs = cStmt.executeQuery();
            while (rs.next()){
                ProveedorxInsumo pXi = new ProveedorxInsumo();
                
                int idProveedor = rs.getInt("ID_PROVEEDOR");
                pXi.setPrecio(rs.getDouble("PRECIO"));
                
                ArrayList<Proveedor> proveedores = proveedorDa.listarProveedor();
                for(int i=0; i< proveedores.size();i++){
                    if(idProveedor == Integer.parseInt(proveedores.get(i).getIDProveedor())){
                        pXi.setProveedor(proveedores.get(i));
                        break;
                    }
                }
                
                lista.add(pXi);      
            }
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }    
    
}
