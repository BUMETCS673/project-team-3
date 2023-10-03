package Employee_Management_System.credential;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "credential")
public class Credential {

    @Id
    private String username;
    @Column(name = "password_hash")
    private String passwordHash;

    public Credential(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Credential() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

//    public Integer getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(Integer employeeId) {
//        this.employeeId = employeeId;
//    }

    @Override
    public String toString() {
        return "Credential{" +
                "username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
//                ", employeeId=" + employeeId +
                '}';
    }
}
