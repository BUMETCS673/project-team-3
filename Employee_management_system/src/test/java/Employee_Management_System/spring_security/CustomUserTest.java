package Employee_Management_System.spring_security;

import Employee_Management_System.credential.Credential;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CustomUserTest {

    @Mock
    private Credential mockCredential;
    @Mock
    private Collection<? extends GrantedAuthority> mockAuthorities;

    private CustomUser customUserUnderTest;

    @BeforeEach
    void setUp() {
        customUserUnderTest = new CustomUser(mockCredential, mockAuthorities);
    }

    @Test
    void testCredentialGetterAndSetter() {
        final Credential credential = new Credential(null, null);
        customUserUnderTest.setCredential(credential);
        assertThat(customUserUnderTest.getCredential()).isEqualTo(credential);
    }

    @Test
    void testEquals() {
        assertThat(customUserUnderTest.equals(null)).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(customUserUnderTest.canEqual(null)).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(customUserUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    void testToString() {
        // Setup
        // Run the test
        final java.lang.String result = customUserUnderTest.toString();

        // Verify the results
    }
}
