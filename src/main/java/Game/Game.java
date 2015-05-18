package Game;

import Players.Computer;
import Players.Player;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Liliia_Klymenko on 15-May-15.
 */
public class Game {


    Rules rules;
    Player player;
    Computer computer;


    public Game() throws IOException, JDOMException, SQLException {
        rules = new Rules();
        player = new Player();
        computer = new Computer();
    }


    void start(){

        System.out.println(Rules.listOfCities.toString());
        System.out.println("Start the game with word:");
        String firstWord = Rules.listOfCities.get((int)Math.random()+10);
        System.out.println(firstWord);
        rules.setNewWord(firstWord);
        rules.setPreviousWord(rules.getNewWord());
        do {
            rules.setNewWord(player.printWord(rules.getPreviousWord()));
            rules.setPreviousWord(rules.getNewWord());
            rules.setNewWord(computer.printWord(rules.getPreviousWord()));
            rules.setPreviousWord(rules.getNewWord());

        } while (Rules.listOfCities.size()>0);

    }

}
