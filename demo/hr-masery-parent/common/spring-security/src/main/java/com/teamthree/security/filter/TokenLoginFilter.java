package com.teamthree.security.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamthree.common.jwt.JwtHelper;
import com.teamthree.common.result.ResponseUtil;
import com.teamthree.common.result.Result;
import com.teamthree.common.result.StatusCodeEnum;
import com.teamthree.security.customcomponent.CustomUser;
import com.teamthree.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter{

    public TokenLoginFilter(AuthenticationManager authenticationManager){
        this.setAuthenticationManager(authenticationManager);
        this.setPostOnly(false);
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/admin/system/index/login","POST"));
    }

    // 登录认证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginVo loginVo = new ObjectMapper().readValue(request.getInputStream(), LoginVo.class);

            // 生成一个包含账号密码的认证信息
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());

            // AuthenticationManager校验这个认证信息，返回一个已认证的Authentication
            return this.getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // 成功登录
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        CustomUser user =(CustomUser) authResult.getPrincipal();
        String token = JwtHelper.createToken(user.getSysUser().getId(), user.getSysUser().getPassword());

        //保存权限数据
//        Collection<GrantedAuthority> userAuthorities = user.getAuthorities();

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
//        map.put("permissions",userAuthorities);
        ResponseUtil.out(response, Result.ok(map));
    }

    // 登陆失败
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        ResponseUtil.out(response,Result.build(null,StatusCodeEnum.DATA_ERROR));
    }
}
