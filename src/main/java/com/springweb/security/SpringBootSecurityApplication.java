package com.springweb.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityApplication {

	public static void main(String[] args) {
		//BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
	    //El String que mandamos al metodo encode es el password que queremos encriptar.
		//System.out.println(bCryptPasswordEncoder.encode("1234"));	    
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

}
