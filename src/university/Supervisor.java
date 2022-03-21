package university;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supervisor {
    /**
     * the supervisor name
     */
    public String name;

    /**
     * Constructor
     * @param name, the supervisor name
     */
    public Supervisor(String name){
        this.name = name;
    }

    /**
     *
     * @return List of Supervior read from the file Supervisor.txt
     * @throws FileNotFoundException
     */
    public static List<Supervisor> getAllSupervisors() throws FileNotFoundException {
        List<Supervisor> li = new ArrayList<>();
        FileInputStream fis= new FileInputStream("/Users/xiayixiang/Desktop/CSC8404-Coursework/src/test/Supervisor.txt");
        Scanner s = new Scanner(fis);
        while(s.hasNextLine())
        {
            String line = s.nextLine();
            Supervisor sp = new Supervisor(line);
            li.add(sp);
        }
        return li;
    }

    /**
     * Override the toString() function
     * @return the supervisor name
     */
    public String toString(){
        return name;
    }
}
