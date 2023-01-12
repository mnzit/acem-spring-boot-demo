package com.acem.demo.filter;

import com.acem.demo.constant.SecurityConstant;
import com.acem.demo.exception.AuthenticationFailedException;
import com.acem.demo.exception.InvalidJwtException;
import com.acem.demo.exception.JwtExpiredException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
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
    private UserDetailsService userDetailsService;

    public JwtTokenFilter(SecretKeySpec secretKeySpec, UserDetailsService userDetailsService) {
        this.secretKeySpec = secretKeySpec;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();
        if (!path.equals("/auth")) {
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

                    UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                    System.out.println(userDetails);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                } catch (ExpiredJwtException exception) {
                    throw new JwtExpiredException();
                } catch (MalformedJwtException | SignatureException | IllegalArgumentException exception) {
                    throw new InvalidJwtException();
                } catch (Exception exception) {
                    throw new AuthenticationFailedException();
                }
            } else {
                throw new AuthenticationFailedException();
            }
        }
        filterChain.doFilter(request, response);
    }
}
