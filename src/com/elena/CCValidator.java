package com.elena;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CCValidator extends JFrame{

        //set up components
    private JTextField creditCardNumberTextField;
    private JButton validateButton;
    private JButton QUITButton;
    private JPanel rootPanel;
    private JLabel validMessageLabel;

    private boolean resetMessageOnKeyPress = false;
    public CCValidator() {
    //layout
    super("Credit Card Validator");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
            // Sets the label's text to show whether the credit card number is valid.

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String ccNumber = creditCardNumberTextField.getText();
            boolean valid = isVisaCreditCardNumberValid(ccNumber);{

            if(valid) {
                validMessageLabel.setText("Credit Card number is valid.Go shopping");
            }else{
                validMessageLabel.setText("Can't go shopping. Not Valid card!");
            }resetMessageOnKeyPress = true;
        });
        //QUIT button
        QUITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        }
    // this method applies to Visa cards
    private boolean isVisaCreditCardNumberValid(String cardNumber){
    boolean answer = false; // gets 'true' if card number is valid
    int calc = 0; // stores accumulated sum of digits in the card number
    int numberOfDigits = cardNumber.length();// number of characters/digits  in card number
    int value = 0; //stores value that will be added to the sum for given digit; depends on the digit position

    // arr is an array of chars in the card number
    char[] arr;
    arr = new char[numberOfDigits];

    // if first digit is 4 and total number of chars is 16, continue
    if (cardNumber.startsWith("4") & (numberOfDigits == 16)) {

        // get an array with digits in the card number
        for (int i = 0; i < numberOfDigits; i++) {
            arr[i] = cardNumber.charAt(i);
        }

        // calculate the sum of digits per the algorithm
        for (int i = 0; i < numberOfDigits; i++) {

            // converts char into integer
            int d = Character.getNumericValue(arr[i]);

            // check the position/index of digit from 0-15
            if (i % 2 == 0) // even:0,2,4,6,8,10,12,14
            {
                if (d < 6) value = 2 * d;
                else {
                    // for a digit that 6 or greater
                    // 1. double the digit. sum will be a 2-digit number(either 12, 14, 16, or 18)
                    // 2. then calculate the reminder
                    // 3. then sum "1" (for tens) and the reminder (for ones)
                    int ones = (d + d) % 10;
                    value = 1 + ones;
                }
            }

            else value = d; //when the digit index is odd

            // get accumulated sum
            calc = calc + value;
            System.out.println("index = " + i
                    + "  digit = " + d
                    + "  value to add = " + value
                    + "  sum = " + calc);
        }


        System.out.println("total sum for the final check = " + calc);
        if (calc % 10 == 0) answer = true;
        System.out.println("check: " + answer);
    }

    return answer;
    }
        });
    }
}

