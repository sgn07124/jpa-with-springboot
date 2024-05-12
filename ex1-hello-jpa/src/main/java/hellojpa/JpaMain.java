package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code
        try {
           /*  멤버 추가
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member);
            */


            /* 멤버 조회
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember = " + findMember.getId());
            System.out.println("findMember = " + findMember.getName());
             */

            /* 멤버 삭제
            Member findMember = em.find(Member.class, 2L);
            em.remove(findMember);
             */

            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
