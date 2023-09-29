package Employee_Management_System.spring_security;

import Employee_Management_System.result.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

class ResponseUtilTest {

    @Test
    void testOut() {
        // Setup
        final HttpServletResponse response = null;
        final Result r = Result.ok(null);

        // Run the test
        ResponseUtil.out(response, r);

        // Verify the results
    }
}
