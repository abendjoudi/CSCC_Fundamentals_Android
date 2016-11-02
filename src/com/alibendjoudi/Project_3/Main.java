package com.alibendjoudi.Project_3;

import java.util.*;

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
            }
            catch (NumberFormatException e) {
                System.out.println(userInput + " is not a valid integer.\n" + message);
                userInput = scanner.nextLine();
            }
        }

        return userInt;
    }

    public String promptString(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();

        String userString = "";
        boolean isString = false;
        while (!isString) {
            try {
                userString = userInput;
                isString = true;
            }
            catch (Exception e) {
                System.out.println(userInput + " is not a valid String. " + message);
                userInput = scanner.nextLine();
            }
        }
        return userString;
    }
}

class Task implements Comparable<Task>{

    private String Title,Description;
    private int Priority;
    public Task (){}
    public Task(String title, String description, int priority) {
        Title = title;
        Description = description;
        Priority = priority;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setPriority(int priority) {

        while(priority<1 | priority>5) {
            System.out.println("Priority must be between 1 and 5");
            Scanner scanner =new Scanner(System.in);
            priority=Integer.parseInt(scanner.nextLine());
        }
        Priority = priority;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public int getPriority() {
        return Priority;
    }

    public String getDescription() {
        return Description;
    }

    public void display(){

        System.out.println("Title: " + this.Title + ", Description: "
                + this.Description+ ", Priority: " + this.Priority);

    }

    @Override
    public int compareTo(Task T) {
        if (this.Priority>T.getPriority()){
            return -1;

        }else{
            if(this.Priority <T.getPriority()) {
                return 1;
            }else {
                //T1.Priority==T2.Priority
                return this.Title.compareTo(T.getTitle());
            }
        }
    }

}


class TaskList implements Iterable<Task>{
    static List<Task> Taskslist = new ArrayList<>();
    static UserInput getInput =new UserInput();


    static void addTask() {


        String taskTitle = getInput.promptString("Enter the Title of the new task.");

        String taskDescription = getInput.promptString("Enter the Description of the new task.");

        int taskPriority = getInput.promptInt("Enter the Priority of the new task.");

        Task newTask = new Task(taskTitle,taskDescription,taskPriority);
        Taskslist.add(newTask);
        System.out.println("Task "+ taskTitle +" Successfully Added \n");
    }

    static void updateTask(int taskIndex) {
        UserInput getInput= new UserInput();
        boolean validIndex = false;
        while (!validIndex) {
            try {

                validIndex = true;
                Task updatedTask = Taskslist.get(taskIndex);

                String newTaskTitle = getInput.promptString("Enter the new Title of the task.");
                updatedTask.setTitle(newTaskTitle);

                String newTaskDescription = getInput.promptString("Enter the new Description of the task.");
                updatedTask.setDescription(newTaskDescription);

                int newTaskPriority = getInput.promptInt("Enter the new Priority of the task.");
                updatedTask.setPriority(newTaskPriority);

                System.out.println("Task at index "+taskIndex +" Successfully Updated \n");
            }   catch (IndexOutOfBoundsException e) {
                System.out.println(taskIndex + " is not a valid Index. ");
                validIndex = true;
            }
        }
    }

    static void removeTask(int taskToRemoveIndex) {
        try {
            Taskslist.remove(taskToRemoveIndex);
            System.out.println("Task at index "+taskToRemoveIndex +" Successfully deleted \n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("sorry Index doesn't exist");
        }
    }

    static void listAllTasks() {


        Collections.sort(Taskslist);

       for (Task T: Taskslist){
           T.display();
       }

    }

    static void listAllTasks(int Priority) {

        Collections.sort(Taskslist);

        for (Task task : Taskslist) {
            if (task.getPriority() == Priority)

               task.display();
        }

    }

    static int size(){
        return Taskslist.size();

    }

    @Override
    public Iterator<Task> iterator() {
        return Taskslist.iterator();
    }

}

public class Main {

    static void DisplayOptions() {
        System.out.println("Please Choose an option:");
        System.out.println("(1) Add a Task.");
        System.out.println("(2) Remove  a Task.");
        System.out.println("(3) Update a Task.");
        System.out.println("(4) List all Tasks.");
        System.out.println("(5) List all Tasks of certain priority.");
        System.out.println("(0) Exit.");
    }

    public static void main(String[] args) {
        int Choice;
        TaskList TaskCollection=new TaskList();
        UserInput getInput =new UserInput();

        DisplayOptions();
        Choice =getInput.promptInt("Enter your option");
             while (Choice != 0) {
                switch (Choice) {
                    case 1:
                        TaskCollection.addTask();
                        break;
                    case 2:
                        if (TaskCollection.size()==0)
                            System.out.println("no Tasks to delete");
                        else
                            TaskCollection.removeTask(getInput.promptInt("Enter a Index of the Task you want to delete"));
                        break;
                    case 3:
                        if (TaskCollection.size()==0)
                            System.out.println("no Tasks to Update");
                        else
                            TaskCollection.updateTask(getInput.promptInt("Enter a Index of the Task you want to update"));
                        break;
                    case 4:
                        if (TaskCollection.size()==0)
                            System.out.println("no Tasks to Display");
                        else

                            TaskCollection.listAllTasks();
                        break;
                    case 5:
                        if (TaskCollection.size()==0)
                            System.out.println("no Tasks to Display");
                        else
                            TaskCollection.listAllTasks(getInput.promptInt("Enter a Priority"));
                        break;
                }
                DisplayOptions();
                Choice =getInput.promptInt("Enter your option");
            }
    }
}