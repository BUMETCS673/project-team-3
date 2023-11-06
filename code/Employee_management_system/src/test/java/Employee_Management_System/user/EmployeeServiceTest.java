package Employee_Management_System.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootApplication
@DataJpaTest
@Disabled
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class EmployeeServiceTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    // test cases for AddNewEmployee
    @Test
    public void testAddNewEmployeeSingle() {
        Employee employee = Employee.builder().name("Alex").email("alex.stevenson@gmail.com").annualSalary(12000.56).jobTitle("manager")
                .build();

        Employee savedEmployee = employeeRepository.save(employee);

        Assertions.assertThat(employee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
    }
    @Test
    public void testAddNewEmployeeNull() {
        Employee employee = Employee.builder().build();

        Employee savedEmployee = employeeRepository.save(employee);

        Assertions.assertThat(employee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
    }
    @Test
    public void testAddNewEmployeeMultipleFull() {
        Employee employee1 = Employee.builder().name("Alex").email("alex.stevenson@gmail.com").annualSalary(25642.2).jobTitle("employee")
                .build();
        Employee employee2 = Employee.builder().name("Amanda").email("amanda@gmail.com").annualSalary(46152.2).jobTitle("manager")
                .build();
        Employee employee3 = Employee.builder().name("Narayan").email("Narayan@gmail.com").annualSalary(46152.2).jobTitle("employee")
                .build();
        Employee employee4 = Employee.builder().name("Wallace").email("Wallace@gmail.com").annualSalary(32152.2).jobTitle("employee")
                .build();
        Employee employee5 = Employee.builder().name("Wong").email("Wong@gmail.com").annualSalary(25025.3).jobTitle("employee")
                .build();
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
        Employee savedEmployee = employeeRepository.save(employee5);
        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @Test
    public void testAddNewEmployeeMultipleWithNull() {
        Employee employee1 = Employee.builder().name("Alex").annualSalary(25642.2).jobTitle("employee")
                .build();
        Employee employee2 = Employee.builder().name("Amanda").email("amanda@gmail.com").jobTitle("manager")
                .build();
        Employee employee3 = Employee.builder().name("Narayan").email("Narayan@gmail.com").annualSalary(46152.2).jobTitle("employee")
                .build();
        Employee employee4 = Employee.builder().name("Wallace").email("Wallace@gmail.com").annualSalary(32152.2)
                .build();
        Employee employee5 = Employee.builder().name("Wong").email("Wong@gmail.com").annualSalary(25025.3).jobTitle("employee")
                .build();
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
        Employee savedEmployee = employeeRepository.save(employee5);
        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    // test cases for getAllEmployee

    @Test
    void getAllEmployeeNull() {
        List<Employee> allEmployees = employeeRepository.findAll();
        Assertions.assertThat(allEmployees).hasSize((int) employeeRepository.count());
    }

    @Test
    void getAllEmployeeSingle() {
        Employee employee = Employee.builder().name("Alex").email("alex.stevenson@gmail.com").annualSalary(12000.56).jobTitle("manager")
                .build();
        employeeRepository.save(employee);
        List<Employee> allEmployees = employeeRepository.findAll();

        Assertions.assertThat(allEmployees).hasSizeGreaterThan(0);
        Assertions.assertThat(allEmployees).hasSize((int) employeeRepository.count());
    }

    @Test
    void getAllEmployeeMultiple() {
        Employee employee1 = Employee.builder().name("Alex").email("alex.stevenson@gmail.com").annualSalary(25642.2).jobTitle("employee")
                .build();
        Employee employee2 = Employee.builder().name("Amanda").email("amanda@gmail.com").annualSalary(46152.2).jobTitle("manager")
                .build();

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        List<Employee> allEmployees = employeeRepository.findAll();
        Assertions.assertThat(allEmployees).hasSize((int) employeeRepository.count());
    }

    @Test
    void getAllEmployeeMultipleLarge() {
        Employee employee1 = Employee.builder().name("Alex").email("alex.stevenson@gmail.com").annualSalary(25642.2).jobTitle("employee")
                .build();
        Employee employee2 = Employee.builder().name("Amanda").email("amanda@gmail.com").annualSalary(46152.2).jobTitle("manager")
                .build();
        Employee employee3 = Employee.builder().name("Narayan").email("Narayan@gmail.com").annualSalary(46152.2).jobTitle("employee")
                .build();
        Employee employee4 = Employee.builder().name("Wallace").email("Wallace@gmail.com").annualSalary(32152.2)
                .build();
        Employee employee5 = Employee.builder().name("Wong").email("Wong@gmail.com").annualSalary(25025.3).jobTitle("employee")
                .build();
        Employee employee6 = Employee.builder().name("Niomi").email("Niomi@gmail.com").annualSalary(46152.2).jobTitle("manager")
                .build();
        Employee employee7 = Employee.builder().name("Willy").email("Willy@gmail.com").annualSalary(32152.2)
                .build();
        Employee employee8 = Employee.builder().name("Ahmad").email("Ahmad@gmail.com").annualSalary(25025.3).jobTitle("manager")
                .build();

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
        employeeRepository.save(employee5);
        employeeRepository.save(employee6);
        employeeRepository.save(employee7);
        employeeRepository.save(employee8);
        List<Employee> allEmployees = employeeRepository.findAll();
        Assertions.assertThat(allEmployees).hasSize((int) employeeRepository.count());
    }

    // test cases for deletingEmployeeByID
    @Test
    void deleteEmployeeNull() {
        Integer userId = 1;
        employeeRepository.deleteById(userId);
        Optional<Employee> employee = employeeRepository.findEmployeeById(userId);
        Assertions.assertThat(employee).isNotPresent();
    }
    @Test
    void deleteEmployee() {
        Employee employee1 = Employee.builder().name("Alex").email("alex.stevenson@gmail.com").annualSalary(25642.2).jobTitle("employee")
                .build();
        Employee employee2 = Employee.builder().name("Amanda").email("amanda@gmail.com").annualSalary(46152.2).jobTitle("manager")
                .build();
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        Integer userId = 2;
        employeeRepository.deleteById(userId);
        Optional<Employee> employee = employeeRepository.findEmployeeById(userId);
        Assertions.assertThat(employee).isNotPresent(); // need to change
    }

    // test cases for updateEmployeeName

    @Test
    void updateEmployeeNameNullUserID() {
        Integer userId = 1;
        if (employeeRepository.findEmployeeById(userId).isPresent()){
            Employee optionalEmployee = employeeRepository.findEmployeeById(userId).get();
            optionalEmployee.setName("John");
            employeeRepository.save(optionalEmployee);
            Employee updatedEmployee = employeeRepository.findEmployeeById(userId).get();
            Assertions.assertThat(updatedEmployee.getName()).isEqualTo("John");
        }
        else{
            System.out.println("Job ID doesn't exist");
        }
    }

    @Test
    void updateEmployeeName() {
        Employee employee1 = Employee.builder().name("Alex").id(1).email("alex.stevenson@gmail.com").annualSalary(25642.2).jobTitle("employee")
                .build();
        // add into database
        Employee employee2 = Employee.builder().name("Amanda").id(2).email("alex.son@gmail.com").annualSalary(24000.56).jobTitle("manager")
                .build();
        Employee employee3 = Employee.builder().name("Narayan").email("Narayan@gmail.com").annualSalary(46152.2).jobTitle("employee")
                .build();
        Employee employee4 = Employee.builder().name("Wallace").email("Wallace@gmail.com").annualSalary(32152.2)
                .build();
        Employee employee5 = Employee.builder().name("Wong").email("Wong@gmail.com").annualSalary(25025.3).jobTitle("employee")
                .build();
        Employee employee6 = Employee.builder().name("Niomi").email("Niomi@gmail.com").annualSalary(46152.2).jobTitle("manager")
                .build();
        Employee employee7 = Employee.builder().name("Willy").email("Willy@gmail.com").annualSalary(32152.2)
                .build();
        Employee employee8 = Employee.builder().name("Ahmad").email("Ahmad@gmail.com").annualSalary(25025.3).jobTitle("manager")
                .build();

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
        employeeRepository.save(employee5);
        employeeRepository.save(employee6);
        employeeRepository.save(employee7);
        employeeRepository.save(employee8);

        Integer userId = 8;
        Employee optionalEmployee = employeeRepository.findEmployeeById(userId).get();
        optionalEmployee.setName("John");
        employeeRepository.save(optionalEmployee);
        //check updated name
        Employee updatedEmployee = employeeRepository.findEmployeeById(userId).get();
        Assertions.assertThat(updatedEmployee.getName()).isEqualTo("John");
    }

    @Test
    void updateEmployeeNameNullName() {
        Employee employee = Employee.builder().email("alex.stevenson@gmail.com").id(123).annualSalary(12000.56).jobTitle("manager")
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        Integer userId = 1;
        if (employeeRepository.findEmployeeById(userId).isPresent()){
            Employee optionalEmployee = employeeRepository.findEmployeeById(userId).get();
            if (optionalEmployee.getName()!=null){
                optionalEmployee.setName("John");
                employeeRepository.save(optionalEmployee);
                Employee updatedEmployee = employeeRepository.findEmployeeById(userId).get();
                Assertions.assertThat(updatedEmployee.getName()).isEqualTo("John");
            }
            else{
                System.out.println("Name doesn't exist");
            }
        }
        else{
            System.out.println("Job ID doesn't exist");
        }
    }

}