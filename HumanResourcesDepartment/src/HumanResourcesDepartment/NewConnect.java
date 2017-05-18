/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResourcesDepartment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class NewConnect extends javax.swing.JDialog {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    private boolean ready = false;

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    

    /**
     * Get the value of Ready
     *
     * @return the value of Ready
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Set the value of Ready
     *
     * @param Ready new value of Ready
     */
   

    /**
     * Creates new form NewConnect
     *
     * @param parent
     * @param modal
     */
    public NewConnect(java.awt.Frame parent, boolean modal) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        portText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        hostText = new javax.swing.JTextField();
        loginText = new javax.swing.JTextField();
        connectBotton = new javax.swing.JButton();
        passwordText = new javax.swing.JPasswordField();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Хост");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Имя");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Логин");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Порт");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Пароль");
        jLabel5.setToolTipText("");

        portText.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        portText.setText("5432");

        nameText.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        nameText.setText("postgres");

        hostText.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        hostText.setText("127.0.0.1");
        hostText.setName(""); // NOI18N

        loginText.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        loginText.setText("postgres");

        connectBotton.setText("Подключение");
        connectBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBottonActionPerformed(evt);
            }
        });

        passwordText.setText("123456");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(loginText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(portText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hostText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(passwordText)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(connectBotton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hostText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(portText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameText, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(loginText)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(passwordText))
                .addGap(18, 18, 18)
                .addComponent(connectBotton)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void connectBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBottonActionPerformed
        String url = "jdbc:postgresql://" + hostText.getText() + ":"
                + portText.getText() + "/" + nameText.getText();
        String connectLogin = this.loginText.getText();
        String connectPassword = this.passwordText.getText();

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, connectLogin, connectPassword);
            JOptionPane.showMessageDialog(new JFrame(), "Соединение выполнено!");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            return;
        }
        setReady(true);
        dispose();
    }//GEN-LAST:event_connectBottonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectBotton;
    private javax.swing.JTextField hostText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField loginText;
    private javax.swing.JTextField nameText;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField portText;
    // End of variables declaration//GEN-END:variables
}
