package com.zaq.ssncv.ssncvprovideruser;

import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * @author ZAQ
 */
//@EnableAuthorizationServer
//@Configuration
public class OAuthConfigurer extends AuthorizationServerConfigurerAdapter {
    //    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource(
                "keystore.jks"), "000000".toCharArray()).getKeyPair("ssncvclient");
        converter.setKeyPair(keyPair);
        return converter;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("ssoclient").secret("ssosecret").autoApprove(true)
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("openid");
    }
}
