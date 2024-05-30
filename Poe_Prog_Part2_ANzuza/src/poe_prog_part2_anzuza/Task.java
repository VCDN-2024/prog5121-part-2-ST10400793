package poe_prog_part2_anzuza;

import javax.swing.JOptionPane;

public class Task {

    // The static variable to keep track of the total duration of all tasks
    public static double totalDuration = 0;

    // Method to get the status of a task (currently not implemented)
   

    // Instance variables for Task class
    private final String name;
    private final String description;
    private final String id;
    private final double duration;
    private final int status;

    // Constructor for Task class
    public Task(String name, String description, String id, double duration, int status) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.duration = duration;
        this.status = status;
        totalDuration += duration; // Add the duration of this task to the total duration
    }

    // Method to add tasks by prompting user input
    public static void addTasks() {
        int numTasks = getNumberOfTasks(); // Get the number of tasks from the user
        double totalHours = createTask(numTasks); // Create the tasks and get the total duration
        JOptionPane.showMessageDialog(null, "Total amount of Hours: " + totalHours); // Display the total duration
    }

    // Method to prompt user for the number of tasks
    public static int getNumberOfTasks() {
        int numTasks = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = JOptionPane.showInputDialog("Enter the number of tasks you wish to enter:");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Input cancelled. Please try again.");
            } else {
                try {
                    numTasks = Integer.parseInt(input); // Convert input to integer
                    if (numTasks <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid positive integer.");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e)  
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid positive integer.");
                    
                    /* (No date a) Java IF ... else. Available at: https://www.w3schools.com/java/java_conditions.asp (Accessed: 28 May 2024). */
                }
            }
        }
        return numTasks ;
    }

    // Method to create tasks
    public static double createTask  (int numTasks) {

        // Loop to create each task
        for (int i = 0; i < numTasks; i++)
        {
            String taskName = JOptionPane.showInputDialog(null, "Please enter the NAME of Task " + (i + 1));
            String taskDescription = JOptionPane.showInputDialog(null, "Please enter a short DESCRIPTION of Task " + (i + 1));

            // Ensure task description is not longer than 50 characters
            while (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                taskDescription = JOptionPane.showInputDialog(null, "Please enter a short DESCRIPTION of Task " + (i + 1));
            }

            String developerDetails = JOptionPane.showInputDialog(null, "Enter developer details (First Name & Last Name): ");
            // Create a task ID based on task name, index, and developer details
            String taskID = (taskName.substring(0, 2) + ":" + i + ":" + developerDetails.substring(developerDetails.length() - 3)).toUpperCase();
            double duration = getTaskDuration() ; // Getting task duration from the user
            int status = getTaskStatus() ; // Getting task status from the user

            // Create task object and display details
            Task task = new Task(taskName, taskDescription, taskID, duration, status);
            String output = task.outputDetails();
            JOptionPane.showMessageDialog(null, output);

        }

        return totalDuration; // Return the total duration of all tasks
    }

    // Method to get task duration from user
    public static double getTaskDuration() {
        double duration = 0 ;
        boolean InputValid = false;

        while (!InputValid) {
            String input = JOptionPane.showInputDialog(null, "Enter task duration in Hours:");
            if (input ==  null) {
                JOptionPane.showMessageDialog(null, "Input cancelled. Please try again!") ;
            } else  {
                try  {
                    duration   = Double.parseDouble(input) ; // Convert the input to double
                    if (duration <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid positive number!") ;
                    } else {
                         InputValid =  true  ;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog (null, "Please enter a valid positive number.");
                  }
             }
        }  /* (No date a) Java IF ... else. Available at: https://www.w3schools.com/java/java_conditions.asp (Accessed: 28 May 2024). */
        return duration;
    }

    // Method to get task status from user
    public static int getTaskStatus() {
        int status = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = JOptionPane.showInputDialog(null, "Please select the STATUS of the Task"
                    + "\n1: To Do\n2: Done\n3: Doing");

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Input cancelled. Please try again!");
            } else {
                try {
                    status = Integer.parseInt(input); // Convert input to integer
                    if (status < 1 || status > 3) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid option (1, 2, or 3)!");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid option (1, 2, or 3)!") ;
                }
            }
        }  /* (No date a) Java IF ... else. Available at: https://www.w3schools.com/java/java_conditions.asp (Accessed: 28 May 2024). */

        return status;
    }

    // Method to get the total duration of all tasks
    public static double getTotalDuration() {
        return totalDuration ;
    }

    // Method to output the details of the task
    public String outputDetails()  {
        return "Task: " + name + "\nDescription: " + description + "\nID: " + id + "\nDuration: " + duration + " hours\nStatus: " + getStatusString();
    }

    // Method to get the string representation of the status
    private String getStatusString() {
        switch (status) {
            case 1:
                return "To do" ;
            case 2:
                return "Done" ;
            case 3: 
                return "Doing" ;
            default:
                return "" ;
                /* (No date) Java switch. Available at: https://www.w3schools.com/java/java_switch.asp (Accessed: 28 May 2024). */
        }
    }
    
}
