package Employee_Management_System.credential;

import Employee_Management_System.spring_security.CustomUser;
import Employee_Management_System.spring_security.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 难道返回得不是一个credential？ 需要你们确定一下
        Optional<Credential> credential = credentialRepository.findByUsername(username);

        if(!credential.isPresent()) {
            throw new UsernameNotFoundException("user not exist");
        }

        // 第一个参数返回得是一个credential对象
        return new CustomUser(credential.get(), Collections.emptyList());
    }

}

