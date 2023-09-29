package Employee_Management_System.spring_security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class TokenLoginFilterTest {

    @Mock
    private AuthenticationManager mockAuthenticationManager;

    private TokenLoginFilter tokenLoginFilterUnderTest;

    @BeforeEach
    void setUp() {
        tokenLoginFilterUnderTest = new TokenLoginFilter(mockAuthenticationManager);
    }

    @Test
    void testAttemptAuthentication() {
        // Setup
        final HttpServletRequest request = null;
        final Authentication expectedResult = new TestingAuthenticationToken("user", "pass", "ROLE_USER");

        // Run the test
        final Authentication result = tokenLoginFilterUnderTest.attemptAuthentication(request, null);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testAttemptAuthentication_ThrowsAuthenticationException() {
        // Setup
        final HttpServletRequest request = null;

        // Run the test
        assertThatThrownBy(() -> tokenLoginFilterUnderTest.attemptAuthentication(request, null))
                .isInstanceOf(AuthenticationException.class);
    }

    @Test
    void testSuccessfulAuthentication() {
        // Setup
        final HttpServletResponse response = null;
        final Authentication authResult = new TestingAuthenticationToken("user", "pass", "ROLE_USER");

        // Run the test
        tokenLoginFilterUnderTest.successfulAuthentication(null, response, null, authResult);

        // Verify the results
    }

    @Test
    void testSuccessfulAuthentication_ThrowsIOException() {
        // Setup
        final HttpServletResponse response = null;
        final Authentication authResult = new TestingAuthenticationToken("user", "pass", "ROLE_USER");

        // Run the test
        assertThatThrownBy(() -> tokenLoginFilterUnderTest.successfulAuthentication(null, response, null,
                authResult)).isInstanceOf(IOException.class);
    }

    @Test
    void testSuccessfulAuthentication_ThrowsServletException() {
        // Setup
        final HttpServletResponse response = null;
        final Authentication authResult = new TestingAuthenticationToken("user", "pass", "ROLE_USER");

        // Run the test
        assertThatThrownBy(() -> tokenLoginFilterUnderTest.successfulAuthentication(null, response, null,
                authResult)).isInstanceOf(ServletException.class);
    }

    @Test
    void testUnsuccessfulAuthentication() {
        // Setup
        final HttpServletResponse response = null;

        // Run the test
        tokenLoginFilterUnderTest.unsuccessfulAuthentication(null, response, null);

        // Verify the results
    }

    @Test
    void testUnsuccessfulAuthentication_ThrowsIOException() {
        // Setup
        final HttpServletResponse response = null;

        // Run the test
        assertThatThrownBy(
                () -> tokenLoginFilterUnderTest.unsuccessfulAuthentication(null, response, null))
                .isInstanceOf(IOException.class);
    }

    @Test
    void testUnsuccessfulAuthentication_ThrowsServletException() {
        // Setup
        final HttpServletResponse response = null;

        // Run the test
        assertThatThrownBy(
                () -> tokenLoginFilterUnderTest.unsuccessfulAuthentication(null, response, null))
                .isInstanceOf(ServletException.class);
    }
}
