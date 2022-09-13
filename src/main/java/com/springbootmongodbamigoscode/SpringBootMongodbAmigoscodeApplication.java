package com.springbootmongodbamigoscode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootMongodbAmigoscodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbAmigoscodeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address(
					"USA",
					"New York",
					"55478956"
			);

			String email = "parker@email.com";

			Student student =  new Student(
					"Peter",
					"Parker",
					email,
					Gender.MALE,
					address,
					List.of("Computer Science", "Mathematics"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

			repository.findByEmail(email)
					.ifPresentOrElse(
							s -> System.out.println(s + " already exists"),
							() -> {
								System.out.println("Inserting student " + student);
								repository.insert(student);
							}
					);
		};
	}
}
