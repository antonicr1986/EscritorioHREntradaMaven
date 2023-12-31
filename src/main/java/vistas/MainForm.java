package vistas;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import login.ConexionBDLocal;


/**
 *
 * @author antonio minero
 */
public class MainForm extends javax.swing.JFrame {

    public JTextField getjTextFieldIPServidor() {
        return jTextFieldIPServidor;
    }

    public JPasswordField getjPasswordField() {
        return jPasswordField;
    }

    public void setjPasswordField(JPasswordField jPasswordField) {
        this.jPasswordField = jPasswordField;
    }

    public JTextField getjTextFieldUsuario() {
        return jTextFieldUsuario;
    }

    public void setjTextFieldUsuario(JTextField jTextFieldUsuario) {
        this.jTextFieldUsuario = jTextFieldUsuario;
    }

    public void setjTextFieldIPServidor(JTextField jTextFieldIPServidor) {
        this.jTextFieldIPServidor = jTextFieldIPServidor;
    }
    
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        this.setTitle("Ventana Login usuarios");
        // Establece la ubicación de la ventana en el centro de la pantalla
        this.setLocationRelativeTo(null);
        jCheckBoxVerContraseña.setEnabled(false);
        jButtonConfirmar.setEnabled(false);
        jPasswordField.setEnabled(false);              
    }
    
    public void conexionSocket(FormUsuarioAdmin adminForm, FormUsuario usuarioForm){
        boolean salir = false;

        try {
            //IMPLEMENTA
            Socket socket = new Socket(jTextFieldIPServidor.getText(), 8888);
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));//flujo lectura del server
            BufferedWriter escriptor = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//flujo envio al server
            
            ///Llegeix del servidor el mensaje de bienvenida, y la pregunta que nos hace ///           
            String mensajeServer = lector.readLine();
            
            //ahora escribimos en servidor , enviandole la palabra a buscar 
            String palabra = jTextFieldUsuario.getText();
            String pass = jPasswordField.getText();
            String number = null;
            String codigo = null;

            String login = palabra + "," + pass;

            escriptor.write(login);
            escriptor.newLine();
            escriptor.flush();

            mensajeServer = lector.readLine();

            String[] textElements = mensajeServer.split(",");
            for (int i = 0; i < textElements.length; i++) {
                palabra = textElements[0];
                pass = textElements[1];
                number = textElements[2];
                codigo = textElements[3];             
            }
            
            //recibimos la respuesta
            if (palabra.equals(jTextFieldUsuario.getText())
                    && pass.equals(jPasswordField.getText())
                    && number.equals("0")) {
                adminForm.setVisible(true);
                this.setVisible(salir);
            } else if (palabra.equals(jTextFieldUsuario.getText())
                    && pass.equals(jPasswordField.getText())
                    && number.equals("1")) {
                usuarioForm.setVisible(true);
                this.setVisible(salir);
            }
            lector.close();
            escriptor.close();
            socket.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void habilitarBotones() {
        if (!jTextFieldUsuario.getText().isEmpty() && !jPasswordField.getText().isEmpty()) {
            jButtonConfirmar.setEnabled(true);
            jCheckBoxVerContraseña.setEnabled(true);
        } else {
            jButtonConfirmar.setEnabled(false);
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
        jButtonConfirmar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelContraseña = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelServidorIP = new javax.swing.JLabel();
        jTextFieldIPServidor = new javax.swing.JTextField();
        jCheckBoxVerContraseña = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(331, 267));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setMinimumSize(new java.awt.Dimension(331, 262));

        jButtonConfirmar.setText("CONFIRMAR");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("LIMPIAR");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jLabelUsuario.setText("Usuario");

        jLabelContraseña.setText("Contraseña");

        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyReleased(evt);
            }
        });

        jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioKeyReleased(evt);
            }
        });

        jLabelServidorIP.setText("IP Servidor");

        jCheckBoxVerContraseña.setBackground(new java.awt.Color(102, 102, 102));
        jCheckBoxVerContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxVerContraseña.setText("Ver contraseña");
        jCheckBoxVerContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxVerContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxVerContraseña)
                    .addComponent(jLabelUsuario)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButtonConfirmar)
                            .addGap(79, 79, 79)
                            .addComponent(jButtonLimpiar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelContraseña)
                            .addGap(23, 23, 23)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelServidorIP)
                            .addGap(27, 27, 27)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(jTextFieldIPServidor)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelServidorIP)
                    .addComponent(jTextFieldIPServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContraseña)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jCheckBoxVerContraseña)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonLimpiar))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        jTextFieldUsuario.setText("");
        jPasswordField.setText("");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        FormUsuarioAdmin ventanaSecundariaAdmin= new FormUsuarioAdmin();
        FormUsuario ventanaSecundariaUser=new FormUsuario();
        try{
            // TODO add your handling code here:
            if (jTextFieldIPServidor.getText().isEmpty()||jTextFieldIPServidor.getText().isBlank()||jTextFieldIPServidor.getText() =="" ){
                   JOptionPane.showMessageDialog(null, 
                             "Rellena el campo IP.");
            }else{//Esta la ip rellena
                if (!jTextFieldUsuario.getText().equals("") && !jPasswordField.getText().equals("")) {                     
                                          
                        conexionSocket(ventanaSecundariaAdmin, ventanaSecundariaUser);
                        
                        //Conexion en local
                        /*ConexionBDLocal conexion = new ConexionBDLocal(jTextFieldIPServidor.getText());
                        Connection dbConnection = conexion.getConexion();

                        if (conexion.verificarCredencialesBDLocal(jTextFieldUsuario.getText(),jPasswordField.getText())==0){
                            dispose();
                            //Ofrecemos la info del objeto que podriamos guardar para enviar
                            conexion.logInSocketsInfo(jTextFieldUsuario.getText(),jPasswordField.getText()); //Para mostrar datos de los objetos creados
                            //Conexion por sockets
                            //conexionSocket(ventanaSecundariaAdmin, ventanaSecundariaUser);
                            ventanaSecundariaAdmin = new FormUsuarioAdmin ();
                            ventanaSecundariaAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            ventanaSecundariaAdmin.setLocation(x,y);
                            ventanaSecundariaAdmin.setVisible(true);  

                        }else if(conexion.verificarCredencialesBDLocal(jTextFieldUsuario.getText(),jPasswordField.getText())==1){
                            dispose();
                            //Ofrecemos la info del objeto que podriamos guardar para enviar
                            conexion.logInSocketsInfo(jTextFieldUsuario.getText(),jPasswordField.getText()); //Para mostrar datos de los objetos creados
                            //Conexion por sockets
                            //conexionSocket(ventanaSecundariaAdmin, ventanaSecundariaUser);
                            ventanaSecundariaUser = new FormUsuario ();
                            ventanaSecundariaUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            ventanaSecundariaUser.setLocation(x,y);
                            ventanaSecundariaUser.setVisible(true);  
                        }else if(conexion.verificarCredencialesBDLocal(jTextFieldUsuario.getText(),jPasswordField.getText())==-1){
                            JOptionPane.showMessageDialog(null, "Credenciales inválidas");
                        }
                        if(ventanaSecundariaAdmin!=null|| ventanaSecundariaUser!=null){
                            conexion.entrar(jTextFieldIPServidor.getText(),jTextFieldUsuario.getText(),jPasswordField.getText());
                        }   
                        if(jTextFieldUsuario.getText().isEmpty()&& jPasswordField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, 
                                  "Rellena los campos Usuario y Contraseña");
                        }else{
                            if (jTextFieldUsuario.getText().isEmpty()){
                             JOptionPane.showMessageDialog(null, 
                                      "Rellena el campo de Usuario.");
                             }
                             if ( jPasswordField.getText().isEmpty()){
                                 JOptionPane.showMessageDialog(null, 
                                          "Rellena el campo de Contraseña.");
                            } 
                        }*/
                    }
                }
        } catch (Exception ex) {
            Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed
    
    private void jCheckBoxVerContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxVerContraseñaActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxVerContraseña.isSelected()) {
            jPasswordField.setEchoChar((char) 0);
        } else {
            jPasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBoxVerContraseñaActionPerformed

    private void jPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyReleased
        // TODO add your handling code here:
        habilitarBotones();
        if(jPasswordField.getText()==""||jPasswordField.getText().isEmpty()){
            jCheckBoxVerContraseña.setEnabled(false);
        }
    }//GEN-LAST:event_jPasswordFieldKeyReleased

    private void jTextFieldUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyReleased
        // TODO add your handling code here:
        jPasswordField.setEnabled(true);
    }//GEN-LAST:event_jTextFieldUsuarioKeyReleased

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JCheckBox jCheckBoxVerContraseña;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelServidorIP;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldIPServidor;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
