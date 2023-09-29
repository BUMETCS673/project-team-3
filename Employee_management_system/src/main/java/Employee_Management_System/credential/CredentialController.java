package Employee_Management_System.credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @Autowired
    private CredentialRepository credentialRepository;


    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/create-account")
    public String showCreateAccountPage() {
        return "create-account";
    }

    @PostMapping("/login")
    public Credential handleLogin(@RequestParam String username, @RequestParam String password) {
        Optional<Credential> optionalCredential = credentialRepository.findByUsername(username);

        if(optionalCredential.isPresent()) {
            Credential credential = optionalCredential.get();
            if(password.equals(credential.getPasswordHash())) {
                return credential;
            }
        }
        return null;
    }

    @PostMapping("/create-account")
    public String handleCreateAccount(@ModelAttribute Credential credential) {
        credentialService.createAccount(credential);
        return "redirect:/auth/login";
    }

//    // CREATE: Create a new Credential
//    @PostMapping("/")
//    public String createCredential(@RequestBody Credential credential) {
//        credentialService.save(credential);
//        return "Credential Created Successfully";
//    }
//
//    // READ: Get a list of all Credentials
//    @GetMapping("/")
//    public List<Credential> getAllCredentials() {
//        return credentialService.findAll();
//    }
//
//    // READ: Get a single Credential by username
//    @GetMapping("/{username}")
//    public String getCredentialByUsername(@PathVariable String username) {
//        Optional<Credential> optionalCredential = credentialService.findByUsername(username);
//        return optionalCredential.map(Credential::getUsername).orElse("Username Not Found");
//    }
//
//    // UPDATE: Update an existing Credential by username
//    @PutMapping("/{username}")
//    public String updateCredential(@PathVariable String username, @RequestBody Credential updatedCredential) {
//        Optional<Credential> optionalCredential = credentialService.findByUsername(username);
//        if (optionalCredential.isPresent()) {
//            Credential existingCredential = optionalCredential.get();
//            existingCredential.setPassword(updatedCredential.getPassword()); // Assume Credential has a setPassword method
//            credentialService.save(existingCredential);
//            return "Credential Updated Successfully";
//        }
//        return "Username Not Found";
//    }
//
//    // DELETE: Delete an existing Credential by username
//    @DeleteMapping("/{username}")
//    public String deleteCredential(@PathVariable String username) {
//        Optional<Credential> optionalCredential = credentialService.findByUsername(username);
//        if (optionalCredential.isPresent()) {
//            credentialService.delete(optionalCredential.get());
//            return "Credential Deleted Successfully";
//        }
//        return "Username Not Found";
//    }
}
