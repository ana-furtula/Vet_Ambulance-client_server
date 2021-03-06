/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.components;

import client.communication.Communication;
import client.listeners.NotificationListener;
import client.view.controller.Controller;
import commonlib.domain.Invoice;
import commonlib.domain.InvoiceItem;
import commonlib.domain.Medicine;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ANA
 */
public class PanelInvoiceItemMedicine extends javax.swing.JPanel {

    private List<Medicine> medicines;

    /**
     * Creates new form PanelInvoiceItemMedicine
     */
    public PanelInvoiceItemMedicine() {
        initComponents();
        try {
            prepareView();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Došlo je do greške", "Greška", JOptionPane.ERROR_MESSAGE);
        }
        Controller.getInstance().setNotificationListener(new NotificationListener() {
            @Override
            public void invoiceChanged(Invoice invoice) {
                try {
                    for (InvoiceItem item : invoice.getItems()) {
                        if (item.getMedicine() != null) {
                            for (Medicine medicine : medicines) {
                                if (medicine.getId().equals(item.getMedicine().getId())) {
                                    medicine.setAvailableQuantity(item.getMedicine().getAvailableQuantity());
                                    break;
                                }
                            }
                        }
                    }
                    if (cmbMedicine.getSelectedItem() != null) {
                        txtAvailableQuantity.setText(((Medicine) cmbMedicine.getSelectedItem()).getAvailableQuantity().toString());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void newInvoiceAdded(Invoice invoice) {
                try {
                    for (InvoiceItem item : invoice.getItems()) {
                        if (item.getMedicine() != null) {
                            for (Medicine medicine : medicines) {
                                if (medicine.getId().equals(item.getMedicine().getId())) {
                                    medicine.setAvailableQuantity(item.getMedicine().getAvailableQuantity());
                                    break;
                                }
                            }
                        }
                    }
                    if (cmbMedicine.getSelectedItem() != null) {
                        txtAvailableQuantity.setText(((Medicine) cmbMedicine.getSelectedItem()).getAvailableQuantity().toString());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void changedMedicine(Medicine medicine1) {
                try {
                    for (Medicine medicine : medicines) {
                        if (medicine.getId().equals(medicine1.getId())) {
                            medicine.setAvailableQuantity(medicine1.getAvailableQuantity());
                            medicine.setMeasurementUnit(medicine1.getMeasurementUnit());
                            medicine.setName(medicine1.getName());
                            medicine.setPrice(medicine1.getPrice());
                            break;
                        }
                    }
                    if (cmbMedicine.getSelectedItem() != null && ((Medicine) cmbMedicine.getSelectedItem()).getId().equals(medicine1.getId())) {
                        txtAvailableQuantity.setText(medicine1.getAvailableQuantity().toString());
                        txtMeasurementUnit.setText(medicine1.getMeasurementUnit().toString());
                        txtPrice.setText(medicine1.getPrice().toString());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void deletedMedicine(Medicine medicine1) {
                try {
                    for (Medicine medicine : medicines) {
                        if (medicine.getId().equals(medicine1.getId())) {
                            if (cmbMedicine.getSelectedItem() != null && ((Medicine) cmbMedicine.getSelectedItem()).getId().equals(medicine.getId())) {
                                txtAvailableQuantity.setText("");
                                txtMeasurementUnit.setText("");
                                txtPrice.setText("");
                                txtQuantityForItem.setText("");
                            }
                            cmbMedicine.removeItem(medicine);
                            medicines.remove(medicine);
                            break;
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void newMedicineAdded(Medicine medicine) {
                medicines.add(medicine);
                cmbMedicine.addItem(medicine);
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMedicine = new javax.swing.JLabel();
        cmbMedicine = new javax.swing.JComboBox();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblAvailableQuantity = new javax.swing.JLabel();
        txtAvailableQuantity = new javax.swing.JTextField();
        lblErrorQuantity = new javax.swing.JLabel();
        lblQuantityForItem = new javax.swing.JLabel();
        txtQuantityForItem = new javax.swing.JTextField();
        lblMeasurementUnit = new javax.swing.JLabel();
        txtMeasurementUnit = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Lijek"));

        lblMedicine.setText("Izaberite lijek:");

        cmbMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedicineActionPerformed(evt);
            }
        });

        lblPrice.setText("Cijena:");

        txtPrice.setEditable(false);

        lblAvailableQuantity.setText("Raspoloživo:");

        txtAvailableQuantity.setEditable(false);

        lblErrorQuantity.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        lblErrorQuantity.setForeground(new java.awt.Color(255, 0, 0));

        lblQuantityForItem.setText("Količina:");

        txtQuantityForItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantityForItemFocusGained(evt);
            }
        });

        lblMeasurementUnit.setText("Mjerna jedinica:");

        txtMeasurementUnit.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblErrorQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblAvailableQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQuantityForItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMeasurementUnit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbMedicine, 0, 301, Short.MAX_VALUE)
                            .addComponent(txtPrice)
                            .addComponent(txtAvailableQuantity)
                            .addComponent(txtQuantityForItem)
                            .addComponent(txtMeasurementUnit))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedicine)
                    .addComponent(cmbMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvailableQuantity)
                    .addComponent(txtAvailableQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMeasurementUnit)
                    .addComponent(txtMeasurementUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantityForItem)
                    .addComponent(txtQuantityForItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorQuantity)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedicineActionPerformed
        Medicine medicine = (Medicine) cmbMedicine.getSelectedItem();
        txtPrice.setText(medicine.getPrice().toString());
        txtAvailableQuantity.setText(medicine.getAvailableQuantity().toString());
        txtMeasurementUnit.setText(medicine.getMeasurementUnit().toString());
    }//GEN-LAST:event_cmbMedicineActionPerformed

    private void txtQuantityForItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityForItemFocusGained
        lblErrorQuantity.setText("");
    }//GEN-LAST:event_txtQuantityForItemFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbMedicine;
    private javax.swing.JLabel lblAvailableQuantity;
    private javax.swing.JLabel lblErrorQuantity;
    private javax.swing.JLabel lblMeasurementUnit;
    private javax.swing.JLabel lblMedicine;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantityForItem;
    private javax.swing.JTextField txtAvailableQuantity;
    private javax.swing.JTextField txtMeasurementUnit;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantityForItem;
    // End of variables declaration//GEN-END:variables

    private void prepareView() throws Exception {
        medicines = Controller.getInstance().getAllMedicines();

        for (Medicine medicine : medicines) {
            cmbMedicine.addItem(medicine);
        }

    }

    public Medicine getSelectedMedicine() throws Exception {
        if (cmbMedicine.getItemCount() > 0) {
            return (Medicine) cmbMedicine.getSelectedItem();
        } else {
            throw new Exception("Ne postoji nijedan lijek.");
        }
    }

    public String getSelectedQuantity() throws Exception {
        return txtQuantityForItem.getText().trim();
    }

    public void setSelectedQuantityError(String error) {
        lblErrorQuantity.setText(error);
    }

    public void updateAvailableQuantity(BigDecimal leftQuantity, Medicine med) {
        for (Medicine medicine : medicines) {
            if (medicine.getId().equals(med.getId())) {
                medicine.setAvailableQuantity(leftQuantity);
                break;
            }
        }
    }
    
    public BigDecimal getAvailableQuantity(Medicine med) {
        for (Medicine medicine : medicines) {
            if (medicine.getId().equals(med.getId())) {
                return medicine.getAvailableQuantity();
            }
        }
        return BigDecimal.valueOf(-1);
    }
    
    
}
