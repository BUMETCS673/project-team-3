package Employee_Management_System.credential;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CredentialTest {

    @Test
    void getUsername() {
        // Arrange
        Credential credential = new Credential();
        String expectedUsername = "someUser";

        // Act
        credential.setUsername(expectedUsername);

        // Assert
        assertEquals(expectedUsername, credential.getUsername(), "The username returned should match the one set");
    }

    @Test
    void setUsername() {
        // Arrange
        Credential credential = new Credential();
        String expectedUsername = "someOtherUser";

        // Act
        credential.setUsername(expectedUsername);

        // Assert
        assertEquals(expectedUsername, credential.getUsername(), "The username set should match the one returned");
    }

    @Test
    void getPasswordHash() {
        // Arrange
        Credential credential = new Credential();
        String expectedPasswordHash = "someHashedPassword";

        // Act
        credential.setPasswordHash(expectedPasswordHash);

        // Assert
        assertEquals(expectedPasswordHash, credential.getPasswordHash(), "The password hash returned should match the one set");
    }

    @Test
    void setPasswordHash() {
        // Arrange
        Credential credential = new Credential();
        String expectedPasswordHash = "someOtherHashedPassword";

        // Act
        credential.setPasswordHash(expectedPasswordHash);

        // Assert
        assertEquals(expectedPasswordHash, credential.getPasswordHash(), "The password hash set should match the one returned");
    }
}
