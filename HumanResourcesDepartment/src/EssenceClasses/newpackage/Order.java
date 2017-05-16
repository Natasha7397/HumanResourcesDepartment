/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EssenceClasses.newpackage;

import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Order {

    private int id;
    private String dateOrder;

    public Order(int id, String dateOrder) {
        this.id = id;
        this.dateOrder = dateOrder;
    }

    @Override
    public String toString() {
        return getDateOrder();
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

    /**
     * Get the value of date_order
     *
     * @return the value of date_order
     */
    public String getDateOrder() {
        return dateOrder;
    }

    /**
     * Set the value of date_order
     *
     * @param dateOrder new value of date_order
     */
    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

}
