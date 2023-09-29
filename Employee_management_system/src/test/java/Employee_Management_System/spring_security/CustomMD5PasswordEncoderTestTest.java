package Employee_Management_System.spring_security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomMD5PasswordEncoderTestTest {

    private CustomMD5PasswordEncoderTest customMD5PasswordEncoderTestUnderTest;

    @BeforeEach
    void setUp() {
        customMD5PasswordEncoderTestUnderTest = new CustomMD5PasswordEncoderTest();
    }

    @Test
    void testEncode() {
        customMD5PasswordEncoderTestUnderTest.encode();
    }

    @Test
    void testMatches() {
        customMD5PasswordEncoderTestUnderTest.matches();
    }
}
