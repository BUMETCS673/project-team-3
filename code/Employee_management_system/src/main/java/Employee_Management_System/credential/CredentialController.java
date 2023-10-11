package Employee_Management_System.credential;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CredentialController {

    private final CredentialService service;

    @PostMapping("/signup")
    public ResponseEntity<Employee_Management_System.credential.AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }


    @PostMapping("/signin")
    public ResponseEntity<Employee_Management_System.credential.AuthenticationResponse> authenticate(
            @RequestBody Employee_Management_System.credential.AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

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
