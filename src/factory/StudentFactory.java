package factory;

import university.*;
import university.Module;

import java.util.*;

public abstract class StudentFactory implements Student {

    /**
     * Undergraduate type
     */
    public static final String UNDERGRADUATE = "UG";

    /**
     * Postgraduate taught type
     */
    public static final String POSTGRADUATETAUGHT = "PGT";

    /**
     * Postgraduate research type
     */
    public static final String POSTGRADUATERESEARCH = "PGR";

    /**
     * The student id
     */
    private StudentID sid;

    /**
     * The student type
     */
    private final String st;

    /**
     * Indicates if a student is registered correctly
     * 180 credits for PGR, 120 credits for PGT, supervisor allocated for PGR returns true, else false
     */
    private boolean isRegisteredCorrectly = false;

    /**
     * SmartCard instance of the student
     */
    private SmartCard sc;

    /**
     * Indicates if a SmartCard is issued
     */
    private boolean isSmartCardIssued = false;

    /**
     * The StudentName
     */
    private StudentName sn;

    /**
     * The student's birthday
     */
    private Date birthday;

    /**
     * Constructor
     * @param studentType, student type, UG, PGR, PGT
     * @param studentName, StudentName, firstname, lastname
     * @param birth, student birthday
     */
    StudentFactory(String studentType, StudentName studentName, Date birth) {
        this.st = studentType;
        this.sn = studentName;
        this.birthday = birth;
    }

    /**
     * Returns a student objct with given type, name and birthday
     * @param studentType, student type, UG, PGR, PGT
     * @param studentName, StudentName, firstname, lastname
     * @param birth, student birthday
     * @return
     */
    public static Student getInstance(String studentType, StudentName studentName, Date birth){
       if(studentType.equals(UNDERGRADUATE)){
           return new Undergraduate(studentType, studentName, birth);
       }
       else if(studentType.equals(POSTGRADUATERESEARCH)){
           return new PostGraduateResearch(studentType, studentName, birth);
       }
       else if(studentType.equals(POSTGRADUATETAUGHT)){
           return new PostgraduateTaught(studentType, studentName, birth);
       }
       else{
           throw new IllegalArgumentException();
       }
    }


    /**
     *
     * see Student.getStudentID()
     */
    @Override
    public StudentID getStudentID() {
        return sid;
    }

    /**
     *
     * see Student.getStudentType()
     */
    @Override
    public String getStudentType() {
        return st;
    }

    /**
     *
     * see Student.getStudentName()
     */
    @Override
    public StudentName getStudentName(){
        return sn;
    }

    /**
     *
     * see Student.getStudentBirthday()
     */
    @Override
    public Date getStudentBirthday() { return birthday; }

    /**
     *
     * see Student.isSmartCardIssued()
     */
    @Override
    public boolean isSmartCardIssued(){
        return isSmartCardIssued;
    }

    /**
     *
     * see Student.setSmartCardIssued()
     */
    @Override
    public void setSmartCardIssued(){
        this.isSmartCardIssued = true;
    }

    /**
     *
     * see Student.getSmartCard()
     */
    @Override
    public SmartCard getSmartCard(){
        return sc;
    }

    @Override
    public void setSmartCard(SmartCard sc){
        this.sc = sc;
    }


    /**
     *
     * see Student.setStudentID()
     */
    @Override
    public void setStudentID(StudentID id){
        this.sid =  id;
    }

    /**
     *
     * see Student.isStudentRegistered()
     */
    @Override
    public boolean isStudentRegistered(){
        int i = 0;
        if(this.getStudentType().equals(UNDERGRADUATE)){
            for(Module m : ((Undergraduate) this).getModules()){
                i += m.getCredit();
            }
            if(i >= ((Undergraduate) this).TotalCredits){
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(this.getStudentType().equals(POSTGRADUATETAUGHT)){
            for(Module m : ((PostgraduateTaught) this).getModules()){
                i += m.getCredit();
            }
            if(i >= ((PostgraduateTaught) this).TotalCredits){
                return true;
            }
            else{
                return false;
            }

        }
        else if(this.getStudentType().equals(POSTGRADUATERESEARCH)){
            if(((PostGraduateResearch) this).getSupervisor().equals(null)){
                return false;
            }
            else{
                return true;
            }

        }
        else{
            return false;
        }
    }

    /**
     *
     * see Student.setStudentName()
     */
    @Override
    public void setStudentName(StudentName sn){
        this.sn = sn;
    }

    /**
     *
     * see Student.setStudentBirthday()
     */
    @Override
    public void setStudentBirthday(Date birth){
        this.birthday = birth;
    }


}
