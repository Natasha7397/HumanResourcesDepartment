/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.ContentOrder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import EssenceClasses.newpackage.ContentOrder;

/**
 *
 * @author Acer
 */
public class ContentOrderModel extends AbstractTableModel {

    private List<ContentOrder> contentOrder = new ArrayList<>();
    private Connection c;

    public ContentOrderModel(Connection c) throws SQLException {
        super();
        this.c = c;
        contentOrder = selectTable(c);
        rowsCount = contentOrder.size();
    }

    public void updateData() throws SQLException {
        contentOrder = new ArrayList<>();
        contentOrder = selectTable(c);
        rowsCount = contentOrder.size();
    }
    public void delete(int id) throws SQLException{
        Statement statement = c.createStatement();
                statement.executeUpdate("delete from content_order where id="
                        + id+ ";");
    }
    private int rowsCount = 10;
    private int colCount = 3;

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
                    ResultSet rs = statement.executeQuery("SELECT * FROM \"order\" where id="
                            + contentOrder.get(rowIndex).getOrderId() + ";");
                    rs.next();
                    s = rs.getString("date_order");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 1:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM employee where tab_number="
                            + contentOrder.get(rowIndex).getEmplTabNumber() + ";");
                    rs.next();
                    s = rs.getString("last_name");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 2:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM action_order where id="
                            + contentOrder.get(rowIndex).getOrderActionId() + ";");
                    rs.next();
                    s = rs.getString("name");

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
                return "Приказ";
            case 1:
                return "Сотрудник";
            case 2:
                return "Действие приказа";

        }
        return null;
    }

    public ContentOrder getSelectesContentOrder(int row) {
        return contentOrder.get(row);
    }

    private static List<ContentOrder> selectTable(Connection c) throws SQLException {
        Statement statement = c.createStatement();
        List<ContentOrder> contens = new ArrayList<>();
        ResultSet rs = statement.executeQuery("select co.*, ao.name as action_order_name from content_order co left join action_order ao on co.order_action_id=ao.id;");

        while (rs.next()) {
            ContentOrder item = new ContentOrder(rs.getInt("id"),
                    rs.getInt("order_id"), rs.getInt("empl_tab_number"),
                    rs.getInt("order_action_id"), rs.getString("action_order_name"));

            contens.add(item);
        }
        return contens;
    }
}
