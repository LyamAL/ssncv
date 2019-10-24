package com.zaq.ssncv.ssncvprovideruser.config;

import com.zaq.ssncv.ssncvprovideruser.entity.AuthParameters;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ZAQ
 */
@Component
public class JwtTokenProvider implements TokenManager {
    @Autowired
    AuthParameters authParameters;
    private Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Override
    public String createNewToken(Authentication authentication) {
        //user name (对应的user.id)
        String username =
                ((org.springframework.security.core.userdetails.UserDetails)
                        authentication.getPrincipal()).getUsername();
        //expire time
        Date expireTime = new Date(System.currentTimeMillis() +
                authParameters.getTokenExpiredMs());
        //create token
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expireTime)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, authParameters.getJwtTokenSecret())
                .compact();
    }

    /**
     * validate token eligible.
     * if Jwts can parse the token string and no throw any exception,
     * then the token is eligible.
     *
     * @param token a jws string.
     * @return
     */
    @Override
    public boolean validateToken(String token) {
        String validateFailed = "validate failed : ";
        try {
            Jwts
                    .parser().
                    //密匙
                            setSigningKey(authParameters.getJwtTokenSecret())
                    .parseClaimsJws(token);
            return true;

        } catch (Exception ex) {
            //ExpiredJwtException
            //UnsupportedJwtException
            //MalformedJwtException
            //SignatureException
            //IllegalArgumentException
            logger.error(validateFailed + ex.getMessage());
            return false;
        }
    }


}
