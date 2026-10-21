/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import chatapp.Message;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message(1, "+2718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message ready to send.", msg.checkMessageLengthStatus());
    }

    @Test
    public void testMessageLengthFailure() {
        // Create a string longer than 250 characters
        char[] longChars = new char[260];
        java.util.Arrays.fill(longChars, 'a');
        String longContent = new String(longChars);

        Message msg = new Message(1, "+2718693002", longContent);
        assertTrue(msg.checkMessageLengthStatus().contains("Message exceeds 250 characters"));
    }

    @Test
    public void testRecipientCellSuccess() {
        Message msg = new Message(1, "+2718693002", "Hello");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCellStatus());
    }

    @Test
    public void testRecipientCellFailure() {
        Message msg = new Message(1, "0857597588", "Hello"); // Missing international code / '+'
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg.checkRecipientCellStatus());
    }

    @Test
    public void testMessageIDCreation() {
        Message msg = new Message(1, "+2718693002", "Test");
        assertTrue(msg.checkMessageID());
        assertNotNull(msg.getMessageID());
    }

    @Test
    public void testMessageHashFormat() {
        Message msg = new Message(1, "+2718693002", "Hi Mike, can you join us for dinner tonight?");
        String hash = msg.createMessageHash();
        
        // Hash should start with first 2 digits of the ID, followed by colon, message number, etc.
        String expectedPrefix = msg.getMessageID().substring(0, 2) + ":1:";
        assertTrue(hash.startsWith(expectedPrefix));
        assertTrue(hash.endsWith("HITONIGHT"));
    }

    @Test
    public void testSendOptions() {
        Message msg = new Message(1, "+2718693002", "Test message");
        
        assertEquals("Message successfully sent.", msg.sentMessage(1));
        assertEquals("Press 0 to delete the message.", msg.sentMessage(2));
        assertEquals("Message successfully stored.", msg.sentMessage(3));
    }
}