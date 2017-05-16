/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResourcesDepartment;

import Check.ColumnWidth;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import EssenceClasses.ActionOrder.ActionsOrder;
import EssenceClasses.ContentOrder.ContenrOrders;

import EssenceClasses.Employee.Employees;
import EssenceClasses.EmployeePost.EployeesPostst;
import EssenceClasses.Order.Orders;
import EssenceClasses.OrderPost.OrderPosts;
import EssenceClasses.Post.Posts;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Acer
 */
public class Main extends javax.swing.JFrame {

    Connection connection = null;
    Model model;
    ColumnWidth columnWidth;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        NewConnect nc = new NewConnect(this, true);
        nc.setVisible(true);
        if (nc.ready) {
            connection = nc.getConnection();
        }
        try {
            if (connection != null) {
                DatabaseMetaData dmd = connection.getMetaData();
                String url = dmd.getURL();
                status.setText("Подключено к базе "
                        + url.substring(url.lastIndexOf("/") + 1));
            } else {
                status.setText("Не подключено");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        model = new Model(connection);
        jTable1.setModel(model);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        columnWidth = new ColumnWidth();
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

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        status = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        connectMenu = new javax.swing.JMenu();
        newConnectMenu = new javax.swing.JMenuItem();
        closeConnectMenu = new javax.swing.JMenuItem();
        exitConnectMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        employeeMenu = new javax.swing.JMenuItem();
        postMenu = new javax.swing.JMenuItem();
        orderMenu = new javax.swing.JMenuItem();
        action_orderMenu = new javax.swing.JMenuItem();
        content_orderMenu = new javax.swing.JMenuItem();
        employee_postMenu = new javax.swing.JMenuItem();
        order_postMenu = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        connectMenu.setText("Подключение");

        newConnectMenu.setText("Новое");
        newConnectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newConnectMenuActionPerformed(evt);
            }
        });
        connectMenu.add(newConnectMenu);

        closeConnectMenu.setText("Отключить");
        closeConnectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeConnectMenuActionPerformed(evt);
            }
        });
        connectMenu.add(closeConnectMenu);

        exitConnectMenu.setText("Выйти");
        exitConnectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitConnectMenuActionPerformed(evt);
            }
        });
        connectMenu.add(exitConnectMenu);

        jMenuBar1.add(connectMenu);

        jMenu3.setText("Сущности");

        employeeMenu.setText("Сотрудники");
        employeeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeMenuActionPerformed(evt);
            }
        });
        jMenu3.add(employeeMenu);

        postMenu.setText("Должности");
        postMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postMenuActionPerformed(evt);
            }
        });
        jMenu3.add(postMenu);

        orderMenu.setText("Приказ");
        orderMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderMenuActionPerformed(evt);
            }
        });
        jMenu3.add(orderMenu);

        action_orderMenu.setText("Действие приказа");
        action_orderMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action_orderMenuActionPerformed(evt);
            }
        });
        jMenu3.add(action_orderMenu);

        content_orderMenu.setText("Содержание приказа");
        content_orderMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                content_orderMenuActionPerformed(evt);
            }
        });
        jMenu3.add(content_orderMenu);

        employee_postMenu.setText("Сотрудник и должность");
        employee_postMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_postMenuActionPerformed(evt);
            }
        });
        jMenu3.add(employee_postMenu);

        order_postMenu.setText("Приказ о должности");
        order_postMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_postMenuActionPerformed(evt);
            }
        });
        jMenu3.add(order_postMenu);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newConnectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newConnectMenuActionPerformed
        NewConnect nc = new NewConnect(this, true);
        nc.setVisible(true);
        if (nc.ready) {
            connection = nc.getConnection();
        }
        try {
            if (connection != null) {
                DatabaseMetaData dmd = connection.getMetaData();
                String url = dmd.getURL();
                status.setText("Поключение к базе: "
                        + url.substring(url.lastIndexOf("/") + 1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }//GEN-LAST:event_newConnectMenuActionPerformed

    private void closeConnectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeConnectMenuActionPerformed
        try {
            connection.close();
            JOptionPane.showMessageDialog(new JFrame(), "Подключение закрыто");
            connection = null;
            status.setText("Нет подключения");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }//GEN-LAST:event_closeConnectMenuActionPerformed

    private void exitConnectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitConnectMenuActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_exitConnectMenuActionPerformed

    private void employeeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeMenuActionPerformed
        if (connection != null) {
            Employees nc = new Employees(this, true, connection);
            nc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключения");
        }
    }//GEN-LAST:event_employeeMenuActionPerformed

    private void postMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postMenuActionPerformed
        if (connection != null) {
            Posts nc = new Posts(this, true, connection);
            nc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключения");
        }
    }//GEN-LAST:event_postMenuActionPerformed

    private void orderMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderMenuActionPerformed

        if (connection != null) {

            Orders nc = new Orders(this, true, connection);
            nc.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключения");
        }
    }//GEN-LAST:event_orderMenuActionPerformed

    private void action_orderMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_action_orderMenuActionPerformed
        if (connection != null) {
            ActionsOrder nc = new ActionsOrder(this, true, connection);
            nc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключения");
        }
    }//GEN-LAST:event_action_orderMenuActionPerformed

    private void content_orderMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_content_orderMenuActionPerformed
        if (connection != null) {
            ContenrOrders nc = new ContenrOrders(this, true, connection);
            nc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключения");
        }
    }//GEN-LAST:event_content_orderMenuActionPerformed

    private void employee_postMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_postMenuActionPerformed
        if (connection != null) {
            EployeesPostst nc = new EployeesPostst(this, true, connection);
            nc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключения");
        }
    }//GEN-LAST:event_employee_postMenuActionPerformed

    private void order_postMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_postMenuActionPerformed
        if (connection != null) {
            try {
                OrderPosts nc = new OrderPosts(this, true, connection);
                nc.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Нет подключения");
        }
    }//GEN-LAST:event_order_postMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem action_orderMenu;
    private javax.swing.JMenuItem closeConnectMenu;
    private javax.swing.JMenu connectMenu;
    private javax.swing.JMenuItem content_orderMenu;
    private javax.swing.JMenuItem employeeMenu;
    private javax.swing.JMenuItem employee_postMenu;
    private javax.swing.JMenuItem exitConnectMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem newConnectMenu;
    private javax.swing.JMenuItem orderMenu;
    private javax.swing.JMenuItem order_postMenu;
    private javax.swing.JMenuItem postMenu;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
