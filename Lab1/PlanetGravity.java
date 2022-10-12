package Lab1;
//Ex5
/*Write a Java program that determines the acceleration due to gravity of a planet, based on user-supplied values for the 4 quantities above.
This should then be displayed to 2 decimal places*/

import java.util.Scanner;

public class PlanetGravity {
    public static void main(String[] args)
    {
        Double massE, massP, radiusE, radiusP;
        final float g = 9.81f;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the mass of planet Earth: ");
        massE = input.nextDouble();

        System.out.print("Please enter the radius of planet Earth: ");
        radiusE = input.nextDouble();

        System.out.print("Please enter the mass of the other planet: ");
        massP = input.nextDouble();

        System.out.print("Please enter the radius of the other planet: ");
        radiusP = input.nextDouble();

        Double acceleration = (g*massP*radiusE*radiusE)/(massE*radiusP*radiusP);

        System.out.println("\n\nThe acceleration due to gravity on the other planet is " + String.format("%.2f",acceleration) + " m/s/s");
    }
}
