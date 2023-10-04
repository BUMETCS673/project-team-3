package Employee_Management_System.credential;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuthenticationRequest {
    private String username;
    String password;
}
