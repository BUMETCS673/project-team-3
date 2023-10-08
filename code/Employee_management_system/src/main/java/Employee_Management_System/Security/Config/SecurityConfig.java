package Employee_Management_System.Security.Config;

import Employee_Management_System.credential.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import Employee_Management_System.Security.Filter.JwtAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    //private final LogoutHandler logoutHandler;


    //@Autowired
    //protected HandlerMappingIntrospector introspector;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .requestMatchers(
                        "/api/v1/auth/**",
                        "/index*",
                        "/static/**",
                        "/*.js",
                        "/*.json",
                        "/*.ico")

                .permitAll()
                //.requestMatchers( "/api/v1/auth/**").hasAnyRole(Role.USER.name())
                //.requestMatchers(POST, "/api/v1/auth/**").hasAnyAuthority(Role.USER.name())


                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/index.html")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/homepage.html", true)
                .failureUrl("/index.html?error=true")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                //.logout()
                //.logoutUrl("/api/v1/auth/logout")
                //.addLogoutHandler(logoutHandler)
                //.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
        ;

        return http.build();
    }
}
