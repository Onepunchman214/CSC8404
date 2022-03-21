package university;

import factory.Postgraduate;
import factory.PostgraduateTaught;
import factory.StudentFactory;
import factory.Undergraduate;

import java.util.Date;
import java.util.List;

public class AbstractUniversity implements University{

    /**
     * Modules available in the university
     */
    private List<Module> modules;

    /**
     * Supervisors available in the university
     */
    private List<Supervisor> supervisors;

    /**
     * List of registered student
     */
    private List<Student> students;

    /**
     * Constructor
     * @param moduleList, list of available modules
     * @param supervisorList, list of available supervisors
     * @param studentList, list of students, empty when initialization
     */
    public AbstractUniversity(List<Module> moduleList, List<Supervisor> supervisorList, List<Student> studentList){
        this.modules = moduleList;
        this.supervisors = supervisorList;
        this.students = studentList;
    }

    /**
     * See AbstractUniversity.noOfStudents()
     */
    @Override
    public int noOfStudents(String typeOfStudent) {
        int i = 0;
        for(Student s : students){
            if(s.getStudentType().equals(typeOfStudent)){
                i++;
            }
        }
        return i;
    }

    /**
     * See AbstractUniversity.amendStudentData()
     */
    @Override
    public void amendStudentData(Student s, StudentName sn, Date birth) {
        s.setStudentName(sn);
        s.setStudentBirthday(birth);
    }

    /**
     * See AbstractUniversity.terminateStudent()
     */
    @Override
    public void terminateStudent(Student s) throws IllegalArgumentException{
        students.remove(s);
    }

    /**
     * See AbstractUniversity.registerStudent()
     */
    @Override
    public void registerStudent(Student s){
        StudentID id = university.StudentID.getInstance();
        if(!students.contains(s))
        {
            students.add(s);
        }
        s.setStudentID(id);
    }

    /**
     * See AbstractUniversity.getAllModules()
     */
    @Override
    public List<Module> getAllModules(){
        return modules;
    }

    /**
     * See AbstractUniversity.getAllSupervisors()
     */
    @Override
    public List<Supervisor> getAllSupervisors(){
        return supervisors;
    }

    /**
     * See AbstractUniversity.setAllModules()
     */
    @Override
    public void setAllModules(List<Module> li){
        this.modules = li;
    }

    /**
     * See AbstractUniversity.setAllSupervisors()
     */
    @Override
    public void setAllSupervisors(List<Supervisor> li){
        this.supervisors = li;
    }

    /**
     * See AbstractUniversity.registerModule()
     */
    @Override
    public void registerModule(Student s, Module m){
        if(s.getStudentType().equals(StudentFactory.UNDERGRADUATE)){
            ((Undergraduate) s).addModules(m);

        }
        else if(s.getStudentType().equals(StudentFactory.POSTGRADUATETAUGHT)) {
            ((PostgraduateTaught) s).addModules(m);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     *    See AbstractUniversity.issueSmartCard()
     */
    @Override
    public void issueSmartCard(Student s, Date date){
        if(s.isSmartCardIssued()){
            throw new IllegalArgumentException("The student already has a smart card!");
        }
        else{
            if(s.getStudentType().equals(StudentFactory.UNDERGRADUATE)){
                if(2021 - Integer.parseInt(SmartCard.getYearFromDate(s.getStudentBirthday())) >= ((Undergraduate) s).MinAge){
                    SmartCard sc = SmartCard.getSmartCard(s,date);
                    s.setSmartCard(sc);
                    s.setSmartCardIssued();
                }
                else{
                    throw new IllegalArgumentException("The student is less than 17!");
                }
            }
            else if(s.getStudentType().equals(StudentFactory.POSTGRADUATERESEARCH) || s.getStudentType().equals(StudentFactory.POSTGRADUATETAUGHT)){
                if(2021 - Integer.parseInt(SmartCard.getYearFromDate(s.getStudentBirthday())) >= ((Postgraduate) s).MinAge){
                    SmartCard sc = SmartCard.getSmartCard(s,date);
                    s.setSmartCard(sc);
                    s.setSmartCardIssued();
                }
                else{
                    throw new IllegalArgumentException("The student is less than 20!");
                }
            }
            else{
                throw new IllegalArgumentException();
            }
        }

    }
}
