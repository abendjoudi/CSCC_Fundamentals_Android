package com.alibendjoudi.week_06;

import java.util.Scanner;

class UserInput {
    Scanner scanner = new Scanner(System.in);

    public int promptInt(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();

        int userInt = 0;
        boolean isInt = false;
        while (!isInt) {
            try {
                userInt = Integer.parseInt(userInput);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not a valid integer.\n" + message);
                userInput = scanner.nextLine();
            }
        }

        return userInt;
    }

    public double promptDouble(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();

        double userDouble = 0;
        boolean isDouble = false;
        while (!isDouble) {
            try {
                userDouble = Double.parseDouble(userInput);
                isDouble = true;
            }
            catch (NumberFormatException e) {
                System.out.println(userInput + " is not a valid Double.\n" + message);
                userInput = scanner.nextLine();
            }
        }

        return userDouble;
    }

    public String promptString(String message){
        System.out.println(message);
        return  scanner.nextLine();

    }

}

public class Main {
    public static void main(String[] args){
        UserInput input = new UserInput();
        String aString = input.promptString("Enter a string.");
        System.out.println("The string you entered is " + aString);

    }
}
