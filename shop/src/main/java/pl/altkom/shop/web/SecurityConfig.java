package pl.altkom.shop.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:security.xml")
public class SecurityConfig {
	// extends WebSecurityConfigurerAdapter {

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().antMatchers("/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')").and()
	// .formLogin().permitAll().and().exceptionHandling().accessDeniedPage("/?status=access-denied").and()
	// .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	// .logoutSuccessUrl("/?status=logout");
	//
	// }
	//
	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	// auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	// auth.inMemoryAuthentication().withUser("rest").password("rest").roles("REST");
	// }
}
