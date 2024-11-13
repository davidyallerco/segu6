package net.pe.yallerco.segu6.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityBeansInjector {

	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;//es proveida por spring security
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		
		return authenticationConfiguration.getAuthenticationManager();
		
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authenticationStrategy = new DaoAuthenticationProvider();
		authenticationStrategy.setPasswordEncoder(passwordEncoder());
		authenticationStrategy.setUserDetailsService(null);
		
		return authenticationStrategy;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
//		return new UserDetailsService() {
//			
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
		return (username) -> {
			return userRepository, findByUsername(username)
					.orElseThrow(() -> new Object));
		};
	}
}
