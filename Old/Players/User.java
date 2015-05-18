package Players;

import java.util.Scanner;

/**
 * Created by Lili on 14.05.2015.
 */
public class User extends Player {


Scanner sc = new Scanner(System.in);

    public User() {
    }

    @Override
    public String printWord(String previousWord) {
        System.out.println("Your turn:");
        String word = sc.next();
        return word;
    }


}
