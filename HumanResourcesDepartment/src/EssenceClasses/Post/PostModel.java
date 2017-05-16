/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.Post;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import EssenceClasses.newpackage.Post;

/**
 *
 * @author Acer
 */
public class PostModel extends AbstractTableModel {

    List<Post> list = new ArrayList<>();
    Connection c;

    public PostModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectTable(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectTable(c);

        rowsCount = list.size();
    }
    int rowsCount = 5;
    int colCount = 2;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getName();
            case 1:
                return list.get(rowIndex).getSalary();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Наименование";
            case 1:
                return "Заработная плата";
        }
        return null;
    }

    public Post getSelectesState(int row) {
        return list.get(row);
    }

    @Override
    public int getRowCount() {
        return rowsCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    public static List<Post> selectTable(Connection c) throws SQLException {
        Statement statement = c.createStatement();
        List<Post> posts = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM post");
        while (rs.next()) {
            Post post = new Post(rs.getInt("kod"), rs.getString("name"),
                    rs.getInt("salary"));

            posts.add(post);
        }
        return posts;
    }
}
