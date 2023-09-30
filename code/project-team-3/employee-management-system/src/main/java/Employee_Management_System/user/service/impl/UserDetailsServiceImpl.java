package Employee_Management_System.user.service.impl;


import Employee_Management_System.credential.entity.UserCredential;
import Employee_Management_System.credential.service.UserCredentialService;
import Employee_Management_System.springsescurity.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserCredentialService userCredentialService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserCredential user = userCredentialService.getUserByUserName(username);

        if(null == user) {
            throw new UsernameNotFoundException("User does not exist");
        }

//        // 查询权限信息
//        List<String> userPermsList = sysMenuService.findUserPermByUserId(sysUser.getId());
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (String perm : userPermsList) {
//            authorities.add(new SimpleGrantedAuthority(perm.trim()));
//        }

        return new CustomUser(user, Collections.emptyList());
    }

}
