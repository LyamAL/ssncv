package com.zaq.ssncv.ssncvprovideruser2.config;

import org.springframework.security.core.Authentication;

/**
 * @author ZAQ
 */
public interface TokenManager {
    /**
     * Creates a new token for the user and returns its {@link String}.
     * It may add it to the token list or replace the previous one for the user
     * Never returns {@code null}.
     */
    String createNewToken(Authentication authentication);

    /** Returns user details for a token. */
//    UserDetails getUserDetails(String token);

    /**
     * Returns user details for a username.
     */
//    UserDetails getUserDetailsByUsername(String username);

    boolean validateToken(String token);

}
