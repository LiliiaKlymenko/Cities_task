package Players;

import Game.Rules;

/**
 * Created by Liliia_Klymenko on 15-May-15.
 */
public class Computer implements Players{


    public String printWord(String previousWord)  {

        char lastLetters = previousWord.toLowerCase().charAt(previousWord.length()-1);
        char firstLetter;

        for (String word : Rules.listOfCities) {
            firstLetter = word.toLowerCase().charAt(0);
            if (firstLetter==lastLetters) {
                System.out.println("Computer: " + word);
                return word;
            }
        }
        return null;
    }
}
