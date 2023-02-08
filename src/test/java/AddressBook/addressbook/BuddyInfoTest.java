package AddressBook.addressbook;

import AddressBook.addressbook.model.BuddyInfoModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfoModel buddy;

    @Before
    public void setUp() {
        buddy = new BuddyInfoModel("Kareem", "613 123 4567");
    }

    @After
    public void tearDown() {
        buddy = null;
    }

    @Test
    public void setNameTest() {
        assertEquals(buddy.getName(), "Kareem");
        buddy.setName("Babak");
        assertEquals(buddy.getName(), "Babak");
    }

    @Test
    public void getNameTest() {
        assertEquals(buddy.getName(), "Kareem");
    }

    @Test
    public void setNumberTest() {
        assertEquals(buddy.getNumber(), "613 123 4567");
        buddy.setNumber("613 123 1212");
        assertEquals(buddy.getNumber(), "613 123 1212");
    }

    @Test
    public void getNumberTest() {
        assertEquals(buddy.getNumber(), "613 123 4567");
    }
}