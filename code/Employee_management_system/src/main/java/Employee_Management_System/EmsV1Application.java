
package Employee_Management_System;
import Employee_Management_System.credential.AuthenticationRequest;
import Employee_Management_System.credential.CredentialService;
import Employee_Management_System.credential.RegisterRequest;
import Employee_Management_System.credential.Role;
import Employee_Management_System.user.Employee;
import Employee_Management_System.user.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EmsV1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmsV1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			CredentialService service,
			EmployeeRepository employeeRepo

	) {
		return args -> {

			//STAFF ROLE - Jack
			var admin = RegisterRequest.builder()
					.firstname("jack")
					.lastname("staff")
					.username("user1")
					.password("password")
					.role(Role.STAFF)
					.build();
			System.out.println("staff token: " + service.register(admin).getAccessToken());

			//ADMIN ROLE - JOHN
			var manager = RegisterRequest.builder()
					.firstname("john")
					.lastname("admin")
					.username("user2")
					.password("password")
					.role(Role.ADMIN)
					.build();
			System.out.println("Manager1 token: " + service.register(manager).getAccessToken());

			AuthenticationRequest request = new AuthenticationRequest("user2", "password");
			System.out.println("request made..............");
			service.authenticate(request);

			//EMPLOYEE INFORMATION
			var employee1 = Employee.builder()
					.name("john")
					.jobTitle("teacher")
					.email("testmail")
					.annualSalary(50000.00)
					.phoneNumber("708569856")
					.build();

			var employee2 = Employee.builder()
					.name("jack")
					.jobTitle("bus driver")
					.email("testmail2")
					.annualSalary(60000.00)
					.phoneNumber("55555555")
					.build();

			var employee3 = Employee.builder()
					.name("joe")
					.jobTitle("firefighter")
					.email("testmail3")
					.annualSalary(70000.00)
					.phoneNumber("888888888")
					.build();



			employeeRepo.saveAll(List.of(employee1, employee2, employee3));

		};
	}

}
