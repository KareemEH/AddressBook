package AddressBook.addressbook.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AddressBooks")
public class AddressBookModel implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;


    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BuddyInfoModel> buddyList;

    // Parameterized Constructor
    public AddressBookModel(String name) {
        this.name = name;
        buddyList = new ArrayList<>();
    }

    // Default Constructor
    public AddressBookModel() {
        this.name = "";
        buddyList = new ArrayList<>();
    }

    // Add a BuddyInfo object to the AddressBook
    public void addBuddy(BuddyInfoModel buddy){
        this.buddyList.add(buddy);
    }

    // Remove a BuddyInfo object from the AddressBook given the name of the buddy
    public void removeBuddyByName(String name){
        for (int i = 0; i < buddyList.size(); i++) {
            if ((buddyList.get(i).getName()).equals(name)) {
                buddyList.remove(i);
                break;
            }
        }
    }

    // Getter for buddyList
    public List<BuddyInfoModel> getBuddyList() {
        return buddyList;
    }

    // Getter for id
    public Integer getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // toString
    public String toString(){
        String str = "";
        for (int i = 0; i < buddyList.size(); i++) {
            str += "Buddy #" + (i+1) + ":\n" + buddyList.get(i).toString();
        }
        return str;
    }

}
