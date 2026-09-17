/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatapp;

/**
 *
 * @author TECH 1
 */
 import java.util.Scanner;
public class ChatApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== USER REGISTRATION ===");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        Login appLogin = new Login(firstName, lastName);

        String username, password, cellPhone, registrationMessage;
        
        // Loop registration until valid inputs are provided
        while (true) {
            System.out.print("Enter Username (must contain '_' and <= 5 chars): ");
            username = scanner.nextLine();

            System.out.print("Enter Password: ");
            password = scanner.nextLine();

            System.out.print("Enter Cell Phone Number (e.g. +27838968976): ");
            cellPhone = scanner.nextLine();

            registrationMessage = appLogin.registerUser(username, password, cellPhone, firstName, lastName);
            System.out.println("\n" + registrationMessage + "\n");

            if (registrationMessage.contains("Username successfully captured")) {
                break;
            }
        }
        
        System.out.println("=== USER LOGIN ===");
        System.out.print("Enter Username: ");
        String loginUser = scanner.nextLine();

        System.out.print("Enter Password: ");
        String loginPass = scanner.nextLine();

        boolean isAuthenticated = appLogin.loginUser(loginUser, loginPass);
        System.out.println(appLogin.returnLoginStatus(isAuthenticated));

        scanner.close();
    }
}

/**
 * Login class handling validation rules and user authentication.
 */
public class Login {
    
    // Attributes to store registered user details
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructors
    public Login() {
    }

    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Checks if the username contains an underscore and is <= 5 characters
    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }
    
    // Checks password complexity: >= 8 chars, at least 1 uppercase, 1 digit, 1 special char
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasNumber && hasSpecial;
    }
    
    // Regex check for South African cell phone format (+27 followed by digits, length <= 13 total)
    // Reference: Java Regex Pattern Matching for International SA Standard (+27)
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        if (cellPhoneNumber == null) {
            return false;
        }
        // Regex pattern: Starts with +27 followed by 9 or 10 digits
        String phoneRegex = "^\\+27[0-9]{9,10}$";
        return cellPhoneNumber.matches(phoneRegex);
    }
    
    // Register user method returning validation status string
    public String registerUser(String username, String password, String cellPhoneNumber, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
        
        // Store credentials upon successful validation
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;

        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }
    
    // Verifies entered credentials against stored user details
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (this.username == null || this.password == null) {
            return false;
        }
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }
    
    // Returns authentication status message
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + this.firstName + " ," + this.lastName + " it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
