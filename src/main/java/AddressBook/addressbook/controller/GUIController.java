package AddressBook.addressbook.controller;

import AddressBook.addressbook.model.AddressBookModel;
import AddressBook.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GUIController {

    @Autowired
    private final AddressBookRepository addressBookRepo;

    public GUIController(AddressBookRepository addressBookRepo) {
        this.addressBookRepo = addressBookRepo;
    }

    @GetMapping("/")
    public String getAddressBook(Model model) {
        AddressBookModel addressBookModel = addressBookRepo.findByName("book1");
        if (addressBookModel == null) {
            addressBookModel = new AddressBookModel("book1");
            addressBookRepo.save(addressBookModel);
        }
        model.addAttribute("AddressBookModel", addressBookModel);
        if (addressBookModel.getBuddyList() != null) {
            model.addAttribute("buddyList", addressBookModel.getBuddyList());
        }
        return "AddressBook";
    }
}