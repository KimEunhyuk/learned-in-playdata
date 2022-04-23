package dev.hibernate;

import static org.junit.Assert.assertTrue;

import java.util.List;

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa3");
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
    public void readStudent() { //JPA로 학생 리스트 조회
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa3");
        EntityManager em = emf.createEntityManager();

        Major major = em.find(Major.class, 1L);
        List<Student> students = major.getStudents();

        for(Student student: students) {
            System.out.println(student.getStudentName());
        }
    }

    @Test
    public void testSaveNonOwnerWithJPA() { // 연관관계의 주인이 아닌 곳에만 설정할 경우,
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa3");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Major major1 = new Major("컴퓨터 공학");
        em.persist(major1);

        Student student1 = new Student("Yoo");
        major1.getStudents().add(student1); // 연관관계의 주인(student.java N:1중에서 N쪽)이 아닌 곳에만 
        // 연관관계를 설정할 경우,
        em.persist(student1);
        
        Student student2 = new Student("Kang");
        major1.getStudents().add(student2);
        em.persist(student2);

        tx.commit();
    }

    @Test
    public void testSaveOwnerOnlyWithOOP() {
        Major major1 = new Major("컴퓨터 공학");

        Student student1 = new Student("Yoo");
        student1.setMajor(major1);

        Student student2 = new Student("Kang");
        student2.setMajor(major1);

        List<Student> students = major1.getStudents();
        System.out.println("students.size : " + students.size());
    }

    @Test
    public void biWithOOP() {
        Major major1 = new Major("국문학과");

        Student student1 = new Student("Yoo");
        student1.setMajor(major1);
        major1.getStudents().add(student1);

        Student student2 = new Student("Kang");
        student2.setMajor(major1);
        major1.getStudents().add(student2);

        List<Student> students = major1.getStudents();
        System.out.println("student.size : " + students.size());
    }

    @Test
    public void biasdOOP() { //양쪽에 맵핑
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa3");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Major major1 = new Major("국문학과");
        em.persist(major1);

        Student student1 = new Student("Yoo");

        // 양방향 연관관계 설정
        student1.setMajor(major1);
        major1.getStudents().add(student1);
        em.persist(student1);

        Student student2 = new Student("Park");
        student2.setMajor(major1);
        major1.getStudents().add(student2);
        em.persist(student2);

        tx.commit();

        // SELECT S.*, M.MAJOR_NAME FROM STUDENT S JOIN MAJOR M ON S.MAJOR_ID = M.MAJOR_ID WHERE S.MAJOR_ID = 1;
    }
}