/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Insumo;
import Modelo.Proveedor;
import Controlador.InsumoBL;
import Controlador.ProductoBL;
import Controlador.Proveedor_X_Insumo_BL;
import Modelo.ProveedorxInsumo;
import Modelo.TipoProductoG;
import Modelo.UnidadDeMedida;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */

public class GestionInsumo extends javax.swing.JFrame {
    private ArrayList<ProveedorxInsumo> proveedores;
    private Insumo insumoSeleccionado;
    private InsumoBL logicaNegocioInsumo;
    private ProductoBL LogicaNegocioProducto;
    private Proveedor proveedorSeleccionado;
    private Proveedor_X_Insumo_BL LogicaNegocioProveedorXInsumo;
    
    int flag = 0;
    
    public void limpiarTblProveedores(){
        DefaultTableModel modelo = (DefaultTableModel) tblProveedoresXInsumo.getModel();
        int rowCount = modelo.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--){
            modelo.removeRow(i);
        }
    }
    
    public void limpiarCampos(){
        txtIdInsumo.setText(null);
        txtNombreInsumo.setText(null);
        txtDescripcion.setText(null);
        txtColor.setText(null);
        txtStockMinimo.setText(null);
        txtPrecioReferencial.setText(null);
        txtIdProveedor.setText(null);
        txtNombreProveedor.setText(null);
        txtPrecio.setText(null); 
    }
    
    public int validarDatos() {
        if (txtNombreInsumo.getText().trim().isEmpty() || txtDescripcion.getText().trim().isEmpty() || txtColor.getText().trim().isEmpty() || txtPrecioReferencial.getText().trim().isEmpty()
            /*|| txtIdProveedor.getText().trim().isEmpty() || txtNombreProveedor.getText().trim().isEmpty() || txtPrecio.getText().trim().isEmpty() */){
           // JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        if (txtNombreInsumo.getForeground() == java.awt.Color.RED || txtDescripcion.getForeground() == java.awt.Color.RED || txtColor.getForeground() == java.awt.Color.RED || txtPrecioReferencial.getForeground() == java.awt.Color.RED
            || /*txtIdProveedor.getForeground() == java.awt.Color.RED || txtNombreProveedor.getForeground() == java.awt.Color.RED ||*/ txtPrecio.getForeground() == java.awt.Color.RED) {
            //JOptionPane.showMessageDialog(null, "Por favor, corrija los campos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            return 2;
        }
        return 0;
    }
    
    public void estado(String estado){
        switch(estado){
            case "inicial":
                limpiarCampos();
                btnNuevo.setEnabled(true);
                btnBuscarInsumo.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnEliminar.setEnabled(false);
                txtIdInsumo.setEnabled(false); txtIdInsumo.setBackground(Color.lightGray);
                txtNombreInsumo.setEnabled(false); txtNombreInsumo.setBackground(Color.lightGray);
                txtColor.setEnabled(false); txtColor.setBackground(Color.lightGray);
                txtDescripcion.setEnabled(false); txtDescripcion.setBackground(Color.lightGray);
                txtPrecioReferencial.setEnabled(false); txtPrecioReferencial.setBackground(Color.lightGray);
                txtStockMinimo.setEnabled(false); txtStockMinimo.setBackground(Color.lightGray);
                cboTipo.setEnabled(false);
                cboUnidadMedida.setEnabled(false);
                btnBuscarProveedor.setEnabled(false);
                txtIdProveedor.setEnabled(false); txtIdProveedor.setBackground(Color.lightGray);
                txtNombreProveedor.setEnabled(false); txtNombreProveedor.setBackground(Color.lightGray);
                txtPrecio.setEnabled(false); txtPrecio.setBackground(Color.lightGray);
                btnAñadirProveedor.setEnabled(false);
                btnModificarProveedor.setEnabled(false);
                btnEliminarProveedor.setEnabled(false);
                limpiarTblProveedores();
                break;
            case "nuevo":
                btnGuardar.setEnabled(true);
                btnBuscarInsumo.setEnabled(false);
                btnEliminar.setEnabled(false);
                txtIdInsumo.setEnabled(true); txtIdInsumo.setBackground(Color.lightGray);
                txtNombreInsumo.setEnabled(true); txtNombreInsumo.setBackground(Color.white);
                txtColor.setEnabled(true); txtColor.setBackground(Color.white);
                txtDescripcion.setEnabled(true); txtDescripcion.setBackground(Color.white);
                txtStockMinimo.setEnabled(true); txtStockMinimo.setBackground(Color.white);
                txtPrecioReferencial.setEnabled(true); txtPrecioReferencial.setBackground(Color.white);
                cboTipo.setEnabled(true);
                cboUnidadMedida.setEnabled(true);
                btnBuscarProveedor.setEnabled(true);
                txtIdProveedor.setEnabled(false); 
                txtNombreProveedor.setEnabled(false); 
                txtPrecio.setEnabled(true); txtPrecio.setBackground(Color.white);
                btnAñadirProveedor.setEnabled(true);
                btnModificarProveedor.setEnabled(true);
                btnEliminarProveedor.setEnabled(true);
                
                break;
            case "guardar":
                
                break;
            case "buscar":
                txtNombreInsumo.setEnabled(true); txtNombreInsumo.setBackground(Color.white);
                txtDescripcion.setEnabled(true); txtDescripcion.setBackground(Color.white);
                txtStockMinimo.setEnabled(true); txtStockMinimo.setBackground(Color.white);
                txtPrecioReferencial.setEnabled(true); txtPrecioReferencial.setBackground(Color.white);
                txtColor.setEnabled(true); txtColor.setBackground(Color.white);
                txtPrecio.setEnabled(true); txtPrecio.setBackground(Color.white);
                cboTipo.setEnabled(true);
                cboUnidadMedida.setEditable(true);
                btnNuevo.setEnabled(false); btnBuscarInsumo.setEnabled(false);
                btnGuardar.setEnabled(true); btnEliminar.setEnabled(true); btnCancelar.setEnabled(true);
                btnBuscarProveedor.setEnabled(true);
                btnAñadirProveedor.setEnabled(true);
                btnModificarProveedor.setEnabled(true);
                btnEliminarProveedor.setEnabled(true);
                break;
        }
    }

    public void cargarCboUnidadMedidad(){
        ArrayList<TipoProductoG> listaProd = LogicaNegocioProducto.listarTipoProducto();
                for (TipoProductoG tp : listaProd) {
                    cboTipo.addItem(tp);
                }
        ArrayList<UnidadDeMedida> listaUn = LogicaNegocioProducto.listarUnidades();
                for (UnidadDeMedida u : listaUn) {
                    cboUnidadMedida.addItem(u);
                }
    }
    
    public void actualizarDatos(){
        DefaultTableModel modelo = (DefaultTableModel) tblProveedoresXInsumo.getModel();
        Object[] fila = new Object[3];
        for(int i=0;i<proveedores.size();i++){
            fila[0]= proveedores.get(i).getProveedor().getIDProveedor();
            fila[1]= proveedores.get(i).getProveedor().getNombre();
            fila[2]= proveedores.get(i).getPrecio();
            //System.out.println(proveedores.get(i).getProveedor().getNombre());
            modelo.addRow(fila);
        }
    }

    public void añadirTblProveedores(){
        DefaultTableModel modelo = (DefaultTableModel) tblProveedoresXInsumo.getModel();
        Object[] fila = new Object[3];
        
        int i = proveedores.size();
        fila[0]= proveedores.get(i-1).getProveedor().getIDProveedor();
        fila[1]= proveedores.get(i-1).getProveedor().getNombre();
        fila[2]= proveedores.get(i-1).getPrecio();
        modelo.addRow(fila);    
    }
    
    
    public GestionInsumo() {
        initComponents();
        proveedores = new ArrayList<ProveedorxInsumo>();
        logicaNegocioInsumo = new InsumoBL();
        LogicaNegocioProducto = new ProductoBL();
        LogicaNegocioProveedorXInsumo = new Proveedor_X_Insumo_BL();
        estado("inicial");
        
        cargarCboUnidadMedidad();
 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdInsumo = new javax.swing.JTextField();
        txtNombreInsumo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        cboTipo = new javax.swing.JComboBox();
        cboUnidadMedida = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtStockMinimo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPrecioReferencial = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtPrecio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnBuscarProveedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedoresXInsumo = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtIdProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnAñadirProveedor = new javax.swing.JButton();
        btnModificarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscarInsumo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Datos Generales"));

        jLabel2.setText("Id Insumo:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Color:");

        jLabel5.setText("Tipo:");

        jLabel6.setText("Unidad de Medida:");

        txtNombreInsumo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreInsumoKeyTyped(evt);
            }
        });

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        jLabel7.setText("Descripción:");

        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorKeyTyped(evt);
            }
        });

        jLabel11.setText("Stock Minimo:");

        jLabel12.setText("Precio Referencial:");

        txtPrecioReferencial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioReferencialKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cboUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel5))
                                    .addComponent(txtPrecioReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(166, 166, 166)
                                        .addComponent(jLabel4)))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtPrecioReferencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Proveedores"));

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel10.setText("Precio:");

        btnBuscarProveedor.setText("...");
        btnBuscarProveedor.setEnabled(false);
        btnBuscarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarProveedorMouseClicked(evt);
            }
        });

        tblProveedoresXInsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Proveedor", "Nombre", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tblProveedoresXInsumo);
        if (tblProveedoresXInsumo.getColumnModel().getColumnCount() > 0) {
            tblProveedoresXInsumo.getColumnModel().getColumn(0).setResizable(false);
            tblProveedoresXInsumo.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblProveedoresXInsumo.getColumnModel().getColumn(1).setResizable(false);
            tblProveedoresXInsumo.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblProveedoresXInsumo.getColumnModel().getColumn(2).setResizable(false);
            tblProveedoresXInsumo.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jLabel8.setText("Nombre:");

        jLabel9.setText("Id:");

        btnAñadirProveedor.setText("Añadir");
        btnAñadirProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAñadirProveedorMouseClicked(evt);
            }
        });

        btnModificarProveedor.setText("Modificar");
        btnModificarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarProveedorMouseClicked(evt);
            }
        });

        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarProveedorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnAñadirProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btnModificarProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarProveedor)
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarProveedor)
                    .addComponent(btnModificarProveedor)
                    .addComponent(btnAñadirProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jToolBar1.setRollover(true);

        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnBuscarInsumo.setText("Buscar");
        btnBuscarInsumo.setFocusable(false);
        btnBuscarInsumo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarInsumo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarInsumoMouseClicked(evt);
            }
        });
        jToolBar1.add(btnBuscarInsumo);

        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        jToolBar1.add(btnCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
            // TODO add your handling code here:
        try {
                
            if(flag == 0){ //Se registra nuevo insumo
                Insumo i = new Insumo();
                int valido=validarDatos();
                if(valido>0){
                    if(valido==1){
                        JOptionPane.showMessageDialog(null, "Completar los campos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(valido==2){
                        JOptionPane.showMessageDialog(null, "Corregir los campos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }  
                }

                i.setNombre(txtNombreInsumo.getText());
                i.setDescripcion(txtDescripcion.getText());
                i.setColor(txtColor.getText());
                i.setPrecio(Double.valueOf(txtPrecioReferencial.getText()));
                i.setStockMinimo(Double.valueOf(txtStockMinimo.getText()));
                i.setTipo((TipoProductoG)cboTipo.getSelectedItem());
                i.setUnidad((UnidadDeMedida)cboUnidadMedida.getSelectedItem());
                i.setActivo(1);

                if(valido == 0){
       
                //Registrar Insumo en la BD
                    int id = logicaNegocioInsumo.registrarInsumo(i);
                    txtIdInsumo.setText(String.valueOf(id));

                    i.setProveedoresXInsumo(proveedores);

                    for(ProveedorxInsumo pXi : i.getProveedoresXInsumo()){
                        LogicaNegocioProveedorXInsumo.registrarProveedorXInsumo(id,pXi,i.isActivo());
                    }
                    estado("guardar");
                }
                
            }else if(flag == 1){ //Se modifica insumo seleccionado
                int valido=validarDatos();
                if(valido>0){
                    if(valido==1){
                        JOptionPane.showMessageDialog(null, "Completar los campos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(valido==2){
                        JOptionPane.showMessageDialog(null, "Corregir los campos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }  
                }
                insumoSeleccionado.setNombre(txtNombreInsumo.getText());
                insumoSeleccionado.setDescripcion(txtDescripcion.getText());
                insumoSeleccionado.setColor(txtColor.getText());
                insumoSeleccionado.setPrecio(Double.valueOf(txtPrecioReferencial.getText()));
                insumoSeleccionado.setStockMinimo(Double.valueOf(txtStockMinimo.getText()));
                insumoSeleccionado.setTipo((TipoProductoG)cboTipo.getSelectedItem());
                insumoSeleccionado.setUnidad((UnidadDeMedida)cboUnidadMedida.getSelectedItem());
                insumoSeleccionado.setProveedoresXInsumo(proveedores);
                
                
                if(valido == 0){
                    logicaNegocioInsumo.modificarInsumo(insumoSeleccionado);

                    for(ProveedorxInsumo pXi : insumoSeleccionado.getProveedoresXInsumo()){
                        if(LogicaNegocioProveedorXInsumo.validarProveedorXInsumo(insumoSeleccionado.getId(), Integer.valueOf(pXi.getProveedor().getIDProveedor())) == 1){
                            LogicaNegocioProveedorXInsumo.modificarProveedorXInsumo(insumoSeleccionado.getId(),pXi,insumoSeleccionado.isActivo());
                        }
                        else if(LogicaNegocioProveedorXInsumo.validarProveedorXInsumo(insumoSeleccionado.getId(), Integer.valueOf(pXi.getProveedor().getIDProveedor())) == 0){
                            LogicaNegocioProveedorXInsumo.registrarProveedorXInsumo(insumoSeleccionado.getId(),pXi,insumoSeleccionado.isActivo());
                        }
                    }
                    estado("inicial");          
                }
            }      
        } catch (SQLException ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        // TODO add your handling code here:
        estado("nuevo");
        flag = 0;
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnAñadirProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirProveedorMouseClicked
        // TODO add your handling code here:
 if((proveedorSeleccionado != null) && (txtPrecio.getText().length() > 0)){
            double precioProveedor = Double.parseDouble(txtPrecio.getText());
            ProveedorxInsumo pXi = new ProveedorxInsumo(proveedorSeleccionado, precioProveedor);
            proveedores.add(pXi);
            añadirTblProveedores();
            proveedorSeleccionado = null;
            txtNombreProveedor.setText(null);
            txtIdProveedor.setText(null);
            txtPrecio.setText(null);
        }
        else if (proveedorSeleccionado == null){
            JOptionPane.showMessageDialog(null, "Proveedor no seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (txtPrecio.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio del insumo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAñadirProveedorMouseClicked

    private void btnBuscarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProveedorMouseClicked
        // TODO add your handling code here:
        BuscarProveedor frmBP = new BuscarProveedor(null,true);
        frmBP.setVisible(true);

        proveedorSeleccionado = frmBP.getProveedorSeleccionado();
        if(proveedorSeleccionado != null){
            txtIdProveedor.setText(proveedorSeleccionado.getIDProveedor());
            txtNombreProveedor.setText(proveedorSeleccionado.getNombre());
        }
    }//GEN-LAST:event_btnBuscarProveedorMouseClicked

    private void btnBuscarInsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarInsumoMouseClicked
        try {
            // TODO add your handling code here:
            BuscarInsumo frmBI = new BuscarInsumo(null,true);
            frmBI.setVisible(true);
            
            insumoSeleccionado = frmBI.getInsumoSeleccionado();
            if(insumoSeleccionado != null){
                estado("buscar");
                txtIdInsumo.setText(String.valueOf(insumoSeleccionado.getId()));
                txtNombreInsumo.setText(insumoSeleccionado.getNombre());
                txtDescripcion.setText(insumoSeleccionado.getDescripcion());
                txtColor.setText(insumoSeleccionado.getColor());
                txtPrecioReferencial.setText(String.valueOf(insumoSeleccionado.getPrecio()));
                txtStockMinimo.setText(String.valueOf(insumoSeleccionado.getStockMinimo()));
                cboTipo.setSelectedItem(insumoSeleccionado.getTipo());
                cboUnidadMedida.setSelectedItem(insumoSeleccionado.getUnidad());
                
                proveedores = logicaNegocioInsumo.listarProveedoresXInsumo(insumoSeleccionado.getId());
//                for(int q = 0; q<proveedores.size();q++){
//                    System.out.println(proveedores.get(q).getProveedor().getNombre());
//                }
                insumoSeleccionado.setProveedoresXInsumo(proveedores);
                
                actualizarDatos();
                
                flag = 1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarInsumoMouseClicked

    
    private void txtNombreInsumoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreInsumoKeyTyped
        // TODO add your handling code here:
        String texto = txtNombreInsumo.getText();
        Pattern NOMBRE_VALIDO = Pattern.compile("^[a-zA-Z\\s]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = NOMBRE_VALIDO.matcher(texto);
        if (!matcher.find()) {
            txtNombreInsumo.setForeground(java.awt.Color.RED);
        } else {
            txtNombreInsumo.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_txtNombreInsumoKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        String texto = txtDescripcion.getText();
        Pattern DESC_VALIDO = Pattern.compile("^[a-zA-Z\\s]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = DESC_VALIDO.matcher(texto); 
        if (!matcher.find()) {
            txtDescripcion.setForeground(java.awt.Color.RED);
        } else {
            txtDescripcion.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
        // TODO add your handling code here:
        String texto = txtColor.getText();
        Pattern COLOR_VALIDO = Pattern.compile("^[a-zA-Z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = COLOR_VALIDO.matcher(texto);
        if (!matcher.find()) {
            txtColor.setForeground(java.awt.Color.RED);
        } else {
            txtColor.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_txtColorKeyTyped

    private void txtPrecioReferencialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioReferencialKeyTyped
        // TODO add your handling code here:
        String texto = txtPrecioReferencial.getText();
        Pattern PRECIO_VALIDO = Pattern.compile("^[0-9]+(\\.[0-9]{1,2})?$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = PRECIO_VALIDO.matcher(texto);
        if (!matcher.find()) {
            txtPrecioReferencial.setForeground(java.awt.Color.RED);
        } else {
            txtPrecioReferencial.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_txtPrecioReferencialKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
        String texto = txtPrecio.getText();
        Pattern PRECIO_VALIDO = Pattern.compile("^[0-9]+(\\.[0-9]{1,2})?$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = PRECIO_VALIDO.matcher(texto);
        if (!matcher.find()) {
            txtPrecio.setForeground(java.awt.Color.RED);
        } else {
            txtPrecio.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
        estado("inicial");
        flag = 0;
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
        if(insumoSeleccionado != null){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este insumo?", "Atención", dialogButton);
            if (dialogResult == JOptionPane.NO_OPTION) {
                return;
            } else {
                try {
                    logicaNegocioInsumo.eliminarInsumo(insumoSeleccionado);
                    insumoSeleccionado=null;
                    estado("inicial");
                    flag = 0;
                } catch (SQLException ex) {
                    Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProveedorMouseClicked
        // TODO add your handling code here:
        int index = tblProveedoresXInsumo.getSelectedRow();
        
        if(index >= 0){
            if(flag == 1){
                try {
                    LogicaNegocioProveedorXInsumo.eliminarProveedorXInsumo(insumoSeleccionado.getId(),
                            Integer.parseInt(proveedores.get(index).getProveedor().getIDProveedor()));
                } catch (SQLException ex) {
                    Logger.getLogger(GestionInsumo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            proveedores.remove(index);
            DefaultTableModel modelo = (DefaultTableModel) tblProveedoresXInsumo.getModel();
            modelo.removeRow(index);
        }
        else if(index < 0){
            JOptionPane.showMessageDialog(null, "Fila no seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarProveedorMouseClicked

    private void btnModificarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarProveedorMouseClicked
        // TODO add your handling code here:
        int index = tblProveedoresXInsumo.getSelectedRow();
        
        if((index >= 0) && (txtPrecio.getText().length()>0)){
            ProveedorxInsumo proveedor = proveedores.get(index);
            //proveedor.setProveedor(proveedorSeleccionado);
            proveedor.setPrecio(Double.valueOf(txtPrecio.getText()));
            proveedores.set(index, proveedor);

            DefaultTableModel modelo = (DefaultTableModel) tblProveedoresXInsumo.getModel();
            modelo.removeRow(index);

            Object[] fila = new Object[3];
            fila[0]= proveedores.get(index).getProveedor().getIDProveedor();
            fila[1]= proveedores.get(index).getProveedor().getNombre();
            fila[2]= proveedores.get(index).getPrecio();

            modelo.insertRow(index,fila);
        }
        else if(index < 0){
            JOptionPane.showMessageDialog(null, "Fila no seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(txtPrecio.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio del insumo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarProveedorMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionInsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionInsumo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirProveedor;
    private javax.swing.JButton btnBuscarInsumo;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cboTipo;
    private javax.swing.JComboBox cboUnidadMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblProveedoresXInsumo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdInsumo;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtNombreInsumo;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioReferencial;
    private javax.swing.JTextField txtStockMinimo;
    // End of variables declaration//GEN-END:variables
}
