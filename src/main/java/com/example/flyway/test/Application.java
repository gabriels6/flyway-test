package com.example.flyway.test;

import org.flywaydb.core.Flyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext App = SpringApplication.run(Application.class, args);
		
		String url = "jdbc:postgresql://localhost:5432/Test";
		String user = "postgres";
		String password = "root1374";
		
		Flyway flyway = Flyway
				.configure()
				.dataSource(url,user,password)
				.load();
		
		flyway.clean();
		
		flyway.migrate();
		flyway.info();
	}

}
