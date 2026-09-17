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