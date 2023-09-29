package Employee_Management_System.credential;

import Employee_Management_System.result.Result;
import Employee_Management_System.tools.JwtHelper;
import Employee_Management_System.tools.MD5;
import exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    public Credential createAccount(Credential credential) {
        // Hash the password and save the credential
        //String hashedPassword = password;

        String encryptPwd = MD5.encrypt(credential.getPasswordHash());
        credential.setPasswordHash(encryptPwd);
        return credentialRepository.save(credential);
    }

    public Result login(String username, String password) {
        Optional<Credential> optionalCredential = credentialRepository.findByUsername(username);

        if(!optionalCredential.isPresent()) {
            throw new CustomException(200,"user not exist");
        }

        String encryptPwd_login = MD5.encrypt(password);
        String password_dt = optionalCredential.get().getPasswordHash();

        if(!encryptPwd_login.equals(password_dt)) {
            throw new CustomException(201,"Incorrect password");
        }

        String token = JwtHelper.createToken(optionalCredential.get().getEmployeeId(), optionalCredential.get().getUsername());


        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        return Result.ok(map);
    }

//    // READ
//    public Credential getCredential(String username) {
//        return credentialRepository.findById(username)
//                .orElseThrow(() -> new ResourceNotFoundException("Credential", "username", username));
//    }
//
//    // UPDATE
//    public Credential updateCredential(String username, Credential credentialDetails) {
//        Credential credential = getCredential(username); // or use findById(username).orElseThrow(...)
//        // Set fields that need to be updated
//        credential.setPasswordHash(credentialDetails.getPasswordHash());
//        return credentialRepository.save(credential);
//    }
//
//    // DELETE
//    public void deleteCredential(String username) {
//        Credential credential = getCredential(username); // or use findById(username).orElseThrow(...)
//        credentialRepository.delete(credential);
//    }
//
//    // READ ALL
//    public List<Credential> getAllCredentials() {
//        return credentialRepository.findAll();
//    }
//
//    public Credential saveCredential(Credential credential) {
//        return credentialRepository.save(credential);
//    }
//
//    public Optional<Credential> findCredentialById(String id) {
//        return credentialRepository.findById(id);
//    }
//
//    public void deleteCredential(Credential credential) {
//        credentialRepository.delete(credential);
//    }
}

