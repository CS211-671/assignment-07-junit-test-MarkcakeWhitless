package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    UserList userList;

    @BeforeEach
    void init() {
        userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
    }

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
        // TODO: find one of them
        User user = userList.findUserByUsername("user2");
        // TODO: assert that UserList found User
        String expected = "user2";
        String actual = user.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
        // TODO: change password of one user
        boolean result = userList.changePassword("user3", "password3", "newpassword3");
        // TODO: assert that user can change password
        assertTrue(result);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
        // TODO: call login() with correct username and password
        User user = userList.login("user1", "password1");
        // TODO: assert that User object is found
        assertEquals("user1", user.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
        // TODO: call login() with incorrect username or incorrect password
        User user = userList.login("user1", "wrongpassword");
        // TODO: assert that the method return null
        assertNull(user);
    }

}