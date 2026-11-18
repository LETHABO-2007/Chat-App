/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

package chatapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageAppTest {

    @Test
    public void testSentMessagesArrayPopulation() {
        // Test Data: Developer entry for Test data message 1-4 expects specific sent items
        String[] expectedSent = {
            "Did you get the cake?",
            "It is dinner time !"
        };
        
        // Assert that the sent messages array is correctly populated
        assertArrayEquals("Sent messages array should match test data", expectedSent, MessageApp.sentMessages);
    }

    @Test
    public void testDisplayLongestStoredMessage() {
        // Test Data message 2 is the longest stored message
        String expectedLongest = "Where are you? You are late! I have asked you to be on time.";
        
        String longest = MessageApp.storedMessages[0];
        for (String msg : MessageApp.storedMessages) {
            if (msg.length() > longest.length()) {
                longest = msg;
            }
        }
        
        assertEquals("Longest stored message should match test data", expectedLongest, longest);
    }

    @Test
    public void testSearchByMessageID() {
        // Test Data for message ID search (e.g., ID004 corresponding to developer number)
        String searchID = "ID004";
        String expectedRecipient = "0838884567";
        String expectedMessage = "It is dinner time !";

        int index = -1;
        for (int i = 0; i < MessageApp.messageIDs.length; i++) {
            if (MessageApp.messageIDs[i].equals(searchID)) {
                index = i;
                break;
            }
        }

        assertTrue("Message ID should be found", index != -1);
        assertEquals("Recipient should match test data for ID004", expectedRecipient, MessageApp.recipients[index]);
        assertEquals("Message content should match", expectedMessage, MessageApp.sentMessages[1]);
    }

    @Test
    public void testSearchByRecipient() {
        // Test Data recipient: +27838884567
        String targetRecipient = "+27838884567";
        int matchCount = 0;

        for (String rec : MessageApp.recipients) {
            if (rec.equals(targetRecipient)) {
                matchCount++;
            }
        }

        assertTrue("Recipient +27838884567 should have stored/sent messages associated", matchCount > 0);
    }

    @Test
    public void testDeleteByMessageHash() {
        // Test Data Message 2 Hash validation
        String targetHash = "HASH456";
        boolean hashFound = false;

        for (String hash : MessageApp.messageHashes) {
            if (hash.equalsIgnoreCase(targetHash)) {
                hashFound = true;
                break;
            }
        }

        assertTrue("Message hash should exist in the system for deletion", hashFound);
    }

    @Test
    public void testFullReportGeneration() {
        // Validate that stored messages array has items to populate the report
        assertNotNull("Stored messages list should not be null", MessageApp.storedMessages);
        assertTrue("Stored messages list should contain items for the report", MessageApp.storedMessages.length > 0);
    }

    private void assertEquals(String longest_stored_message_should_match_test_, String expectedLongest, String longest) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertTrue(String message_ID_should_be_found, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertNotNull(String stored_messages_list_should_not_be_null, String[] storedMessages) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertArrayEquals(String sent_messages_array_should_match_test_dat, String[] expectedSent, String[] sentMessages) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}