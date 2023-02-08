package AddressBook.addressbook;

import AddressBook.addressbook.model.BuddyInfoModel;
import jakarta.persistence.*;
import org.junit.Test;
import java.util.List;

public class BuddyInfoJPATest {

    @Test
    public void performJPA() {

        // Creating objects representing some buddies
        BuddyInfoModel buddy1 = new BuddyInfoModel("Kareem", "613 123 4567");
        buddy1.setId(1);

        BuddyInfoModel buddy2 = new BuddyInfoModel("John", "613 890 1234");
        buddy2.setId(2);

        // Connecting to the database through EntityManagerFactory
        // Connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("address-book-jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the buddy entity objects
        em.persist(buddy1);
        em.persist(buddy2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfoModel b");

        @SuppressWarnings("unchecked")
        List<BuddyInfoModel> results = q.getResultList();

        System.out.println("List of Buddies\n----------------");

        for (BuddyInfoModel b : results) {
            System.out.println("Buddy #" + b.getId() + "\n" + b);
        }

        // Closing connection
        em.close();

        emf.close();
    }

    public static void main(String[] args) {
        System.out.println("Running BuddyInfo JPA Test..");
        BuddyInfoJPATest jpaTest = new BuddyInfoJPATest();
        jpaTest.performJPA();
    }
}
