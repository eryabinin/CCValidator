package com.elena;

public class Main {

    public static void main(String[] args) {
        // write your code here
        CCValidator validator = new CCValidator();
    }

    boolean isVisaCreditCardNumberValid(String cc) {

        if (!cc.startsWith("4") || (cc.length() != 16)) {
            System.out.println("Doesn't start with 4 or length wrong");
            return false;
        }

        int sum = 0;

        for (int i = 0; i < 16; i++) {
            int thisDigit = Integer.parseInt((cc.substring(i, i + 1)));
            if (i % 2 == 1) {
                sum = sum + thisDigit;
            } else {
                int doubled = thisDigit * 2;
                if (doubled > 9) {
                    int toAdd = 1 + (doubled % 10);
                    sum = sum + toAdd;
                } else {
                    sum = sum + (thisDigit * 2);
                }
            }
        }
        if (sum % 10 == 0) {
            return true;
        }

        return false;

    }
}

