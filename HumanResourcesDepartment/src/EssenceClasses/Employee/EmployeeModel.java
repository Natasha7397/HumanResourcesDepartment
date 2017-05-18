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
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class EmployeeModel extends AbstractTableModel {

    private List<Employee> employee = new ArrayList<>();
    private Connection c;

    public EmployeeModel(Connection c) throws SQLException {
        super();
        this.c = c;

        employee = selectTable(c);
        rowsCount = employee.size();
    }

    public void updateData() throws SQLException {

        employee = new ArrayList<>();
        employee = selectTable(c);
        rowsCount = employee.size();
    }
    public void delete(int id) throws SQLException{
        Statement statement = c.createStatement();
                statement.executeUpdate("delete from employee where tab_number="
                        + id+ ";");
    }
    private int rowsCount = 5;
    private int colCount = 6;

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
                return employee.get(rowIndex).getLastName();
            case 1:
                return employee.get(rowIndex).getName();
            case 2:
                return employee.get(rowIndex).getMiddleName();
            case 3:
                return employee.get(rowIndex).getDateBirth();
            case 4:
                return employee.get(rowIndex).getEducation();
            case 5:
                return employee.get(rowIndex).getDateOfWork();

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

    public Employee getSelectesEmployee(int row) {
        return employee.get(row);
    }

    private static List<Employee> selectTable(Connection c) throws SQLException {
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
