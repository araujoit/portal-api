package br.com.araujoit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${spring.security.user.name}")
	private String securityUsername;
	
	@Value("${spring.security.user.password}")
	private String securityPassword;

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.csrf().disable() // desabilita o Cross-Site Request Forgery
				.authorizeHttpRequests().anyRequest().authenticated() // habilita todas as requisições, desde que sejam
																		// autenticadas...
				.and().httpBasic(); // ...e estejam com basic authentication
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication() // autenticação em memória
		.withUser(securityUsername).password("{noop}" + securityPassword) // com usuário e senha
		.roles("USER");
	}
}
