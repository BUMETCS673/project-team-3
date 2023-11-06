package Employee_Management_System.Security.Config;

import Employee_Management_System.credential.Credential;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    SimpleUrlAuthenticationSuccessHandler staffSuccessHandler = new SimpleUrlAuthenticationSuccessHandler("/staff");
    SimpleUrlAuthenticationSuccessHandler adminSuccessHandler = new SimpleUrlAuthenticationSuccessHandler("/admin/allemployee");
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority:authorities) {
            String authorityName = grantedAuthority.getAuthority();
            if(authorityName.equals("ROLE_ADMIN")){
                this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                return;
            }
            this.staffSuccessHandler.onAuthenticationSuccess(request, response,authentication);
        }


    }

    }

