/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResourcesDepartment;

import EssenceClasses.newpackage.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class Model extends AbstractTableModel {

    Connection c;
    List<Orders> orders = new ArrayList<>();

    public Model(Connection c) {
        super();
        this.c = c;

        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("select  \"date_order\",\"action_order\".\"name\" ,\"last_name\" from \"order\",\"employee\",\"action_order\",\"content_order\" where \"content_order\".\"order_id\" =\"order\".\"id\"and \"content_order\".\"order_action_id\" =\"action_order\".\"id\" and \"content_order\".\"empl_tab_number\" =\"employee\".\"tab_number\";");

            while (rs.next()) {
                Orders ord = new Orders(rs.getString("date_order"),
                        rs.getString("name"),
                        rs.getString("last_name"));

                orders.add(ord);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        rowsCount = orders.size();
    }
    int rowsCount = 5;
    int colCount = 3;

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
        switch (columnIndex) {
            case 0:
                return orders.get(rowIndex).getDateOrder();
            case 1:
                return orders.get(rowIndex).getName();
            case 2:
                return orders.get(rowIndex).getLastName();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Дата";
            case 1:
                return "Содержание";
            case 2:
                return "Фамилия";

        }
        return null;
    }
}
