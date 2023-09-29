package Employee_Management_System.spring_security;

import Employee_Management_System.credential.Credential;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
public class Custom User extends User {


    private Credential credential;

    public CustomUser(Credential credential, Collection<? extends GrantedAuthority> authorities) {
        super(credential.getUsername(), credential.getPasswordHash(), authorities);
        this.credential = credential;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}
