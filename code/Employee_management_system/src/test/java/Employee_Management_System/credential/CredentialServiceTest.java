package Employee_Management_System.credential;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;



class CredentialServiceTest {


    @Mock
    // @Mock is used to create a mock implementation of CredentialRepository.
    private CredentialRepository credentialRepository;

    @InjectMocks
    // @InjectMocks is used to inject mock fields into the service instance to be tested.
    private CredentialService credentialService;

    @BeforeEach
    //  @BeforeEach is used to setup mocks before each test.
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAccount() {
        Credential credential = new Credential();
        credential.setUsername("testUsername");
        credential.setPasswordHash("testPassword");

        // configuring the mock credentialRepository to return the credential object when its save method is called with
        // any object of type Credential.
        when(credentialRepository.save(any(Credential.class))).thenReturn(credential);

        Credential createdCredential = credentialService.createAccount(credential);

        // Use assertions to check if the output is as expected.
        assertEquals(credential.getUsername(), createdCredential.getUsername());
        assertEquals(credential.getPasswordHash(), createdCredential.getPasswordHash());
        verify(credentialRepository, times(1)).save(credential);
    }

    @Test
    void login() {
        String username = "testUsername";
        String password = "testPassword";

        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setPasswordHash(password);
        // when findByUsername method of the credentialRepository mock is called with the username parameter, it should
        // return an Optional containing the credential object
        when(credentialRepository.findByUsername(username)).thenReturn(Optional.of(credential));

        Credential loggedCredential = credentialService.login(username, password);

        // Use assertions to check if the output is as expected.
        assertEquals(username, loggedCredential.getUsername());
        assertEquals(password, loggedCredential.getPasswordHash());
    }

    @Test
    void shouldCreateAccountSuccessfully() {
        // Arrange a new user with valid details
        Credential expectedCredential = new Credential("newUser", "newPass");
        when(credentialRepository.save(any(Credential.class))).thenReturn(expectedCredential);

        // Creating an account
        Credential actualCredential = credentialService.createAccount(expectedCredential);

        // Assert
        assertNotNull(actualCredential, "Created account should not be null");
        assertEquals(expectedCredential.getUsername(), actualCredential.getUsername(), "Username should match");
        assertEquals(expectedCredential.getPasswordHash(), actualCredential.getPasswordHash(), "Password should match");
    }

    @Test
    void shouldNotCreateAccountWithExistingUsername() {
        // Arrange a username that already exists in the system
        Credential existingCredential = new Credential("existingUser", "correctPass");
        when(credentialRepository.findByUsername(existingCredential.getUsername()))
                .thenReturn(Optional.of(existingCredential));

        // Creating an account
        Credential actualCredential = credentialService.createAccount(existingCredential);

        // Assert
        assertNull(actualCredential, "Account with existing username should not be created");
    }


    @Test
    void shouldNotCreateAccountWithInvalidDetails() {
        // Arrange
        Credential invalidCredential1 = new Credential("", "somePass"); // Empty username
        Credential invalidCredential2 = new Credential("someUser", ""); // Empty password
        Credential invalidCredential3 = new Credential(null, "somePass"); // Null username
        Credential invalidCredential4 = new Credential("someUser", null); // Null password

        // Act
        Credential actualCredential1 = credentialService.createAccount(invalidCredential1);
        Credential actualCredential2 = credentialService.createAccount(invalidCredential2);
        Credential actualCredential3 = credentialService.createAccount(invalidCredential3);
        Credential actualCredential4 = credentialService.createAccount(invalidCredential4);

        // Assert
        assertNull(actualCredential1, "Account with empty username should not be created");
        assertNull(actualCredential2, "Account with empty password should not be created");
        assertNull(actualCredential3, "Account with null username should not be created");
        assertNull(actualCredential4, "Account with null password should not be created");
    }



    @Test
    void shouldLoginSuccessfully() {
        // Arrange a valid username and password (excepted)
        Credential validCredential = new Credential("validUser", "validPass");
        when(credentialRepository.findByUsername(validCredential.getUsername()))
                .thenReturn(Optional.of(validCredential));

        // The user should be successfully logged in
        Credential actualCredential = credentialService.login(validCredential.getUsername(), validCredential.getPasswordHash());

        // Assert
        assertNotNull(actualCredential, "Logged-in account should not be null");
        assertEquals(validCredential.getUsername(), actualCredential.getUsername(), "Username should match");
    }

    @Test
    void shouldNotLoginWithNonExistingUsername() {
        // Arrange
        String nonExistingUsername = "nonExistingUser";
        when(credentialRepository.findByUsername(nonExistingUsername)).thenReturn(Optional.empty());

        // Act
        Credential actualCredential = credentialService.login(nonExistingUsername, "somePass");

        // Assert
        assertNull(actualCredential, "Non-existing username should not be able to log in");
    }

    @Test
    void shouldNotLoginWithIncorrectPassword() {
        // Arrange
        Credential existingCredential = new Credential("existingUser", "correctPass");
        when(credentialRepository.findByUsername(existingCredential.getUsername()))
                .thenReturn(Optional.of(existingCredential));

        // Act
        Credential actualCredential = credentialService.login(existingCredential.getUsername(), "incorrectPass");

        // Assert
        assertNull(actualCredential, "Incorrect password should not be able to log in");
    }


}