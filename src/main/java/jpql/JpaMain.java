package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team teamA = new Team();
            teamA.setName("TeamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("TeamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

            String query = "select m from Member m where m = :member";

            Member findMember = em.createQuery(query, Member.class)
                    .setParameter("member", member1)
                    .getSingleResult();

            System.out.println("findMember = " + findMember);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
