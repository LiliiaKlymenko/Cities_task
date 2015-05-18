package Game;

import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Liliia_Klymenko on 15-May-15.
 */
public class Rules {



    private static List<String> listOfCities;

    public Rules() throws JDOMException, IOException {
        Rules.listOfCities = (new Factory().getListOfCities("cities.xls"));
    }


    public static List<String> getListOfCities() throws JDOMException, IOException {
        return (new Factory().getListOfCities("cities.xls"));
    }


    List<String> crossOutTheWord(String word) {
        if (listOfCities.contains(word))
            listOfCities.remove(word);
        return listOfCities;
    }

    boolean exist(String word) {
        if (listOfCities.contains(word))
            return true;
        else
            return false;
    }

    public static boolean proper(String word, String previousWord){
       char firstLetter, lastLetter;
        firstLetter =  word.toLowerCase().charAt(0);
        lastLetter = previousWord.toLowerCase().charAt(previousWord.length()-1);
        if (firstLetter==lastLetter)
            return  true;
        else
            return false;
    }


}
