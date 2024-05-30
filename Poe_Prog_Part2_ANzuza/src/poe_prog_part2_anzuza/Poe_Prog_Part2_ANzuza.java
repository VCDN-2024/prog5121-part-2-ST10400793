package poe_prog_part2_anzuza;

import javax.swing.JOptionPane;

public class Poe_Prog_Part2_ANzuza {

    public static void main(String[] args) {
        // Attempt to create an account (register or login)
        boolean loggedIn = createAccount();

        // Proceed with the main program logic if logged in successfully
        if (loggedIn) {
            Option() ;
        }
    }

    public static boolean createAccount() {
        boolean loggedIn = false ;
        // Loop until the user successfully logs in
        while (!loggedIn) {
            // Prompt the user with options to register, login, or quit
            String inputs = JOptionPane.showInputDialog(null, "Please enter the number of what you would like to do:\n" + "1: Register \n2: Login \n3: Quit");
            int option = Integer.parseInt(inputs);
            switch (option) {
                case 1 :
                    // Register a new user
                    register() ;
                    break ;
                case 2:
                    // Attempt to log in
                    loggedIn = login();
                    break;
                case 3:
                    // Exit the program
                    JOptionPane.showMessageDialog(null, "Goodbye :)");
                    System.exit (0);
                    break;
                default:
                    // Handle invalid input
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
        return true ; // Indicates a successful login
    }

    public static void register() 
    {
        // Get the user's name and surname
        String name = JOptionPane.showInputDialog("Enter your name");
        String surname = JOptionPane.showInputDialog("Enter your surname");

        // Check if either name or surname is null or empty
        if (name == null || name.isEmpty() || surname == null || surname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Please enter a valid input");
            return ; // Exit the method if input is invalid
        }

        // Create a username from the first letter of the name and the first three letters of the surname
        String username = name.substring(0, 1) + surname.substring(0, 3);

        // Display the generated username to the user
        JOptionPane.showMessageDialog(null, "Your username is: " + username + "_");
    }

    public static boolean login() {
        // Prompt the user for a username
        String username = JOptionPane.showInputDialog("Enter your username (max 5 characters, must contain '_'):");

        // Validate the entered username
        if (username == null || username.isEmpty() || !(username.length() <= 5 && username.contains("_"))) {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please make sure that your username contains an underscore and is not more than 5 characters in length. Please try again.");
            return false;
        }
/* (No date a) Java IF ... else. Available at: https://www.w3schools.com/java/java_conditions.asp (Accessed: 28 May 2024). */
        // Inform the user of successful username capture
        JOptionPane.showMessageDialog(null, "Your Username Successfully Captured.");

        // Prompt the user for a password
        String password = JOptionPane.showInputDialog("Please Enter Password:");

        // Validate the entered password
        if (password == null || password.isEmpty() || !checkPasswordComplexity(password))  
        {
            JOptionPane.showMessageDialog (null,  "This Password is not correctly formatted, please make sure that the password contains at least 8 characters, a capital letter, a number, and a special character. Please try again.");
            return false ;
        }
/* (No date a) Java IF ... else. Available at: https://www.w3schools.com/java/java_conditions.asp (Accessed: 28 May 2024). */
        // Inform the user of successful password capture
        JOptionPane.showMessageDialog(null, "Password Successfully Captured.");
        return isValidLogin(username, password) ;
    }

    private static boolean  checkPasswordComplexity(String password) {
        // Check if the password meets complexity requirements: at least 8 characters, contains a capital letter, a number, and a special character
        if (password.length() < 8) 
        {
            return false ;
        }
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Iterate through each character in the password to check for complexity criteria
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch))  {
                hasUpperCase = true ;
            } else if (Character.isDigit(ch)) {
                hasDigit = true ;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true ;
            }
        }
/* (No date a) Java IF ... else. Available at: https://www.w3schools.com/java/java_conditions.asp (Accessed: 28 May 2024). */
        return hasUpperCase && hasDigit && hasSpecialChar;
    }

    private static boolean isValidLogin(String username, String password) {
        // Placeholder logic for login validation
        // Replace this with your actual login validation logic (e.g., checking against a database)
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }

    public static void Option()  {
        // Welcoming Message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanBan");

        int option = 0;
        // Loop to handle user menu options
        while (option != 3) {
            // Prompt the user to select an option
            String feature = JOptionPane.showInputDialog(null, "Please select one of the following options:(enter the number of your selection)\n"
                    + "1: Add Tasks\n2: Show report\n3: Quit") ;

            option = Integer.parseInt(feature) ;

            switch (option) {
                case 1:
                    // Add tasks
                    addTasks();
                    break;
                case 2:
                    // Show report
                    showReport();
                    break;
                case 3:
                    // Exit the program
                    JOptionPane.showMessageDialog(null, "Goodbye :)");
                    System.exit(0);
                    break;
                default:
                    // Handle invalid input
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    public static void addTasks() {
        // Get the number of tasks to add
        int numTasks = getNumberOfTasks();
        // Loop through the number of tasks and create each one
        for (int i = 0; i < numTasks; i++) {
            createTask(i + 1);
        }
        // Inform the user that tasks were added successfully
        JOptionPane.showMessageDialog(null, "Tasks added successfully!");
    }

    public static void showReport(){
        // Coming soon message
        JOptionPane.showMessageDialog(null,"Coming Soon") ;
    }

    public static int getNumberOfTasks() {
        int numTasks = 0;
        boolean validInput = false ;
        // Loop until valid input is received
        while (!validInput) {
            // Prompt the user to enter the number of tasks
            String input = JOptionPane.showInputDialog("Enter the number of tasks you wish to enter:");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Input cancelled. Please try again.");
            } else {
                try {
                    numTasks = Integer.parseInt(input);
                    if (numTasks <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid positive integer.");
                    } else {
                        validInput = true ;
                    }
                } catch (NumberFormatException e)  {
                    JOptionPane.showMessageDialog(null,  "Please enter a valid positive integer.");
                }
            }
        } /* (No date a) Java IF ... else. Available at: https://www.w3schools.com/java/java_conditions.asp (Accessed: 28 May 2024). */
        return numTasks ;
    }

    public static void createTask (int taskNumber) {
        // Get task details from the user
        String taskName = JOptionPane.showInputDialog(null, "Please enter the NAME of Task " + taskNumber) ;
        String taskDescription = JOptionPane.showInputDialog(null, "Please enter a short DESCRIPTION of Task " + taskNumber);

        // Ensure the task description is less than 50 characters
        while (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            taskDescription = JOptionPane.showInputDialog(null, "Please enter a short DESCRIPTION of Task " + taskNumber);
        }

        // Get developer details
        String developerDetails = JOptionPane.showInputDialog(null, "Enter developer details (First Name & Last Name): ");
        // Create a task ID using the task name, task number, and developer details
        String taskID = (taskName.substring(0, 2) + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3)).toUpperCase();
        // Get the duration of the task
        double duration = getTaskDuration();
        // Get the status of the task
        int status = getTaskStatus();

        // Create a new Task object
        Task task1 = new Task(taskName, taskDescription, taskID, duration, status);
        // Get the task details and total duration
        String output = task1.outputDetails();
        double total = task1.getTotalDuration();
        // Display the total duration and task details to the user
        JOptionPane.showMessageDialog(null, "The total duration : " + total); //Displaying the  message
        JOptionPane.showMessageDialog(null, output);
    }

    public static double getTaskDuration() {
        double duration = 0 ;
        boolean validInput = false ;

        // Looping until valid input is received
        while (!validInput) 
        {
            // Prompt the user to enter the task duration
            String input = JOptionPane.showInputDialog(null, "Enter task duration in Hours:");
            if (input == null) 
            {
                JOptionPane.showMessageDialog(null, "Input cancelled. Please try again!");
            } else {
                try {
                    duration = Double.parseDouble(input);
                    if (duration <= 0) {
                                                JOptionPane.showMessageDialog(null, "Please enter a valid positive number!");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) 
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid positive number.");
                }
            }
        } /* (No date a) Java IF ... else. Available at: https://www.w3schools.com/java/java_conditions.asp (Accessed: 28 May 2024). */
        return duration;
    }

    public static int getTaskStatus() {
        int status = 0;
        boolean validInput = false ;

        // Loop until valid input is received
        while (!validInput) 
        {
            // Prompt the user to select the status of the task
            String input = JOptionPane.showInputDialog(null, "Please select the STATUS of the Task"
                    + "\n1: To Do\n2: Done\n3: Doing");

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Input cancelled. Please try again!");
            } else {
                try {
                    status = Integer.parseInt(input) ;
                    if (status < 1 || status > 3)  {
                        JOptionPane.showMessageDialog(null, "Please enter a valid option (1, 2, or 3)!");
                    } else {
                        validInput = true ;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog (null, "Please enter a valid option (1, 2, or 3)!"); /* Java IF ... else. Available at: https://www.w3schools.com/java/java_conditions.asp (Accessed: 28 May 2024). */
                }
            }
        }

        return status ;
    }
}



   