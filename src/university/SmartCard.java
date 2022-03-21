package university;

import factory.StudentFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmartCard {
    /**
     * issue date
     */
    private Date issueDate;
    /**
     * expire date, UG = issueDate + 4 years, PGT = issueDate + 2 years, PGR = issueDate + 5 years
     */
    private Date expireDate;
    /**
     * the StudentID which to be shown on a smart card
     */
    private StudentID studentID;
    /**
     * the SmartCardID which to be shown on a smart card
     */
    private SmartCardID smartCardID;
    /**
     * the StudentName which to be shown on a smart card
     */
    private StudentName sn;

    /**
     * Returns the expireDate of the SmartCard
     * @return the expireDate of the SmartCard
     */
    public Date getExpireDate(){
        return expireDate;
    }

    /**
     * Returns the issueDate of the SmartCard
     * @return the issueDate of the SmartCard
     */
    public Date getIssueDate(){
        return issueDate;
    }

    /**
     * Returns the smartCardID of the SmartCard
     * @return the smartCardID of the SmartCard
     */
    public SmartCardID getSmartCardID(){
        return smartCardID;
    }

    /**
     * Returns the studentID of the SmartCard
     * @return the studentID of the SmartCard
     */
    public StudentID getStudentID(){
        return studentID;
    }

    /**
     * Returns the StudentName of the SmartCard
     * @return the StudentName of the SmartCard
     */
    public StudentName getStudentName(){ return sn; }

    /**
     * Constructor
     * @param s, the Student object
     * @param date, the date
     */
    private SmartCard(Student s, Date date){
        this.issueDate = date;
        this.studentID = s.getStudentID();
        this.sn = s.getStudentName();
        this.expireDate = date;
    }

    /**
     *
     * @param s, the Student object
     * @param date, the date
     * @return SmartCard object
     */
    public static SmartCard getSmartCard(Student s, Date date){
        SmartCard sc = new SmartCard(s, date);
        sc.smartCardID = SmartCardID.getInstance(s.getStudentName(), getYearFromDate(date));
        sc.issueDate = date;
        sc.studentID = s.getStudentID();
        Date expiredate;
        switch(s.getStudentType()) {
            case StudentFactory.UNDERGRADUATE:
                expiredate = new Date(sc.getIssueDate().getTime() + Constant.year * 4);
                sc.expireDate = expiredate;
            case StudentFactory.POSTGRADUATETAUGHT:
                expiredate = new Date(sc.getIssueDate().getTime() + Constant.year * 2);
                sc.expireDate =  expiredate;
            case StudentFactory.POSTGRADUATERESEARCH:
                expiredate = new Date(sc.getIssueDate().getTime() + Constant.year * 5);
                sc.expireDate.setTime(sc.getIssueDate().getTime() + Constant.year * 5);
        }
        sc.sn = new StudentName(s.getStudentName().getFirstname(), s.getStudentName().getLastname());
        return sc;
    }

    /**
     *
     * @param date, the date
     * @return the year of the date, converting to String
     */
    public static String getYearFromDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        return formatter.format(date);
    }
}
