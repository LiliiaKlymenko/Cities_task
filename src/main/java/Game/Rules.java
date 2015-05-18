package Game;

import Parser.Factory;
import org.apache.log4j.Logger;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Liliia_Klymenko on 15-May-15.
 */
public class Rules {


    static final String FILE_NAME = "cities/cities.sql";
    private static final Logger rulesLog = Logger.getLogger(Rules.class);
    public static List<String> listOfCities;

    private String newWord;
    private String previousWord;

    public void setPreviousWord(String previousWord) {
        this.previousWord = previousWord;
    }

    public void setNewWord(String newWord) {
        if (exist(newWord) && newWord!=null){
            this.newWord = newWord;
            rulesLog.info("Said :" + newWord);
            crossOut(newWord);
        }
        else {
            rulesLog.info("Game over");
            System.out.println("\nThe end!");
            lostGame();
        }
    }

    public String getNewWord() {
        return newWord;
    }

    public String getPreviousWord() {
        return previousWord;
    }

    public Rules() throws IOException, JDOMException, SQLException {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource(FILE_NAME).getFile();
        listOfCities =  new Factory().getListOfCities(path);
        Collections.shuffle(listOfCities);
    }

    void crossOut(String word) {
        if (listOfCities.contains(word))
       listOfCities.remove(listOfCities.indexOf(word));

    }

    public boolean exist(String word) {
        if (listOfCities.contains(word))
            return true;
        else
            return false;
    }

    public void lostGame() {
        System.out.println("Bye!");
        System.exit(0);
    }
//    public static void main(String[] args) throws IOException, JDOMException {
//
//        Rules rules = new Rules();
//        System.out.println(listOfCities.toString());
//        Scanner sc = new Scanner(System.in);
//        rules.crossOut("Алчевск");
//        System.out.println(listOfCities.toString());
//    }

}
