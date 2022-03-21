package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import factory.PostGraduateResearch;
import factory.PostgraduateTaught;
import factory.StudentFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import university.*;
import university.Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


class UnitTest {

    static Student student1;
    static Student student2;
    static Student student3;
    static Calendar c1;
    static Calendar c2;
    static Calendar c3;
    static Calendar c4;
    static Calendar c5;
    static AbstractUniversity university;
    static StudentName sn1 = new StudentName("Sven", "Xia");
    static StudentName sn2 = new StudentName("Lester", "Lu");
    static StudentName sn3 = new StudentName("Yi", "Sheng");

    @BeforeAll
    static void initialize() throws FileNotFoundException {
        c1 = Calendar.getInstance();
        c1.set(1989, 07, 02);
        c2 = Calendar.getInstance();
        c2.set(1999, 11, 02);
        c3 = Calendar.getInstance();
        c3.set(2002, 07, 11);
        c4 = Calendar.getInstance();
        c4.set(2003,8,8);
        c5 = Calendar.getInstance();
        c5.set(2021,10,25);
        student1 = StudentFactory.getInstance("PGT", sn1, c1.getTime());
        student2 = StudentFactory.getInstance("PGR", sn2, c2.getTime());
        student3 = StudentFactory.getInstance("UG", sn3, c3.getTime());
        List<Module> modules = Module.getAllModules();
        List<Supervisor> supervisors = Supervisor.getAllSupervisors();
        List<Student> li = new ArrayList<>();
        university = new AbstractUniversity(modules, supervisors, li);
    }

    @Test

    public void testModule() throws FileNotFoundException {
        List<Module> li = Module.getAllModules();
        assertEquals(14, li.size());
    }

    @Test
    public void testSupervisor() throws FileNotFoundException{
        List<Supervisor> li = Supervisor.getAllSupervisors();
        assertEquals(12, li.size());
    }

    @Test
    public void testUniversity() {
        assertEquals(14, university.getAllModules().size());
        assertEquals(12, university.getAllSupervisors().size());
        university.registerStudent(student1);
        university.registerStudent(student2);
        university.registerStudent(student3);
        int count = university.noOfStudents("UG");
        assertEquals(1, count);
        university.amendStudentData(student1, sn1, c4.getTime());
        assertEquals(c4.getTime(), student1.getStudentBirthday());
        Module m = new Module("CSC8404", "Advanced Progrmming in Java", 10);
        Module m1 = new Module("CSC8499", "Project and Dissertation for MSc in Advanced Computer Science", 90);
        Module m2 = new Module("CSC8208", "Research Methods and Group Project in Security and Resilience", 20);
        Module m3 = new Module("CSC8207", "Security Analysis of Complex Systems", 20);
        Module m4 = new Module("CSC8414", "Security Tools and Analysis", 20);
        Module m5 = new Module("CSC8112", "Internet of Things", 10);
        Module m6 = new Module("CSC8022", "Human Computer Interaction", 10);
        List<Module> li = new ArrayList<>();
        li.add(m);
        li.add(m1);
        li.add(m2);
        li.add(m3);
        li.add(m4);
        li.add(m5);
        li.add(m6);
        ((PostgraduateTaught) student1).setModules(li);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> university.registerModule(student1,m));
        assertEquals("This module has been registered!", exception.getMessage());
        assertEquals(true, student1.isStudentRegistered());
        ((PostGraduateResearch) student2).setSupervisor(university.getAllSupervisors().get(0));
        assertEquals(true, student2.isStudentRegistered());
        university.terminateStudent(student3);
        int count1 = university.noOfStudents("UG");
        assertEquals(0, count1);
    }

    @Test
    public void testStudentFactory() {
        assertEquals("PGT", student1.getStudentType());
        assertEquals("PGR", student2.getStudentType());
        assertEquals("UG", student3.getStudentType());
        assertEquals("Sven Xia", student1.getStudentName().toString());
        assertEquals("Lester Lu", student2.getStudentName().toString());
        assertEquals("Yi Sheng", student3.getStudentName().toString());
        System.out.println(student1.getStudentID().toString());
        System.out.println(student2.getStudentID().toString());
        System.out.println(student3.getStudentID().toString());
        assertEquals(7, ((PostgraduateTaught) student1).getModules().size());
    }

    @Test
    public void testSmartCard(){
        university.issueSmartCard(student1, c5.getTime());
        System.out.println(student1.getSmartCard().getIssueDate());
        System.out.println(student1.getSmartCard().getExpireDate());
        System.out.println(student1.getSmartCard().getSmartCardID().toString());
        assertEquals("Sven Xia", student1.getSmartCard().getStudentName().toString());
        assertEquals(true, student1.isSmartCardIssued());
    }
}



