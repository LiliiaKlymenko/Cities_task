package Players;

import java.util.Scanner;

/**
 * Created by Liliia_Klymenko on 15-May-15.
 */
public class Player implements Players{


    public String printWord(String previousWord) {

        char lastLetters = previousWord.toLowerCase().charAt(previousWord.length() - 1);
        char firstLetter = 0;
        String word;

        System.out.println("Player: ");
        Scanner sc = new Scanner(System.in);
        word = sc.nextLine();
        firstLetter = word.toLowerCase().charAt(0);
        if (firstLetter == lastLetters) {
            return word;
        } else
            return null;
    }
}
