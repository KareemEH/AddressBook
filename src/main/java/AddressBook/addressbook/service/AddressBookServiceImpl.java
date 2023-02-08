package AddressBook.addressbook.service;

import AddressBook.addressbook.model.AddressBookModel;
import AddressBook.addressbook.model.BuddyInfoModel;
import AddressBook.addressbook.repository.AddressBookRepository;
import AddressBook.addressbook.repository.BuddyInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private final AddressBookRepository addressBookRepo;
    private final BuddyInfoRepository buddyInfoRepo;

    public AddressBookServiceImpl(AddressBookRepository addressBookRepo, BuddyInfoRepository buddyInfoRepo) {
        this.addressBookRepo = addressBookRepo;
        this.buddyInfoRepo = buddyInfoRepo;
    }

    @Override
    public void saveBuddy(String addressBookName, BuddyInfoModel buddyInfoModel) {
        BuddyInfoModel b = buddyInfoRepo.save(buddyInfoModel);
        AddressBookModel addressBookModel = addressBookRepo.findByName(addressBookName);
        if (addressBookModel != null) {
            addressBookModel.addBuddy(b);
        } else {
            addressBookModel = new AddressBookModel(addressBookName);
            addressBookModel.addBuddy(b);
        }
        addressBookRepo.save(addressBookModel);

    }

    @Override
    public void removeBuddy(String addressBookName, String name) {
        BuddyInfoModel buddyInfoModel = buddyInfoRepo.findByName(name);
        AddressBookModel addressBookModel = addressBookRepo.findByName(addressBookName);
        addressBookModel.removeBuddyByName(name);
        buddyInfoRepo.delete(buddyInfoModel);
        addressBookRepo.save(addressBookModel);
    }

    @Override
    public List<BuddyInfoModel> getBuddyList(String addressBookName) {
        AddressBookModel addressBookModel = addressBookRepo.findByName(addressBookName);
        return addressBookModel.getBuddyList();
    }


}
