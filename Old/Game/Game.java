package Game;

import Players.Computer;
import Players.Player;
import Players.User;
import org.jdom2.JDOMException;

import java.io.IOException;

/**
 * Created by Liliia_Klymenko on 14-May-15.
 */
public class Game {

    private static String previousWord;
    public String word;
    Player user;
    Player computer;
    Rules rules;
    static final String FIRST_WORD = "Харьков";

    public Game() throws JDOMException, IOException {
        setPreviousWord(FIRST_WORD);

        rules = new Rules();
        rules.getListOfCities();
        user = new User();
        computer = new Computer();
    }

    public String getPreviousWord() {
        return previousWord;
    }


    public void setPreviousWord(String previousWord) {
        this.previousWord = previousWord;
    }

   public void setWord(String word) {
        if (rules.exist(word) && rules.proper(word, getPreviousWord()))
            this.word = word;
        else
            theEnd();
    }
    public void start() throws JDOMException, IOException {
        while (true) {
            userNextStep(computerNextStep(previousWord));
        }
    }

    public void theEnd(){
        System.out.println("The End!");

    }

    public String userNextStep(String previousWord) throws JDOMException, IOException {
    setWord(user.printWord(previousWord));
        setPreviousWord(word);
        return word;
    }

    public String computerNextStep(String previousWord) throws JDOMException, IOException {
        setWord(computer.printWord(previousWord));
        setPreviousWord(word);
        return word;
    }

}
