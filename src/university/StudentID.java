package university;

import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class StudentID {
    /**
     * the random letter a-z
     */
    private final String letter;

    /**
     * the random digits 0001~9999
     */
    private final String digits;

    /**
     * Hashmap to avoid duplicated StudentID
     */
    private static final Map<String, StudentID> StudentIDs = new HashMap<String, StudentID>();

    /**
     *
     * @param letter, a random letter from a to z
     * @param digits, 4 digits int toString() from 0001 to 9999
     */
    private StudentID(String letter, String digits) {
        this.letter = letter;
        this.digits = digits;
    }

    /**
     * Returns the instance of StudentID
     * @return the instance of StudentID
     */
    public static StudentID getInstance(){
        String letter = generateRandomChar();
        String digits = generateRandomDigits();
        final String k = letter + digits;
        if(!StudentIDs.containsKey(k)){
            StudentIDs.put(k, new StudentID(letter,digits));
        }
        return StudentIDs.get(k);
    }

    /**
     * Returns the first letter of the StudentID
     * @return the first letter of the StudentID
     */
    public String getLetter(){
        return letter;
    }

    /**
     * Returns the 4 digits of the StudentID as a String
     * @return the 4 digits of the StudentID as a String
     */
    public String getDigits(){
        return digits;
    }

    /**
     * Returns a random letter between a and z
     * @return a random letter between a and z
     */
    public static String generateRandomChar(){
        Random r = new Random();
        char c = (char) (r.nextInt(26)+ 'a');
        return Character.toString(c);
    }

    /**
     * Returns a 4 digit number between 0 and 9999, format to String
     * @return a 4 digit number between 0 and 9999, format to String
     */
    public static String generateRandomDigits(){
        Random r = new Random();
        int digits = r.nextInt(9999);
        return String.format("%04d", digits);
    }

    /**
     * Override the toString() function
     * @return the whole StudentID with a String format
     */
    public String toString(){
        String id = this.letter + this.digits;
        return id;
    }

}
