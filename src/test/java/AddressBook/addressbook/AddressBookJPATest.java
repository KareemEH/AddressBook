package AddressBook.addressbook;

import AddressBook.addressbook.model.AddressBookModel;
import AddressBook.addressbook.model.BuddyInfoModel;
import jakarta.persistence.*;
import org.junit.Test;

import java.util.List;

public class AddressBookJPATest {

    @Test
    public void performJPA() {

        // Creating objects representing some buddies and an address book
        BuddyInfoModel buddy1 = new BuddyInfoModel("Kareem", "613 123 4567");
        buddy1.setId(1);

        BuddyInfoModel buddy2 = new BuddyInfoModel("John", "613 890 1234");
        buddy2.setId(2);

        AddressBookModel addressBookModel = new AddressBookModel();
        addressBookModel.setId(1);

        addressBookModel.addBuddy(buddy1);
        addressBookModel.addBuddy(buddy2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("address-book-jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(addressBookModel);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT a FROM AddressBookModel a");

        @SuppressWarnings("unchecked")
        List<AddressBookModel> results = q.getResultList();

        System.out.println("List of AddressBooks\n----------------");

        for (AddressBookModel ab : results) {
            System.out.println("AddressBook #" + ab.getId());
        }

        // Closing connection
        em.close();

        emf.close();
    }

    public static void main(String[] args) {
        System.out.println("Running AddressBook JPA example...");
        AddressBookJPATest jpaTest = new AddressBookJPATest();
        jpaTest.performJPA();
    }
}
