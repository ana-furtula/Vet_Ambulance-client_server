/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.form;

import client.listeners.NotificationListener;
import client.view.components.TableModelInvoices;
import client.view.components.TableModelMedicines;
import client.view.controller.Controller;
import commonlib.domain.Invoice;
import commonlib.domain.Medicine;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ANA
 */
public class FormInvoicesView extends javax.swing.JDialog {

    /**
     * Creates new form FormInvoicesView
     */
    public FormInvoicesView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            prepareView();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Došlo je do greške prilikom inicijalizacije pogleda.", "Greška", JOptionPane.ERROR_MESSAGE);
        }

        Controller.getInstance().setNotificationListener(new NotificationListener() {
            @Override
            public void invoiceChanged(Invoice invoice) {
                TableModelInvoices model = (TableModelInvoices) tblInvoices.getModel();
                model.changeInvoice(invoice);
            }

            @Override
            public void newInvoiceAdded(Invoice invoice) {
                TableModelInvoices model = (TableModelInvoices) tblInvoices.getModel();
                model.add(invoice);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblInvoices = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblInvoices.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        tblInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblInvoices.setToolTipText("");
        tblInvoices.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tblInvoices.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblInvoices);

        btnSearch.setText("Pretraži");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchTerm = txtSearch.getText().trim();
        if (!searchTerm.equals("dd-MM-yyyy")) {
            try {
                TableModelInvoices tbm = (TableModelInvoices) tblInvoices.getModel();
                List<Invoice> invoices = Controller.getInstance().getInvoicesByDate(searchTerm);
                tbm.updateTable(invoices);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Doslo je do greške, pokušajte ponovo.", "Greška", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInvoices;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void prepareView() throws Exception {
        tblInvoices.getTableHeader().setOpaque(false);
        tblInvoices.getTableHeader().setBackground(new Color(51, 153, 255));
        tblInvoices.getTableHeader().setForeground(new Color(255, 255, 255));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblInvoices.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(JLabel.LEFT);
        tblInvoices.setRowHeight(22);
        List<Invoice> invoices = Controller.getInstance().getAllInvoices();
        tblInvoices.setModel(new TableModelInvoices(invoices));
        tblInvoices.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selected = tblInvoices.getSelectedRow();
                if (selected != -1) {
                    TableModelInvoices model = (TableModelInvoices) tblInvoices.getModel();
                    Invoice invoice = model.getInvoice(selected);
                    new FormInvoiceDetails(FormInvoicesView.this, true, invoice).setVisible(true);
                }
            }
        });

        txtSearch.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtSearch.getText().equals("dd-MM-yyyy")) {
                    txtSearch.setText("");
                    txtSearch.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtSearch.getText().isEmpty()) {
                    txtSearch.setForeground(Color.GRAY);
                    txtSearch.setText("dd-MM-yyyy");
                    TableModelInvoices tbm = (TableModelInvoices) tblInvoices.getModel();
                    try {
                        tbm.updateTable(Controller.getInstance().getAllInvoices());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(FormInvoicesView.this, "Doslo je do greške, pokušajte ponovo.", "Greška", JOptionPane.ERROR_MESSAGE);
                        FormInvoicesView.this.dispose();
                    }
                }
            }
        });

    }
}