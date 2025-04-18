package com.rubypaper.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

//~ 생략 ~
@Configuration
public class BoardAutoConfiguration {
	
	@Bean
	JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass("com.mysql.cj.jdbc.Drvier");
		manager.setUrl("jdbc:mysql://localhost:3306/musthave");
		manager.setUsername("musthave");
		manager.setPassword("napking");
		return manager;
	}

}