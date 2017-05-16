/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.Employee;

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
public class EmployeeModel extends AbstractTableModel {

    List<Employee> list = new ArrayList<>();
    Connection c;

    public EmployeeModel(Connection c) throws SQLException {
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
    int colCount = 6;

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
                return list.get(rowIndex).getLastName();
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getMiddleName();
            case 3:
                return list.get(rowIndex).getDateBirth();
            case 4:
                return list.get(rowIndex).getEducation();
            case 5:
                return list.get(rowIndex).getDateOfWork();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Фамилия";
            case 1:
                return "Имя";
            case 2:
                return "Отчество";
            case 3:
                return "Дата рождения";
            case 4:
                return "Образование";
            case 5:
                return "Дата принятия на работу";

        }
        return null;
    }

    public Employee getSelectesUser(int row) {
        return list.get(row);
    }

    public static List<Employee> selectTable(Connection c) throws SQLException {
        Statement statement = c.createStatement();
        List<Employee> employees = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM employee");
        while (rs.next()) {
            Employee employee = new Employee(rs.getInt("tab_number"),
                    rs.getString("last_name"),
                    rs.getString("name"), rs.getString("middle_name"),
                    rs.getString("date_birth"),
                    rs.getString("education"), rs.getString("date_of_work"));

            employees.add(employee);
        }
        return employees;
    }
}
