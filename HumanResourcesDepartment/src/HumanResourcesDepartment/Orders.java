/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResourcesDepartment;

/**
 *
 * @author Acer
 */
public class Orders {

    private String dateOrder;
    private String name;
    private String lastName;

    public Orders(String dateOrder, String name, String lastName) {
        this.dateOrder = dateOrder;
        this.name = name;
        this.lastName = lastName;
    }

    /**
     * @return the Date_order
     */
    public String getDateOrder() {
        return dateOrder;
    }

    /**
     * @param dateOrder the Date_order to set
     */
    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Last_name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the Last_name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
