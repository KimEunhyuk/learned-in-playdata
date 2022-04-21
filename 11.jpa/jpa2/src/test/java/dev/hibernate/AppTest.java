package dev.hibernate;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import dev.hibernate.model.Major;
import dev.hibernate.model.Student;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testSave() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa2");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 학과 데이터 저장
        Major major1 = new Major("컴퓨터 공학");
        em.persist(major1);

        
        // 학생1 저장
        Student student1 = new Student("Kim");
        student1.setMajor(major1);
        em.persist(student1);

        // 학생2 저장
        Student student2 = new Student("Eun");
        student2.setMajor(major1);
        em.persist(student2);

        tx.commit();
    }
    // @Before, @After 한번 써봐라

    @Test
    public void testRead() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa2");
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, 1L);
        Major major = student.getMajor();
        System.out.println("전공 이름 : " + major.getMajorName());
    }

    @Test
    public void updateRelation() {
        /*
        1. 새로운 major 국문학과 생성, 영속화(persist)
        2. 학생1(1L) 조회 후 (find), 새로운 학과(국문학과)로 설정
        3. commit()
        */

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa2");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Major major2 = new Major("국문학과");
        em.persist(major2);

        Student student = em.find(Student.class, 1L); // findById
        student.setMajor(major2); // em.update()같은 별도의 메서드가 없고, setXxx()를 활용하여 엔티티 변경,
        // tx.commit()이 발생하면 flush() 내부적으로 호출, 변경 감지 기능 작동(dirty checking), 변경 사항을 DB에 자동으로 반영함.
        // em.persist(student); 강사님은 안쓰심

        tx.commit();
    }

    @Test
    public void deleteRelation() {
        /**
         * 1. 학생1의 전공을 제거(null)
         * 
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa2");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student student = em.find(Student.class, 1L);
        student.setMajor(null);
        // em.persist(student); 강사님은 안쓰심

        tx.commit();
    }

    @Test
    public void deleteEntity() { //Entity 제거
        /**
         * 1. 컴퓨터 공학 전공 Entity를 DB에서 제거
         */

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa2");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student sm = em.find(Student.class, 2L);
        sm.setMajor(null);

        Major major = em.find(Major.class, 1L);
        em.remove(major);

        tx.commit();
    }
    // set,remove하면 persist도 된다
}