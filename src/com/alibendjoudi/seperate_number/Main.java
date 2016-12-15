package com.alibendjoudi.seperate_number;

/**
 * Created by abendjoudi on 12/14/16.
 */


public class Main {

    static void seperateNumber(int anumber){


        if (anumber>0){ // our if stops the function when the number ==0
            int modNumber=anumber % 10;// we divide the number by 10 and only take the rest of the division
            anumber=anumber / 10;  // anumber takes the result of the division by 10
            seperateNumber(anumber); // call the seperatenumber function on our new anumber () this is recusion we do the same exact thing to the new number

            System.out.print( modNumber + " "); // this is just to display the results
        }


      }



    public static void main(String[] args) {

        double number=126985.1256; // the number we want to seperate

        String stringNumber = Double.toString(number); // we convert the number to a string
        String[] fractiontnumber = stringNumber.split("\\."); // we sperate the decimal part from the fraction part and put the two parts in an array (tableau)

        int aNumber = Integer.parseInt(fractiontnumber[0]); // part 1 decimal part in position 1 of the array
        int bNumber = Integer.parseInt(fractiontnumber[1]); // part 2 fraction part in position 2 of the array

        seperateNumber(aNumber);// we call the seperateNumber function on part 1
        seperateNumber(bNumber);// we call the same seperate function on part 2





    }




}
