package Lab1;
/*Write a program called CyclistSponsor.java which will ask for the cyclist’s name and the distance cycled (take it that it’s a whole number of km here).
Your program should calculate the money due, then display a dialog containing the cyclist’s name, the distance cycled, and the money due, to 2 decimal places.*/

import javax.swing.*;

public class CyclistSponsor {
    public static void main(String[] args)
    {
        final float RATE_1 = 1.75f, RATE_2 = 2.50f;
        float sponsorAmt, calc1, calc2;

        String name = JOptionPane.showInputDialog(null,"Please enter your name");

        String kmAsString = JOptionPane.showInputDialog(null,"Please enter the number of km cycled");

        int km = Integer.parseInt(kmAsString);

        if(km < 10)
            sponsorAmt = RATE_1 * km;
        else
        {
            calc1 = RATE_1 * 10;
            calc2 = RATE_2 * (km - 10);
            sponsorAmt = calc1 + calc2;
        }

        JOptionPane.showMessageDialog(null,"Name: " + name + "\nDistance cycled: " + km + " km" +"\nSponsorship amount due: €" + String.format("%.2f",sponsorAmt),"Receipt",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
