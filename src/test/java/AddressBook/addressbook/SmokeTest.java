package AddressBook.addressbook;

import AddressBook.addressbook.controller.AddressBookController;
import AddressBook.addressbook.controller.GUIController;
import AddressBook.addressbook.repository.AddressBookRepository;
import AddressBook.addressbook.service.AddressBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private AddressBookController addressBookController;

    @Autowired
    private GUIController guiController;

    @Autowired
    private AddressBookService addressBookService;

    @Autowired
    private AddressBookRepository addressBookRepo;

    @Test
    public void contextLoadsMainController() throws Exception {
        assertThat(addressBookController).isNotNull();
    }

    @Test
    public void contextLoadsGUIController() throws Exception {
        assertThat(guiController).isNotNull();
    }

    @Test
    public void contextLoadsService() throws Exception {
        assertThat(addressBookService).isNotNull();
    }

    @Test
    public void contextLoadsRepo() throws Exception {
        assertThat(addressBookRepo).isNotNull();
    }

}
