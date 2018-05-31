/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.InsumoxProducto;
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
            CallableStatement cs = con.prepareCall("{call REGISTRAR_PRODUCTO(?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(2, p.getNombre());
            cs.setString(3, p.getDescripcion());
            cs.setString(4, Character.toString(p.getTalla()));
            cs.setString(5, p.getColor());
            cs.setDouble(6, p.getPrecio());
            cs.setDouble(7, p.getStockActual());
            cs.setInt(8, p.getTipo().getId());
            cs.setInt(9, p.getUnidad().getId());
            cs.setInt(10, p.isActivo());
            cs.execute();
            p.setId(cs.getInt(1));
            for(InsumoxProducto ip: p.getLista())
                agregarInsumoXProducto(p.getId(), ip);
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
            try (Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45")) {
                CallableStatement cs = con.prepareCall("{call MODIFICAR_PRODUCTO(?,?,?,?,?,?,?,?,?,?)}");
                cs.setInt(1, p.getId());
                cs.setString(2, p.getNombre());
                cs.setString(3, p.getDescripcion());
                cs.setString(4, Character.toString(p.getTalla()));
                cs.setString(5, p.getColor());
                cs.setDouble(6, p.getPrecio());
                cs.setDouble(7, p.getStockActual());
                cs.setInt(8, p.getUnidad().getId());
                cs.setInt(9, p.getTipo().getId());
                cs.setInt(10, p.isActivo());
                cs.executeUpdate();
            }
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
                p.setUnidad(new UnidadDeMedida());
                p.getUnidad().setId(rs.getInt("ID_UNIDAD_MEDIDA"));
                p.setTipo(new TipoProductoG());
                p.getTipo().setId(rs.getInt("ID_TIPO_PRODUCTO"));

                CallableStatement cs_t = con.prepareCall("{call BUSCA_TIPO_PRODUCTO(?,?,?)}");
                cs_t.setInt(1, rs.getInt("ID_TIPO_PRODUCTO"));
                cs_t.execute();
                p.getTipo().setNombre(cs_t.getString("_NOMBRE"));
                p.getTipo().setActivo(cs_t.getInt("_ACTIVO"));

                CallableStatement cs_u = con.prepareCall("{call BUSCA_UNIDAD_MEDIDA(?,?,?)}");
                cs_u.setInt(1, rs.getInt("ID_UNIDAD_MEDIDA"));
                cs_u.execute();
                p.getUnidad().setNombre(cs_u.getString("_NOMBRE"));
                p.getUnidad().setActivo(cs_u.getInt("_ACTIVO"));
                lista.add(p);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<TipoProductoG> listarTipoProducto() {
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
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<UnidadDeMedida> listarUnidadMedida() {
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
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public void agregarInsumoXProducto(int idProducto, InsumoxProducto ip) {
        try {
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call REGISTRAR_INSUMO_X_PRODUCTO(?,?,?)}");
            cs.setInt(1, ip.getIdInsumo());
            cs.setInt(2, idProducto);
            cs.setDouble(3, ip.getCantidad());
            cs.execute();
            System.out.println("Insumo por Producto insertado (" + ip.getDescripcion() + ")");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarInsumoXProducto(int idProducto,InsumoxProducto ip) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            String query = "UPDATE INSUMO_X_PRODUCTO SET CANTIDAD_INSUMO=? WHERE ID_INSUMO=? AND ID_PRODUCTO=?";
            PreparedStatement sentencia = con.prepareStatement(query);
            sentencia.setDouble(1, ip.getCantidad());
            sentencia.setInt(1, ip.getIdInsumo());
            sentencia.setInt(1, idProducto);
            sentencia.executeUpdate();
            System.out.println("Registro actualizado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void eliminarInsumoXProducto(int idProducto,int idInsumo) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            String query = "DELETE FROM INSUMO_X_PRODUCTO WHERE ID_INSUMO=? AND ID_PRODUCTO=?";
            PreparedStatement sentencia = con.prepareStatement(query);
            sentencia.setInt(1, idInsumo);
            sentencia.setInt(2, idProducto);
            sentencia.executeUpdate();
            System.out.println("Registro eliminado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<InsumoxProducto> listarInsumoXProducto(int idProducto) {
        ArrayList<InsumoxProducto> lista = new ArrayList<>();
        try {
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call LISTAR_INSUMO_X_PRODUCTO(?)}");
            cs.setInt(1, idProducto);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                InsumoxProducto ip = new InsumoxProducto();
                ip.setIdInsumo(rs.getInt("ID_INSUMO"));
                ip.setDescripcion(rs.getString("DESCRIPCION"));
                ip.setIdInsumo(rs.getInt("CANTIDAD_INSUMO"));
                lista.add(ip);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}

