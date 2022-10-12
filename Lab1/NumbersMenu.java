package Lab1;

//Ex8
/*Write a program that will use a counter-controlled do-while loop to read in up to 10 whole numbers, one at a time*/

import javax.swing.*;

public class NumbersMenu {
    public static void main(String[] args)
    {
       int i = 0, choice, number;
       double factorial;
       String numberAsString, choiceAsString;

       do {
           numberAsString = JOptionPane.showInputDialog(null, "-------Iteration " + (i+1) + "-------\n\nPlease enter any whole number:");

           choiceAsString = JOptionPane.showInputDialog(null, "What would you like to do?\n\n1. Determine if the number is odd or even\n2. Find the factorial of the number\n3. Quit the program\n\nPlease enter your choice:");

           choice = Integer.parseInt(choiceAsString);

           switch(choice)
           {
               case 1 :
                            number = Integer.parseInt(numberAsString);

                            if(number % 2 == 0)
                                JOptionPane.showMessageDialog(null,"The number you entered was even","Number Data",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null,"The number you entered was odd","Number Data",JOptionPane.INFORMATION_MESSAGE);
                            break;

               case 2 :
                            if(numberAsString.charAt(0) == '-')
                                JOptionPane.showMessageDialog(null,"Cannot get the factorial of a negative number","Number Data",JOptionPane.INFORMATION_MESSAGE);
                            else
                            {
                                number = Integer.parseInt(numberAsString);

                                factorial = 1;

                                for(int j = 1; j <= number; j++)
                                    factorial *= j;

                                JOptionPane.showMessageDialog(null,"The factorial of the number you entered is " + factorial,"Number Data",JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;

               default :
                        JOptionPane.showMessageDialog(null,"Quitting the program earlier than anticipated ... Goodbye","Number Data",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
           }

           i++;
       }
       while(i < 10);
    }
}
