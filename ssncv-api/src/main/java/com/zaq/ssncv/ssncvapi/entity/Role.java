package com.zaq.ssncv.ssncvapi.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author ZAQ
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role implements GrantedAuthority {
    private int uid;
    private Authority authority;

    @Override
    public String getAuthority() {
        return authority.toString();
    }
}
