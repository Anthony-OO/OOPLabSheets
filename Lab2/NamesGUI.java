package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

//Ex8
public class NamesGUI{
    JFrame jFrameWindow;
    JTextField namesField;
    JLabel namesInfo;
    JButton searchButton, findLongestName;
    String names[] = new String[5];
    int i = 0;
    public NamesGUI()
    {
        //GUI creation code + event-handler registration
        jFrameWindow = new JFrame("Student Names");

        FlowLayout flowLayout = new FlowLayout();
        jFrameWindow.setLayout(flowLayout);

        jFrameWindow.setSize(500,120);

        jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel namePrompt = new JLabel("Name");
        jFrameWindow.add(namePrompt);

        namesField = new JTextField(20);
        jFrameWindow.add(namesField);

        namesInfo = new JLabel("The names array is currently empty! Add names using text-field above");
        jFrameWindow.add(namesInfo);

        TextFieldHandler handler = new TextFieldHandler();

        namesField.addActionListener(handler);

        jFrameWindow.setVisible(true);
    }

    public static void main(String args[])
    {
        NamesGUI guiApp = new NamesGUI();
    }

    private class TextFieldHandler implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            //Event-handling code
            if(i < names.length)
            {
                names[i] = namesField.getText();
                namesInfo.setText("Name Added! " + ((names.length-1)-i) + " slots of the array remain empty");

                namesField.setText("");
                i++;

                if(i == names.length)
                {
                    JOptionPane.showMessageDialog(null, "Names array now full! To find longest name or search this array hit return", "Array Full!", JOptionPane.INFORMATION_MESSAGE);
                    namesInfo.setVisible(false);

                    searchButton = new JButton("Search");
                    jFrameWindow.add(searchButton);

                    findLongestName = new JButton("Find Longest Name");
                    jFrameWindow.add(findLongestName);

                    JButtonEventHandler buttonHandler = new JButtonEventHandler();

                    searchButton.addActionListener(buttonHandler);
                    findLongestName.addActionListener(buttonHandler);
                }
            }
            System.out.println(Arrays.toString(names));
        }
    }

    private class JButtonEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == searchButton)
            {
                Arrays.sort(names);
                if(binarySearch(names,namesField.getText()))
                    JOptionPane.showMessageDialog(null,"The name you searched for, " + namesField.getText() + ", was found!","Name Found!",JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"The name you searched for, " + namesField.getText() + ", was not found!","Name not Found!",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                String longestName = "";

                for (int j = 0; j < names.length; j++)
                {
                    if(names[j].length() > longestName.length())
                        longestName = names[j];
                }

                JOptionPane.showMessageDialog(null,"The longest name found is " + longestName,"Longest Name!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private static boolean binarySearch(String names[],String name)
    {
        int lowerSub = 0, higherSub = names.length-1, middleSub;

        while(lowerSub <= higherSub)
        {
            middleSub = (lowerSub + higherSub)/2;

            if(names[middleSub].compareTo(name) < 0)
                lowerSub = middleSub+1;
            else if(names[middleSub].compareTo(name) > 0)
                higherSub = middleSub-1;
            else
                return true;
        }
        return false;
    }
}
