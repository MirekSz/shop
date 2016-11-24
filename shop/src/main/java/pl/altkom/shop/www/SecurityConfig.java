package pl.altkom.shop.www;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
// @EnableWebSecurity
@ImportResource("classpath:security.xml")
public class SecurityConfig {
}
