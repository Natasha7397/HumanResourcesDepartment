/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import EssenceClasses.newpackage.Order;

/**
 *
 * @author Acer
 */
public class OrderModel extends AbstractTableModel {

    private List<Order> order = new ArrayList<>();
    private Connection c;

    public OrderModel(Connection c) throws SQLException {
        super();
        this.c = c;
        order = selectTable(c);
        rowsCount = order.size();
    }

    public void updateData() throws SQLException {
        order = new ArrayList();
        order = selectTable(c);
        rowsCount = order.size();
    }
    public void delete(int id) throws SQLException{
        Statement statement = c.createStatement();
                statement.executeUpdate("delete from \"order\" where id="
                        + id+ ";");
    }
    private int rowsCount = 5;
    private int colCount = 1;

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
                return order.get(rowIndex).getDateOrder();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Дата приказа";
        }
        return null;
    }

    public Order getSelectesOrder(int row) {
        return order.get(row);
    }

    private  static List<Order> selectTable(Connection c) throws SQLException {
        Statement statement = c.createStatement();
        List<Order> orders = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM \"order\"");
        while (rs.next()) {
            Order order = new Order(rs.getInt("id"),
                    rs.getString("date_order"));

            orders.add(order);
        }
        return orders;
    }
}
