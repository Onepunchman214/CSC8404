package university;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public final class SmartCardID {
    /**
     * the StudentName
     */
    private StudentName sn;

    /**
     * the year of the issue date
     */
    private String year;

    /**
     * the random 2 digits series number
     */
    private String seriesNumber;

    /**
     * Hashmap to avoid duplication during generating SmartCardID
     */
    private static final Map<String, SmartCardID> SmartCardIDs = new HashMap<String, SmartCardID>();

    /**
     * Constructor
     * @param sn, the StudentName
     * @param year, the year of issue date
     * @param seriesNumber, the random series number, 2 digits
     */
    public SmartCardID(StudentName sn, String year, String seriesNumber){
        this.sn = sn;
        this.year = year;
        this.seriesNumber = seriesNumber;
    }

    /**
     * Returns the SmartCardID instance
     * @param sn, the StudentName
     * @param year, the year of issue date
     * @return the SmartCardID instance
     */
    public static SmartCardID getInstance(StudentName sn, String year){
        String seriesNumber = generateRandomSeriesNumber();
        final String k = sn.getFirstname().substring(0,1).toUpperCase()+sn.getLastname().substring(0,1).toUpperCase() + "-" + year + "-" + seriesNumber;
        if(!SmartCardIDs.containsKey(k))
            SmartCardIDs.put(k,new SmartCardID(sn, year, seriesNumber));
        return SmartCardIDs.get(k);
    }

    /**
     * Returns a random 2 digits, 1~99, String format
     * @return a random 2 digits, 1~99, String format
     */
    public static String generateRandomSeriesNumber(){
        Random r = new Random();
        int digits = r.nextInt(99);
        return String.format("%02d", digits);
    }

    /**
     * Override the toString() function
     * @return the String format of StudentID, Sven Xia, 2021, 15 as SX-2021-15
     */
    public String toString(){
        return this.sn.getFirstname().substring(0,1).toUpperCase() + this.sn.getLastname().substring(0,1).toUpperCase() + "-" + this.year + "-" + this.seriesNumber;
    }

}
