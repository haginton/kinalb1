package com.postgre.sql.security.jwt;

import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.sql.User;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;

@Component
public class OperationJwtImpl implements OperationJwt{

    @Value("${security.jwt.secret.key}")
    private String secretKey;

    @Override
    public String generateToken(UserRepositoryDto user, Calendar calendar) {
        return Jwts.builder()
                .subject(String.valueOf(user.getIdUser()))
                .claim("User", user.getUsername())
                .issuedAt(new Date())
                .expiration(calendar.getTime())
                .signWith(generateKey(), Jwts.SIG.HS256)
                .compact()
                ;

    }

    private SecretKey generateKey(){
        byte[] passwordDecoded = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(passwordDecoded);
    }
}
