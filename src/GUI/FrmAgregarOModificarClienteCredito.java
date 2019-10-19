/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.security.ntlm.Client;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import logica.ClienteContado;
import logica.ClienteCredito;

/**
 *
 * @author Fabricio
 */
public class FrmAgregarOModificarClienteCredito extends javax.swing.JDialog {
    private boolean aceptar;
    private ClienteCredito oClienteCredito;
    
    /**
     * Creates new form frmAgregarModificarCliente
     */
    public FrmAgregarOModificarClienteCredito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setMinimumSize(new Dimension(749, 549));  // Impide hacer más pequeño el frame
        this.setLocationRelativeTo(parent);
        this.aceptar = false;
        this.tituloPrincipal.setText("AGREGAR CLIENTE");
    }
    
    public FrmAgregarOModificarClienteCredito(java.awt.Frame parent, boolean modal, ClienteCredito pClienteCredito) {
        super(parent, modal);
        initComponents();
        this.setMinimumSize(new Dimension(749, 549));  // Impide hacer más pequeño el frame
        this.setLocationRelativeTo(parent);
        this.aceptar = false;
        this.oClienteCredito = pClienteCredito;
        this.tituloPrincipal.setText("MODIFICAR CLIENTE");
        this.setClienteCredito();
    }
    
    public boolean isAceptar(){
        return this.aceptar;
    }
    
    public ClienteCredito getClienteCredito(){
        double monto = Double.parseDouble(this.cpMontoCredito.getValue().toString());
        int fecha = Integer.parseInt(this.cpPeriodoGracia.getModel().getValue().toString());
        ClienteCredito aux = new ClienteCredito(this.cpCodigo.getText(), this.cpNombre.getText(), 
                                                    this.cpApellido1.getText(), this.cpApellido2.getText(), 
                                                    this.cpTelefono.getText(), this.cpCorreo.getText(), 
                                                    this.cpDireccion.getText(), this.cbxCategoria.getSelectedItem().toString(),
                                                    this.cpNotas.getText(), monto, fecha);
        return aux;
    }
    
    public void setClienteCredito(){
        this.cpCodigo.setText(oClienteCredito.getCodigo());
        this.cpNombre.setText(oClienteCredito.getNombre());
        this.cpApellido1.setText(oClienteCredito.getApellido1());
        this.cpApellido2.setText(oClienteCredito.getApellido2());
        this.cpTelefono.setText(oClienteCredito.getTelefono());
        this.cpCorreo.setText(oClienteCredito.getCorreo_electrónico());
        this.cpDireccion.setText(oClienteCredito.getDireccion());
        this.cpMontoCredito.setText(String.valueOf(oClienteCredito.getMonto_credito()));
        this.cpPeriodoGracia.getModel().setValue(oClienteCredito.getFecha_gracia());
        this.cpNotas.setText(oClienteCredito.getNotas());
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
        tituloPrincipal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cpCodigo = new javax.swing.JTextField();
        cpDireccion = new javax.swing.JTextField();
        cpNombre = new javax.swing.JTextField();
        cpApellido1 = new javax.swing.JTextField();
        cpApellido2 = new javax.swing.JTextField();
        cpTelefono = new javax.swing.JFormattedTextField();
        cpCorreo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCategoria = new javax.swing.JLabel();
        txtMontoCredito = new javax.swing.JLabel();
        txtPeriodoGracia = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox();
        cpMontoCredito = new javax.swing.JFormattedTextField();
        cpPeriodoGracia = new javax.swing.JSpinner();
        txtDias = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cpNotas = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        tituloPrincipal.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
        tituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        tituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setText("AGREGAR CLIENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tituloPrincipal)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 750, 74);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Primer apellido:");

        jLabel4.setText("Segundo apellido:");

        jLabel5.setText("Teléfono:");

        jLabel6.setText("Correo electrónico:");

        jLabel7.setText("Dirección:");

        cpCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpCodigoKeyPressed(evt);
            }
        });

        cpDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpDireccionKeyPressed(evt);
            }
        });

        cpNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpNombreKeyPressed(evt);
            }
        });

        cpApellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpApellido1KeyPressed(evt);
            }
        });

        cpApellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpApellido2KeyPressed(evt);
            }
        });

        cpTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpTelefonoKeyPressed(evt);
            }
        });

        cpCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpCorreoKeyPressed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtCategoria.setText("Categoría:");

        txtMontoCredito.setText("Monto crédito:");

        txtPeriodoGracia.setText("Periódo de gracia:");

        jLabel12.setText("Notas:");

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C" }));
        cbxCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxCategoriaKeyPressed(evt);
            }
        });

        cpMontoCredito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        cpMontoCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpMontoCreditoKeyPressed(evt);
            }
        });

        cpPeriodoGracia.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        cpPeriodoGracia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpPeriodoGraciaKeyPressed(evt);
            }
        });

        txtDias.setFont(new java.awt.Font("Raleway", 1, 12)); // NOI18N
        txtDias.setText("días");

        cpNotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpNotasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(cpNotas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cpCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2))
                                            .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(66, 66, 66)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(57, 57, 57)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cpTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cpCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cpNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cpApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cpApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtCategoria)
                            .addComponent(txtMontoCredito)
                            .addComponent(txtPeriodoGracia)
                            .addComponent(jLabel12))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpDireccion)
                            .addComponent(cpMontoCredito)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cpPeriodoGracia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cpCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cpDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cpNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategoria))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cpApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoCredito)
                    .addComponent(cpMontoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cpApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpPeriodoGracia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeriodoGracia)
                    .addComponent(txtDias))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cpTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 100, 670, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if(!this.cpCodigo.getText().toString().equals("") ||
            !this.cpNombre.getText().toString().equals("") ||
            !this.cpApellido1.getText().toString().equals("") ||
            !this.cpApellido2.getText().toString().equals("") ||
            !this.cpTelefono.getText().toString().equals("") ||
            !this.cpCorreo.getText().toString().equals("") ||
            !this.cpDireccion.getText().toString().equals("") || 
            !this.cpMontoCredito.getText().toString().equals("")){

            this.aceptar = true;
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(rootPane, "No rellenó algunos campos necesarios");
        }
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cpCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpCodigoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.cpNombre.requestFocus();
        }
    }//GEN-LAST:event_cpCodigoKeyPressed

    private void cpNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpNombreKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.cpApellido1.requestFocus();
        }
    }//GEN-LAST:event_cpNombreKeyPressed

    private void cpApellido1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpApellido1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.cpApellido2.requestFocus();
        }
    }//GEN-LAST:event_cpApellido1KeyPressed

    private void cpApellido2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpApellido2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.cpTelefono.requestFocus();
        }
    }//GEN-LAST:event_cpApellido2KeyPressed

    private void cpTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpTelefonoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.cpCorreo.requestFocus();
        }
    }//GEN-LAST:event_cpTelefonoKeyPressed

    private void cpCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpCorreoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.cpDireccion.requestFocus();
        }
    }//GEN-LAST:event_cpCorreoKeyPressed

    private void cpDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpDireccionKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.cbxCategoria.requestFocus();
        }
    }//GEN-LAST:event_cpDireccionKeyPressed

    private void cbxCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxCategoriaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.cpMontoCredito.requestFocus();
        }
    }//GEN-LAST:event_cbxCategoriaKeyPressed

    private void cpMontoCreditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpMontoCreditoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.cpPeriodoGracia.requestFocus();
        }
    }//GEN-LAST:event_cpMontoCreditoKeyPressed

    private void cpPeriodoGraciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpPeriodoGraciaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.cpNotas.requestFocus();
        }
    }//GEN-LAST:event_cpPeriodoGraciaKeyPressed

    private void cpNotasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpNotasKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_TAB){ 
            this.btnAgregar.requestFocus();
        }
    }//GEN-LAST:event_cpNotasKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbxCategoria;
    private javax.swing.JTextField cpApellido1;
    private javax.swing.JTextField cpApellido2;
    private javax.swing.JTextField cpCodigo;
    private javax.swing.JTextField cpCorreo;
    private javax.swing.JTextField cpDireccion;
    private javax.swing.JFormattedTextField cpMontoCredito;
    private javax.swing.JTextField cpNombre;
    private javax.swing.JTextPane cpNotas;
    private javax.swing.JSpinner cpPeriodoGracia;
    private javax.swing.JFormattedTextField cpTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tituloPrincipal;
    private javax.swing.JLabel txtCategoria;
    private javax.swing.JLabel txtDias;
    private javax.swing.JLabel txtMontoCredito;
    private javax.swing.JLabel txtPeriodoGracia;
    // End of variables declaration//GEN-END:variables
}