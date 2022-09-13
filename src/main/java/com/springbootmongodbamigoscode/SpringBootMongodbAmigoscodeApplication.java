package com.springbootmongodbamigoscode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootMongodbAmigoscodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbAmigoscodeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			Address address = new Address(
					"USA",
					"New York",
					"55478956"
			);

			Student student =  new Student(
					"Peter",
					"Parker",
					"parker@email.com",
					Gender.MALE,
					address,
					List.of("Computer Science", "Mathematics"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

			repository.insert(student);
		};
	}
}
