package com.technology.apigateway.security;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.technology.apigateway.controller.response.LoginResponse;
import com.technology.apigateway.exception.BusinessException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JwtTokenProvider {

    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private final String JWT_SECRET = "crm_security";

    // Thời gian có hiệu lực của chuỗi jwt
    private final long JWT_EXPIRATION = 3600000L;

    // Tạo ra jwt từ thông tin user
    public LoginResponse generateToken(CustomUserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(expiryDate);

        System.out.println(s);

        LoginResponse res = new LoginResponse(Jwts.builder()
                .setSubject(userDetails.getUser().getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact(), "Bearer", userDetails.getUser().getTimeExpired());
        return res;

        // Jwts.builder()
        // .setSubject(userDetails.getUser().getUsername())
        // .setIssuedAt(now)
        // .setExpiration(expiryDate)
        // .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
        // .compact();
    }

    // Lấy thông tin user từ jwt
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public String getUserNameByToken(String token) {
        String userName = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
        return userName;
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException e) {
            throw new BusinessException("01", "Expire Jwt token");
        } catch (UnsupportedJwtException e) {
            throw new BusinessException("01", "Unsupported Jwt token");
        } catch (MalformedJwtException e) {
            throw new BusinessException("01", "Invalid format token");
        } catch (SignatureException e) {
            throw new BusinessException("01", "Invalid Jwt signature");
        } catch (IllegalArgumentException e) {
            System.out.println("EMPTY");
            throw new BusinessException("01", "jwt claims String is empty");
        }
    }
}
