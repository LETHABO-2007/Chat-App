/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chatapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TECH 1
 */
public class MessageAppIT {
    
    public MessageAppIT() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class MessageApp.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MessageApp.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendNewMessage method, of class MessageApp.
     */
    @Test
    public void testSendNewMessage() {
        System.out.println("sendNewMessage");
        MessageApp.Scanner scanner = null;
        MessageApp.sendNewMessage(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayArray method, of class MessageApp.
     */
    @Test
    public void testDisplayArray() {
        System.out.println("displayArray");
        String title = "";
        String[] arr = null;
        MessageApp.displayArray(title, arr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storedMessagesMenu method, of class MessageApp.
     */
    @Test
    public void testStoredMessagesMenu() {
        System.out.println("storedMessagesMenu");
        MessageApp.Scanner scanner = null;
        MessageApp.storedMessagesMenu(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySenderAndRecipient method, of class MessageApp.
     */
    @Test
    public void testDisplaySenderAndRecipient() {
        System.out.println("displaySenderAndRecipient");
        MessageApp.displaySenderAndRecipient();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLongestStoredMessage method, of class MessageApp.
     */
    @Test
    public void testDisplayLongestStoredMessage() {
        System.out.println("displayLongestStoredMessage");
        MessageApp.displayLongestStoredMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByMessageID method, of class MessageApp.
     */
    @Test
    public void testSearchByMessageID() {
        System.out.println("searchByMessageID");
        MessageApp.Scanner scanner = null;
        MessageApp.searchByMessageID(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByRecipient method, of class MessageApp.
     */
    @Test
    public void testSearchByRecipient() {
        System.out.println("searchByRecipient");
        MessageApp.Scanner scanner = null;
        MessageApp.searchByRecipient(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByMessageHash method, of class MessageApp.
     */
    @Test
    public void testDeleteByMessageHash() {
        System.out.println("deleteByMessageHash");
        MessageApp.Scanner scanner = null;
        MessageApp.deleteByMessageHash(scanner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayFullReport method, of class MessageApp.
     */
    @Test
    public void testDisplayFullReport() {
        System.out.println("displayFullReport");
        MessageApp.displayFullReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
