/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.*;
import Modelo.PersonaJuridica;
import Modelo.PersonaNatural;
import Modelo.Proveedor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.collections4.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author alulab14
 */
public class ReportesBL {   
    
    private ReportesDA accesoDatos;
    
    public ReportesBL(){
        accesoDatos = new ReportesDA();
    }
    
    public int reporteVentasTotales(PersonaNatural natural,PersonaJuridica juridica){
        String id = "", nombre = "", documento = "",email = "", telef = "";
        if(natural!=null || juridica!= null){
            if(natural!=null){
                id = natural.getIdPersona();
                nombre = natural.getNombre() + " "+ natural.getApellidoP() + " "+ natural.getApellidoM();
                documento = "DNI: " + natural.getDNI();
                email = natural.getEmail();
                telef = natural.getTelefono();
            }
            else if(juridica !=null){
                id = juridica.getIdPersona();
                nombre = juridica.getNombre();
                documento = "RUC: " + juridica.getRUC();
                email = juridica.getEmail();
                telef = juridica.getTelefono();
            }
            else return 0;
        }else return 0;
        try {
            ArrayList listaDatos = accesoDatos.listaVentasTotales(Integer.parseInt(id));
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Reporte de Ventas");
            CellStyle style;
            Row row;
            Cell cell;
            short rowNum = 0;
            short colNum = 0;
            
            row = sheet.createRow(rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Cliente:");
            cell = row.createCell((short)2);
            cell.setCellValue(nombre);
        
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue(documento);
            
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Email:");
            cell = row.createCell((short)2);
            cell.setCellValue(email);
            
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Telefono:");
            cell = row.createCell((short)2);
            cell.setCellValue(telef);
            String pedidoAnterior = "";
            rowNum++;
            boolean primero = true;
            float totalPedido =0;
            float total=0;
            for(int i = 0; i<listaDatos.size(); i++){
                row = sheet.createRow((short) i+rowNum);
                ArrayList col = (ArrayList)(listaDatos.get(i));
                if(!pedidoAnterior.equals((String)col.get(0))){
                    if(!primero){
                        rowNum++;
                        row = sheet.createRow(rowNum);
                        cell = row.createCell((short)8);
                        cell.setCellValue("Total:");
                        cell = row.createCell((short)9);
                        cell.setCellValue(String.valueOf(totalPedido));
                        total += totalPedido;
                        totalPedido = 0;
                    }else{
                        primero = false;
                    }
                    rowNum++;
                    rowNum++;
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    cell = row.createCell((short)1);
                    cell.setCellValue("Pedido "+(String)col.get(0));
                    pedidoAnterior = (String)col.get(0);
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    cell = row.createCell((short)1);
                    cell.setCellValue("Id Pedido");
                    cell = row.createCell((short)2);
                    cell.setCellValue("Id Producto");
                    cell = row.createCell((short)3);
                    cell.setCellValue("Nombre");
                    cell = row.createCell((short)4);
                    cell.setCellValue("Descripcion");
                    cell = row.createCell((short)5);
                    cell.setCellValue("Color");
                    cell = row.createCell((short)6);
                    cell.setCellValue("Precio Unitario");
                    cell = row.createCell((short)7);
                    cell.setCellValue("Talla");
                    cell = row.createCell((short)8);
                    cell.setCellValue("Cant Producto");
                    cell = row.createCell((short)9);
                    cell.setCellValue("Importe (S/.)");
                }
                rowNum++;
                row = sheet.createRow(rowNum);
                for(int j=0; j<col.size();j++){
                    cell = row.createCell((short) j+1);
                    cell.setCellValue((String)col.get(j));
                    if(j == col.size()-1){
                        totalPedido += Float.parseFloat((String)col.get(j));
                    }
                }
            } 
            rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell((short)8);
            cell.setCellValue("Total:");
            cell = row.createCell((short)9);
            cell.setCellValue(String.valueOf(totalPedido));
            total += totalPedido;
            totalPedido = 0;
            rowNum++;rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell(1);
            cell.setCellValue("Importe Total por Cliente:");
            cell = row.createCell(2);
            cell.setCellValue(String.valueOf(total));
            
            String path = new File("").getAbsolutePath();
            System.out.println(path);
            
            FileOutputStream fileOut = new FileOutputStream(path+"\\ReporteDeVentasCliente-"+id+".xlsx");
            wb.write(fileOut);
            
        }catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
        return 1;
    }
    
    public int reporteComprasTotales(Proveedor prov){
        String id = "", nombre = "", documento = "",email = "", telef = "";
        if(prov !=null){
            id = prov.getIDProveedor();
            nombre = prov.getNombre();
            documento = prov.getRUC();
            email = prov.getEmail();
            telef = prov.getTelefono();
        }
        else return 0;
        try {
            ArrayList listaDatos = accesoDatos.listaComprasTotales(Integer.parseInt(id));
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Reporte de Compras");
            CellStyle style;
            Row row;
            Cell cell;
            short rowNum = 0;
            short colNum = 0;
            
            row = sheet.createRow(rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Proveedor:");
            cell = row.createCell((short)2);
            cell.setCellValue(nombre);
        
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("RUC:");
            cell = row.createCell((short)2);
            cell.setCellValue(documento);
            
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Email:");
            cell = row.createCell((short)2);
            cell.setCellValue(email);
            
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Telefono:");
            cell = row.createCell((short)2);
            cell.setCellValue(telef);
            String pedidoAnterior = "";
            rowNum++;
            boolean primero = true;
            float totalPedido =0;
            float total=0;
            for(int i = 0; i<listaDatos.size(); i++){
                row = sheet.createRow((short) i+rowNum);
                ArrayList col = (ArrayList)(listaDatos.get(i));
                if(!pedidoAnterior.equals((String)col.get(0))){
                    if(!primero){
                        rowNum++;
                        row = sheet.createRow(rowNum);
                        cell = row.createCell((short)8);
                        cell.setCellValue("Total:");
                        cell = row.createCell((short)9);
                        cell.setCellValue(String.valueOf(totalPedido));
                        total += totalPedido;
                        totalPedido = 0;
                    }else{
                        primero = false;
                    }
                    rowNum++;
                    rowNum++;
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    cell = row.createCell((short)1);
                    cell.setCellValue("Compra "+(String)col.get(0));
                    pedidoAnterior = (String)col.get(0);
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    cell = row.createCell((short)1);
                    cell.setCellValue("Id Pedido");
                    cell = row.createCell((short)2);
                    cell.setCellValue("Id Insumo");
                    cell = row.createCell((short)3);
                    cell.setCellValue("Nombre");
                    cell = row.createCell((short)4);
                    cell.setCellValue("Descripcion");
                    cell = row.createCell((short)5);
                    cell.setCellValue("Color");
                    cell = row.createCell((short)6);
                    cell.setCellValue("Precio Unitario");
                    cell = row.createCell((short)7);
                    cell.setCellValue("Stock Minimo");
                    cell = row.createCell((short)8);
                    cell.setCellValue("Cant Insumo");
                    cell = row.createCell((short)9);
                    cell.setCellValue("Cuenta (S/.)");
                }
                rowNum++;
                row = sheet.createRow(rowNum);
                for(int j=0; j<col.size();j++){
                    cell = row.createCell((short) j+1);
                    cell.setCellValue((String)col.get(j));
                    if(j == col.size()-1){
                        totalPedido += Float.parseFloat((String)col.get(j));
                    }
                }
            } 
            rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell((short)8);
            cell.setCellValue("Total:");
            cell = row.createCell((short)9);
            cell.setCellValue(String.valueOf(totalPedido));
            total += totalPedido;
            totalPedido = 0;
            rowNum++;rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell(1);
            cell.setCellValue("Cuenta Total por Proveedor:");
            cell = row.createCell(2);
            cell.setCellValue(String.valueOf(total));
            
            String path = new File("").getAbsolutePath();
            System.out.println(path);
            
            FileOutputStream fileOut = new FileOutputStream(path+"\\ReporteDeComprasProveedor-"+id+".xlsx");
            wb.write(fileOut);
            
        }catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
            return 0;
        }
        return 1;
    }
    
    public int reporteClientes(){
        try {
            ArrayList listaDatos = accesoDatos.listaMejoresClientes();
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Reporte de Clientes");
            CellStyle style;
            Row row;
            Cell cell;
            short rowNum = 0;
            
            row = sheet.createRow(rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Reporte de Clientes");
            
            row = sheet.createRow(++rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Id Cliente");
            cell = row.createCell((short)2);
            cell.setCellValue("Nombre");
            cell = row.createCell((short)3);
            cell.setCellValue("Email");
            cell = row.createCell((short)4);
            cell.setCellValue("Telefono");
            cell = row.createCell((short)5);
            cell.setCellValue("Importe Total");
            rowNum++;
            for(int i = 0; i<listaDatos.size(); i++){
                row = sheet.createRow((short) i+rowNum);
                ArrayList col = (ArrayList)(listaDatos.get(i));
                row = sheet.createRow(rowNum);
                for(int j=0; j<col.size();j++){
                    cell = row.createCell((short) j+1);
                    cell.setCellValue((String)col.get(j));
                }
                rowNum++;
            } 
            
            String path = new File("").getAbsolutePath();
            System.out.println(path);
            
            FileOutputStream fileOut = new FileOutputStream(path+"\\ReporteDeClientes.xlsx");
            wb.write(fileOut);
            
        }catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
            return 0;
        }
        return 1;
    }
    
    public int reporteProductosEInsumos(){
        try {
            ArrayList listaDatos = accesoDatos.listaProductos();
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Productos Más Vendidos");
            CellStyle style;
            Row row;
            Cell cell;
            short rowNum = 0;
            
            row = sheet.createRow(rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Productos Más Vendidos");
            
            row = sheet.createRow(++rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Id Producto");
            cell = row.createCell((short)2);
            cell.setCellValue("Nombre");
            cell = row.createCell((short)3);
            cell.setCellValue("Descripcion");
            cell = row.createCell((short)4);
            cell.setCellValue("Color");
            cell = row.createCell((short)5);
            cell.setCellValue("Talla");
            cell = row.createCell((short)6);
            cell.setCellValue("Importe Total");
            rowNum++;
            for(int i = 0; i<listaDatos.size(); i++){
                row = sheet.createRow((short) i+rowNum);
                ArrayList col = (ArrayList)(listaDatos.get(i));
                row = sheet.createRow(rowNum);
                for(int j=0; j<col.size();j++){
                    cell = row.createCell((short) j+1);
                    cell.setCellValue((String)col.get(j));
                }
                rowNum++;
            } 
            
            listaDatos = accesoDatos.listaInsumos();
            
            rowNum = 0;
            sheet = wb.createSheet("Insumos Más Comprados");
            
            row = sheet.createRow(rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Insumos Más Comprados");
            
            row = sheet.createRow(++rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Id Insumo");
            cell = row.createCell((short)2);
            cell.setCellValue("Nombre");
            cell = row.createCell((short)3);
            cell.setCellValue("Descripcion");
            cell = row.createCell((short)4);
            cell.setCellValue("Color");
            cell = row.createCell((short)5);
            cell.setCellValue("Importe Total");
            rowNum++;
            for(int i = 0; i<listaDatos.size(); i++){
                row = sheet.createRow((short) i+rowNum);
                ArrayList col = (ArrayList)(listaDatos.get(i));
                row = sheet.createRow(rowNum);
                for(int j=0; j<col.size();j++){
                    cell = row.createCell((short) j+1);
                    cell.setCellValue((String)col.get(j));
                }
                rowNum++;
            } 
            
            String path = new File("").getAbsolutePath();
            System.out.println(path);
            
            FileOutputStream fileOut = new FileOutputStream(path+"\\ReporteDeProductosEInsumos.xlsx");
            wb.write(fileOut);
            
        }catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
            return 0;
        }
        return 1;
    }
}
