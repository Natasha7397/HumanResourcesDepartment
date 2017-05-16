/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.newpackage;

/**
 *
 * @author Acer
 */
public class EmployeePost {

    private int id;

    private int postKod;

    private int employeeTabNumber;

    public EmployeePost(int id, int postKod, int employeeTabNumber) {
        this.id = id;
        this.postKod = postKod;
        this.employeeTabNumber = employeeTabNumber;
    }

    /**
     * Get the value of employee_tab_number
     *
     * @return the value of employee_tab_number
     */
    public int getEmployeeTabNumber() {
        return employeeTabNumber;
    }

    /**
     * Set the value of employee_tab_number
     *
     * @param employeeTabNumber new value of employee_tab_number
     */
    public void setEmployeeTabNumber(int employeeTabNumber) {
        this.employeeTabNumber = employeeTabNumber;
    }

    /**
     * Get the value of post_kod
     *
     * @return the value of post_kod
     */
    public int getPostKod() {
        return postKod;
    }

    /**
     * Set the value of post_kod
     *
     * @param postKod new value of post_kod
     */
    public void setPostKod(int postKod) {
        this.postKod = postKod;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

}
