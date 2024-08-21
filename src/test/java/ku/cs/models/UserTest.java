package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("tester", "password123");
    }

    @Test
    @DisplayName("Username constructor should initialize username and set password to null")
    void testUsernameConstructor() {
        User user = new User("tester");
        assertEquals("tester", user.getUsername());
        assertNull(user.getPassword());
    }

    @Test
    @DisplayName("Username and password constructor should initialize both username and hashed password")
    void testUsernameAndPasswordConstructor() {
        assertEquals("tester", user.getUsername());
        assertNotNull(user.getPassword());
    }

    @Test
    @DisplayName("Username check should correctly identify existing username")
    void testIsUsername() {
        assertTrue(user.isUsername("tester"));
        assertFalse(user.isUsername("othertester"));
    }

    @Test
    @DisplayName("Setting a new password should update the hashed password")
    void testSetPassword() {
        String newPassword = "newpassword";
        user.setPassword(newPassword);
        assertTrue(user.validatePassword(newPassword));
        assertFalse(user.validatePassword("wrongpassword"));
    }

    @Test
    @DisplayName("Password validation should work correctly with correct and incorrect passwords")
    void testValidatePassword() {
        assertTrue(user.validatePassword("password123"));
        assertFalse(user.validatePassword("wrongpassword"));
    }

    @Test
    @DisplayName("Get username should return the correct username")
    void testGetUsername() {
        assertEquals("tester", user.getUsername());
    }

    @Test
    @DisplayName("Password should not be stored in plain text")
    public void testPasswordIsNotStoredInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified correctly using plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }
}
