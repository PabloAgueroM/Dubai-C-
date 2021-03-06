/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.ProveedorBL;
import Modelo.*;
import java.sql.Date;
import java.util.regex.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class GestionarProveedor_Ventas extends javax.swing.JFrame {

    private ProveedorBL logicaNegocio;
    private Proveedor proveedorSeleccionado;
    private int flag = 0;

    public GestionarProveedor_Ventas() {
        initComponents();

        logicaNegocio = new ProveedorBL();
        proveedorSeleccionado = new Proveedor();
        estado(1);
    }

    public int validarDatos() {
        if (TxtRazonSocial.getText().trim().isEmpty() || TxtNombre.getText().trim().isEmpty() || TxtRUC.getText().trim().isEmpty() || TxtTelefono.getText().trim().isEmpty()
            || TxtEmail.getText().trim().isEmpty() || TxtNombreRep.getText().trim().isEmpty() || TxtApellidoPRep.getText().trim().isEmpty() || TxtApellidoMRep.getText().trim().isEmpty()
            || TxtDNIRep.getText().trim().isEmpty() || TxtTelefonoRep.getText().trim().isEmpty()) {
           // JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        if (TxtRazonSocial.getForeground() == java.awt.Color.RED || TxtNombre.getForeground() == java.awt.Color.RED || TxtRUC.getForeground() == java.awt.Color.RED || TxtTelefono.getForeground() == java.awt.Color.RED
            || TxtEmail.getForeground() == java.awt.Color.RED || TxtNombreRep.getForeground() == java.awt.Color.RED || TxtApellidoPRep.getForeground() == java.awt.Color.RED || TxtApellidoMRep.getForeground() == java.awt.Color.RED
            || TxtDNIRep.getForeground() == java.awt.Color.RED || TxtTelefonoRep.getForeground() == java.awt.Color.RED) {
            //JOptionPane.showMessageDialog(null, "Por favor, corrija los campos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            return 2;
        }
        return 0;
    }

    public void estado(int i) {
        switch (i) {
            case 1: //Inicial
                TxtID.setEnabled(false);
                TxtRazonSocial.setEnabled(false);
                TxtNombre.setEnabled(false);
                TxtRUC.setEnabled(false);
                TxtTelefono.setEnabled(false);
                TxtEmail.setEnabled(false);
                TxtNombreRep.setEnabled(false);
                CbDia.setEnabled(false);
                CbMes.setEnabled(false);
                TxtApellidoPRep.setEnabled(false);
                TxtApellidoMRep.setEnabled(false);
                TxtDNIRep.setEnabled(false);
                TxtTelefonoRep.setEnabled(false);
                BtnCancelar.setEnabled(false);
                BtnGuardar.setEnabled(false);
                Buscar.setEnabled(true);
                
                flag = 0;
                limpiarCampos();
                break;
            case 2: //Nuevo
                TxtID.setEnabled(false);
                TxtRazonSocial.setEnabled(true);
                TxtNombre.setEnabled(true);
                TxtRUC.setEnabled(true);
                TxtTelefono.setEnabled(true);
                TxtEmail.setEnabled(true);
                TxtNombreRep.setEnabled(true);
                TxtApellidoPRep.setEnabled(true);
                TxtApellidoMRep.setEnabled(true);
                TxtDNIRep.setEnabled(true);
                CbDia.setEnabled(true);
                CbMes.setEnabled(true);
                TxtTelefonoRep.setEnabled(true);
                BtnCancelar.setEnabled(true);
                BtnGuardar.setEnabled(true);
                Buscar.setEnabled(true);
                
                flag = 0;
                limpiarCampos();
                break;
            case 3: //Guardar
                TxtID.setEnabled(false);
                TxtRazonSocial.setEnabled(false);
                TxtNombre.setEnabled(false);
                TxtRUC.setEnabled(false);
                TxtTelefono.setEnabled(false);
                TxtEmail.setEnabled(false);
                TxtNombreRep.setEnabled(false);
                TxtApellidoPRep.setEnabled(false);
                TxtApellidoMRep.setEnabled(false);
                CbDia.setEnabled(false);
                CbMes.setEnabled(false);
                TxtDNIRep.setEnabled(false);
                TxtTelefonoRep.setEnabled(false);
                BtnCancelar.setEnabled(false);
                BtnGuardar.setEnabled(false);
                Buscar.setEnabled(true);
                
                flag = 0;

                break;
        }
    }

    public void limpiarCampos() {
        TxtID.setText("");
        TxtRazonSocial.setText("");
        TxtNombre.setText("");
        TxtRUC.setText("");
        TxtTelefono.setText("");
        TxtEmail.setText("");
        TxtNombreRep.setText("");
        TxtApellidoPRep.setText("");
        TxtApellidoMRep.setText("");
        TxtDNIRep.setText("");
        TxtTelefonoRep.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TxtNombreRep = new javax.swing.JTextField();
        TxtApellidoPRep = new javax.swing.JTextField();
        TxtApellidoMRep = new javax.swing.JTextField();
        TxtDNIRep = new javax.swing.JTextField();
        TxtTelefonoRep = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtRazonSocial = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtRUC = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        CbMes = new javax.swing.JComboBox<>();
        CbDia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        TxtID = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        Buscar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Representante del Proveedor"));

        jLabel8.setText("Nombres:");

        jLabel9.setText("Apellido Paterno:");

        jLabel10.setText("Apellido Materno:");

        jLabel11.setText("D.N.I. :");

        jLabel12.setText("Teléfono:");

        TxtNombreRep.setText("jTextField1");
        TxtNombreRep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreRepKeyTyped(evt);
            }
        });

        TxtApellidoPRep.setText("jTextField2");
        TxtApellidoPRep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtApellidoPRepKeyTyped(evt);
            }
        });

        TxtApellidoMRep.setText("jTextField3");
        TxtApellidoMRep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtApellidoMRepKeyTyped(evt);
            }
        });

        TxtDNIRep.setText("jTextField4");
        TxtDNIRep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDNIRepKeyTyped(evt);
            }
        });

        TxtTelefonoRep.setText("jTextField5");
        TxtTelefonoRep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTelefonoRepKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtApellidoPRep, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(TxtApellidoMRep)
                    .addComponent(TxtDNIRep)
                    .addComponent(TxtTelefonoRep)
                    .addComponent(TxtNombreRep))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TxtNombreRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtApellidoPRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TxtApellidoMRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TxtDNIRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TxtTelefonoRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Razón Social:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("R.U.C. :");

        jLabel5.setText("Fecha de Aniversario:");

        jLabel6.setText("Teléfono:");

        jLabel7.setText("Email:");

        TxtRazonSocial.setText("jTextField1");

        TxtNombre.setText("jTextField2");

        TxtRUC.setText("jTextField3");
        TxtRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtRUCKeyTyped(evt);
            }
        });

        TxtTelefono.setText("jTextField5");
        TxtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTelefonoKeyTyped(evt);
            }
        });

        TxtEmail.setText("jTextField6");
        TxtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtEmailKeyTyped(evt);
            }
        });

        CbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        CbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel4.setText("ID del Proveedor:");

        TxtID.setText("jTextField1");

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(CbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(TxtRUC, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtRazonSocial)
                                    .addComponent(TxtID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(BtnGuardar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(CbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(BtnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(Buscar);

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        if (flag == 0) { //es nuevo proveedor
            Proveedor prov = new Proveedor();
            PersonaNatural rep = new PersonaNatural();
            Date fecha = new Date(118, CbMes.getSelectedIndex(), CbDia.getSelectedIndex() + 1);
            prov.setRazonSocial(TxtRazonSocial.getText());
            prov.setRUC(TxtRUC.getText());
            prov.setNombre(TxtNombre.getText());
            prov.setFechaAniversario(fecha);
            prov.setEmail(TxtEmail.getText());
            prov.setTelefono(TxtTelefono.getText());
            rep.setNombre(TxtNombreRep.getText());
            rep.setApellidoP(TxtApellidoPRep.getText());
            rep.setApellidoM(TxtApellidoMRep.getText());
            rep.setDNI(TxtDNIRep.getText());
            rep.setTelefono(TxtTelefonoRep.getText());
            prov.setRepresentante(rep);            
            int valido=validarDatos();
            if(valido>0){
                if(valido==1){
                    JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(valido==2){
                    JOptionPane.showMessageDialog(null, "Por favor, corrija los campos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            }
            logicaNegocio.registrarProveedor(prov);
            estado(3);
        } else {

            Date fecha = new Date(118, CbMes.getSelectedIndex(), CbDia.getSelectedIndex() + 1);
            proveedorSeleccionado.setIDProveedor(TxtID.getText());
            proveedorSeleccionado.setRazonSocial(TxtRazonSocial.getText());
            proveedorSeleccionado.setRUC(TxtRUC.getText());
            proveedorSeleccionado.setNombre(TxtNombre.getText());
            proveedorSeleccionado.setFechaAniversario(fecha);
            proveedorSeleccionado.setEmail(TxtEmail.getText());
            proveedorSeleccionado.setTelefono(TxtTelefono.getText());
            PersonaNatural rep = proveedorSeleccionado.getRepresentante();
            rep.setNombre(TxtNombreRep.getText());
            rep.setApellidoP(TxtApellidoPRep.getText());
            rep.setApellidoM(TxtApellidoMRep.getText());
            rep.setDNI(TxtDNIRep.getText());
            rep.setTelefono(TxtTelefonoRep.getText());
            proveedorSeleccionado.setRepresentante(rep);
            int valido=validarDatos();
            if(valido>0){
                if(valido==1){
                    JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(valido==2){
                    JOptionPane.showMessageDialog(null, "Por favor, corrija los campos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            }
            logicaNegocio.ModificarProveedor(proveedorSeleccionado);            
            estado(1);
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        estado(1);
        flag = 0;
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        BuscarProveedor frm = new BuscarProveedor(null, true);
        frm.setVisible(true);
        proveedorSeleccionado = frm.getProveedorSeleccionado();
        if (proveedorSeleccionado != null) {
            estado(2);
            TxtID.setText(proveedorSeleccionado.getIDProveedor());
            TxtRazonSocial.setText(proveedorSeleccionado.getRazonSocial());
            TxtNombre.setText(proveedorSeleccionado.getNombre());
            TxtRUC.setText(proveedorSeleccionado.getRUC());
            String prueba = proveedorSeleccionado.getRUC();
            TxtTelefono.setText(proveedorSeleccionado.getTelefono());
            TxtEmail.setText(proveedorSeleccionado.getEmail());
            TxtNombreRep.setText(proveedorSeleccionado.getRepresentante().getNombre());
            CbDia.setSelectedIndex(proveedorSeleccionado.getFechaAniversario().getDay());
            CbMes.setSelectedIndex(proveedorSeleccionado.getFechaAniversario().getMonth());
            TxtApellidoPRep.setText(proveedorSeleccionado.getRepresentante().getApellidoP());
            TxtApellidoMRep.setText(proveedorSeleccionado.getRepresentante().getApellidoM());
            TxtDNIRep.setText(proveedorSeleccionado.getRepresentante().getDNI());
            TxtTelefonoRep.setText(proveedorSeleccionado.getRepresentante().getTelefono());
            flag = 1;
            BtnGuardar.setEnabled(true);

        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void TxtRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtRUCKeyTyped
        String texto = TxtRUC.getText();
        Pattern EMAIL_VALIDO = Pattern.compile("^[0-9]{10}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_VALIDO.matcher(texto);
        if (!matcher.find()) {
            TxtRUC.setForeground(java.awt.Color.RED);
        } else {
            TxtRUC.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_TxtRUCKeyTyped

    private void TxtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelefonoKeyTyped
        String texto = TxtTelefono.getText();
        Pattern EMAIL_VALIDO = Pattern.compile("^[0-9]{6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_VALIDO.matcher(texto);
        if (!matcher.find()) {
            TxtTelefono.setForeground(java.awt.Color.RED);
        } else {
            TxtTelefono.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_TxtTelefonoKeyTyped

    private void TxtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEmailKeyTyped
        String texto = TxtEmail.getText();
        Pattern EMAIL_VALIDO = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{1,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_VALIDO.matcher(texto);
        if (!matcher.find()) {
            TxtEmail.setForeground(java.awt.Color.RED);
        } else {
            TxtEmail.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_TxtEmailKeyTyped

    private void TxtNombreRepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreRepKeyTyped
        String texto = TxtNombreRep.getText();
        Pattern EMAIL_VALIDO = Pattern.compile("^[a-zA-Z]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_VALIDO.matcher(texto);
        if (!matcher.find()) {
            TxtNombreRep.setForeground(java.awt.Color.RED);
        } else {
            TxtNombreRep.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_TxtNombreRepKeyTyped

    private void TxtApellidoPRepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtApellidoPRepKeyTyped
        String texto = TxtApellidoPRep.getText();
        Pattern EMAIL_VALIDO = Pattern.compile("^[a-zA-Z]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_VALIDO.matcher(texto);
        if (!matcher.find()) {
            TxtApellidoPRep.setForeground(java.awt.Color.RED);
        } else {
            TxtApellidoPRep.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_TxtApellidoPRepKeyTyped

    private void TxtApellidoMRepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtApellidoMRepKeyTyped
        String texto = TxtApellidoMRep.getText();
        Pattern EMAIL_VALIDO = Pattern.compile("^[a-zA-Z]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_VALIDO.matcher(texto);
        if (!matcher.find()) {
            TxtApellidoMRep.setForeground(java.awt.Color.RED);
        } else {
            TxtApellidoMRep.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_TxtApellidoMRepKeyTyped

    private void TxtDNIRepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDNIRepKeyTyped
        String texto = TxtDNIRep.getText();
        Pattern EMAIL_VALIDO = Pattern.compile("^[0-9]{7}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_VALIDO.matcher(texto);
        if (!matcher.find()) {
            TxtDNIRep.setForeground(java.awt.Color.RED);
        } else {
            TxtDNIRep.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_TxtDNIRepKeyTyped

    private void TxtTelefonoRepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelefonoRepKeyTyped
        String texto = TxtTelefonoRep.getText();
        Pattern EMAIL_VALIDO = Pattern.compile("^[0-9]{8}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_VALIDO.matcher(texto);
        if (!matcher.find()) {
            TxtTelefonoRep.setForeground(java.awt.Color.RED);
        } else {
            TxtTelefonoRep.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_TxtTelefonoRepKeyTyped

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
            java.util.logging.Logger.getLogger(GestionarProveedor_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarProveedor_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarProveedor_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarProveedor_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarProveedor_Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton Buscar;
    private javax.swing.JComboBox<String> CbDia;
    private javax.swing.JComboBox<String> CbMes;
    private javax.swing.JTextField TxtApellidoMRep;
    private javax.swing.JTextField TxtApellidoPRep;
    private javax.swing.JTextField TxtDNIRep;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtID;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtNombreRep;
    private javax.swing.JTextField TxtRUC;
    private javax.swing.JTextField TxtRazonSocial;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtTelefonoRep;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
