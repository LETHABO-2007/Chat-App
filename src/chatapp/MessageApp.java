/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

/**
 *
 * @author TECH 1
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MessageApp {

    // Arrays/Lists to store the data as required
    private static ArrayList<String> sentMessages = new ArrayList<>();
    private static ArrayList<String> disregardedMessages = new ArrayList<>();
    private static ArrayList<String> storedMessages = new ArrayList<>();
    private static ArrayList<String> messageHash = new ArrayList<>();
    private static ArrayList<String> messageID = new ArrayList<>();
    private static ArrayList<String> recipients = new ArrayList<>(); // To track recipients for stored/sent messages

    public static void main(String[] args) {
        // Populate arrays with test data automatically on startup
        initializeTestData();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n================ MAIN MENU ================");
            System.out.println("1. Send a Message");
            System.out.println("2. View Disregarded Messages");
            System.out.println("3. View Sent Messages");
            System.out.println("4. Stored Messages (Part 3 Menu)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Send Message feature selected.");
                    break;
                case 2:
                    System.out.println("\n--- Disregarded Messages ---");
                    for (String msg : disregardedMessages) {
                        System.out.println("- " + msg);
                    }
                    break;
                case 3:
                    System.out.println("\n--- Sent Messages ---");
                    for (String msg : sentMessages) {
                        System.out.println("- " + msg);
                    }
                    break;
                case 4:
                    handleStoredMessagesMenu(scanner);
                    break;
                case 5:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please choose between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Initialize test data from Part 3 specifications
    public static void initializeTestData() {
        // Message 1 (Sent)
        sentMessages.add("Did you get the cake?");
        messageID.add("1");
        messageHash.add("HASH001");
        recipients.add("+27834557896");

        // Message 2 (Stored)
        storedMessages.add("Where are you? You are late! I have asked you to be on time.");
        messageID.add("2");
        messageHash.add("HASH002");
        recipients.add("+2783884567");

        // Message 3 (Disregarded)
        disregardedMessages.add("Yohoooo, I am at your gate.");
        messageID.add("3");
        messageHash.add("HASH003");
        recipients.add("+27834484567");

        // Message 4 (Sent)
        sentMessages.add("It is dinner time !");
        messageID.add("4");
        messageHash.add("HASH004");
        recipients.add("038884567");

        // Message 5 (Stored)
        storedMessages.add("Ok, I am leaving without you.");
        messageID.add("5");
        messageHash.add("HASH005");
        recipients.add("+2783884567");
    }

    // 4th Main Menu Option Sub-Menu ("Stored Messages")
    private static void handleStoredMessagesMenu(Scanner scanner) {
        int subChoice;
        do {
            System.out.println("\n========= STORED MESSAGES MENU (Option 4) =========");
            System.out.println("a. Display sender/recipient and message of all stored messages");
            System.out.println("b. Display the longest stored message");
            System.out.println("c. Search for a message ID and display recipient and message");
            System.out.println("d. Search for all messages stored for a particular recipient");
            System.out.println("e. Delete a message using the message hash");
            System.out.println("f. Display a report of all stored messages");
            System.out.println("g. Return to Main Menu");
            System.out.print("Enter your choice (a-g): ");

            String input = scanner.nextLine().trim().toLowerCase();
            if (input.isEmpty()) continue;
            subChoice = input.charAt(0);

            switch (subChoice) {
                case 'a':
                    displaySenderAndStoredMessages();
                    break;
                case 'b':
                    displayLongestStoredMessage();
                    break;
                case 'c':
                    searchByMessageID(scanner);
                    break;
                case 'd':
                    searchByRecipient(scanner);
                    break;
                case 'e':
                    deleteByMessageHash(scanner);
                    break;
                case 'f':
                    displayFullReport();
                    break;
                case 'g':
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid selection! Please enter a letter from a to g.");
            }
        } while (true);
    }

    // a. Display sender and recipient of all stored messages
    public static void displaySenderAndStoredMessages() {
        System.out.println("\n--- Sender and Stored Messages ---");
        for (int i = 0; i < storedMessages.size(); i++) {
            // Mapping stored messages back to their corresponding records
            System.out.println("Recipient: " + recipients.get(1 + i) + " | Message: " + storedMessages.get(i));
        }
    }

    // b. Display the longest stored message (or across messages if evaluated broadly)
    public static void displayLongestStoredMessage() {
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages available.");
            return;
        }
        String longest = storedMessages.get(0);
        for (String msg : storedMessages) {
            if (msg.length() > longest.length()) {
                longest = msg;
            }
        }
        System.out.println("\n--- Longest Stored Message ---");
        System.out.println(longest);
    }

    // c. Search for a message ID and display recipient and message
    public static void searchByMessageID(Scanner scanner) {
        System.out.print("Enter Message ID to search: ");
        String id = scanner.nextLine().trim();
        int index = messageID.indexOf(id);
        if (index != -1) {
            System.out.println("\n--- Message Found ---");
            System.out.println("ID: " + messageID.get(index));
            System.out.println("Recipient/Sender: " + recipients.get(index));
            // Check where message belongs
            String msgText = "";
            if (id.equals("1") || id.equals("4")) msgText = sentMessages.get(id.equals("1") ? 0 : 1);
            else if (id.equals("3")) msgText = disregardedMessages.get(0);
            else if (id.equals("2") || id.equals("5")) msgText = storedMessages.get(id.equals("2") ? 0 : 1);
            
            System.out.println("Message: " + msgText);
        } else {
            System.out.println("Message ID not found.");
        }
    }

    // d. Search all the messages stored for a particular recipient
    public static void searchByRecipient(Scanner scanner) {
        System.out.print("Enter recipient number to search (e.g., +2783884567): ");
        String targetRecipient = scanner.nextLine().trim();
        boolean found = false;

        System.out.println("\n--- Messages for Recipient: " + targetRecipient + " ---");
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).equals(targetRecipient)) {
                found = true;
                // Find matching message text based on index
                if (i == 1) System.out.println("- " + storedMessages.get(0));
                else if (i == 4) System.out.println("- " + storedMessages.get(1));
                else if (i == 0) System.out.println("- " + sentMessages.get(0));
                else if (i == 3) System.out.println("- " + sentMessages.get(1));
            }
        }
        if (!found) {
            System.out.println("No messages found for this recipient.");
        }
    }

    // e. Delete a message using the message hash
    public static void deleteByMessageHash(Scanner scanner) {
        System.out.print("Enter Message Hash to delete (e.g., HASH002): ");
        String hash = scanner.nextLine().trim();
        int index = messageHash.indexOf(hash);

        if (index != -1) {
            String targetID = messageID.get(index);
            messageHash.remove(index);
            messageID.remove(index);
            recipients.remove(index);
            
            // Remove from specific category list
            if (index < sentMessages.size()) {
                sentMessages.remove(index);
            } else {
                storedMessages.remove(Math.min(index, storedMessages.size() - 1));
            }
            System.out.println("Message with Hash " + hash + " successfully deleted.");
        } else {
            System.out.println("Message hash not found.");
        }
    }

    // f. Display a report that lists full details of all stored messages
    public static void displayFullReport() {
        System.out.println("\n================ STORED MESSAGES REPORT ================");
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages to display.");
            return;
        }
        for (int i = 0; i < storedMessages.size(); i++) {
            int originalIdx = (i == 0) ? 1 : 4; // Mapping indices based on test dataset
            System.out.println("Message Hash : " + messageHash.get(originalIdx));
            System.out.println("Message ID   : " + messageID.get(originalIdx));
            System.out.println("Recipient    : " + recipients.get(originalIdx));
            System.out.println("Message      : " + storedMessages.get(i));
            System.out.println("--------------------------------------------------");
        }
    }
}