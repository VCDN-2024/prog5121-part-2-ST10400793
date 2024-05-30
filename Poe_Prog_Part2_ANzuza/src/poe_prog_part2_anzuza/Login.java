package poe_prog_part2_anzuza;

public class Login {

    // Instance variables for Login class
    private String username ;
    private String password ;
    private String firstname ;
    private String lastname ;

    // Constructor to initialize a Login object
    public Login(String username, String password, String firstname, String lastname) {
        this.username = username ;
        this.password = password ;
        this.firstname = firstname ;
        this.lastname = lastname ;
    }

    // Method to check if the username contains an underscore
    public static boolean checkUserName(String username)  {
        return username.contains("_") ;
    }

    // Method to check the complexity of the password
    public static boolean checkPasswordComplexity(String password) {
        boolean checkUpperCase = false; //  for uppercase letters
        boolean checkLowerCase = false; // for lowercase letters
        boolean checkSpecialCharacter = false; //  for special characters
        boolean checkNumber = false; //  for numbers

        // Loop through each character in the password to check for the required types
        for (char character : password.toCharArray()) {
            if (Character.isUpperCase(character)) {
                checkUpperCase = true;
            }
            if (Character.isLowerCase(character)) {
                checkLowerCase = true;
            }
            if (Character.isDigit(character)) {
                checkNumber = true;
            }
            if (!Character.isLetterOrDigit(character) && !Character.isSpaceChar(character)) {
                checkSpecialCharacter = true;
            }
        }  /* (No date a) Java IF ... else. Available at: https://www.w3schools.com/java/java_conditions.asp (Accessed: 28 May 2024). */

        // Return true if all complexity requirements are met
        return checkUpperCase && checkLowerCase && checkNumber && checkSpecialCharacter;
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }

    // Getter method for firstname
    public String getFirstname() {
        return firstname;
    }

    // Getter method for lastname
    public String getLastname() {
        return lastname;
    }

    // Setter method for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Setter method for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Setter method for firstname
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Setter method for lastname
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
/*
- Elliot Frisch
- 1965
- How to use a instance variable from one class in other class?​
- Code version​
-  source code​
- Stack Overflow. Available at: https://stackoverflow.com/questions/61483340/how-to-use-a-instance-variable-from-one-class-in-other-class (Accessed: 16 May 2024). 

*/

