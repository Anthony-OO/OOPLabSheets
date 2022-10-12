package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Ex6
public class WeightConverter{
    JTextField jTextField;
    JLabel kiloLabel;
    public WeightConverter()
    {
        //GUI creation code + event-handler registration
        JFrame jFrameWindow = new JFrame("Weight Converter");

        FlowLayout flowLayout = new FlowLayout();
        jFrameWindow.setLayout(flowLayout);

        jFrameWindow.setSize(300,100);

        jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel poundLabel = new JLabel("Pounds:");

        jFrameWindow.add(poundLabel);

        jTextField = new JTextField(5);

        jFrameWindow.add(jTextField);

        kiloLabel = new JLabel();

        jFrameWindow.add(kiloLabel);

        TextFieldHandler handler = new TextFieldHandler();

        jTextField.addActionListener(handler);

        jFrameWindow.setVisible(true);
    }

    public static void main(String args[])
    {
        WeightConverter guiApp = new WeightConverter();
    }

     private class TextFieldHandler implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            //Event-handling code
            if(jTextField.getText().equals(""))
                JOptionPane.showMessageDialog(null,"You must enter a value into the textfield","Error",0);
            else
            {
                float pounds = Float.parseFloat(jTextField.getText());

                double kilos = pounds * .454;

                kiloLabel.setText("This is equivalent to " + String.format("%.2f",kilos) + "kg");

            }
        }
    }

}
