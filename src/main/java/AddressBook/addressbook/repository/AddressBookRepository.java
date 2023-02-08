package AddressBook.addressbook.repository;

import AddressBook.addressbook.model.AddressBookModel;
import org.springframework.data.repository.CrudRepository;
public interface AddressBookRepository extends CrudRepository<AddressBookModel, Integer>{
    AddressBookModel findById(Long Id);
    AddressBookModel findByName(String name);
}
