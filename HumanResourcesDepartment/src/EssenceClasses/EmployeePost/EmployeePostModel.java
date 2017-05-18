/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.EmployeePost;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import EssenceClasses.newpackage.EmployeePost;

/**
 *
 * @author Acer
 */
public class EmployeePostModel extends AbstractTableModel {

    private List<EmployeePost> employeePost = new ArrayList<>();
    private Connection c;

    public EmployeePostModel(Connection c) throws SQLException {
        super();
        this.c = c;
        employeePost = selectTable(c);
        rowsCount = employeePost.size();
    }

    public void updateData() throws SQLException {

        employeePost = new ArrayList<>();
        employeePost = selectTable(c);
        rowsCount = employeePost.size();
    }
    public void delete(int id) throws SQLException{
        Statement statement = c.createStatement();
                statement.executeUpdate("delete from employee_post where id="
                        + id+ ";");
    }
    private int rowsCount = 5;
    private int colCount = 2;

    @Override
    public int getRowCount() {
        return rowsCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String s = "";
        switch (columnIndex) {

            case 0:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM post where kod="
                            + employeePost.get(rowIndex).getPostKod() + ";");
                    rs.next();
                    s = rs.getString("name");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 1:

                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM employee where tab_number="
                            + employeePost.get(rowIndex).getEmployeeTabNumber() + ";");
                    rs.next();
                    s = rs.getString("last_name");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Должность";
            case 1:
                return "Сотрудник";

        }
        return null;
    }

    public EmployeePost getSelectesEmployeePost(int row) {
        return employeePost.get(row);
    }

    private static List<EmployeePost> selectTable(Connection c) throws SQLException {
        Statement statement = c.createStatement();
        List<EmployeePost> employeePost = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM employee_post");

        while (rs.next()) {
            EmployeePost item = new EmployeePost(rs.getInt("id"),
                    rs.getInt("post_kod"), rs.getInt("employee_tab_number"));

            employeePost.add(item);
        }
        return employeePost;
    }
}
