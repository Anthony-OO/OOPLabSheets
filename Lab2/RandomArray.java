package Lab2;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args)
    {
      int values[] = new int[10], over100 = 0;

      populateArray(values);

      String output = "The initial contents of the array is " + Arrays.toString(values);

      Arrays.sort(values);

        for (int i = 0; i < 10; i++)
            if (values[i] > 100)
                over100++;

      output += "\nThe percentage of values that exceed 100 is " + (over100/values.length)*100 + "%";

      output += "\nThe contents of the array after sorting is " + Arrays.toString(values);

      JOptionPane.showMessageDialog(null,output,"Array Stats",JOptionPane.INFORMATION_MESSAGE);

      System.exit(0);
    }

    private static void populateArray(int values[])
    {
        for (int i = 0; i < values.length; i++)
             values[i] = (int)(Math.random()*1000)+1;
    }
}
