package com.politechnika.hibernatealone.application;

import com.politechnika.hibernatealone.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class HibernateAlone {
    public static EntityManager manager;

    private static void handleStudent(){
        StudentRepository studentRepository = new StudentRepository(manager);

        Student student = new Student();
/*        student.setName("Daniel");
        student.setCity("Opole");
        student.setPesel("12345678901");
        student.setSex("M");
        student.setSurname("Blaszczyk");
        student.setStreet("Ozimska 3e");
        student.setZipcode("34-123");


        studentRepository.create(student);*/

        List<Student> students = studentRepository.getAll();

        System.out.println(students.size());

        for(Student std : students) {
            System.out.println(std.toString());
        }

        student = studentRepository.get(2);
        System.out.println(student.toString());
        student.setCity("Sosnowiec");
        System.out.println(student.toString());
        studentRepository.update(student);
    }

    private static void handleTeacher(){
        TeacherRepository teacherRepository = new TeacherRepository(manager);

        Teacher teacher = new Teacher();
        teacher.setName("Daniel");
        teacher.setCity("Opole");
        teacher.setSex("M");
        teacher.setSurname("Blaszczyk");
        teacher.setStreet("Ozimska 3e");
        teacher.setZipcode("34-123");


        teacherRepository.create(teacher);

        List<Teacher> teachers = teacherRepository.getAll();

        System.out.println(teachers.size());

        for(Teacher std : teachers) {
            System.out.println(std.toString());
        }

        teacher = teacherRepository.get(8);
        if (teacher != null) {
            teacher.setCity("Sosnowiec");
            System.out.println(teacher.toString());
            teacherRepository.update(teacher);
        }
    }

    private static void handleMark(){
        MarkRepository markRepository = new MarkRepository(manager);

        Mark mark = new Mark();
        mark.setDate(new Date());
        mark.setDescription("dwója");
        mark.setMark(2);

        markRepository.create(mark);

        List<Mark> marks = markRepository.getAll();

        System.out.println(marks.size());

        for(Mark item : marks) {
            System.out.println(item.toString());
        }

        mark = markRepository.get(21);
        if (mark != null) {
            mark.setDescription("no dobra, masz trzy.");
            System.out.println(mark.toString());
            markRepository.update(mark);
        }
    }

    private static void handleSubject(){
        SubjectRepository subjectRepository = new SubjectRepository(manager);

        Subject subject = new Subject();
        subject.setName("Matma");
        subjectRepository.create(subject);

        Subject subject2 = new Subject();
        subject2.setName("Fizyka");
        subjectRepository.create(subject2);

        List<Subject> subjects = subjectRepository.getAll();

        for(Subject item : subjects) {
            System.out.println(item.toString());
        }

        subject = subjectRepository.get(2);
        if (subject != null) {
            subject.setName("Fizyka 2");
            System.out.println(subject.toString());
            subjectRepository.update(subject);
        }
    }

    private static void handleKlasa(){
        KlasaRepository klasaRepository = new KlasaRepository(manager);

        Klasa klasa = new Klasa();
        klasa.setName("1a");
        klasa.setYear("2014/2015");
        klasaRepository.create(klasa);

        Klasa klasa2 = new Klasa();
        klasa2.setName("2c");
        klasa2.setYear("2014/2015");
        klasaRepository.create(klasa2);

        List<Klasa> klasy = klasaRepository.getAll();

        for(Klasa item : klasy) {
            System.out.println(item.toString());
        }

        klasa = klasaRepository.get(2);
        if (klasa != null) {
            klasa.setName("Fizyka 2");
            System.out.println(klasa.toString());
            klasaRepository.update(klasa);
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateAlone");
        manager = factory.createEntityManager();

        //handleTeacher();
        handleMark();

        manager.close();
        factory.close();
    }

}
