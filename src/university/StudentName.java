package university;

public class StudentName {

    private String firstname;
    private String lastname;

    /**
     * Constructor
     * @param fn, first name
     * @param ln, last name
     */
    public StudentName(String fn, String ln){
        this.firstname = fn;
        this.lastname = ln;
    }

    /**
     *
     * @return, first name
     */
    public String getFirstname() { return firstname; }

    /**
     *
     * @return last name
     */
    public String getLastname() { return lastname; }

    /**
     * Override the toString() function
     * @return full name
     */
    public String toString(){
        return firstname + " " + lastname;
    }

}
