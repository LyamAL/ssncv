package com.zaq.ssncv.ssncvprovideruser;

import com.zaq.ssncv.ssncvprovideruser.config.JsonUsernamePasswordAuthenticationFilter;
import com.zaq.ssncv.ssncvprovideruser.config.MyAuthenticationFailureHandler;
import com.zaq.ssncv.ssncvprovideruser.config.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ZAQ
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    @Autowired
    SessionRegistry sessionRegistry;
    @Autowired
    @Qualifier("userServiceImpl")
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter;

    @Bean
    public SessionRegistry getSessionRegistry() {
        return new SessionRegistryImpl();
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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/user/login", "/user/add")
                .permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/user/login")
                .usernameParameter("phone")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/user/logOut");

        http
                .sessionManagement()
                .maximumSessions(1)
                .sessionRegistry(getSessionRegistry());

        http.addFilterAt(jsonUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return (String) charSequence;
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }
        });
        return provider;
    }

    //    @Bean
//    public LocaleResolver localResolver() {
//        return new SessionLocaleResolver();
//    }
//
//    /**
//     * 检查所有请求的lang的查询参数
//     * return
//     */
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        return localeChangeInterceptor;
//    }

    @Bean
    public ServletListenerRegistrationBean httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
    }


}
