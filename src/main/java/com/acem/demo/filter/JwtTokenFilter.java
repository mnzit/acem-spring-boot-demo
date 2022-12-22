package com.acem.demo.filter;

import com.acem.demo.constant.SecurityConstant;
import com.acem.demo.exception.AuthenticationFailedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private SecretKeySpec secretKeySpec;

    public JwtTokenFilter(SecretKeySpec secretKeySpec) {
        this.secretKeySpec = secretKeySpec;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       String path = request.getRequestURI();
        if(!path.equals("/auth")){
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);

            if (token == null) {
                throw new AuthenticationFailedException();
            }

            if (token.trim().length() == 0) {
                throw new AuthenticationFailedException();
            }

            if (token.contains(SecurityConstant.BEARER)) {
                token = token.replace(SecurityConstant.BEARER, "").trim();
                try {
                    Jwt<JwsHeader, Claims> jwt = Jwts
                            .parserBuilder()
                            .setSigningKey(secretKeySpec)
                            .build()
                            .parse(token);

                    String email = (String) jwt
                            .getBody()
                            .get("email");

                    System.out.println(email);

                } catch (Exception exception) {
                    throw new AuthenticationFailedException();
                }
            } else {
                throw new AuthenticationFailedException();
            }


        }
        filterChain.doFilter(request,response);
    }
}
