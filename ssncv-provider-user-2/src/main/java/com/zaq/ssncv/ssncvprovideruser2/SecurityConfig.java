package com.zaq.ssncv.ssncvprovideruser2;

import com.zaq.ssncv.ssncvprovideruser2.config.*;
import com.zaq.ssncv.ssncvprovideruser2.entity.AuthParameters;
import com.zaq.ssncv.ssncvprovideruser2.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ZAQ
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserServiceImpl userService;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter;
    @Autowired
    private CustomLogoutHandler customLogoutHandler;
    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;
    @Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Bean
    public SessionRegistry getSessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public AuthParameters getAuthParameters() {
        return new AuthParameters();
    }

    @Bean
    public JwtAuthenticationFilter getJwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public CustomLogoutHandler getCustomLogoutHandler() {
        return new CustomLogoutHandler();
    }

    @Bean
    public CustomLogoutSuccessHandler getCustomLogoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public JsonUsernamePasswordAuthenticationFilter getJsonUsernamePasswordAuthenticationFilter() throws Exception {
        JsonUsernamePasswordAuthenticationFilter filter = new JsonUsernamePasswordAuthenticationFilter();
        filter.setFilterProcessesUrl("/user/login");
        filter.setAuthenticationFailureHandler(getMyAuthenticationFailureHandler());
        filter.setAuthenticationSuccessHandler(getMyAuthenticationSuccessHandler());
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    @Bean
    public AuthenticationFailureHandler getMyAuthenticationFailureHandler() {
        return new MyAuthenticationFailureHandler();
    }

    @Bean
    public AuthenticationSuccessHandler getMyAuthenticationSuccessHandler() {
        return new MyAuthenticationSuccessHandler();
    }

    @Bean
    public JwtTokenProvider getJwtTokenProvider() {
        return new JwtTokenProvider();
    }

    @Bean
    public UnauthorizedEntryPoint getUnauthorizedEntryPoint() {
        return new UnauthorizedEntryPoint();
    }

    @Bean
    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(getbCryptPasswordEncoder());
//        provider.setPasswordEncoder(new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return (String) charSequence;
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return charSequence.toString().equals(s);
//            }
//        });
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(getJwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/user/login", "/user/add")
                .permitAll()
                .antMatchers("/user/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/user/login")
                .usernameParameter("phone")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .addLogoutHandler(customLogoutHandler)
                .and().exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint);

        http.addFilterAt(jsonUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }
}
