/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.OrderPost;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import EssenceClasses.newpackage.OrderPost;

/**
 *
 * @author Acer
 */
public class OrderPostModel extends AbstractTableModel {

    private List<OrderPost> orderPost = new ArrayList<>();
    private Connection c;

    public OrderPostModel(Connection c) throws SQLException {
        super();
        this.c = c;
        orderPost = selectTable(c);
        rowsCount = orderPost.size();
    }

    public void updateData() throws SQLException {

        orderPost = new ArrayList<>();
        orderPost = selectTable(c);
        rowsCount = orderPost.size();
    }
    public void delete(int id) throws SQLException{
        Statement statement = c.createStatement();
                statement.executeUpdate("delete from order_post where id="
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
                            + orderPost.get(rowIndex).getPostKod() + ";");
                    rs.next();
                    s = rs.getString("name");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 1:

                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT name FROM action_order,content_order where content_order.order_action_id=action_order.id and content_order.id="
                            + orderPost.get(rowIndex).getContenOrderId() + ";");
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
                return "Должность";
            case 1:
                return "Содержание приказа";

        }
        return null;
    }

    public OrderPost getSelectesOrderPost(int row) {
        return orderPost.get(row);
    }

    private static List<OrderPost> selectTable(Connection c) throws SQLException {
        Statement statement = c.createStatement();
        List<OrderPost> orderPost = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM order_post");

        while (rs.next()) {
            OrderPost item = new OrderPost(rs.getInt("id"),
                    rs.getInt("post_kod"),
                    rs.getInt("content_order"));

            orderPost.add(item);
        }
        return orderPost;
    }
}
