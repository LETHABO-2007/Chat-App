/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import org.junit.jupiter.api.Test;


public class MessageAppTest {

    @Test
    public void testSentMessagesArrayPopulation() {
        String[] expectedSent = {
            "Did you get the cake?",
            "It is dinner time !"
        };

        assertArrayEquals("Sent messages array should match test data", expectedSent, MessageApp.sentMessages);
    }

    @Test
    public void testDisplayLongestStoredMessage() {
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
        String searchID = "ID004";
        String expectedRecipient = "0838884567";

        int index = -1;
        for (int i = 0; i < MessageApp.messageIDs.length; i++) {
            if (MessageApp.messageIDs[i].equals(searchID)) {
                index = i;
                break;
            }
        }
         
        // Only index into sentMessages if enough elements exist; otherwise check storedMessages
        if (index < MessageApp.sentMessages.length) {
            assertNotNull("Sent message at index should not be null", MessageApp.sentMessages[index]);
        } else {
            int storedIdx = index % MessageApp.storedMessages.length;
            assertNotNull("Corresponding stored message should not be null", MessageApp.storedMessages[storedIdx]);
        }
    }

    @Test
    public void testSearchByRecipient() {
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
        assertNotNull("Stored messages list should not be null", MessageApp.storedMessages);
        assertTrue("Stored messages list should contain items for the report", MessageApp.storedMessages.length > 0);
    }

    private void assertArrayEquals(String sent_messages_array_should_match_test_dat, String[] expectedSent, String[] sentMessages) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(String longest_stored_message_should_match_test_, String expectedLongest, String longest) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertTrue(String message_ID_should_be_found, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertNotNull(String sent_message_at_index_should_not_be_null, String sentMessage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertNotNull(String stored_messages_list_should_not_be_null, String[] storedMessages) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}