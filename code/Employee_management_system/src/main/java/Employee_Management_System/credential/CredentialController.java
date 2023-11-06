package Employee_Management_System.credential;

import Employee_Management_System.Security.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CredentialController {

    private final CredentialService service;
    private final JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }



    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {

        //RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/getrole")
        public ResponseEntity<String> getRole(
                @RequestBody AuthenticationRequest request
    ){
        String username = request.getUsername();
        Optional<Credential> credential = service.loadUserByUsername(username);

        return ResponseEntity.ok(credential.get().getRole().name());

    }

//    @PostMapping("/role")
//    public String getRole(@RequestBody String token){
//        String username = jwtService.extractUsername(token);
//        Optional<Credential> credential = service.loadUserByUsername(username);
//
//        return credential.get().getRole().name();
//
//    }

//    @GetMapping("/test")
//    public ResponseEntity<String> test(){
//        return ResponseEntity.ok("testing passed");
//    }

//    @PostMapping("/refresh-token")
//    public void refreshToken(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws IOException {
//        service.refreshToken(request, response);
//    }


}
