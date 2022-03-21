package factory;

import university.StudentName;
import university.Supervisor;

import java.util.Date;
import java.util.List;
import java.util.Random;

public final class PostGraduateResearch extends Postgraduate{
    /**
     * the Supervisor
     */
    private Supervisor sp;

    PostGraduateResearch(String studentType, StudentName studentName, Date birth) { super(studentType, studentName, birth);}

    /**
     *
     * @return the PostgraduateResearch's Supervisor
     */
    public Supervisor getSupervisor() {
        return sp;
    }

    /**
     *
     * set the PostgraduateResearch's Supervisor
     */
    public void setSupervisor(Supervisor sp){
        this.sp = sp;
    }

}
