package com.intercorp.retail.ircliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.fabiomaffioletti.firebase.EnableFirebaseRepositories;

@EnableFirebaseRepositories
@SpringBootApplication
public class IrclienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrclienteApplication.class, args);
	}

}
