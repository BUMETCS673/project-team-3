package Employee_Management_System.springsescurity;

import Employee_Management_System.credential.entity.UserCredential;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class CustomUser extends User {


    private UserCredential credential;

    public CustomUser(UserCredential credential, Collection<? extends GrantedAuthority> authorities) {
        super(credential.getUsername(), credential.getPassword(), authorities);
        this.credential = credential;
    }

    public UserCredential getCredential() {
        return credential;
    }

    public void setCredential(UserCredential credential) {
        this.credential = credential;
    }
}
