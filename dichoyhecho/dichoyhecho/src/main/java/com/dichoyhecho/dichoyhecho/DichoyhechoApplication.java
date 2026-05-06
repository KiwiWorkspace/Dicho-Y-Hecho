package com.dichoyhecho.dichoyhecho;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DichoyhechoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DichoyhechoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("website working...");
	}
}
