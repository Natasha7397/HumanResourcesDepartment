/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.ContentOrder;

import java.sql.Connection;
import java.util.List;
import EssenceClasses.newpackage.ContentOrder;
import EssenceClasses.newpackage.Order;
import EssenceClasses.newpackage.Employee;
import EssenceClasses.newpackage.ActionOrder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class NewContentOrder extends javax.swing.JDialog {

    private Connection c;
    private ContentOrder editItem;
    private List<Order> order;
    private List<Employee> employee;
    private List<ActionOrder> actionOrder;

    /**
     * Creates new form NewContentOrder
     *
     * @param parent
     * @param modal
     * @param c
     */
    public NewContentOrder(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();

        this.c = c;
        entryContentOrder();
    }

    public NewContentOrder(java.awt.Frame parent, boolean modal, Connection c, ContentOrder u) {
        super(parent, modal);
        initComponents();
        
        this.c = c;
        editItem = u;
        entryContentOrder();
        fillFields();
    }
    private  void entryContentOrder(){
        order = new ArrayList<>();
        employee = new ArrayList<>();
        actionOrder = new ArrayList<>();

        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"order\"");
            while (rs.next()) {
                Order item = new Order(rs.getInt("id"),
                        rs.getString("date_order"));
                order.add(item);
            }
            order_id.setModel(new DefaultComboBoxModel(order.toArray()));

            rs = statement.executeQuery("SELECT * FROM \"employee\"");
            while (rs.next()) {
                Employee item = new Employee(rs.getInt("tab_number"),
                        rs.getString("last_name"),
                        rs.getString("name"), rs.getString("middle_name"),
                        rs.getString("date_birth"),
                        rs.getString("education"), rs.getString("date_of_work"));
                employee.add(item);
            }
            empl_tab_number.setModel(new DefaultComboBoxModel(employee.toArray()));

            rs = statement.executeQuery("SELECT * FROM action_order");
            while (rs.next()) {
                ActionOrder item = new ActionOrder(rs.getInt("id"), rs.getString("name"));
                actionOrder.add(item);
            }
            action_order_id.setModel(new DefaultComboBoxModel(actionOrder.toArray()));
        } catch (SQLException ex) {
            

        }
    }

    private void fillFields() {

        for (Order s : order) {
            if (s.getId() == editItem.getOrderId()) {
                order_id.setSelectedItem((s));
            }
        }
        for (Employee s : employee) {
            if (s.getTabNumber() == editItem.getEmplTabNumber()) {
                empl_tab_number.setSelectedItem((s));
            }
        }
        for (ActionOrder s : actionOrder) {
            if (s.getId() == editItem.getOrderActionId()) {
                action_order_id.setSelectedItem((s));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        order_id = new javax.swing.JComboBox<>();
        empl_tab_number = new javax.swing.JComboBox<>();
        action_order_id = new javax.swing.JComboBox<>();
        OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Приказ");

        jLabel2.setText("Сотрудник");

        jLabel3.setText("Действие приказа");

        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(action_order_id, 0, 175, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(order_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(empl_tab_number, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(order_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(empl_tab_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(action_order_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(OK)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        try {
            // TODO add your handling code here:
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into content_order "
                        + "(order_id,empl_tab_number,order_action_id) values "
                        + "('" + ((Order) order_id.getSelectedItem()).getId()
                        + "','" + ((Employee) empl_tab_number.getSelectedItem()).getTabNumber()
                        + "','" + ((ActionOrder) action_order_id.getSelectedItem()).getId() + "');");
            } else {
                statement.executeUpdate("update content_order set order_id='"
                        + ((Order) order_id.getSelectedItem()).getId()
                        + "',empl_tab_number='"
                        + ((Employee) empl_tab_number.getSelectedItem()).getTabNumber()
                        + "',order_action_id='"
                        + ((ActionOrder) action_order_id.getSelectedItem()).getId()
                        + "' where id=" + editItem.getId() + ";");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        dispose();
    }//GEN-LAST:event_OKActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OK;
    private javax.swing.JComboBox<String> action_order_id;
    private javax.swing.JComboBox<String> empl_tab_number;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> order_id;
    // End of variables declaration//GEN-END:variables
}
