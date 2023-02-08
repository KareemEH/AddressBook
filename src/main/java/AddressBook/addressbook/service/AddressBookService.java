package AddressBook.addressbook.service;

import AddressBook.addressbook.model.BuddyInfoModel;
import java.util.List;

public interface AddressBookService {
    void saveBuddy(String addressBookName, BuddyInfoModel buddyInfoModel);
    void removeBuddy(String addressBookName, String firstName);
    List<BuddyInfoModel> getBuddyList(String addressBookName);
}

