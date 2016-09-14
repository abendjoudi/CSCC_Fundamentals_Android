package com.alibendjoudi.week_03;

import java.util.Scanner;

public class Main {



static double fToC(double fahrenheit){

    return (fahrenheit - 32.0)* 5/9.0;


}

static void displayTemp(double temperature) {
    System.out.println("The temperature is " + temperature + ".");
}

static double userInput(){
    System.out.println("Enter a Fahrenheit temperature ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    double doubleInput =Double.parseDouble(input);
    return doubleInput;
    }

public static void main (String[] args){
        double userTempaerature=userInput();
        while (userTempaerature>=-460) {
            double celsuis =fToC(userTempaerature);
            displayTemp(celsuis);
            userTempaerature=userInput();
        }
    }
}
