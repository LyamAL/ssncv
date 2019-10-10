package com.zaq.ssncv.ssncvprovideruser2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZAQ
 */
@MapperScan("com.zaq.ssncv.ssncvprovideruser2.mapper")
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
@Configuration
public class ProviderUser2Config {

}
