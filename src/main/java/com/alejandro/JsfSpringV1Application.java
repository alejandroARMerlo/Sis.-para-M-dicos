package com.alejandro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class JsfSpringV1Application {

	public static void main(String[] args) {
		SpringApplication.run(JsfSpringV1Application.class, args);
                
              /*  String contra= "456";
		
		System.out.println("Contra : " + contra);
		
		System.out.println("ENCRIPTADO: " + crearContra(contra) ); */             
                
	}
        
       /* public static String crearContra(String password) {
		 
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		    
		return encoder.encode(password);	
		
	}*/
        

}
