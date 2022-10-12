package Lab2;
//Ex1
import javax.swing.*;

public class ComputerData {
    public static void main(String[] args)
    {
        String serialNo, hardDiskSpaceAsString, processorType, cheapestProcessorType = "", priceAsString;
        int hardDiskSpace, i = 0, numprocessed = 0;
        float price, total = 0, cheapest = 0, dearest = 0;
        boolean valid;

        serialNo = JOptionPane.showInputDialog(null, "Please enter the serial number(<CR> to exit)");

        while(!serialNo.equals(""))
        {
            hardDiskSpaceAsString = JOptionPane.showInputDialog(null, "Please enter the hard-disk space");

            valid = false;

            while(!valid)
            {
                for (i = 0; i < hardDiskSpaceAsString.length(); i++)
                    if(!Character.isDigit(hardDiskSpaceAsString.charAt(i)))
                        break;

                if(i < hardDiskSpaceAsString.length())
                    hardDiskSpaceAsString = JOptionPane.showInputDialog(null, "Invalid! Please re-enter the hard-disk space");
                else
                {
                  hardDiskSpace = Integer.parseInt(hardDiskSpaceAsString);

                  if(hardDiskSpace > 50 && hardDiskSpace < 5000)
                  {
                      valid = true;
                      total += hardDiskSpace;
                  }
                  else
                      hardDiskSpaceAsString = JOptionPane.showInputDialog(null,"Invalid! Please re-enter the hard-disk space");
                }
            }

            processorType = JOptionPane.showInputDialog(null, "Please enter the processor type");

            priceAsString = JOptionPane.showInputDialog(null, "Please enter the price");

            price = Float.parseFloat(priceAsString);

            numprocessed++;

            if(numprocessed == 1)
            {
                cheapest = price;
                dearest = price;
                cheapestProcessorType = processorType;
            }
            else if(price < cheapest)
                cheapest = price;
            else if(price > dearest)
                dearest = price;

            serialNo = JOptionPane.showInputDialog(null, "Please enter the serial number(<CR> to exit)");
        }

        if(numprocessed == 0)
            JOptionPane.showMessageDialog(null, "No data entered", "Computer Stats", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "The average disk space available on the computers processed is: " + String.format("%.0f",averageDiskSpace(total,numprocessed)) + "GB" + "\nThe price range of the computers is from €" + String.format("%.2f",cheapest) + " to €" + String.format("%.2f",dearest) + "\nThe processor type on the cheapest computer is " + cheapestProcessorType, "Computer Stats", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }

    private static float averageDiskSpace(float totalnum, int numprocessed)
    {
        return (totalnum/numprocessed);
    }
}
