package university;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module {
    /**
     * the code of the module, e.g: CSC8404
     */
    private String code;
    /**
     * the title of the module, e.g: Advanced Progrmming in Java
     */
    private String title;

    /**
     * the credit of the module, e.g: 10
     */
    private int credit;

    /**
     * Constructor
     * @param code, the code of the module, e.g: CSC8404
     * @param title, the title of the module, e.g: Advanced Progrmming in Java
     * @param credit, the credit of the module, e.g: 10
     */
    public Module(String code, String title, int credit){
        this.code = code;
        this.title = title;
        this.credit = credit;
    }

    /**
     *
     * @return the list of modules read from module.txt
     * @throws FileNotFoundException
     */
    public static List<Module> getAllModules() throws FileNotFoundException {
        List<Module> li = new ArrayList<>();
        FileInputStream fis= new FileInputStream("/Users/xiayixiang/Desktop/CSC8404-Coursework/src/test/module.txt");
        Scanner s = new Scanner(fis);
        while(s.hasNextLine()) {
            String line = s.nextLine();
            String[] elements = line.split(", ");
            li.add(new Module(elements[0], elements[1], Integer.parseInt(elements[2])));
        }
        return li;
    }

    /**
     *
     * @return the credit of the module, e.g: 10
     */
    public int getCredit(){
        return credit;
    }

    /**
     *
     * @return the code of the module, e.g: CSC8404
     */
    public String getCode(){
        return code;
    }

    /**
     *
     * @return the title of the module, e.g: Advanced Progrmming in Java
     */
    public String getTitle(){ return title; }

    /**
     * Override the toString() function
     * @return the String format of the module, e.g: CSC8404, Advanced Progrmming in Java, 10
     */
    public String toString(){
        return this.code + ", " + this.title + ", " + this.credit;
    }

}
