/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.ActionOrder;

import EssenceClasses.newpackage.ActionOrder;
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
public class ActionOrderModel extends AbstractTableModel {

    List<ActionOrder> actionOrder = new ArrayList<>();
    Connection c;

    public ActionOrderModel(Connection c) throws SQLException {
        super();
        this.c = c;
        actionOrder = selectTable(c);
        rowsCount = actionOrder.size();
    }

    public void updateData() throws SQLException {

        actionOrder = new ArrayList<>();
        actionOrder = selectTable(c);

        rowsCount = actionOrder.size();
    }
    int rowsCount = 5;
    int colCount = 1;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return actionOrder.get(rowIndex).getName();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Наименование";

        }
        return null;
    }

    public ActionOrder getSelectesState(int row) {
        return actionOrder.get(row);
    }

    @Override
    public int getRowCount() {
        return rowsCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    public static List<ActionOrder> selectTable(Connection c) throws SQLException {
        Statement statement = c.createStatement();
        List<ActionOrder> actions = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM action_order");
        while (rs.next()) {
            ActionOrder action = new ActionOrder(rs.getInt("id"),
                    rs.getString("name"));
            actions.add(action);

        }
        return actions;
    }
}
