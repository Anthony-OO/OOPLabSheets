package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Ex6
public class NumbersGUI{
    JTextField numbersField;
    JLabel JLabelLargest, JLabelSmallest;
    int count = 0;
    float largest = 0, smallest = 0;
    public NumbersGUI()
    {
        //GUI creation code + event-handler registration
        JFrame jFrameWindow = new JFrame("Numbers Application");

        FlowLayout flowLayout = new FlowLayout();
        jFrameWindow.setLayout(flowLayout);

        jFrameWindow.setSize(500,150);

        jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel numberPrompt = new JLabel("Please enter your numbers here");

        jFrameWindow.add(numberPrompt);

        numbersField = new JTextField(20);

        jFrameWindow.add(numbersField);

        JLabelLargest = new JLabel("No numbers entered yet");

        jFrameWindow.add(JLabelLargest);

        JLabelSmallest = new JLabel();

        jFrameWindow.add(JLabelSmallest);

        TextFieldHandler handler = new TextFieldHandler();

        numbersField.addActionListener(handler);

        jFrameWindow.setVisible(true);
    }

    public static void main(String args[])
    {
        NumbersGUI guiApp = new NumbersGUI();
    }

    private class TextFieldHandler implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            //Event-handling code
            if(numbersField.getText().equals(""))
                JOptionPane.showMessageDialog(null,"You must enter something!!!","Error",0);
            else
            {
                String numberAsString = numbersField.getText();
                numbersField.setText("");
                float number = Float.parseFloat(numberAsString);

                if(count == 0)
                {
                    largest = number;
                    smallest = number;
                    count++;
                }
                else if(number > largest)
                    largest = number;
                else if(number < smallest)
                    smallest = number;

                JLabelLargest.setText("Largest number so far is: " + largest);

                JLabelSmallest.setText("Smallest number so far is: " + smallest);
            }
        }
    }
}
