package Lab2;

import javax.swing.*;
import java.util.Random;

//Ex2
public class RollTheDice {
    public static void main(String[] args)
    {
        char result;
        int count = 0, computerWins = 0, playerWins = 0, draws = 0;

        String choice = JOptionPane.showInputDialog("Would you like to play a game of roll the dice? (yes or no)");

        while(!choice.equals("no"))
        {
            result = rollTheDice();

            count++;

            if(result == 'c')
                computerWins++;
            else if(result == 'p')
                playerWins++;
            else
                draws++;

            JOptionPane.showMessageDialog(null,"Games played: " + count + "\nComputer Wins: " + computerWins + "\nPlayer Wins: " + playerWins + "\nDraws: " + draws,"Game Info",JOptionPane.INFORMATION_MESSAGE);

            choice = JOptionPane.showInputDialog("Would you like to play another game? (yes or no)");
        }
            JOptionPane.showMessageDialog(null,"Thanks for playing the game!","Farewell",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
    }

    private static char rollTheDice() {
        Random dice = new Random();

        int diceNoComp = dice.nextInt(11) + 2;
            JOptionPane.showMessageDialog(null,"The computer roll generated the value " + diceNoComp + "\n... now hit return to see the player roll","Computer Roll",JOptionPane.INFORMATION_MESSAGE);

        int diceNoPlayer = dice.nextInt(11) + 2;
            JOptionPane.showMessageDialog(null,"The player roll generated the value " + diceNoPlayer,"Player roll",JOptionPane.INFORMATION_MESSAGE);

        if(diceNoComp > diceNoPlayer)
            return 'c';
        else if(diceNoPlayer > diceNoComp)
            return 'p';
        else
            return 'd';
    }
}


