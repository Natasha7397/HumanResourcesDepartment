/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.Employee;

import Check.Resize;
import java.awt.Frame;
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
public class EditEmployees extends javax.swing.JDialog {

    private Connection connection;
    private EmployeeModel model;
    private Resize columnWidth;

    /**
     * Creates new form Employees
     *
     * @param parent
     * @param modal
     * @param c
     */
    public EditEmployees(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();
        connection = c;
        try {
            model = new EmployeeModel(connection);
        } catch (SQLException ex) {
            Logger.getLogger(EditEmployees.class.getName()).log(Level.SEVERE, null, ex);
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
        addEmployee = new javax.swing.JButton();
        editEmployee = new javax.swing.JButton();
        deletEmployee = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        addEmployee.setText("Добавить");
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });

        editEmployee.setText("Изменить");
        editEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmployeeActionPerformed(evt);
            }
        });

        deletEmployee.setText("Удалить");
        deletEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(addEmployee)
                .addGap(37, 37, 37)
                .addComponent(editEmployee)
                .addGap(44, 44, 44)
                .addComponent(deletEmployee)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmployee)
                    .addComponent(editEmployee)
                    .addComponent(deletEmployee))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
        NewEmployee nu = new NewEmployee((Frame) this.getParent(), true, connection);
        nu.setVisible(true);
        try {
            model.updateData();
        } catch (SQLException ex) {
            Logger.getLogger(EditEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_addEmployeeActionPerformed

    private void editEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmployeeActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            NewEmployee nu = new NewEmployee((Frame) this.getParent(), true,
                    connection, model.getSelectesEmployee(jTable1.getSelectedRow()));
            nu.setVisible(true);
            try {
                model.updateData();
            } catch (SQLException ex) {
                Logger.getLogger(EditEmployees.class.getName()).log(Level.SEVERE, null, ex);
            }
            ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
        }
    }//GEN-LAST:event_editEmployeeActionPerformed

    private void deletEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletEmployeeActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            try {
                model.delete(
                        model.getSelectesEmployee(jTable1.getSelectedRow()).getTabNumber());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                return;
            }
        }
        try {
            model.updateData();
        } catch (SQLException ex) {
            Logger.getLogger(EditEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((AbstractTableModel) jTable1.getModel()).fireTableDataChanged();
    }//GEN-LAST:event_deletEmployeeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployee;
    private javax.swing.JButton deletEmployee;
    private javax.swing.JButton editEmployee;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
