/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.form;

import client.validation.ValidationException;
import client.validation.Validator;
import client.view.controller.Controller;
import commonlib.domain.Employee;
import javax.swing.JOptionPane;

/**
 *
 * @author ANA
 */
public class FormChangePassword extends javax.swing.JDialog {

    /**
     * Creates new form FormChangePassword
     */
    public FormChangePassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOldPassword = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        lblNewPassword = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        btnChange = new javax.swing.JButton();
        lblErrorOldPass = new javax.swing.JLabel();
        lblErrorNewPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblOldPassword.setText("Trenutna šifra:");

        txtOldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOldPasswordFocusGained(evt);
            }
        });

        lblNewPassword.setText("Nova šifra:");

        txtNewPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNewPasswordFocusGained(evt);
            }
        });

        btnChange.setText("Promijeni");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        lblErrorOldPass.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        lblErrorOldPass.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorNewPass.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        lblErrorNewPass.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorOldPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNewPassword)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblErrorNewPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnChange)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOldPassword)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lblErrorOldPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPassword)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorNewPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChange)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        boolean signal = true;
        String oldPass = String.valueOf(txtOldPassword.getPassword());
        String newPass = String.valueOf(txtNewPassword.getPassword());
        try {
            Validator.startValidation()
                    .validateNotNullOrEmpty(oldPass, "Trenutna šifra je obavezno polje.")
                    .throwIfInvalide();
        } catch (ValidationException ex) {
            signal = false;
            lblErrorOldPass.setText(ex.getMessage());
        }
        try {
            Validator.startValidation()
                    .validateNotNullOrEmpty(newPass, "Nova šifra je obavezno polje.")
                    .throwIfInvalide();
        } catch (ValidationException ex) {
            signal = false;
            lblErrorNewPass.setText(ex.getMessage());
        }
        if (signal) {
            try {
                Employee employee = Controller.getInstance().getCurrentEmployee();
                if (employee.getPassword().equals(oldPass)) {
                    if (oldPass.equals(newPass)) {
                        JOptionPane.showMessageDialog(this, "Trenutna i nova šifra ne mogu biti iste.", "Greška", JOptionPane.ERROR_MESSAGE);
                    } else {
                        employee.setPassword(newPass);
                        Controller.getInstance().changePassword(employee);
                        JOptionPane.showMessageDialog(this, "Uspješno promijenjena šifra");
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Pogrešna trenutna šifra", "Greška", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    private void txtOldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOldPasswordFocusGained
        lblErrorOldPass.setText("");
    }//GEN-LAST:event_txtOldPasswordFocusGained

    private void txtNewPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewPasswordFocusGained
        lblErrorNewPass.setText("");
    }//GEN-LAST:event_txtNewPasswordFocusGained

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JLabel lblErrorNewPass;
    private javax.swing.JLabel lblErrorOldPass;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblOldPassword;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    // End of variables declaration//GEN-END:variables

}
