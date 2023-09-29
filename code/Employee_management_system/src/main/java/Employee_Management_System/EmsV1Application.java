
package Employee_Management_System;
import Employee_Management_System.credential.CredentialService;
import Employee_Management_System.credential.RegisterRequest;
import Employee_Management_System.credential.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmsV1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmsV1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			CredentialService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin1")
					.lastname("Admin1")
					.username("user1")
					.password("password")
					.role(Role.USER)
					.build();
			System.out.println("Admin1 token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Admin2")
					.lastname("Admin2")
					.username("user2")
					.password("password")
					.role(Role.ADMIN)
					.build();
			System.out.println("Manager1 token: " + service.register(manager).getAccessToken());

		};
	}

}
