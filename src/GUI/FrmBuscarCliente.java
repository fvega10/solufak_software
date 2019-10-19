/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BaseDeDatos.ConsultasSQLTablaClienteContado;
import BaseDeDatos.ConsultasSQLTablaClienteCredito;
import baseDatos.ConexionBaseDatos;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Articulo;
import logica.ClienteContado;
import logica.ClienteCredito;

/**
 *
 * @author Fabricio
 */
public class FrmBuscarCliente extends javax.swing.JDialog {
    private boolean aceptar;
    ConexionBaseDatos conexion;
    Articulo oCliente;
    ArrayList clientes;
    ArrayList clienteCredito;
    private int fila;
    private String[][] datos;
    private boolean tipo; //True credito, False contado
    /**
     * Creates new form frmBuscarCliente
     */
    public FrmBuscarCliente(java.awt.Frame parent, boolean modal, ConexionBaseDatos pConexion) {
        super(parent, modal);
        initComponents();
        this.setMinimumSize(new Dimension(660, 541));  // Impide hacer más pequeño el frame
        this.setLocationRelativeTo(parent);
        this.aceptar = false;
        this.conexion = pConexion;
        this.datos = new String[0][8];
        tipo = true;
        this.cargarDatosClientes();
        
    }
    /**
     * El que asigna los datos al panel en el frame según los datos(matriz) y su cabecera(arreglo)
     */
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    /**
     * Cabecera del Panel correspondiente a la tabla Dueño
     * @return un arreglo con la cabecera correspondiente a cada tabla de la base de datos
     */
    
    private String[] cabecerasCliente = {"Código", "Nombre", "Apellido1", "Apellido2", "Teléfono", "Correo Electrónico", "Dirección", "Tipo"};
    
    /**
     * Redimensiona el Panel según los datos de la tabla
     */
    private void redimensionarMatriz() {
        String[][] respaldo = this.datos;   // Respalda los datos de la matriz principal en una auxiliar

        this.datos = new String[respaldo.length + 1][8]; // Inicializa la matriz sumandole un fila adicional, con la cantidad de columnas asginadas por parámetros
        
        // Permite redimensionar la matrix con los datos de la matrix auxiliar más la columna nueva sin datos
        for (int i = 0; i < respaldo.length; i++) {
            for (int j = 0; j < respaldo[0].length; j++) {
                this.datos[i][j] = respaldo[i][j];  // Vuelve agregar los datos de la matrix auxiliar para no perder ningúna datos
            }
        }
    }
    
    public boolean isAceptar(){
        return this.aceptar;
    }
    
    public boolean isClienteCredito(){
        return this.tipo;
    }
    
    public ArrayList getCliente(){
        ArrayList arregloCliente = new ArrayList();
        if(this.datos[fila][7].equals("Contado")){
            ClienteContado oC = new ClienteContado(this.datos[fila][0], 
                                            this.datos[fila][1], 
                                            this.datos[fila][2], 
                                            this.datos[fila][3], 
                                            this.datos[fila][4], 
                                            this.datos[fila][5], 
                                            this.datos[fila][6]);
            arregloCliente.add(oC);
            
        }else{
            for(int i = 0; i<this.clienteCredito.size(); i++){
                ClienteCredito oCC = (ClienteCredito)clienteCredito.get(i);
                if(oCC.getTipo().equals(this.datos[fila][7])){
                    arregloCliente.add(oCC);
                    break;
                }
            }
            
            
        }
        return arregloCliente;
        
    }
    
    
    public void cargarDatosClientes(){
        ConsultasSQLTablaClienteContado oA = new ConsultasSQLTablaClienteContado(conexion);
        clientes = oA.obtenerClienteContado();
        if(!oA.isError()){
            if(clientes.size()>0){
                for(int i = 0; i < clientes.size(); i++){
                    ClienteContado oArt = (ClienteContado)clientes.get(i);
                    this.redimensionarMatriz();
                    this.datos[this.datos.length - 1][0] = oArt.getCodigo();
                    this.datos[this.datos.length - 1][1] = oArt.getNombre();
                    this.datos[this.datos.length - 1][2] = oArt.getApellido1();
                    this.datos[this.datos.length - 1][3] = oArt.getApellido2();
                    this.datos[this.datos.length - 1][4] = oArt.getTelefono();
                    this.datos[this.datos.length - 1][5] = oArt.getCorreo_electrónico();
                    this.datos[this.datos.length - 1][6] = oArt.getDireccion();
                    this.datos[this.datos.length - 1][7] = oArt.getTipo();
                }
                this.modelo.setDataVector(datos, cabecerasCliente); // Se prepara el panel con los datos y cabecera determinados
                this.panel.setModel(modelo);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error inesperado");
        }
        ConsultasSQLTablaClienteCredito oE = new ConsultasSQLTablaClienteCredito(conexion);
        clienteCredito = oE.obtenerClienteCredito();
        if(!oE.isError()){
            if(clienteCredito.size()>0){
                for(int i = 0; i < clienteCredito.size(); i++){
                    ClienteCredito oArt = (ClienteCredito)clienteCredito.get(i);
                    this.redimensionarMatriz();
                    this.datos[this.datos.length - 1][0] = oArt.getCodigo();
                    this.datos[this.datos.length - 1][1] = oArt.getNombre();
                    this.datos[this.datos.length - 1][2] = oArt.getApellido1();
                    this.datos[this.datos.length - 1][3] = oArt.getApellido2();
                    this.datos[this.datos.length - 1][4] = oArt.getTelefono();
                    this.datos[this.datos.length - 1][5] = oArt.getCorreo_electrónico();
                    this.datos[this.datos.length - 1][6] = oArt.getDireccion();
                    this.datos[this.datos.length - 1][7] = oArt.getTipo();
                }
                this.modelo.setDataVector(datos, cabecerasCliente); // Se prepara el panel con los datos y cabecera determinados
                this.panel.setModel(modelo);
            }
        }
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jLabel1.setFont(new java.awt.Font("Poiret One", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANTENIMIENTO CLIENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 640, 80);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel2.setText("Filtrar por nombre:");

        jButton1.setText("Filtrar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 80, 640, 100);

        panel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(panel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 200, 580, 230);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(350, 460, 110, 35);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setBounds(160, 460, 110, 35);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            if(this.panel.getSelectedRow() >=0){
                fila = this.panel.getSelectedRow();
                if(this.datos[fila][7].equals("Contado")){
                    tipo = false; // Contado
                }else{
                    tipo = true; // Crédito
                }
                aceptar = true;
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Debe seleccionar al menos una fila");
            }
        }
    }//GEN-LAST:event_panelMouseClicked

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        if(this.panel.getSelectedRow() >=0){
            fila = this.panel.getSelectedRow();
            aceptar = true;
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar al menos una fila");
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable panel;
    // End of variables declaration//GEN-END:variables
}
