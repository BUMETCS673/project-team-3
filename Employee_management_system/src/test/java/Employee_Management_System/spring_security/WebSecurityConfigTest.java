package Employee_Management_System.spring_security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class WebSecurityConfigTest {

    @Mock
    private UserDetailsService mockUserDetailsService;
    @Mock
    private CustomMD5PasswordEncoder mockCustomMd5PasswordEncoder;

    @InjectMocks
    private WebSecurityConfig webSecurityConfigUnderTest;

    @Test
    void testAuthenticationManager() {
        // Setup
        // Run the test
        final AuthenticationManager result = webSecurityConfigUnderTest.authenticationManager();

        // Verify the results
    }

    @Test
    void testAuthenticationManager_ThrowsException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> webSecurityConfigUnderTest.authenticationManager()).isInstanceOf(Exception.class);
    }

    @Test
    void testConfigure1() {
        // Setup
        final HttpSecurity http = new HttpSecurity(null, new AuthenticationManagerBuilder(null), null);

        // Run the test
        webSecurityConfigUnderTest.configure(http);

        // Verify the results
    }

    @Test
    void testConfigure1_ThrowsException() {
        // Setup
        final HttpSecurity http = new HttpSecurity(null, new AuthenticationManagerBuilder(null), null);

        // Run the test
        assertThatThrownBy(() -> webSecurityConfigUnderTest.configure(http)).isInstanceOf(Exception.class);
    }

    @Test
    void testConfigure2() {
        // Setup
        final AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(null);

        // Run the test
        webSecurityConfigUnderTest.configure(auth);

        // Verify the results
    }

    @Test
    void testConfigure2_ThrowsException() {
        // Setup
        final AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(null);

        // Run the test
        assertThatThrownBy(() -> webSecurityConfigUnderTest.configure(auth)).isInstanceOf(Exception.class);
    }

    @Test
    void testConfigure3() {
        // Setup
        final WebSecurity web = new WebSecurity(null);

        // Run the test
        webSecurityConfigUnderTest.configure(web);

        // Verify the results
    }

    @Test
    void testConfigure3_ThrowsException() {
        // Setup
        final WebSecurity web = new WebSecurity(null);

        // Run the test
        assertThatThrownBy(() -> webSecurityConfigUnderTest.configure(web)).isInstanceOf(Exception.class);
    }
}
