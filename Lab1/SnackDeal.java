package Lab1;

import javax.swing.*;

public class SnackDeal {
    public static void main(String[] args)
    {
        String name = JOptionPane.showInputDialog(null,"Please enter your name");

        String course = JOptionPane.showInputDialog(null,"Please enter your course");

        String snacksAsString = JOptionPane.showInputDialog(null,"How many snacks would you like?");

        int snacks = Integer.parseInt(snacksAsString);

        JOptionPane.showMessageDialog(null,"Name: " + name + "\nCourse: " + course + "\nSnacks: " + snacks + "\nCost: €" + snacks*2,"Receipt",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
