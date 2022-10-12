//Math.random()
/*Testing, Testing, 123*/

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String args[])
    {
        for(int i = 0; i < 100; i++)
        {
            Random dice = new Random();
            int diceNo = dice.nextInt(11) + 2;
            System.out.print(diceNo + " ");
        }
    }
}