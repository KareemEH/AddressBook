package AddressBook.addressbook.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Buddies")
public class BuddyInfoModel implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String number;

    // Parameterized Constructor
    public BuddyInfoModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

    // Default Constructor
    public BuddyInfoModel() {
        this.name = "";
        this.number = "";
    }

    // toString Serializer
    public String toString() {
        String str = "Name: " + name + "\nNumber: " + number + "\n";
        return str;
    }

    // Setter for name
    public void setName(String name) { this.name = name; }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for number
    public void setNumber(String number) { this.number = number; }

    // Getter for number
    public String getNumber() {
        return number;
    }

    // Setter for id
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter for id
    public Integer getId() {
        return id;
    }

}
