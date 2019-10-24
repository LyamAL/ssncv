package com.zaq.ssncv.ssncvapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author ZAQ
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Role implements GrantedAuthority {
    @JsonIgnore
    private int uid;

    private String authority;
}
