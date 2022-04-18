package dev.hibernate;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.hibernate.model.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

        // EntityManagerFactory를 통해 EntityManager 객체 생성
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
        tx.begin();
        Book book = new Book();
        // book.setId("book1"); //H2 DB 설정
        book.setBookName("The little prince");
        book.setPubDate(new Date());

        // 등록, em.persist(등록할 entity); list.add(entity);
        // book data DB Insert
        em.persist(book); // INSERT INTO BOOK (ID, BOOK_NAME, PUB_DATE) VALUES('book1', "The little prince", "현재 날짜값")

        // 수정, em.update()같은 별도의 수정 메서드가 존재하지 않음.
        // 어떤 엔티티가 변경되었는지만 JPA가 추적함.
        book.setBookName("어른 왕자"); // UPDATE MEMBER SET BOOK_NAME = "다 큰 왕자" WHERE ID = "book1";

        // 한 행 조회 : em.find(조회할 엔티티의 타입, @ID로 매핑한 필드값)
        // Book findBook = em.find(Book.class, "book1");
        // System.out.println(findBook.getBookName()); //

        // 엔티티 삭제 : em.remove(삭제할 entity);
        // em.remove(findBook); // DELETE FROM BOOK WHERE id = "book1";


        tx.commit();
        } catch(Exception e) { // 매개변수의 다형성
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
