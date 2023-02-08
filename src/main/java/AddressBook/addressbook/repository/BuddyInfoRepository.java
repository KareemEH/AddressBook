package AddressBook.addressbook.repository;

import AddressBook.addressbook.model.BuddyInfoModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfoModel, Integer>{
    BuddyInfoModel findByName(String name);
    BuddyInfoModel findByNumber(String number);
    BuddyInfoModel findById(Long Id);
}