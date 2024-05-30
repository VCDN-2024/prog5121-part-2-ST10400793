package poe_prog_part2_anzuza;

public class Poe_Prog_Part2_ANzuza {

    // Method to create an account (currently just returns false)
    public static boolean createAccount() {
        // This method involves user input, so it's hard to unit test directly.
        return false;
    }

    // Method to register a user by creating a username
    public static String register(String name, String surname) {
        // Set up username (e.g., first letter of name + surname + "_")
        return name.substring(0, 1) + surname + "_";
    }

    // Method to log in a user by validating username and password
    public static boolean login(String username, String password) {
        return isValidLogin(username, password); // Delegate to helper method
    }

    // Helper method to check if the login credentials are valid
    private static boolean isValidLogin(String username, String password) {
        // Validate that neither username nor password is null or empty
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }

    // Method to get the number of tasks from a string input
    public static int getNumberOfTasks(String input) {
        try {
            int numTasks = Integer.parseInt(input); // Convert input to integer
            if (numTasks <= 0) {
                return -1; // Invalid input if number of tasks is not positive
            }
            return numTasks;
        } catch (NumberFormatException e) {
            return -1; // Invalid input if conversion fails
        }
    }

    // Method to get the task duration from a string input
    public static double getTaskDuration(String input) {
        try {
            double duration = Double.parseDouble(input); // Convert input to double
            if (duration <= 0) {
                return -1; // Invalid input if duration is not positive
            }
            return duration;
        } catch (NumberFormatException e) {
            return -1; // Invalid input if conversion fails
        }
    }

    // Method to get the task status from a string input
    public static int getTaskStatus(String input) {
        try {
            int status = Integer.parseInt(input); // Convert input to integer
            if (status < 1 || status > 3) {
                return -1; // Invalid input if status is not 1, 2, or 3
            }
            return status;
        } catch (NumberFormatException e) {
            return -1; // Invalid input if conversion fails
        }
    }
}
