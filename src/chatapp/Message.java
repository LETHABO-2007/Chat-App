/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

/**
 *
 * @author TECH 1
 */

import java.util.Random;

public final class Message {
    private final String messageID;
    private final int messageNumber;
    private final String recipient;
    private final String messageContent;
    private final String messageHash;
    private String sendStatus;

    // Constructor
    public Message(int messageNumber, String recipient, String messageContent) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    // Generate a random 10-digit Message ID
    private String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    // Check Message ID format
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    // Check Message Length Status
    public String checkMessageLengthStatus() {
        if (messageContent != null && messageContent.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = messageContent.length() - 250;
            return "Message exceeds 250 characters by " + excess + " characters; please reduce the size.";
        }
    }

    // Check Recipient Cell Number Status
    public String checkRecipientCellStatus() {
        if (recipient != null && recipient.length() <= 10 && recipient.startsWith("+")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Create Message Hash
    public String createMessageHash() {
        if (messageID == null || messageID.length() < 2) return "";
        
        String prefix = messageID.substring(0, 2);
        String trimmed = messageContent.replaceAll("^\"|\"$", "").trim();
        String[] words = trimmed.split("\\s+");
        String firstWord = words.length > 0 ? words[0].replaceAll("[^a-zA-Z]", "") : "";
        String lastWord = words.length > 1 ? words[words.length - 1].replaceAll("[^a-zA-Z]", "") : firstWord;
        
        return (prefix + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }

    // Handle Send Options
    public String sentMessage(int option) {
        switch (option) {
            case 1 -> {
                this.sendStatus = "Message successfully sent.";
                return this.sendStatus;
            }
            case 2 -> {
                this.sendStatus = "Press 0 to delete the message.";
                return this.sendStatus;
            }
            case 3 -> {
                storeMessage();
                this.sendStatus = "Message successfully stored.";
                return this.sendStatus;
            }
            default -> {
                return "Invalid option selected.";
            }
        }
    }

    public void storeMessage() {
        // Optional JSON file writing stub
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageContent() {
        return messageContent;
    }

    boolean printMessages() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean checkRecipientCell() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean checkMessageLength() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}