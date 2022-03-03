package com.alejandro;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
 	private UserDetailsService detallesDeUsuarioService;
	
	
	@Bean
	public BCryptPasswordEncoder passwordUsuario() {
		
		BCryptPasswordEncoder contrasenaCodificada= new BCryptPasswordEncoder();
		
		return contrasenaCodificada;		
    }
	
	//sirve para agregar mas usuarios y personalizar usuarios que vamos a utilizar para hacer login
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(detallesDeUsuarioService).passwordEncoder(passwordUsuario());
                
                /*auth.inMemoryAuthentication()
                .withUser("admin")
                    .password("{noop}123")
                    .roles("ADMIN","USER")
                .and()
                .withUser("user")
                    .password("{noop}123")
                    .roles("USER")
                ;*/
                
	}     
	
     // metodo que obliga a que cualquier peticion que entra debe estar autenticada
	// restringe las urls segun el rol de cada usuario
	protected void configure(HttpSecurity http) throws Exception{			
		
		http.authorizeRequests().antMatchers("/javax.faces.resource/**","/index.xhtml")
                        .permitAll().antMatchers("/fallo.xhtml").hasRole("USER").anyRequest().authenticated();
                        
                //http.authorizeRequests().antMatchers("/javax.faces.resource/**", "/index.xhtml").permitAll();
                        
               
    
// login
    http.formLogin().loginPage("/login.xhtml").defaultSuccessUrl("/paginaInicio.xhtml", true).permitAll()
        .failureUrl("/login.xhtml?error=true");
    // logout
    http.logout().logoutSuccessUrl("/login.xhtml").logoutSuccessUrl("/index.xhtml");
    // not needed as JSF 2.2 is implicitly protected against CSRF
    http.csrf().disable();	         		            
				
	}	
	
	
}
