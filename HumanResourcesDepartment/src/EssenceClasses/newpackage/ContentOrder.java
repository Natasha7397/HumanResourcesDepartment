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
public class ContentOrder {

    private int id;

    private int orderId;

    private int emplTabNumber;

    private int orderActionId;

    private String moveAction;

    /**
     * Get the value of moveAction
     *
     * @return the value of moveAction
     */
    public String getMoveAction() {
        return moveAction;
    }

    /**
     * Set the value of moveAction
     *
     * @param moveAction new value of moveAction
     */
    public void setMoveAction(String moveAction) {
        this.moveAction = moveAction;
    }

    @Override
    public String toString() {
        return getMoveAction();
    }

    public ContentOrder(int id, int orderId, int emplTabNumber, int orderActionId, String moveAction) {
        this.id = id;
        this.orderId = orderId;
        this.emplTabNumber = emplTabNumber;
        this.orderActionId = orderActionId;
        this.moveAction = moveAction;
    }

    /**
     * Get the value of order_action_id
     *
     * @return the value of order_action_id
     */
    public int getOrderActionId() {
        return orderActionId;
    }

    /**
     * Set the value of order_action_id
     *
     * @param orderActionId new value of order_action_id
     */
    public void setOrderActionId(int orderActionId) {
        this.orderActionId = orderActionId;
    }

    /**
     * Get the value of empl_tab_number
     *
     * @return the value of empl_tab_number
     */
    public int getEmplTabNumber() {
        return emplTabNumber;
    }

    /**
     * Set the value of empl_tab_number
     *
     * @param emplTabNumber new value of empl_tab_number
     */
    public void setEmplTabNumber(int emplTabNumber) {
        this.emplTabNumber = emplTabNumber;
    }

    /**
     * Get the value of order_id
     *
     * @return the value of order_id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set the value of order_id
     *
     * @param orderId new value of order_id
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
