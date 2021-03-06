/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.Order;

import Check.Resize;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class EditOrders extends javax.swing.JDialog {

    private Connection connection;
    private OrderModel model;
    private Resize columnWidth;

    /**
     * Creates new form Orders
     *
     * @param parent
     * @param modal
     * @param c
     */
    public EditOrders(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();
        connection = c;

        try {
            model = new OrderModel(connection);
        } catch (SQLException ex) {
            Logger.getLogger(EditOrders.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTable1.setModel(model);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        columnWidth = new Resize();
        columnWidth.resizeColumnWidth(jTable1);
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
        jTable1 = new javax.swing.JTable();
        addOrder = new javax.swing.JButton();
        editOrder = new javax.swing.JButton();
        deleteOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        addOrder.setText("Добавить");
        addOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderActionPerformed(evt);
            }
        });

        editOrder.setText("Изменить");
        editOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOrderActionPerformed(evt);
            }
        });

        deleteOrder.setText("Удалить");
        deleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addOrder)
                        .addGap(44, 44, 44)
                        .addComponent(editOrder)
                        .addGap(49, 49, 49)
                        .addComponent(deleteOrder)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOrder)
                    .addComponent(editOrder)
                    .addComponent(deleteOrder))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderActionPerformed
        try {
            NewOrder nu = new NewOrder((Frame) this.getParent(), true, connection);
            nu.setVisible(true);

            model.updateData();

            ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_addOrderActionPerformed

    private void editOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOrderActionPerformed
        try {
            if (jTable1.getSelectedRow() >= 0) {

                NewOrder nu = new NewOrder((Frame) this.getParent(), true,
                        connection, model.getSelectesOrder(jTable1.getSelectedRow()));
                nu.setVisible(true);

                model.updateData();

                ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_editOrderActionPerformed

    private void deleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderActionPerformed
        try {
            if (jTable1.getSelectedRow() >= 0) {
                try {
                    model.delete(
                        model.getSelectesOrder(jTable1.getSelectedRow()).getId());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                    return;
                }
            }
            model.updateData();
            ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        } catch (HeadlessException | SQLException ex) {

        }
    }//GEN-LAST:event_deleteOrderActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOrder;
    private javax.swing.JButton deleteOrder;
    private javax.swing.JButton editOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
