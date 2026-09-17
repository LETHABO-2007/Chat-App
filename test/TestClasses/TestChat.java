/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login("Kyl", "1");
    }
    
    // --- Username Tests ---
    @Test
    public void testCheckUserNameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserNameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }
    
    // --- Password Tests ---
    @Test
    public void testCheckPasswordComplexitySuccess() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexityFailure() {
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    // --- Cell Phone Tests ---
    @Test
    public void testCheckCellPhoneNumberSuccess() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneNumberFailure() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
    
    // --- Login Authentication Tests ---
    @Test
    public void testLoginUserSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyl", "1");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    
    @Test
    public void testLoginUserFailure() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyl", "1");
        assertFalse(login.loginUser("kyl_1", "wrongpassword"));
    }
    
    // --- Status String Response Tests ---
    @Test
    public void testReturnLoginStatusSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyl", "1");
        String status = login.returnLoginStatus(true);
        assertEquals("Welcome Kyl ,1 it is great to see you.", status);
    }

    @Test
    public void testReturnLoginStatusFailure() {
        String status = login.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", status);
    }
}