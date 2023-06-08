package models;
import java.io.Serializable;


/**
 *
 * @author Fortune Agbone
 */
public class Person implements Serializable {
    /* defining the properties */
    private String firstname;
    private String lastname;

    /* generating an empty constructor. A constructor without any arugemnts */
    public Person(){
        firstname = "";
        lastname = "";
    }

    /* generating a none empty constructor. a constructor with arguments */
    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    /*defining the getters and setters*/

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}