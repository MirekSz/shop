package pl.altkom.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("pl.altkom.shop")
@EnableAspectJAutoProxy
@PropertySource(value = { "classpath:application.properties" }, ignoreResourceNotFound = true)
public class CoreConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer propertyReader() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
