/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Producto;
import Modelo.TipoProductoG;
import Modelo.UnidadDeMedida;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Katherine Espinoza 20122127
 */
public class ProductoDA {

    public int registrarProducto(Producto p) {
        try {
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call INSERTAR_PRODUCTO(?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(2, p.getNombre());
            cs.setString(3, p.getDescripcion());
            cs.setString(4, Character.toString(p.getTalla()));
            cs.setString(5, p.getColor());
            cs.setDouble(6, p.getPrecio());
            cs.setDouble(7, p.getStockActual());
            cs.setInt(8, p.getTipo().getId());
            cs.setInt(9, p.getUnidad().getId());
            cs.setInt(10, p.isActivo());
            cs.executeUpdate();
            p.setId(cs.getInt(1));

            System.out.println("Registro realizado");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p.getId();
    }

    public void modificarInsumo(Producto p) {
        try {
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call MODIFICAR_PRODUCTO(?,?,?,?,?,?,?,?,?,?)}");
            cs.setDouble(1, p.getId());
            cs.setString(2, p.getNombre());
            cs.setString(3, p.getDescripcion());
            cs.setString(4, Character.toString(p.getTalla()));
            cs.setString(5, p.getColor());
            cs.setDouble(6, p.getPrecio());
            cs.setDouble(7, p.getStockActual());
            cs.setInt(8, p.isActivo());
            cs.setInt(9, p.getTipo().getId());
            cs.setInt(10, p.getUnidad().getId());
            cs.executeUpdate();
            System.out.println("Registro actualizado");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call LISTAR_PRODUCTOS()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("ID_PRODUCTO"));
                p.setNombre(rs.getString("NOMBRE"));
                p.setDescripcion(rs.getString("DESCRIPCION"));
                p.setTalla(rs.getString("TALLA").charAt(0));
                p.setColor(rs.getString("COLOR"));
                p.setPrecio(rs.getDouble("PRECIO"));
                p.setStockActual(rs.getDouble("STOCK_ACTUAL"));
                p.setActivo(rs.getInt("ACTIVO"));
                
                CallableStatement cs_u = con.prepareCall("{BUSCA_UNIDAD_MEDIDA(?,?,?)}");
                cs_u.setInt(1, rs.getInt("ID_UNIDAD_MEDIDA"));
                cs.executeUpdate();                
                p.setUnidad(new UnidadDeMedida());
                p.getUnidad().setId(rs.getInt("ID_UNIDAD_MEDIDA"));
                p.getUnidad().setNombre(cs_u.getString(2));
                p.getUnidad().setActivo(cs_u.getInt(3));
                
                CallableStatement cs_t = con.prepareCall("{BUSCA_TIPO_PRODUCTO(?,?,?)}");
                cs_u.setInt(1, rs.getInt("ID_TIPO_PRODUCTO"));
                cs.executeUpdate();                
                p.setTipo(new TipoProductoG());                
                p.getTipo().setId(cs_t.getInt("ID_TIPO_PRODUCTO"));
                p.getTipo().setNombre(cs_t.getString(2));
                p.getTipo().setActivo(cs_t.getInt(3)); 
                lista.add(p);
            }
            con.close();
        } catch (Exception e) {

        }
        return lista;
    }
    public ArrayList<TipoProductoG> listarTipoProducto(){
        ArrayList<TipoProductoG> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call LISTAR_TIPO_PRODUCTO()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                TipoProductoG tp = new TipoProductoG();
                tp.setId(rs.getInt("ID_TIPO_PRODUCTO"));
                tp.setNombre(rs.getString("NOMBRE"));
                tp.setActivo(rs.getInt("ACTIVO"));
                lista.add(tp);
            }
            con.close();
        } catch (Exception e) {

        }
        return lista;
    }
    public ArrayList<UnidadDeMedida> listarUnidadMedida(){
        ArrayList<UnidadDeMedida> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call LISTAR_UNIDAD_MEDIDA()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                UnidadDeMedida u = new UnidadDeMedida();
                u.setId(rs.getInt("ID_UNIDAD_MEDIDA"));
                u.setNombre(rs.getString("NOMBRE"));
                u.setActivo(rs.getInt("ACTIVO"));                
                lista.add(u);
            }
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }
}
