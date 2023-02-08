package AddressBook.addressbook;

import AddressBook.addressbook.model.AddressBookModel;
import AddressBook.addressbook.model.BuddyInfoModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBookModel addressBookModel;
    private BuddyInfoModel buddy1;
    private BuddyInfoModel buddy2;
    private BuddyInfoModel buddy3;

    @Before
    public void setUp() {
        addressBookModel = new AddressBookModel();
        BuddyInfoModel buddy1 = new BuddyInfoModel("Kareem", "613 123 4567");
        BuddyInfoModel buddy2 = new BuddyInfoModel("John", "613 890 1234");
        BuddyInfoModel buddy3 = new BuddyInfoModel("Babak", "613 123 1212");
        addressBookModel.addBuddy(buddy1);
        addressBookModel.addBuddy(buddy2);
        addressBookModel.addBuddy(buddy3);
    }

    @After
    public void tearDown() {
        addressBookModel = null;
        buddy1 = null;
        buddy2 = null;
        buddy3 = null;
    }

    @Test
    public void addBuddyTest() {
        int numBuddies = addressBookModel.getBuddyList().size();
        addressBookModel.addBuddy(new BuddyInfoModel("Micheal", "613 321 1232"));
        assertEquals(addressBookModel.getBuddyList().size(), numBuddies+1);
    }

    @Test
    public void removeBuddyTest() {
        int numBuddies = addressBookModel.getBuddyList().size();
        addressBookModel.removeBuddyByName("Babak");
        assertEquals(addressBookModel.getBuddyList().size(), numBuddies-1);
    }
}