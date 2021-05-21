package castisvn.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;

import castisvn.repository.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter{	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(userDetailsService());
		return authenticationProvider;
	}
	
	@Bean
	public BasicAuthenticationEntryPoint basicAuth() {
		BasicAuthenticationEntryPoint basicAuthentication = new BasicAuthenticationEntryPoint();
		basicAuthentication.setRealmName("Monkey3110");
		System.out.println("Using BasicAuthenticationEntryPoint");
		return basicAuthentication;
	}
	
	@Bean DigestAuthenticationEntryPoint digestAuth() {
		DigestAuthenticationEntryPoint digest = new DigestAuthenticationEntryPoint();
		digest.setRealmName("Monkey3110");
		digest.setKey("Khoa_cua_tao");
		System.out.println("Using DigestAuthenticationEntryPoint");
		return digest;
	}
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
		auth.authenticationProvider(authenticationProvider());
	}
	
    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring()            
      .antMatchers("/public/**");
    }

    //auto-configuration for security
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
////		You should not call super.configure(http) since you want to use a custom security configuration
////		super.configure(http); 
//		http.authorizeRequests()		
//		.antMatchers("/admin/**").hasAuthority("ADMIN")
//		.antMatchers("/staff/**").hasAuthority("USER")
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()		
//		.usernameParameter("username_hoac_email")
//		.passwordParameter("mat_khau_nguoi_dung")
//		.loginProcessingUrl("/doLogin")
//		.defaultSuccessUrl("/")
//		.failureUrl("/error/access-denied")
//		.permitAll()
//		.and()
//		.logout()
//		.permitAll()
//		.and().httpBasic().authenticationEntryPoint(digestAuth());
//	}
	
    
    //custom-configuration for security
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		You should not call super.configure(http) since you want to use a custom security configuration
//		super.configure(http); 
		http
		.authorizeRequests()		
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		.antMatchers("/staff/**").hasAuthority("USER")		
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login-system")
		.usernameParameter("username_hoac_email")
		.passwordParameter("mat_khau_nguoi_dung")
		.loginProcessingUrl("/doLogin")
		.defaultSuccessUrl("/")
		.failureUrl("/login-failed")
		.permitAll()		
		.and()
		.logout()		
		.logoutSuccessUrl("/login-system")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error/access-denied")
		.and().httpBasic().authenticationEntryPoint(digestAuth());
	}
}
