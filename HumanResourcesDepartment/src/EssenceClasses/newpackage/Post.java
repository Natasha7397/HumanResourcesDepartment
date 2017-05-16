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
public class Post {

    private int kod;
    private String name;
    private int salary;

    public Post(int kod, String name, int salary) {
        this.kod = kod;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getName();
    }

    /**
     * Get the value of Name
     *
     * @return the value of Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of Name
     *
     * @param Name new value of Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return kod;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int kod) {
        this.kod = kod;
    }

    /**
     * Get the value of Salary
     *
     * @return the value of Salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Set the value of Salary
     *
     * @param Salary new value of Salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

}
