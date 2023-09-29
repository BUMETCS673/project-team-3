package Employee_Management_System.spring_security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TokenAuthenticationFilterTest {

    private TokenAuthenticationFilter tokenAuthenticationFilterUnderTest;

    @BeforeEach
    void setUp() {
        tokenAuthenticationFilterUnderTest = new TokenAuthenticationFilter();
    }

    @Test
    void testDoFilterInternal() {
        // Setup
        final HttpServletRequest httpServletRequest = null;
        final HttpServletResponse httpServletResponse = null;
        final FilterChain filterChain = null;

        // Run the test
        tokenAuthenticationFilterUnderTest.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

        // Verify the results
    }

    @Test
    void testDoFilterInternal_ThrowsServletException() {
        // Setup
        final HttpServletRequest httpServletRequest = null;
        final HttpServletResponse httpServletResponse = null;
        final FilterChain filterChain = null;

        // Run the test
        assertThatThrownBy(
                () -> tokenAuthenticationFilterUnderTest.doFilterInternal(httpServletRequest, httpServletResponse,
                        filterChain)).isInstanceOf(ServletException.class);
    }

    @Test
    void testDoFilterInternal_ThrowsIOException() {
        // Setup
        final HttpServletRequest httpServletRequest = null;
        final HttpServletResponse httpServletResponse = null;
        final FilterChain filterChain = null;

        // Run the test
        assertThatThrownBy(
                () -> tokenAuthenticationFilterUnderTest.doFilterInternal(httpServletRequest, httpServletResponse,
                        filterChain)).isInstanceOf(IOException.class);
    }
}
