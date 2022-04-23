package dev.hibernate;

import dev.hibernate.model.Major;
import dev.hibernate.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student student1 = new Student(1L, "Kim");
        Student student2 = new Student(2L, "Eun");

        Major major = new Major(1L, "컴퓨터 공학");

        student1.setMajor(major);
        student2.setMajor(major);

        // student1이 속한 학과 조회
        Major foundMajor = student1.getMajor(); // 컴퓨터 공학
        System.out.println(foundMajor);

        major.getMajorName();
    }
}