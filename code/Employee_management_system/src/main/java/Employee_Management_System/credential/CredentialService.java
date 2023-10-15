package Employee_Management_System.credential;


import Employee_Management_System.Security.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CredentialService  {
    private final CredentialRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public Employee_Management_System.credential.AuthenticationResponse register(RegisterRequest request) {
        var user = Credential.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return Employee_Management_System.credential.AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public Employee_Management_System.credential.AuthenticationResponse authenticate(Employee_Management_System.credential.AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return Employee_Management_System.credential.AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

}
