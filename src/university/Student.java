package university;


import java.util.Date;
import java.util.List;

public interface Student {
    /**
     * Returns the student ID
     *
     * @return the student ID
     */
    StudentID getStudentID();

    /**
     * Returns the student type
     *
     * @return the student type
     */
    String getStudentType();

    /**
     * Returns if a student is taking the right number of credits or a supervisor allocated
     *
     * @return if a student is taking the right number of credits or a supervisor allocated
     */
    boolean isStudentRegistered();

    /**
     * Returns the StudentName which includes firstname, lastname
     * @return the StudentName
     */
    StudentName getStudentName();

    /**
     * Returns the student birthday
     * @return the student birthday
     */
    Date getStudentBirthday();

    /**
     * Returns the SmartCard object of the student
     * @return the SmartCard object of the student
     */
    SmartCard getSmartCard();

    boolean isSmartCardIssued();

    /**
     * set the SmartCard for the student
     */
    void setSmartCard(SmartCard sc);

    /**
     * Set SmartCardIssued equals true
     */
    void setSmartCardIssued();

    /**
     * Set the StudentID of the Student
     * @param id is the StudentID
     */
    void setStudentID(StudentID id);

    /**
     *
     * @param sn, is the StudentName, used for amending student data
     */
    void setStudentName(StudentName sn);

    /**
     *
     * @param birth, is the student birthday used for amending student data
     */
    void setStudentBirthday(Date birth);

    /**
     *
     * @param li, list of Modules registered for the student
     */


}