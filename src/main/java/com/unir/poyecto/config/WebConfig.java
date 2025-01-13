package com.unir.poyecto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebSecurity
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:3000")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS").allowCredentials(true);
	}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((requests) -> requests.requestMatchers("/login", "/api/public/**").permitAll()
//				.anyRequest().authenticated()).formLogin((form) -> form.loginPage("/login").permitAll())
//				.logout((logout) -> logout.permitAll())
//				.sessionManagement((session) -> session.maximumSessions(1).maxSessionsPreventsLogin(true));
//
//		return http.build();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("password")).roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

//	@Autowired
//	private CustomUserDetailsService userDetailsService;
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.requestMatchers("/admin/**").hasRole("ADMIN")
//				.requestMatchers("/user/**").hasRole("USER").requestMatchers("/", "/home", "/login").permitAll()
//				.anyRequest().authenticated()).formLogin(formLogin -> formLogin.loginPage("/login").permitAll())
//				.logout(logout -> logout.permitAll());
//
//		return http.build();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}