package Vistas;

import Controlador.ProductoBL;
import Modelo.Insumo;
import Modelo.InsumoxProducto;
import Modelo.Producto;
import Modelo.TipoProductoG;
import Modelo.UnidadDeMedida;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alulab14
 */
public class GestionarProducto extends javax.swing.JFrame {

    private final ArrayList<Insumo> listaInsumos;
    private Insumo seleccionInsumo;
    private Producto producto;
    private ProductoBL LogicaNegocio;
    private int accion = 1;

    public GestionarProducto() throws Exception {
        initComponents();
        LogicaNegocio = new ProductoBL();
        listaInsumos = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DescripcionText = new javax.swing.JTextField();
        PrecioText = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        StockText = new javax.swing.JTextField();
        SeleccionarInsumos = new javax.swing.JPanel();
        CantidadInsumoText = new javax.swing.JTextField();
        lblCantidadI = new javax.swing.JLabel();
        InsertarInsumoBoton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaInsumosxProducto = new javax.swing.JTable();
        SelecBtn = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        buscaProd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        prodTB = new javax.swing.JToolBar();
        NuevoBtn = new javax.swing.JButton();
        ModificarBtn = new javax.swing.JButton();
        CancelarBtn = new javax.swing.JButton();
        EliminarBtn = new javax.swing.JButton();
        guardarBtn = new javax.swing.JButton();
        lblColor = new javax.swing.JLabel();
        lblTalla = new javax.swing.JLabel();
        colorText = new javax.swing.JTextField();
        cmbTalla = new javax.swing.JComboBox<>();
        cmbTipo = new javax.swing.JComboBox<>();
        lblTipo = new javax.swing.JLabel();
        lblUnidad = new javax.swing.JLabel();
        cmbUnidad = new javax.swing.JComboBox<>();
        lblDescripcion = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Producto");
        setUndecorated(true);

        DescripcionText.setAutoscrolls(false);
        DescripcionText.setEnabled(false);

        PrecioText.setAutoscrolls(false);
        PrecioText.setEnabled(false);

        lblNombre.setText("Nombre");

        Precio.setText("Precio");

        lblStock.setText("Stock Actual");

        StockText.setAutoscrolls(false);
        StockText.setEnabled(false);

        SeleccionarInsumos.setBorder(javax.swing.BorderFactory.createTitledBorder("Insumos"));

        CantidadInsumoText.setEnabled(false);

        lblCantidadI.setText("Cantidad");

        InsertarInsumoBoton.setText("Insertar Insumo");
        InsertarInsumoBoton.setEnabled(false);
        InsertarInsumoBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InsertarInsumoBotonMouseClicked(evt);
            }
        });

        TablaInsumosxProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cantidad Necesaria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaInsumosxProducto);
        if (TablaInsumosxProducto.getColumnModel().getColumnCount() > 0) {
            TablaInsumosxProducto.getColumnModel().getColumn(0).setResizable(false);
            TablaInsumosxProducto.getColumnModel().getColumn(1).setResizable(false);
            TablaInsumosxProducto.getColumnModel().getColumn(2).setResizable(false);
        }

        SelecBtn.setBackground(new java.awt.Color(204, 204, 204));
        SelecBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelecBtnMouseClicked(evt);
            }
        });

        jLabel3.setText("Seleccionar");

        javax.swing.GroupLayout SelecBtnLayout = new javax.swing.GroupLayout(SelecBtn);
        SelecBtn.setLayout(SelecBtnLayout);
        SelecBtnLayout.setHorizontalGroup(
            SelecBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelecBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        SelecBtnLayout.setVerticalGroup(
            SelecBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout SeleccionarInsumosLayout = new javax.swing.GroupLayout(SeleccionarInsumos);
        SeleccionarInsumos.setLayout(SeleccionarInsumosLayout);
        SeleccionarInsumosLayout.setHorizontalGroup(
            SeleccionarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionarInsumosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SeleccionarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeleccionarInsumosLayout.createSequentialGroup()
                        .addComponent(SelecBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(lblCantidadI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CantidadInsumoText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(InsertarInsumoBoton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SeleccionarInsumosLayout.setVerticalGroup(
            SeleccionarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionarInsumosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SeleccionarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelecBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SeleccionarInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCantidadI)
                        .addComponent(CantidadInsumoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(InsertarInsumoBoton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289))
        );

        lblCodigo.setText("Codigo");

        idText.setEditable(false);
        idText.setAutoscrolls(false);

        buscaProd.setBackground(new java.awt.Color(204, 204, 204));
        buscaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscaProdMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("...");

        javax.swing.GroupLayout buscaProdLayout = new javax.swing.GroupLayout(buscaProd);
        buscaProd.setLayout(buscaProdLayout);
        buscaProdLayout.setHorizontalGroup(
            buscaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscaProdLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(13, 13, 13))
        );
        buscaProdLayout.setVerticalGroup(
            buscaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        prodTB.setRollover(true);

        NuevoBtn.setText("Nuevo");
        NuevoBtn.setFocusable(false);
        NuevoBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NuevoBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NuevoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NuevoBtnMouseClicked(evt);
            }
        });
        prodTB.add(NuevoBtn);

        ModificarBtn.setText("Modificar");
        ModificarBtn.setFocusable(false);
        ModificarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ModificarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ModificarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarBtnMouseClicked(evt);
            }
        });
        prodTB.add(ModificarBtn);

        CancelarBtn.setText("Cancelar");
        CancelarBtn.setFocusable(false);
        CancelarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CancelarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBtnActionPerformed(evt);
            }
        });
        prodTB.add(CancelarBtn);

        EliminarBtn.setText("Eliminar");
        EliminarBtn.setFocusable(false);
        EliminarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarBtnMouseClicked(evt);
            }
        });
        prodTB.add(EliminarBtn);

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });
        prodTB.add(guardarBtn);

        lblColor.setText("Color");

        lblTalla.setText("Talla");

        colorText.setAutoscrolls(false);
        colorText.setEnabled(false);

        lblTipo.setText("Tipo");

        lblUnidad.setText("Unidad de Medida");

        lblDescripcion.setText("Descripcion");

        nombreText.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SeleccionarInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(buscaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColor)
                            .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Precio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PrecioText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUnidad)
                                        .addComponent(lblTalla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblStock, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StockText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DescripcionText, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(prodTB, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(prodTB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buscaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescripcionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColor)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTalla)
                                .addComponent(cmbTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblUnidad)
                                .addComponent(cmbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTipo))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(Precio))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(StockText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblStock)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(colorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(PrecioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(SeleccionarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void Estado(int estado) {
        switch (estado) {
            case 1: //habilitar campos
                DescripcionText.setEnabled(true);
                PrecioText.setEnabled(true);
                StockText.setEnabled(true);
                CantidadInsumoText.setEnabled(true);
                InsertarInsumoBoton.setEnabled(true);
                guardarBtn.setEnabled(true);
                SelecBtn.setEnabled(true);
                nombreText.setEnabled(true);
                colorText.setEnabled(true);

                ArrayList<TipoProductoG> listaProd = LogicaNegocio.listarTipoProducto();
                for (TipoProductoG tp : listaProd) {
                    cmbTipo.addItem(tp);
                }
                ArrayList<UnidadDeMedida> listaUn = LogicaNegocio.listarUnidades();
                for (UnidadDeMedida u : listaUn) {
                    cmbUnidad.addItem(u);
                }
                cmbTalla.addItem("S");
                cmbTalla.addItem("M");
                cmbTalla.addItem("L");
                break;
            case 2: //Desabilitar campos
                DescripcionText.setEnabled(false);
                PrecioText.setEnabled(false);
                StockText.setEnabled(false);
                CantidadInsumoText.setEnabled(false);
                InsertarInsumoBoton.setEnabled(false);
                guardarBtn.setEnabled(false);
                SelecBtn.setEnabled(false);
                nombreText.setEnabled(false);
                colorText.setEnabled(false);
                break;
            case 3: //Borrar todos los datos
                idText.setText(null);
                DescripcionText.setText(null);
                PrecioText.setText(null);
                StockText.setText(null);
                CantidadInsumoText.setText(null);
                nombreText.setText(null);
                colorText.setText(null);
                //borrar datos en lista de insumos del producto
                DefaultTableModel modelo = (DefaultTableModel) TablaInsumosxProducto.getModel();
                int n = modelo.getRowCount();
                for (int i = 0; i < n; i++) {
                    modelo.removeRow(0);
                }
        }
    }

    private void ModificarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarBtnMouseClicked
        Estado(3);
        Estado(1);
        //Copiar datos a la pantalla
        idText.setText(Integer.toString(producto.getId()));
        nombreText.setText(producto.getNombre());
        DescripcionText.setText(producto.getDescripcion());
        PrecioText.setText(Double.toString(producto.getPrecio()));
        StockText.setText(Double.toString(producto.getStockActual()));
        //insumos
        Object[] filaP = new Object[3];
        DefaultTableModel modeloP = (DefaultTableModel) TablaInsumosxProducto.getModel();
        for (int i = 0; i < producto.getLista().size(); i++) {
            filaP[0] = producto.getLista().get(i).getInsumo().getId();
            filaP[1] = producto.getLista().get(i).getInsumo().getNombre();
            filaP[2] = producto.getLista().get(i).getCantidad();
            modeloP.addRow(filaP);
        }
        accion = 1; 
    }//GEN-LAST:event_ModificarBtnMouseClicked

    private void NuevoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoBtnMouseClicked
        Estado(1);
        Estado(3);
        producto = new Producto();
        accion = 0;
    }//GEN-LAST:event_NuevoBtnMouseClicked

    private void InsertarInsumoBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InsertarInsumoBotonMouseClicked
        DefaultTableModel modelo = (DefaultTableModel) TablaInsumosxProducto.getModel();
        InsumoxProducto ip = new InsumoxProducto(seleccionInsumo,
                Float.parseFloat(CantidadInsumoText.getText()));
        producto.insertarInsumos(ip);
        modelo.addRow(new Object[]{ip.getInsumo().getId(), ip.getInsumo().getNombre(), ip.getCantidad()});
    }//GEN-LAST:event_InsertarInsumoBotonMouseClicked

    private void EliminarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarBtnMouseClicked
        BuscarProducto frm;
        frm = new BuscarProducto();
        frm.setVisible(true);
        producto = frm.getSeleccion();
        guardarBtn.setEnabled(true);
        accion = 3;
    }//GEN-LAST:event_EliminarBtnMouseClicked

    private void buscaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscaProdMouseClicked
        BuscarProducto frm;
        frm = new BuscarProducto();
        frm.setVisible(true);
        producto = frm.getSeleccion();
    }//GEN-LAST:event_buscaProdMouseClicked

    private void SelecBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelecBtnMouseClicked
        BuscarInsumo frm;
        try {
            frm = new BuscarInsumo(this, true);
            frm.setListaInsumos(listaInsumos);
            frm.setVisible(true);
            seleccionInsumo = frm.getInsumoSeleccionado();
        } catch (SQLException ex) {
            Logger.getLogger(GestionarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SelecBtnMouseClicked

    private void CancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBtnActionPerformed
        Estado(2);
        Estado(3);
    }//GEN-LAST:event_CancelarBtnActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        if (accion == 3) {
            LogicaNegocio.eliminarProducto(producto);
            Estado(2);
            Estado(3);
            return;
        }
        if (producto != null) {
            //guardar los cambios si no estan vacios

            try {
                producto.setNombre(this.nombreText.getText());
                if (this.nombreText.getText() == null) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar el campo nombre");
                    producto.setNombre(this.nombreText.getText());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "El nombre ingresado no es correcto");
            }
            try {
                producto.setDescripcion(this.DescripcionText.getText());
                if (this.DescripcionText.getText() == null) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar el campo Descripcion");
                    producto.setDescripcion(this.DescripcionText.getText());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "La Descripcion ingresada no es correcta");
            }
            try {
                producto.setPrecio(Double.parseDouble(this.PrecioText.getText()));
                if (this.PrecioText.getText() == null) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar el campo Precio");
                    producto.setPrecio(Double.parseDouble(this.PrecioText.getText()));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "El precio ingresado debe ser un valor numérico");
            }
            try {
                producto.setStockActual(Double.parseDouble(this.StockText.getText()));
                if (this.StockText.getText() == null) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar el campo stock");
                    producto.setStockActual(Double.parseDouble(this.StockText.getText()));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "El stock ingresado debe ser un valor numérico");
            }
            producto.setTalla(cmbTalla.getSelectedItem().toString().charAt(0));
            producto.setTipo((TipoProductoG) cmbTipo.getSelectedItem());
            producto.setUnidad((UnidadDeMedida) cmbUnidad.getSelectedItem());
            producto.setColor(colorText.getText());
        }

        Estado(2);
        Estado(3);
        switch (accion) {
            case 0:
                LogicaNegocio.agregarProducto(producto);
                idText.setText(Integer.toString(producto.getId()));
                break;
            case 1:
                LogicaNegocio.modificarProducto(producto);
                break;
        }
    }//GEN-LAST:event_guardarBtnActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GestionarProducto().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GestionarProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarBtn;
    private javax.swing.JTextField CantidadInsumoText;
    private javax.swing.JTextField DescripcionText;
    private javax.swing.JButton EliminarBtn;
    private javax.swing.JButton InsertarInsumoBoton;
    private javax.swing.JButton ModificarBtn;
    private javax.swing.JButton NuevoBtn;
    private javax.swing.JLabel Precio;
    private javax.swing.JTextField PrecioText;
    private javax.swing.JPanel SelecBtn;
    private javax.swing.JPanel SeleccionarInsumos;
    private javax.swing.JTextField StockText;
    private javax.swing.JTable TablaInsumosxProducto;
    private javax.swing.JPanel buscaProd;
    private javax.swing.JComboBox<String> cmbTalla;
    private javax.swing.JComboBox<TipoProductoG> cmbTipo;
    private javax.swing.JComboBox<UnidadDeMedida> cmbUnidad;
    private javax.swing.JTextField colorText;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantidadI;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTalla;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUnidad;
    private javax.swing.JTextField nombreText;
    private javax.swing.JToolBar prodTB;
    // End of variables declaration//GEN-END:variables

}
