package Lab2;

//gNamesGUI.java
/*This program processes an array via a GUI interface to find the longest name based on
 *student name data or to search for a particular name using a binary search algorithm*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Arrays;

public class gNamesGUI{

    JButton longestButton, searchButton;
    JTextField nameField;
    JFrame jFrameWindow;
    JLabel infoLabel;

    String[] names = new String[5];
    int i=0;

    public gNamesGUI()
    {
        jFrameWindow = new JFrame("Student Names");
        FlowLayout flowLayout = new FlowLayout();
        jFrameWindow.setLayout(flowLayout);
        jFrameWindow.setSize(500,100);
        jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel nameLabel = new JLabel("Name");
        jFrameWindow.add(nameLabel);
        nameField = new JTextField(20);
        jFrameWindow.add(nameField);
        infoLabel = new JLabel("The names array is currently empty! Add names using text-field above");
        jFrameWindow.add(infoLabel);

        EventHandler handler = new EventHandler();
        nameField.addActionListener(handler);
        jFrameWindow.setVisible(true);
    }

    public static void main(String args[])
    {
        gNamesGUI guiApp = new gNamesGUI();
    }

    private class EventHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==nameField && i<=4)
            {
                names[i] = nameField.getText();
                infoLabel.setText("Name Added! " + (4-i) + " slots of the array remain empty");
                nameField.setText("");
                i++;

                if(i==5)
                {
                    JOptionPane.showMessageDialog(null,"names array now full! To find longest name or search this array hit return",
                            "Array Full!",JOptionPane.INFORMATION_MESSAGE);
                    infoLabel.setVisible(false);
                    searchButton = new JButton("Search");
                    jFrameWindow.add(searchButton);
                    longestButton = new JButton("Find Longest Name");
                    jFrameWindow.add(longestButton);
                    EventHandler handler = new EventHandler();
                    longestButton.addActionListener(handler);
                    searchButton.addActionListener(handler);
                }
            }
            else if(e.getSource()==searchButton) //the source of the event was the "Search" button
            {
                Arrays.sort(names);
                String name = nameField.getText();
                if(binarySearch(names,name))
                    JOptionPane.showMessageDialog(null,"The name you searched for, " + name + ", was found!",
                            "Name Found!",JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"The name you searched for, " + name + ", was not found!",
                            "Name not Found!",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(e.getSource()==longestButton)// the source of the event was the "Find Longest Name" button
            {
                String longest = names[0];

                for(int i=1;i<=4;i++)
                    if(names[i].length()>longest.length())
                        longest = names[i];

                JOptionPane.showMessageDialog(null,"The longest name found is " + longest,
                        "Longest Name!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private static boolean binarySearch(String names[], String name)
    {
        int higherSub=names.length-1,lowerSub=0,middleSub;

        while(lowerSub<=higherSub)
        {
            middleSub = (higherSub+lowerSub)/2;

            if(names[middleSub].compareTo(name)<0)
                lowerSub = middleSub+1;
            else if(names[middleSub].compareTo(name)>0)
                higherSub = middleSub-1;
            else
                return true;
        }
        return false;
    }
}






