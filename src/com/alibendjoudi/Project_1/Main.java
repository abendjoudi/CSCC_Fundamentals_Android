package com.alibendjoudi.Project_1;
import java.util.Scanner;

public class Main {

    static String [] TasksArray =new String[20];
    static Scanner InputScanner =new Scanner(System.in);
    static int taskPosition=-1;

    static void addTask(){
        System.out.println("Enter a description of the new task.");
        TasksArray[taskPosition+1]= InputScanner.nextLine();
        taskPosition++;
    }

    static void updateTask(int taskIndex){

        if (taskIndex>taskPosition)
            System.out.println("The Task Index doesn't exist");
        else {
            System.out.println("Enter the new description of the task.");
            TasksArray[taskIndex] = InputScanner.nextLine();
        }
    }

    static void removeTask(int taskIndex){
        for (int i=taskIndex;i<=taskPosition;i++){
            TasksArray[i]= TasksArray[i+1];
        }
        taskPosition--;
    }

    static void listAllTasks(){

        if (taskPosition==-1 )
            System.out.println("There are no TasksArray to Display");

        else{
            for (int i=0; i<=taskPosition;i++)
                System.out.println(i + "." + TasksArray[i]);
        }
    }

    static void DisplayOptions(){
        System.out.println("Please Choose an option:");
        System.out.println("(1) Add a Task.");
        System.out.println("(2) Remove  a Task.");
        System.out.println("(3) Update a Task.");
        System.out.println("(4) List all TasksArray.");
        System.out.println("(0) Exit.");

    }
    public static void main(String[] args) {
        int Choice;
        DisplayOptions();
        Choice=Integer.parseInt(InputScanner.nextLine());

        while (Choice !=0) {
            switch (Choice) {
                case 1:
                    addTask();

                    break;
                case 2:
                    System.out.println("Enter a Index of the Task you want to delete");
                    removeTask(Integer.parseInt(InputScanner.nextLine()));

                    break;
                case 3:
                    System.out.println("Enter a Index of the Task you want to update");
                    updateTask(Integer.parseInt(InputScanner.nextLine()));

                    break;
                case 4:
                    listAllTasks();

                    break;
            }
            DisplayOptions();
            Choice=Integer.parseInt(InputScanner.nextLine());
        }
   }
}