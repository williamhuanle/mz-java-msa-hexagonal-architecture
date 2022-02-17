package mz.co.kr.config;

import mz.co.kr.adapters.UserJpaAdapterImpl;
import mz.co.kr.auth.domain.services.UserServiceImpl;
import mz.co.kr.auth.ports.api.UserServicePort;
import mz.co.kr.auth.ports.spi.UserPersistencePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS;

    @Value("${mz-app.cors.allowedOrigins}")
    private String[] allowedOrigins;

    public WebMvcConfig() {
        MAX_AGE_SECS = 3600;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins(allowedOrigins)
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
        .allowedHeaders("*")
        .allowCredentials(true)
        .maxAge(MAX_AGE_SECS);
    }

    @Bean
    public UserPersistencePort userPersistence(){
        return new UserJpaAdapterImpl();
    }

    @Bean
    public UserServicePort employeeService(){
        return new UserServiceImpl(userPersistence());
    }
}
