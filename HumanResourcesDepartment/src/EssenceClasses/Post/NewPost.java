/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.Post;

import Check.InputRestriction;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import EssenceClasses.newpackage.Post;

/**
 *
 * @author Acer
 */
public class NewPost extends javax.swing.JDialog {

    private Connection c;
    private Post editPost;

    /**
     * Creates new form NewPost
     *
     * @param parent
     * @param c
     * @param modal
     */
    public NewPost(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();
        entryPost();
        this.c = c;
    }

    public NewPost(java.awt.Frame parent, boolean modal, Connection c, Post s) {
        super(parent, modal);
        initComponents();
        entryPost();
        this.c = c;
        editPost = s;
        fillFields();
    }
   private void entryPost(){
        ((AbstractDocument) name.getDocument()).setDocumentFilter(new InputRestriction(32));
        ((AbstractDocument) salary.getDocument()).setDocumentFilter(new InputRestriction(20));
    }
            

    private void fillFields() {
        name.setText(editPost.getName());
        salary.setText(editPost.getSalary() + "");
    }

    private boolean check() {
        if ("".equals(name.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Поле с наименованием не должно быть пустым");
            return false;
        }
        if ("".equals(salary.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Поле с заработной платой не должно быть пустым");
            return false;
        }
        return true;
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
        name = new javax.swing.JTextField();
        salary = new javax.swing.JTextField();
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Наименование");

        jLabel2.setText("Заработная плата");

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(salary))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        if (!check()) {
            return;
        }
        try {
            Statement statement = c.createStatement();
            if (editPost == null) {
                statement.executeUpdate("insert into post (name,salary) "
                        + "values ('"
                        + name.getText() + "','"
                        + salary.getText() + "');");
            } else {
                statement.executeUpdate("update post set name='"
                        + name.getText() + "',salary='" + salary.getText()
                        + "' where kod=" + editPost.getId() + ";");
            }

        } catch (SQLException ex) {
            if (ex.getMessage().contains("State_Name_key")) {
                JOptionPane.showMessageDialog(new JFrame(), "This name already exist");
            } else {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
            return;
        }
        dispose();
    }//GEN-LAST:event_okActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField name;
    private javax.swing.JButton ok;
    private javax.swing.JTextField salary;
    // End of variables declaration//GEN-END:variables
}
