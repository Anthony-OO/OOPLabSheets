package Lab2;

import javax.swing.*;
import java.util.Arrays;

//Ex4
public class NumbersArray {
    public static void main(String[] args)
    {
        double numbers[] = {22.3,45.6,27.4,56.6,73.2,11.5,87.4,23.8};

        Arrays.sort(numbers);

        JOptionPane.showMessageDialog(null,"The largest value in the array is " + largest(numbers) + "\nThe Average value in the array is "+ String.format("%.3f",average(numbers)) + "\nThe list of values above the average is: " + aboveAverage(numbers,average(numbers)),"Array Stats",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
    private static double average(double nums[])
    {
        double totalnum = 0;

        for(int i = 0; i < nums.length; i++)
            totalnum += nums[i];

        return totalnum/nums.length;
    }

    private static double largest(double nums[])
    {
        double largest = nums[0];

        for(int i = 0; i < nums.length; i++)
            if(nums[i] > largest)
                largest = nums[i];

        return largest;
    }

    private static String aboveAverage(double nums[],double average)
    {
        String ListAboveAverage = "";

        for(int i = 0; i < nums.length; i++)
            if(nums[i] > average)
                ListAboveAverage += nums[i] + " ";

        return ListAboveAverage;
    }
}
