package com.alibendjoudi.week_02;


public class Main {
    public static void main (String[] args){
      String[] weekDays ={"Wednesday","Thursday","Friday","Saturday","Sunday","Monday","Tuesday",};
      int[] highTemperatures= { 45, 29, 10, 22, 41,28, 33};
      int[] snowPrecipitation={ 95, 60, 25, 5,  0, 75, 90};
      int tempthreshold =32;
      int precepthreshold =50;
      for (int index=0;index<weekDays.length;index++){
          if ((highTemperatures[index] <=tempthreshold) && (snowPrecipitation[index] > precepthreshold) )
                  System.out.println(weekDays[index] + " precipitation of Snow is " + snowPrecipitation[index] + "%");
          }

    }



}
