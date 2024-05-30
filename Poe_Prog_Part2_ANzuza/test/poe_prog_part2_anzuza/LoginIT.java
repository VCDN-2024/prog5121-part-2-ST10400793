package poe_prog_part2_anzuza;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginIT {

    @Test
    public void testCheckUserName_Valid() {
        assertTrue(Login.checkUserName("user_name"));
    }

    @Test
    public void testCheckUserName_Invalid() {
        assertFalse(Login.checkUserName("username"));
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        assertTrue(Login.checkPasswordComplexity("Password1!#"));
    }

    @Test
    public void testCheckPasswordComplexity_NoUpperCase() {
        assertFalse(Login.checkPasswordComplexity("password1!#"));
    }

    @Test
    public void testCheckPasswordComplexity_NoLowerCase() {
        assertFalse(Login.checkPasswordComplexity("PASSWORD1!#"));
    }

    @Test
    public void testCheckPasswordComplexity_NoNumber() {
        assertFalse(Login.checkPasswordComplexity("Password!#"));
    }

    @Test
    public void testCheckPasswordComplexity_NoSpecialCharacter() {
        assertFalse(Login.checkPasswordComplexity("Password1"));
    }

    @Test
    public void testGetters() {
        Login login = new Login("user_name", "Sixmarch1970#", "Aya", "Nzuza");
        assertEquals("user_name", login.getUsername());
        assertEquals("Sixmarch1970#", login.getPassword());
        assertEquals("Aya", login.getFirstname());
        assertEquals("Nzuza", login.getLastname());
    }

    @Test
    public void testSetters() {
        Login login = new Login("user_name", "Password1!", "John", "Doe");
        login.setUsername("new_user_name");
        login.setPassword("NewPassword1!");
        login.setFirstname("Jane");
        login.setLastname("Smith");

        assertEquals("new_user_name", login.getUsername());
        assertEquals("NewPassword1!", login.getPassword());
        assertEquals("Jane", login.getFirstname());
        assertEquals("Smith", login.getLastname());
    }
}
