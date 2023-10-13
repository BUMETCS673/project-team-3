
package Employee_Management_System;
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

}
