/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.InsumoMV;
import Modelo.ProductoMV;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kenny-pc
 */
public class MasVendidos extends java.awt.Dialog {

    /**
     * Creates new form MasVendidos
     */
    public MasVendidos(java.awt.Frame parent, boolean modal, int maxInsumos, int maxProductos) {
        super(parent, modal);
        initComponents();
        
        ArrayList<InsumoMV> listIns = new ArrayList<InsumoMV>();
        ArrayList<ProductoMV> listProd = new ArrayList<ProductoMV>();
                
        InsumoMV c1 = new InsumoMV("Tela Blanca", "Telas Blancas SAC",new Float(362.23) );
        InsumoMV c2 = new InsumoMV("Tela Negra","Telas Negras SAC",new Float(225.23));
        InsumoMV c3 = new InsumoMV("Algodon","Algodon SAC",new Float(156.23));
        InsumoMV c4 = new InsumoMV("Etiquetas","Etiquetas SAC",new Float(100));
        listIns.add(c1);
        listIns.add(c2);
        listIns.add(c3);
        listIns.add(c4);
        
        
        
                
        ProductoMV p1 = new ProductoMV("Polos Blancos", "Rosas Negras+ SAC",300 );
        ProductoMV p2 = new ProductoMV("Polos Negros","Orquideas SAC",200);
        ProductoMV p3 = new ProductoMV("Polos Azules","Violetas SAC",150);
        ProductoMV p4 = new ProductoMV("Polos Rosas","Rosas SAC",100);
        listProd.add(p1);
        listProd.add(p2);
        listProd.add(p3);
        listProd.add(p4);
                
        DefaultTableModel modelo = (DefaultTableModel) tabInsumos.getModel();
        Object[] fila = new Object[3];
        for(int i=0; (i<maxInsumos)&&(i<listIns.size());i++){
            fila[0] = listIns.get(i).getName();
            fila[1] = listIns.get(i).getProveedor();
            fila[2] = listIns.get(i).getMonto();
            modelo.addRow(fila);
        }
        DefaultTableModel modelo2 = (DefaultTableModel) tabProductos.getModel();
        Object[] fila2 = new Object[3];
        for(int i=0; (i<maxProductos)&&(i<listProd.size());i++){
            fila2[0] = listProd.get(i).getName();
            fila2[1] = listProd.get(i).getCliente();
            fila2[2] = listProd.get(i).getCant();
            modelo2.addRow(fila2);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabInsumos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabProductos = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        tabInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Insumo", "Proveedor", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabInsumos);

        jPanel1.add(jScrollPane1);

        tabProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cliente", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabProductos);

        jPanel1.add(jScrollPane2);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MasVendidos dialog = new MasVendidos(new java.awt.Frame(), true,0,0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabInsumos;
    private javax.swing.JTable tabProductos;
    // End of variables declaration//GEN-END:variables
}
