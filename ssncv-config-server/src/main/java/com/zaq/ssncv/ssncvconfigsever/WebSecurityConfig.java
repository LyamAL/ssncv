package com.zaq.ssncv.ssncvconfigsever;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author ZAQ
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("AL").password("{bcrypt}$2a$10$gix/mQjnFGzdvhpcGIgDh.pmiQaPkMrLrUsho9hrw8n7WfVwxSuuu").roles("USER").build());
        return manager;
    }
}
