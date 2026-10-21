/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

/**
 *
 * @author TECH 1
 */

import java.util.Scanner;

public class QuickChatApp {
    public static void main(String[] args) {
        // Requirement 1: Users should only be able to send messages if logged in successfully
        try (Scanner scanner = new Scanner(System.in)) {
            // Requirement 1: Users should only be able to send messages if logged in successfully
            System.out.println("=== QuickChat Login ===");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            
            // Simple mock login check (Replace with your actual Part 1 login variables if available)
            boolean isLoggedIn = !username.isEmpty() && !password.isEmpty();
            
            if (!isLoggedIn) {
                System.out.println("Login failed. Exiting application.");
                return;
            }
            
            // Requirement 2: Display Welcome Message
            System.out.println("\nWelcome to QuickChat.");
            
            boolean running = true;
            while (running) {
                // Requirement 3: Numeric menu
                System.out.println("\nPlease choose an option:");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.print("Enter choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                switch (choice) {
                    case 1 -> {
                        // Requirement 5: Define how many messages to enter
                        System.out.print("How many messages would you like to enter? ");
                        int numMessages = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        
                        int totalSentCounter = 0;
                        
                        for (int i = 1; i <= numMessages; i++) {
                            System.out.println("\n--- Entering Message " + i + " of " + numMessages + " ---");
                            
                            System.out.print("Enter recipient cell number (max 10 chars, include country code e.g. +27...): ");
                            String recipient = scanner.nextLine();
                            
                            System.out.print("Enter message content (max 250 characters): ");
                            String content = scanner.nextLine();
                            
                            Message msg = new Message(i, recipient, content);
                            
                            // Validate Length
                            if (!msg.checkMessageLength()) {
                                int excess = content.length() - 250;
                                System.out.println("Please enter a message of less than 250 characters. (Exceeds by " + excess + " characters).");
                                i--; // repeat iteration
                                continue;
                            } else {
                                System.out.println("Message ready to send.");
                            }
                            
                            // Validate Recipient
                            if (!msg.checkRecipientCell()) {
                                System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                                i--; // repeat iteration
                                continue;
                            } else {
                                System.out.println("Cell phone number successfully captured.");
                            }
                            
                            // Display generated Hash and ID info
                            System.out.println("Message ID generated: " + msg.printMessages().split("\n")[0].replace("Message ID: ", ""));
                            System.out.println("Generated Hash: " + msg.createMessageHash());
                            
                            // Send options menu
                            System.out.println("\nSelect an option:");
                            System.out.println("1) Send Message");
                            System.out.println("2) Disregard Message");
                            System.out.println("3) Store Message to send later");
                            System.out.print("Choice: ");
                            int sendOption = scanner.nextInt();
                            scanner.nextLine();
                            
                            String resultStatus = msg.sentMessage(sendOption);
                            System.out.println(resultStatus);
                            
                            // Requirement 7: Display full details after completion
                            System.out.println("\n=== Full Message Details ===");
                            System.out.println(msg.printMessages());
                            
                            if (sendOption == 1 || sendOption == 3) {
                                totalSentCounter++;
                            }
                        }
                        
                        // Requirement 6: Total messages accumulated and displayed
                        System.out.println("Total messages processed/sent in this session: " + totalSentCounter);
                    }
                        
                    case 2 -> System.out.println("Coming Soon.");
                        
                    case 3 -> {
                        System.out.println("Exiting QuickChat. Goodbye!");
                        running = false;
                    }
                        
                    default -> System.out.println("Invalid option. Please select 1, 2, or 3.");
                }
            }
        }
    }
}
    

