/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.LoginDA;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Katherine Espinoza 20122127
 */
public class VentanaPrincipal_admPro extends javax.swing.JFrame {
    private JPanel btn;
    /**
     * Creates new form VentanaPrincipal
     *
     * @throws java.lang.Exception
     */
    private String usuarioActual;
    public VentanaPrincipal_admPro(String usuario) throws Exception {
        initComponents();
        usuarioActual = usuario;
        this.setLocation(300, 50);
        this.setSize(750, 650);
        this.getContentPane().setBackground(Color.WHITE);
        Fondo fondo = new Fondo();
        fondo.setSize(750, 650);
        fondo.setVisible(true);
        FondoPanel.add(fondo);
        menuActivo.setLayout(new GridLayout());
        menuActivo.setVisible(false);
        menuActivo.setOpaque(false);
        FondoPanel.setSize(750, 650);
        FondoPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        Cerrar = new javax.swing.JLabel();
        FondoPanel = new javax.swing.JPanel();
        lateralPanel = new javax.swing.JPanel();
        btnInsumo = new javax.swing.JPanel();
        txtInsumo = new javax.swing.JLabel();
        btnProducto = new javax.swing.JPanel();
        txtProducto = new javax.swing.JLabel();
        btnProveedor = new javax.swing.JPanel();
        txtProveedor = new javax.swing.JLabel();
        btnPedido = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JLabel();
        btnSalir = new javax.swing.JPanel();
        txtSalir = new javax.swing.JLabel();
        menuActivo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        titleBar.setBackground(new java.awt.Color(204, 0, 0));
        titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleBarMouseDragged(evt);
            }
        });
        titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleBarMousePressed(evt);
            }
        });

        txtTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setText("Menú");

        minimizar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        minimizar.setForeground(new java.awt.Color(255, 255, 255));
        minimizar.setText("_");
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });

        Cerrar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Cerrar.setForeground(new java.awt.Color(255, 255, 255));
        Cerrar.setText("x");
        Cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 491, Short.MAX_VALUE)
                .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addGroup(titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cerrar)
                    .addComponent(minimizar)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FondoPanel.setPreferredSize(new java.awt.Dimension(750, 750));

        lateralPanel.setBackground(new java.awt.Color(0, 0, 0));

        btnInsumo.setBackground(new java.awt.Color(0, 0, 0));
        btnInsumo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnInsumoMouseMoved(evt);
            }
        });
        btnInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsumoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsumoMouseExited(evt);
            }
        });

        txtInsumo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtInsumo.setForeground(new java.awt.Color(255, 255, 255));
        txtInsumo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtInsumo.setText("Insumo");

        javax.swing.GroupLayout btnInsumoLayout = new javax.swing.GroupLayout(btnInsumo);
        btnInsumo.setLayout(btnInsumoLayout);
        btnInsumoLayout.setHorizontalGroup(
            btnInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnInsumoLayout.setVerticalGroup(
            btnInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnInsumoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtInsumo)
                .addContainerGap())
        );

        btnProducto.setBackground(new java.awt.Color(0, 0, 0));
        btnProducto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnProductoMouseMoved(evt);
            }
        });
        btnProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductoMouseExited(evt);
            }
        });

        txtProducto.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtProducto.setForeground(new java.awt.Color(255, 255, 255));
        txtProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProducto.setText("Producto");
        txtProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout btnProductoLayout = new javax.swing.GroupLayout(btnProducto);
        btnProducto.setLayout(btnProductoLayout);
        btnProductoLayout.setHorizontalGroup(
            btnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnProductoLayout.setVerticalGroup(
            btnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtProducto)
                .addContainerGap())
        );

        btnProveedor.setBackground(new java.awt.Color(0, 0, 0));
        btnProveedor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnProveedorMouseMoved(evt);
            }
        });
        btnProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProveedorMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProveedorMouseExited(evt);
            }
        });

        txtProveedor.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtProveedor.setForeground(new java.awt.Color(255, 255, 255));
        txtProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProveedor.setText("Proveedor");

        javax.swing.GroupLayout btnProveedorLayout = new javax.swing.GroupLayout(btnProveedor);
        btnProveedor.setLayout(btnProveedorLayout);
        btnProveedorLayout.setHorizontalGroup(
            btnProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        btnProveedorLayout.setVerticalGroup(
            btnProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtProveedor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPedido.setBackground(new java.awt.Color(0, 0, 0));
        btnPedido.setPreferredSize(new java.awt.Dimension(48, 40));
        btnPedido.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnPedidoMouseMoved(evt);
            }
        });
        btnPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPedidoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPedidoMouseExited(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUsuario.setText("Pedido");
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout btnPedidoLayout = new javax.swing.GroupLayout(btnPedido);
        btnPedido.setLayout(btnPedidoLayout);
        btnPedidoLayout.setHorizontalGroup(
            btnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnPedidoLayout.setVerticalGroup(
            btnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPedidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUsuario)
                .addContainerGap())
        );

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSalirMouseMoved(evt);
            }
        });
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });

        txtSalir.setBackground(new java.awt.Color(204, 0, 0));
        txtSalir.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        txtSalir.setForeground(new java.awt.Color(255, 255, 255));
        txtSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSalir.setText("Salir");

        javax.swing.GroupLayout btnSalirLayout = new javax.swing.GroupLayout(btnSalir);
        btnSalir.setLayout(btnSalirLayout);
        btnSalirLayout.setHorizontalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnSalirLayout.setVerticalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout lateralPanelLayout = new javax.swing.GroupLayout(lateralPanel);
        lateralPanel.setLayout(lateralPanelLayout);
        lateralPanelLayout.setHorizontalGroup(
            lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(btnProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lateralPanelLayout.setVerticalGroup(
            lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lateralPanelLayout.createSequentialGroup()
                .addComponent(btnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 532, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout menuActivoLayout = new javax.swing.GroupLayout(menuActivo);
        menuActivo.setLayout(menuActivoLayout);
        menuActivoLayout.setHorizontalGroup(
            menuActivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuActivoLayout.setVerticalGroup(
            menuActivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FondoPanelLayout = new javax.swing.GroupLayout(FondoPanel);
        FondoPanel.setLayout(FondoPanelLayout);
        FondoPanelLayout.setHorizontalGroup(
            FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoPanelLayout.createSequentialGroup()
                .addComponent(lateralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuActivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        FondoPanelLayout.setVerticalGroup(
            FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lateralPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuActivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
            .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(FondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE))
            .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_CerrarMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked
    void resetBotones() {
        resetColor(btnProducto);
        resetColor(btnInsumo);
        resetColor(btnPedido);
        resetColor(btnProveedor);
        resetColor(btnSalir);
    }
    private void btnProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseClicked
        btn=btnProducto;
        setSelect(btn);
        resetBotones();
        GestionarProducto frm;
        menuActivo.removeAll();
        try {
            frm = new GestionarProducto();
            menuActivo.add(frm.getContentPane());
            menuActivo.setVisible(true);
            menuActivo.setOpaque(false);
            menuActivo.repaint();
            //frm.setVisible(true);
//            frm.setLocation(450, 50);
        } catch (Exception ex) {
            Logger.getLogger(VentanaPrincipal_admPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProductoMouseClicked

    private void btnInsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsumoMouseClicked
        btn=btnInsumo;
        setSelect(btn);
        resetBotones();
        setColor(btnInsumo);
        GestionInsumo frmIns;
        menuActivo.removeAll();
        try {
            frmIns = new GestionInsumo();
            menuActivo.add(frmIns.getContentPane());
            menuActivo.setVisible(true);
            menuActivo.setOpaque(false);
            menuActivo.repaint();
            //frm.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(VentanaPrincipal_admPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInsumoMouseClicked

    private void btnProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedorMouseClicked
        btn=btnProveedor;
        setSelect(btn);
        resetBotones();
        GestionarProveedor frmProv;
        menuActivo.removeAll();
        try {
            frmProv = new GestionarProveedor();
            menuActivo.add(frmProv.getContentPane());
            menuActivo.setVisible(true);
            menuActivo.setOpaque(false);
            menuActivo.repaint();
            //frm.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(VentanaPrincipal_admPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProveedorMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        btn=btnSalir;
        setSelect(btn);
        LoginDA cerrar = new LoginDA();
        cerrar.cerrarSesion(usuarioActual);
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidoMouseClicked
        btn=btnPedido;
        setSelect(btn);
        resetBotones();
        GestionarPedido frm;
        menuActivo.removeAll();
        try {
            frm = new GestionarPedido();
            menuActivo.add(frm.getContentPane());
            menuActivo.setVisible(true);
            menuActivo.setOpaque(false);
            menuActivo.repaint();
            //frm.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(VentanaPrincipal_admPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPedidoMouseClicked

    private void titleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_titleBarMouseDragged

    private void titleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_titleBarMousePressed

    private void btnPedidoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidoMouseMoved
        setColor(btnPedido);
    }//GEN-LAST:event_btnPedidoMouseMoved

    private void btnPedidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidoMouseExited
        resetColor(btnPedido);
    }//GEN-LAST:event_btnPedidoMouseExited

    private void btnProductoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseMoved
        setColor(btnProducto);
    }//GEN-LAST:event_btnProductoMouseMoved

    private void btnProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseExited
        resetColor(btnProducto);
    }//GEN-LAST:event_btnProductoMouseExited

    private void btnInsumoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsumoMouseMoved
        setColor(btnInsumo);
    }//GEN-LAST:event_btnInsumoMouseMoved

    private void btnInsumoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsumoMouseExited
        resetColor(btnInsumo);
    }//GEN-LAST:event_btnInsumoMouseExited

    private void btnProveedorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedorMouseMoved
        setColor(btnProveedor);
    }//GEN-LAST:event_btnProveedorMouseMoved

    private void btnProveedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedorMouseExited
        resetColor(btnProveedor);
    }//GEN-LAST:event_btnProveedorMouseExited

    private void btnSalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseMoved
        setColor(btnSalir);
    }//GEN-LAST:event_btnSalirMouseMoved

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        resetColor(btnSalir);
    }//GEN-LAST:event_btnSalirMouseExited
    int xx;
    int xy;

    void setColor(JPanel p) {
        if (btn!=p)
            p.setBackground(new Color(65, 65, 65));
    }
    void setSelect(JPanel p) {
        p.setBackground(new Color(180, 30, 30));
    }
    void resetColor(JPanel p) {
        if (btn!=p)
        p.setBackground(new Color(0, 0, 0));
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal_admPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal_admPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal_admPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal_admPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaPrincipal_admPro(null).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(VentanaPrincipal_admPro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JPanel FondoPanel;
    private javax.swing.JPanel btnInsumo;
    private javax.swing.JPanel btnPedido;
    private javax.swing.JPanel btnProducto;
    private javax.swing.JPanel btnProveedor;
    private javax.swing.JPanel btnSalir;
    private javax.swing.JPanel lateralPanel;
    private javax.swing.JPanel menuActivo;
    private javax.swing.JLabel minimizar;
    private javax.swing.JPanel titleBar;
    private javax.swing.JLabel txtInsumo;
    private javax.swing.JLabel txtProducto;
    private javax.swing.JLabel txtProveedor;
    private javax.swing.JLabel txtSalir;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}