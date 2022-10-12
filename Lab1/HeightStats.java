package Lab1;

import java.util.Scanner;
//Ex6
/*A program is required that will read in a set of 6 user-supplied adult height values using a while loop. Each height value entered is first tested to see if it is valid.*/

public class HeightStats {
    public static void main(String[] args)
    {
        int i = 0, heightBetween1_3_1_9 = 0;
        final float GLOBAL_AVERAGE_HEIGHT = 1.665f;
        float height, lowerLimit = 0.5464f, upperLimit = 2.72f, total = 0, smallest = 0, exceedGlobalAverageHeight = 0;

        Scanner input = new Scanner(System.in);

        while(i <= 5)
        {
            System.out.print("Loop " + (i+1) + " - Please enter height: ");
            height = input.nextFloat();

            while(height < 0 || height < lowerLimit || height > upperLimit)
            {
                System.out.print("Loop " + (i+1) + " - Height value invalid!!! Please re-enter height: ");
                height = input.nextFloat();
            }

            System.out.print("\n");

            total += height;

            if(i == 0)
                smallest = height;
            else
                if(height < smallest)
                    smallest = height;

           if(height > 1.3 && height < 1.9)
               heightBetween1_3_1_9++;

           if(height > GLOBAL_AVERAGE_HEIGHT)
               exceedGlobalAverageHeight++;

            i++;
        }

        System.out.println("-------------------------------" +
                           "\n\t\tHeight Statistics" +
                           "\n-------------------------------");

        System.out.println("\nThe average of the heights entered is " + String.format("%.1f",total/6) + "m");

        System.out.println("The smallest height value entered is " + smallest + "m");

        System.out.println("The number of height values between 1.3m and 1.9m inclusive is " + heightBetween1_3_1_9);

        System.out.println("The percentage of height values exceeding the global average height is " + String.format("%.2f",(exceedGlobalAverageHeight/6)*100) + "%");
    }
}
