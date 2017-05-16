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
public class Employee {

    private int tabNumber;
    private String lastName;
    private String name;
    private String middleName;
    private String dateBirth;
    private String education;
    private String dateOfWork;

    public Employee(int tabNumber, String lastName, String name, String middleName, String dateBirth, String education, String dateOfWork) {
        this.tabNumber = tabNumber;
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.dateBirth = dateBirth;
        this.education = education;
        this.dateOfWork = dateOfWork;
    }

    @Override
    public String toString() {
        return getLastName();
    }

    /**
     * Get the value of date_of_work
     *
     * @return the value of date_of_work
     */
    public String getDateOfWork() {
        return dateOfWork;
    }

    /**
     * Set the value of date_of_work
     *
     * @param dateOfWork new value of date_of_work
     */
    public void setDateOfWork(String dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    /**
     * Get the value of education
     *
     * @return the value of education
     */
    public String getEducation() {
        return education;
    }

    /**
     * Set the value of education
     *
     * @param education new value of education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * Get the value of date_birth
     *
     * @return the value of date_birth
     */
    public String getDateBirth() {
        return dateBirth;
    }

    /**
     * Set the value of date_birth
     *
     * @param dateBirth new value of date_birth
     */
    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    /**
     * Get the value of middle_name
     *
     * @return the value of middle_name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Set the value of middle_name
     *
     * @param middleN\ame new value of middle_name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of tab_number
     *
     * @return the value of tab_number
     */
    public int getTabNumber() {
        return tabNumber;
    }

    /**
     * Set the value of tab_number
     *
     * @param tabNumber new value of tab_number
     */
    public void setTabNumber(int tabNumber) {
        this.tabNumber = tabNumber;
    }

    /**
     * Get the value of last_name
     *
     * @return the value of last_name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of last_name
     *
     * @param lastName new value of last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
