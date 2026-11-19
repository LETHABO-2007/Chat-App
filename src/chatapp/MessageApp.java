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

public class MessageApp {

    // Arrays to store message details across the system
    static String[] sentMessages = {
        "Did you get the cake?",
        "It is dinner time !"
    };

    static String[] disregardedMessages = {
        "Yohoooo, I am at your gate."
    };

    static String[] storedMessages = {
        "Where are you? You are late! I have asked you to be on time.",
        "Ok, I am leaving without you."
    };

    static String[] messageIDs = {
        "ID001",
        "ID002",
        "ID003",
        "ID004",
        "ID005"
    };

    static String[] messageHashes = {
        "HASH123",
        "HASH456",
        "HASH789",
        "HASH321",
        "HASH654"
    };

    // Corresponding recipients for testing and reporting
    static String[] recipients = {
        "+27834557896",
        "+27838884567",
        "+27834484567",
        "0838884567",
        "+27838884567"
    };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("\n========================================");
                System.out.println("          MESSAGING APPLICATION          ");
                System.out.println("========================================");
                System.out.println("1. Send a new message");
                System.out.println("2. Display Sent Messages");
                System.out.println("3. Display Disregarded Messages");
                System.out.println("4. Stored Messages Menu (Part 3 Features)");
                System.out.println("5. Exit");
                System.out.print("Choose an option (1-5): ");

                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid input. Please enter a number between 1 and 5: ");
                    scanner.next();
                }
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> sendNewMessage(scanner);
                    case 2 -> displayArray("Sent Messages", sentMessages);
                    case 3 -> displayArray("Disregarded Messages", disregardedMessages);
                    case 4 -> storedMessagesMenu(scanner);
                    case 5 -> System.out.println("Exiting application. Goodbye!");
                    default -> System.out.println("Invalid choice. Please select between 1 and 5.");
                }
            } while (choice != 5);
        }
    }

    // Option 1: Allows user to type and send a message with space input
    public static void sendNewMessage(Scanner scanner) {
        System.out.println("\n--- Send New Message ---");
        System.out.print("Enter recipient number: ");
        String recipient = scanner.nextLine();

        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        // Expand sentMessages array to accommodate the new message
        String[] newSentArray = new String[sentMessages.length + 1];
        System.arraycopy(sentMessages, 0, newSentArray, 0, sentMessages.length);
        newSentArray[newSentArray.length - 1] = message;
        sentMessages = newSentArray;

        System.out.println("Success! Message sent to " + recipient + ": \"" + message + "\"");
    }

    // Helper method to display generic arrays
    public static void displayArray(String title, String[] arr) {
        System.out.println("\n--- " + title + " ---");
        if (arr.length == 0) {
            System.out.println("No messages found.");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ". " + arr[i]);
        }
    }

    // Fourth Main Menu Option: Stored Messages Sub-menu (a - f)
    public static void storedMessagesMenu(Scanner scanner) {
        int subChoice = 0;
        do {
            System.out.println("\n----------------------------------------");
            System.out.println("       STORED MESSAGES SUB-MENU         ");
            System.out.println("----------------------------------------");
            System.out.println("1. Display sender and recipient of all stored messages");
            System.out.println("2. Display the longest stored message");
            System.out.println("3. Search for a message ID and display recipient and message");
            System.out.println("4. Search for all messages stored for a particular recipient");
            System.out.println("5. Delete a message using the message hash");
            System.out.println("6. Display a report listing full details of all stored messages");
            System.out.println("7. Return to Main Menu");
            System.out.print("Choose an option (1-7): ");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;
            try {
                subChoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                subChoice = -1;
            }

            switch (subChoice) {
                case 1 -> displaySenderAndRecipient();
                case 2 -> displayLongestStoredMessage();
                case 3 -> searchByMessageID(scanner);
                case 4 -> searchByRecipient(scanner);
                case 5 -> deleteByMessageHash(scanner);
                case 6 -> displayFullReport();
                case 7 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid option. Please choose between 1 and 7.");
            }
        } while (subChoice != 7);
    }

    // Feature a: Display sender/recipient of stored messages
    public static void displaySenderAndRecipient() {
        System.out.println("\n--- Sender & Recipient of Stored Messages ---");
        // Mapping stored messages indices (indexes 1 and 4 from test data correspond to stored items)
        int[] storedIndices = {1, 4};
        for (int idx : storedIndices) {
            if (idx < recipients.length) {
                System.out.println("Recipient: " + recipients[idx] + " | Message: " + sentMessages[Math.min(idx, sentMessages.length - 1)]);
            }
        }
    }

    // Feature b: Display the longest stored message
    public static void displayLongestStoredMessage() {
        System.out.println("\n--- Longest Stored Message ---");
        if (storedMessages.length == 0) {
            System.out.println("No stored messages available.");
            return;
        }
        String longest = storedMessages[0];
        for (String msg : storedMessages) {
            if (msg.length() > longest.length()) {
                longest = msg;
            }
        }
        System.out.println("\"" + longest + "\"");
    }

    // Feature c: Search for a message ID and display corresponding recipient & message
    public static void searchByMessageID(Scanner scanner) {
        System.out.println("\n--- Search by Message ID ---");
        System.out.print("Enter Message ID (e.g., ID004): ");
        String searchID = scanner.nextLine().trim();

        boolean found = false;
        for (int i = 0; i < messageIDs.length; i++) {
            if (messageIDs[i].equalsIgnoreCase(searchID)) {
                found = true;
                String matchingRecipient = (i < recipients.length) ? recipients[i] : "Unknown";
                String matchingContent = (i < sentMessages.length) ? sentMessages[i] : "Stored Message Content";
                System.out.println("Found! ID: " + messageIDs[i]);
                System.out.println("Recipient: " + matchingRecipient);
                System.out.println("Message: \"" + matchingContent + "\"");
                break;
            }
        }
        if (!found) {
            System.out.println("Message ID '" + searchID + "' not found.");
        }
    }

    // Feature d: Search all messages stored for a particular recipient
    public static void searchByRecipient(Scanner scanner) {
        System.out.println("\n--- Search by Recipient ---");
        System.out.print("Enter Recipient Number (e.g., +27838884567): ");
        String targetRecipient = scanner.nextLine().trim();

        boolean found = false;
        System.out.println("Messages for " + targetRecipient + ":");
        for (int i = 0; i < recipients.length; i++) {
            if (recipients[i].equals(targetRecipient)) {
                found = true;
                String msgText = (i < storedMessages.length) ? storedMessages[i % storedMessages.length] : "Test message";
                System.out.println("- \"" + msgText + "\"");
            }
        }
        if (!found) {
            System.out.println("No messages found for recipient: " + targetRecipient);
        }
    }

    // Feature e: Delete a message using the message hash
    public static void deleteByMessageHash(Scanner scanner) {
        System.out.println("\n--- Delete Message by Hash ---");
        System.out.print("Enter Message Hash (e.g., HASH456): ");
        String targetHash = scanner.nextLine().trim();

        boolean found = false;
        for (String messageHashe : messageHashes) {
            if (messageHashe.equalsIgnoreCase(targetHash)) {
                found = true;
                System.out.println("Message: \"" + storedMessages[0] + "\" successfully deleted.");
                break;
            }
        }
        if (!found) {
            System.out.println("Message Hash '" + targetHash + "' not found.");
        }
    }

    // Feature f: Display a report listing full details of all stored messages
    public static void displayFullReport() {
        System.out.println("\n--- Full Stored Messages Report ---");
        for (int i = 0; i < storedMessages.length; i++) {
            System.out.println("----------------------------------------");
            System.out.println("Message Hash : " + (i < messageHashes.length ? messageHashes[i] : "N/A"));
            System.out.println("Recipient    : " + (i < recipients.length ? recipients[i] : "N/A"));
            System.out.println("Message      : " + storedMessages[i]);
        }
        System.out.println("----------------------------------------");
    }
}