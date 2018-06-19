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
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.commons.collections4.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author alulab14
 */
public class ReportesBL {   
    
    private ReportesDA accesoDatos;
    private Map<String, CellStyle> cellStyles;
    
    public ReportesBL(){
        accesoDatos = new ReportesDA();
        
    }
    
    public void setCellStyles(Workbook workbook){
        cellStyles = new HashMap<String, CellStyle>();
        
        DataFormat dataFormat = workbook.createDataFormat();

        CellStyle cellStyle;
        //XSSFFont font;

        cellStyle =  workbook.createCellStyle();
        cellStyle.setFillPattern(FillPatternType.FINE_DOTS);
        cellStyle.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);   
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        
//        font = workbook.createFont();
//        font.setFontHeightInPoints((short)16);
//        font.setFontName("Calibri");                                            
//        cellStyle.setFont(font);
        cellStyles.put("header_cell_style", cellStyle);

        cellStyle = workbook.createCellStyle(); 
        cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        
//        font = workbook.createFont();
//        font.setFontHeightInPoints((short)12);
//        font.setFontName("Calibri");                   
//        cellStyle.setFont(font);
        cellStyles.put("normal_cell_style", cellStyle);

        cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);       
        cellStyle.setDataFormat(dataFormat.getFormat("dd-mmm-yyyy"));
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
//        font = workbook.createFont();
//        font.setFontHeightInPoints((short)12);
//        font.setFontName("Calibri");                   
//        cellStyle.setFont(font);
        cellStyles.put("date_cell_style", cellStyle);

        cellStyle = workbook.createCellStyle();
        cellStyle.setFillPattern(FillPatternType.FINE_DOTS);
        cellStyle.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);       
        cellStyle.setDataFormat(dataFormat.getFormat("dd-mmm-yyyy"));
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
//        font = workbook.createFont();
//        font.setFontHeightInPoints((short)16);
//        font.setFontName("Calibri");                   
//        cellStyle.setFont(font);
        cellStyles.put("header_date_cell_style", cellStyle);
        
        
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
            
            setCellStyles(wb);
            
            row = sheet.createRow(rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Cliente:");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)2);
            cell.setCellValue(nombre);
            cell.setCellStyle(cellStyles.get("header_cell_style"));
        
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue(documento);
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Email:");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)2);
            cell.setCellValue(email);
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Telefono:");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)2);
            cell.setCellValue(telef);
            cell.setCellStyle(cellStyles.get("header_cell_style"));
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
                        cell.setCellStyle(cellStyles.get("normal_cell_style"));
                        cell = row.createCell((short)9);
                        cell.setCellValue(String.valueOf(totalPedido));
                        cell.setCellStyle(cellStyles.get("normal_cell_style"));
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
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    pedidoAnterior = (String)col.get(0);
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    cell = row.createCell((short)1);
                    cell.setCellValue("Id Pedido");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)2);
                    cell.setCellValue("Id Producto");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)3);
                    cell.setCellValue("Nombre");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)4);
                    cell.setCellValue("Descripcion");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)5);
                    cell.setCellValue("Color");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)6);
                    cell.setCellValue("Precio Unitario");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)7);
                    cell.setCellValue("Talla");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)8);
                    cell.setCellValue("Cant Producto");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)9);
                    cell.setCellValue("Importe (S/.)");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                }
                rowNum++;
                row = sheet.createRow(rowNum);
                for(int j=0; j<col.size();j++){
                    cell = row.createCell((short) j+1);
                    cell.setCellValue((String)col.get(j));
                    cell.setCellStyle(cellStyles.get("normal_cell_style"));
                    if(j == col.size()-1){
                        totalPedido += Float.parseFloat((String)col.get(j));
                    }
                }
            } 
            rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell((short)8);
            cell.setCellValue("Total:");
            cell.setCellStyle(cellStyles.get("normal_cell_style"));
            cell = row.createCell((short)9);
            cell.setCellValue(String.valueOf(totalPedido));
            cell.setCellStyle(cellStyles.get("normal_cell_style"));
            total += totalPedido;
            totalPedido = 0;
            rowNum++;rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell(1);
            cell.setCellValue("Importe Total por Cliente:");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell(2);
            cell.setCellValue(String.valueOf(total));
            cell.setCellStyle(cellStyles.get("normal_cell_style"));
            
            for(int i = 0; i< 10; i++) sheet.autoSizeColumn(i);
            
            
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null)== JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                
                String path = fileChooser.getSelectedFile().getName();
                String dir = fileChooser.getCurrentDirectory().toString();
                //String path = new File("").getAbsolutePath();
                
                String realpath = dir+"\\"+path+".xlsx";
                System.out.println(realpath);

                FileOutputStream fileOut = new FileOutputStream(realpath);
                wb.write(fileOut);
            }else{ 
                String path = "No se escogio un directorio valido";
                System.out.println(path);
                return 0;
            }
           
            
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
            
            setCellStyles(wb);
            
            row = sheet.createRow(rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Proveedor:");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)2);
            cell.setCellValue(nombre);
            cell.setCellStyle(cellStyles.get("header_cell_style"));
        
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("RUC:");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)2);
            cell.setCellValue(documento);
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Email:");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)2);
            cell.setCellValue(email);
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Telefono:");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)2);
            cell.setCellValue(telef);
            cell.setCellStyle(cellStyles.get("header_cell_style"));
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
                        cell.setCellStyle(cellStyles.get("header_cell_style"));
                        cell = row.createCell((short)9);
                        cell.setCellValue(String.valueOf(totalPedido));
                        cell.setCellStyle(cellStyles.get("normal_cell_style"));
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
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    pedidoAnterior = (String)col.get(0);
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    cell = row.createCell((short)1);
                    cell.setCellValue("Id Pedido");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)2);
                    cell.setCellValue("Id Insumo");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)3);
                    cell.setCellValue("Nombre");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)4);
                    cell.setCellValue("Descripcion");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)5);
                    cell.setCellValue("Color");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)6);
                    cell.setCellValue("Precio Unitario");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)7);
                    cell.setCellValue("Stock Minimo");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)8);
                    cell.setCellValue("Cant Insumo");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                    cell = row.createCell((short)9);
                    cell.setCellValue("Cuenta (S/.)");
                    cell.setCellStyle(cellStyles.get("header_cell_style"));
                }
                rowNum++;
                row = sheet.createRow(rowNum);
                for(int j=0; j<col.size();j++){
                    cell = row.createCell((short) j+1);
                    cell.setCellValue((String)col.get(j));
                    cell.setCellStyle(cellStyles.get("normal_cell_style"));
                    if(j == col.size()-1){
                        totalPedido += Float.parseFloat((String)col.get(j));
                    }
                }
            } 
            rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell((short)8);
            cell.setCellValue("Total:");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)9);
            cell.setCellValue(String.valueOf(totalPedido));
            cell.setCellStyle(cellStyles.get("normal_cell_style"));
            total += totalPedido;
            totalPedido = 0;
            rowNum++;rowNum++;
            row = sheet.createRow(rowNum);
            cell = row.createCell(1);
            cell.setCellValue("Cuenta Total por Proveedor:");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell(2);
            cell.setCellValue(String.valueOf(total));
            cell.setCellStyle(cellStyles.get("normal_cell_style"));
            
            for(int i = 0; i< 10; i++) sheet.autoSizeColumn(i);
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null)== JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                
                String path = fileChooser.getSelectedFile().getName();
                String dir = fileChooser.getCurrentDirectory().toString();
                //String path = new File("").getAbsolutePath();
                
                String realpath = dir+"\\"+path+".xlsx";
                System.out.println(realpath);

                FileOutputStream fileOut = new FileOutputStream(realpath);
                wb.write(fileOut);
            }else{ 
                String path = "No se escogio un directorio valido";
                System.out.println(path);
                return 0;
            }
            
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
            
            setCellStyles(wb);
            
            row = sheet.createRow(rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Reporte de Clientes");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            
            row = sheet.createRow(++rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Id Cliente");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)2);
            cell.setCellValue("Nombre");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)3);
            cell.setCellValue("Email");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)4);
            cell.setCellValue("Telefono");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)5);
            cell.setCellValue("Importe Total");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            rowNum++;
            for(int i = 0; i<listaDatos.size(); i++){
                row = sheet.createRow((short) i+rowNum);
                ArrayList col = (ArrayList)(listaDatos.get(i));
                row = sheet.createRow(rowNum);
                for(int j=0; j<col.size();j++){
                    cell = row.createCell((short) j+1);
                    cell.setCellValue((String)col.get(j));
                    cell.setCellStyle(cellStyles.get("normal_cell_style"));
                }
                rowNum++;
            } 
            for(int i = 0; i< 10; i++) sheet.autoSizeColumn(i);
            
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null)== JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                
                String path = fileChooser.getSelectedFile().getName();
                String dir = fileChooser.getCurrentDirectory().toString();
                //String path = new File("").getAbsolutePath();
                
                String realpath = dir+"\\"+path+".xlsx";
                System.out.println(realpath);

                FileOutputStream fileOut = new FileOutputStream(realpath);
                wb.write(fileOut);
            }else{ 
                String path = "No se escogio un directorio valido";
                System.out.println(path);
                return 0;
            }
            
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
            
            setCellStyles(wb);
            
            row = sheet.createRow(rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Productos Más Vendidos");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            
            row = sheet.createRow(++rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Id Producto");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)2);
            cell.setCellValue("Nombre");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)3);
            cell.setCellValue("Descripcion");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)4);
            cell.setCellValue("Color");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)5);
            cell.setCellValue("Talla");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)6);
            cell.setCellValue("Importe Total");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            rowNum++;
            for(int i = 0; i<listaDatos.size(); i++){
                row = sheet.createRow((short) i+rowNum);
                ArrayList col = (ArrayList)(listaDatos.get(i));
                row = sheet.createRow(rowNum);
                for(int j=0; j<col.size();j++){
                    cell = row.createCell((short) j+1);
                    cell.setCellValue((String)col.get(j));
                    cell.setCellStyle(cellStyles.get("normal_cell_style"));
                }
                rowNum++;
            } 
            for(int i = 0; i< 10; i++) sheet.autoSizeColumn(i);
            
            listaDatos = accesoDatos.listaInsumos();
            
            rowNum = 0;
            sheet = wb.createSheet("Insumos Más Comprados");
            
            row = sheet.createRow(rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Insumos Más Comprados");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            
            row = sheet.createRow(++rowNum);
            row = sheet.createRow(++rowNum);
            cell = row.createCell((short)1);
            cell.setCellValue("Id Insumo");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)2);
            cell.setCellValue("Nombre");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)3);
            cell.setCellValue("Descripcion");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)4);
            cell.setCellValue("Color");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            cell = row.createCell((short)5);
            cell.setCellValue("Importe Total");
            cell.setCellStyle(cellStyles.get("header_cell_style"));
            rowNum++;
            for(int i = 0; i<listaDatos.size(); i++){
                row = sheet.createRow((short) i+rowNum);
                ArrayList col = (ArrayList)(listaDatos.get(i));
                row = sheet.createRow(rowNum);
                for(int j=0; j<col.size();j++){
                    cell = row.createCell((short) j+1);
                    cell.setCellValue((String)col.get(j));
                    cell.setCellStyle(cellStyles.get("normal_cell_style"));
                }
                rowNum++;
            } 
            for(int i = 0; i< 10; i++) sheet.autoSizeColumn(i);
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null)== JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                
                String path = fileChooser.getSelectedFile().getName();
                String dir = fileChooser.getCurrentDirectory().toString();
                //String path = new File("").getAbsolutePath();
                
                String realpath = dir+"\\"+path+".xlsx";
                System.out.println(realpath);

                FileOutputStream fileOut = new FileOutputStream(realpath);
                wb.write(fileOut);
            }else{ 
                String path = "No se escogio un directorio valido";
                System.out.println(path);
                return 0;
            }
            
        }catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
            return 0;
        }
        return 1;
    }
}
