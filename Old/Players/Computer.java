package Players;

import Game.Rules;
import org.jdom2.JDOMException;

import java.io.IOException;

/**
 * Created by Liliia_Klymenko on 15-May-15.
 */
public class Computer extends Player {


    public Computer() {    }


    public String printWord(String previousWord) throws JDOMException, IOException {
        String word = null;
        for(String words : Rules.getListOfCities()){
            if (Rules.proper(words, previousWord))
                word = words;
            break;
        }

        return word;
    }



}
