package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setAge(31);
            member1.setTeam(teamA);
            member1.setType(MemberType.ADMIN);

            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setAge(21);
            member2.setTeam(teamA);
            member2.setType(MemberType.ADMIN);

            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setAge(22);
            member3.setTeam(teamB);
            member3.setType(MemberType.ADMIN);

            em.persist(member3);

            em.flush();
            em.clear();

            int resultCount = em.createQuery("update Member m set m.age = 20").executeUpdate();

            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

            for (Member member : members) {
                System.out.println("member = " + member.getAge());
            }



//            List<Member> resultList = em.createNamedQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", "회원1")
//                    .getResultList();
//
//            for (Member member : resultList) {
//                System.out.println("member = " + member);
//            }


//            String query =  "select m from Member m where m.team = :team";
//            List<Member> findMember = em.createQuery(query, Member.class)
//                    .setParameter("team", teamA)
//                    .getResultList();



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
