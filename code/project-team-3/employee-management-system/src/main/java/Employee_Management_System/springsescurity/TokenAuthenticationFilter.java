package Employee_Management_System.springsescurity;

import Employee_Management_System.jwt.JwtHelper;
import Employee_Management_System.result.Result;
import Employee_Management_System.result.StatusCodeEnum;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        // 登录界面不需要验证
        if ("/admin/system/credential/login".equals(httpServletRequest.getRequestURI())) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getAuthentication(httpServletRequest);

        if (null != usernamePasswordAuthenticationToken) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            ResponseUtil.out(httpServletResponse, Result.build(null, StatusCodeEnum.PERMISSION));
        }

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest httpServletRequest) {

        // Whether or not the request header has a token
        String token = httpServletRequest.getHeader("token");
        if (!StringUtils.isEmpty(token)) {
            String username = JwtHelper.getUsername(token);
            if (!StringUtils.isEmpty(username)) {

                return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
            }
        }
        return null;
    }
}
