package university;

import java.util.Date;
import java.util.List;

public interface University {

    /**
     * Returns the total number of students registered for the type
     * @param typeOfStudent, the type of the student, UG, PGT or PGR
     * @return the total number of students registered for the type
     */
    int noOfStudents(String typeOfStudent);

    /**
     * this method will change the StudentData if different
     * @param s, the Student object
     * @param sn, the new StudentName object which to be amended
     * @param birth, the new student birthday
     */
    void amendStudentData(Student s, StudentName sn, Date birth);

    /**
     * this method will terminate the student, delete it from the system
     * @param s, the Student object
     */
    void terminateStudent(Student s);

    /**
     * this method will register the student, generate an unique student id and add the student to the system
     * @param s, the Student object
     */
    void registerStudent(Student s);

    /**
     * Returns the list of modules available
     * @return the list of modules available
     */
    List<Module> getAllModules();

    /**
     * Returns the list of supervisors available
     * @return the list of supervisors available
     */
    List<Supervisor> getAllSupervisors();

    /**
     *
     * @param li, the list of Module, can be read from test.module.txt
     */
    void setAllModules(List<Module> li);

    /**
     *
     * @param li, the list of Supervisor, can be read from test.Supervisor.txt
     */
    void setAllSupervisors(List<Supervisor> li);

    /**
     *
     * @param s, the Student object
     * @param m, the module to be registered
     */
    void registerModule(Student s, Module m);

    /**
     *
     * @param s, the Student object
     * @param date, the issue date
     */
    void issueSmartCard(Student s, Date date);

}
