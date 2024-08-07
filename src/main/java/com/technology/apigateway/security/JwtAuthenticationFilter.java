package com.technology.apigateway.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Lấy jwt từ request
        String jwt = getJwt(request);

        if (jwt != null && tokenProvider.validateToken(jwt)) {
            // Lấy id user từ chuỗi jwt
            String userName = tokenProvider.getUserNameByToken(jwt);
            // Lấy thông tin người dùng từ id
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);
            if (userDetails != null) {
                // Nếu người dùng hợp lệ, set thông tin cho Seturity Context
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        

        filterChain.doFilter(request, response);
    }

    private String getJwt(HttpServletRequest request) {
        String tokenParam = request.getParameter("token");
        if (tokenParam != null) {
            return tokenParam;
        }
        String athHeader = request.getHeader("Authorization");
        if (athHeader != null && athHeader.startsWith("Bearer")) {
            return athHeader.replace("Bearer", "");
        }
        return null;
    }
}
