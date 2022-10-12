package Lab2;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;

//Ex3
public class NamesArray {
    public static void main(String[] args)
    {
        String names[] = new String[5], longestName ="";
        int totalCharacters = 0;

        populateArray(names);

        for (int i = 0; i <names.length; i++)
        {
            if(names[i].length() > longestName.length())
                longestName = names[i];

            totalCharacters += names[i].length();

            Arrays.sort(names);
        }

        JOptionPane.showMessageDialog(null,"The longest name is " + longestName + "\nAverage characters per name is "+ String.format("%d",(totalCharacters/names.length)) + "\nThe array sorted in ascending order is:\n\n" + Arrays.toString(names),"Results",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    private static void populateArray(String n[])
    {
        for(int i = 0; i < n.length; i++)
            n[i] = JOptionPane.showInputDialog("Please enter the name of person " + (i+1));
    }
}
