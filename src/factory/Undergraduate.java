package factory;

import university.Module;
import university.StudentName;

import java.util.Date;
import java.util.List;

public final class Undergraduate extends StudentFactory{
    /**
     * the total credits for an Undergraduate to be correctly registered
     */
    public final int TotalCredits = 120;

    /**
     * the pass rate of an Undergraduate to pass or fail the exam
     */
    public final double PassRate = 0.4;
    /**
     * the minimum age for an Undergraduate to be issued a smart card
     */
    public final int MinAge = 17;

    /**
     * list of modules registered for the Undergraduate
     */
    private List<university.Module> modules;


    public Undergraduate(String studentType, StudentName studentName, Date birth) {
        super(studentType, studentName, birth);
    }

    /**
     * Add a Module to the student
     * @param m is a Module object
     */
    public void addModules(Module m){
        List<university.Module> li = this.modules;
        if(li.size()>0){
            if(li.contains(m)){
                throw new IllegalArgumentException("This module has been registered!");
            }
            else{
                li.add(m);
            }
        }
        else{
            li.add(m);
        }
        this.setModules(li);
    }

    /**
     * Set the Student registered Modules
     * @param li is the list of Modules
     */
    public void setModules(List<university.Module> li){
        this.modules = li;
    }

    /**
     *
     * @return list of modules registered for the Undergraduate
     */
    public List<Module> getModules(){
        return modules;
    }

}
