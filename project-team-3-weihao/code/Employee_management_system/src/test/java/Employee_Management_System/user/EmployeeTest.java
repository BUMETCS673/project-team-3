package Employee_Management_System.user;

import Employee_Management_System.user.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {
    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
    }

    @Test
    void testGetName() {
        employee.setName("bart");
        assertEquals("bart", employee.getName());
    }

    @Test
    void testGetId() {
        employee.setId(123);
        assertEquals(123, employee.getId());
    }

    @Test
    void testGetJobTitle() {
        employee.setJobTitle("Employee");
        assertEquals("Employee", employee.getJobTitle());
    }

    @Test
    void testGetAnnualSalary() {
        employee.setAnnualSalary(120000.59);
        assertEquals(120000.59, employee.getAnnualSalary());
    }

    @Test
    void testGetEmail() {
        employee.setEmail("ma@bu.edu");
        assertEquals("ma@bu.edu", employee.getEmail());
    }

    @Test
    void testGetPhoneNumber() {
        employee.setPhoneNumber("6142864136");
        assertEquals("6142864136", employee.getPhoneNumber());
    }
}