package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Address address = new Address("city", "street", "100000");

            Member member1 = new Member();
            member1.setUsername("aaa");
            member1.setHomeAddress(address);
            em.persist(member1);

            Address newAddress = new Address("newCity", address.getCity(), address.getZipcode());
            member1.setHomeAddress(newAddress);

            tx.commit(); // 이 시점에서 insert가 일어나는 거 같아
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
