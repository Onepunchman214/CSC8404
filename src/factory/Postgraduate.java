package factory;

import university.StudentName;

import java.util.Date;

public class Postgraduate extends StudentFactory {

    /**
     * the minimum age for a Postgraduate to be issued a smart card
     */
    public final int MinAge = 20;

    /**
     *
     * @param StudentType, student type, UG, PGR or PGT
     * @param studentName, the StudentName including firstname and lastname
     * @param birth, the student birthday
     */
    Postgraduate(String StudentType, StudentName studentName, Date birth) { super(StudentType, studentName, birth);}

}
