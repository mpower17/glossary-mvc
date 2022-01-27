package com.jpt.glossary;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.jpt.glossary.repository")
@EnableMongock
public class GlossaryWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlossaryWebApplication.class, args);
	}
}
