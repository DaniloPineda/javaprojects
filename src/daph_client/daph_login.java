/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daph_client;

import daph_criptografia.Daph_criptografia;
import javax.swing.JOptionPane;
import daph_criptografia.daph_enumTypes;

/**
 *
 * @author DELL
 */
public class daph_login extends javax.swing.JDialog {

    /**
     * Creates new form daph_login
     */
     daph_enumTypes enumTypes;
     Daph_criptografia crytoService = new Daph_criptografia();
     
    public daph_login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnEncrypt = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("User");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 13);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 13);
        jPanel1.add(jLabel2, gridBagConstraints);

        txtUser.setPreferredSize(new java.awt.Dimension(220, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 13);
        jPanel1.add(txtUser, gridBagConstraints);

        txtPassword.setPreferredSize(new java.awt.Dimension(220, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 13);
        jPanel1.add(txtPassword, gridBagConstraints);

        jLabel3.setText("Please, fill in user and password to encrypt.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(jLabel3, gridBagConstraints);

        btnEncrypt.setText("Encrpyt");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        jPanel1.add(btnEncrypt, gridBagConstraints);

        btnCancel.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        jPanel1.add(btnCancel, gridBagConstraints);

        jButton1.setText("Decript");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        jPanel1.add(jButton1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        String enteredUser = this.txtUser.getText();
        int enteredPassword = this.txtPassword.getPassword().length;
        if(enteredUser.isEmpty() || enteredPassword == 0)
        {
            JOptionPane.showMessageDialog(this,"You must enter user and password");
            return;
        }
        String password = String.valueOf(this.txtPassword.getPassword());
        this.dispose();
        
        String userEncryptMD5 = crytoService.encryptText(daph_enumTypes.MD5, enteredUser );
        String userEncryptSHA = crytoService.encryptText(daph_enumTypes.SHA, enteredUser );
        String userEncryptSHA256 = crytoService.encryptText(daph_enumTypes.SHA256, enteredUser );
        String userEncryptSHA512 = crytoService.encryptText(daph_enumTypes.SHA512, enteredUser );
        
        String passEncryptMD5 = crytoService.encryptText(daph_enumTypes.MD5, password );
        String passEncryptSHA = crytoService.encryptText(daph_enumTypes.SHA, password );
        String passEncryptSHA256 = crytoService.encryptText(daph_enumTypes.SHA256, password );
        String passEncryptSHA512 = crytoService.encryptText(daph_enumTypes.SHA512, password );
        
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                daph_AppMain appMain = new daph_AppMain();
                appMain.setVisible(true);
                appMain.setArguments(enteredUser, password, userEncryptMD5, userEncryptSHA, userEncryptSHA256, userEncryptSHA512, 
                        passEncryptMD5, passEncryptSHA, passEncryptSHA256, passEncryptSHA512);
            }
        });
        
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String enteredUser = this.txtUser.getText();
        int enteredPassword = this.txtPassword.getPassword().length;
        if(enteredUser.isEmpty() || enteredPassword == 0)
        {
            JOptionPane.showMessageDialog(this,"You must enter user and password");
            return;
        }
        String password = String.valueOf(this.txtPassword.getPassword());
        this.dispose();
        
        String userEncryptMD5 = crytoService.decryptText(enteredUser );
        String userEncryptSHA = crytoService.decryptText(enteredUser );
        String userEncryptSHA256 = crytoService.decryptText(enteredUser );
        String userEncryptSHA512 = crytoService.decryptText(enteredUser );
        
        String passEncryptMD5 = crytoService.decryptText( password );
        String passEncryptSHA = crytoService.decryptText(password );
        String passEncryptSHA256 = crytoService.decryptText(password );
        String passEncryptSHA512 = crytoService.decryptText( password );
        
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                daph_AppMain appMain = new daph_AppMain();
                appMain.setVisible(true);
                appMain.setArguments(enteredUser, password, userEncryptMD5, userEncryptSHA, userEncryptSHA256, userEncryptSHA512, 
                        passEncryptMD5, passEncryptSHA, passEncryptSHA256, passEncryptSHA512);
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(daph_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daph_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daph_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daph_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                daph_login dialog = new daph_login(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
