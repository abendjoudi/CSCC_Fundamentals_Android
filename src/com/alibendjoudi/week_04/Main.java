package com.alibendjoudi.week_04;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;


public class Main
{
    static List<String> getCities()
    {
        List<String> cities = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city: ");
        String input = scanner.nextLine();
        while (!input.equals("END") && !input.equals("end") )
        {


            cities.add(input);
            System.out.println("Enter a city: ");
            input = scanner.nextLine();
        }
        return cities;
    }




    static Map<String, int[]> getTemperatures (List<String> cities)
    {
        Map<String, int[]> temperatureMap = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        for (String city: cities)
        {
            System.out.println("Enter the five average temperatures (separated by spaces) for " + city);
            String tempString = scanner.nextLine();

            int[] tempIntArray = new int[5];
            String[] tempStringArray = tempString.split(" ");

            for (int i =0; i< 5; i++)
            {
                tempIntArray[i] = Integer.parseInt(tempStringArray[i]);
            }
            temperatureMap.put(city, tempIntArray);
        }
        return temperatureMap;
    }



    static void displayTemperatures(Map<String, int[]> tempMap)
    {
        for (String city: tempMap.keySet())
        {
            int[] tempArray = tempMap.get(city);
            int average = 0;
            for (int temp: tempArray)
            {
                average += temp;
            }
            average /= 5;

            System.out.println("The average temperature for " + city + " is " + average);

        }
    }



    public static void main(String[] args)
    {

        List<String> cities = getCities();
        Map<String, int[]> temperatures = getTemperatures(cities);
        displayTemperatures(temperatures);


    }
}