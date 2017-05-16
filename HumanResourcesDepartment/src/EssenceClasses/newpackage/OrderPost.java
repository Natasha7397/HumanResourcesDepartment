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
public class OrderPost {

    private int id;

    private int postKod;

    private int contenOrderId;

    public OrderPost(int id, int postKod, int contenOrderId) {
        this.id = id;
        this.postKod = postKod;
        this.contenOrderId = contenOrderId;
    }

    /**
     * Get the value of conten_otder_id
     *
     * @return the value of conten_otder_id
     */
    public int getContenOrderId() {
        return contenOrderId;
    }

    /**
     * Set the value of conten_otder_id
     *
     * @param conten_otder_id new value of conten_otder_id
     */
    public void setContenOrderId(int contenOrderId) {
        this.contenOrderId = contenOrderId;
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
