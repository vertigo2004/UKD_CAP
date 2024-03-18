package edu.ukd.cofeejava.conference.asistant;

import edu.ukd.cofeejava.conference.asistant.entity.EventEntity;
import edu.ukd.cofeejava.conference.asistant.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConferenceAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceAssistantApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventRepository repository) {
		return (args) -> {
			repository.save(new EventEntity(
					1L,
					"DEVOXX UK",
					"The Developer Community Conference\n" +
							"8 - 10 May, 2024 | London\n" +
							"Join us in London for a global gathering of the developer community at Devoxx UK 2024. A diverse group of inspiring speakers from around the world will cover vital developer-focused topics and share the latest technology advances.",
					"DEVOXX UK IS ORGANISED BY DMJE LTD. REGISTERED OFFICE 52 HIGH STREET, PINNER, MIDDLESEX. HA5 5PW UNITED KINGDOM. COMPANY REGISTRATION NUMBER 08481796"));
			repository.save(new EventEntity(2L,
					"JAX 2024",
					"The Conference for Java,\n" +
							"Architecture and Software Innovation\n" +
							"April 22 – 26, 2024\n" +
							"Expo: April 23 – 25, 2024\n" +
							"Rheingoldhalle Mainz or Online",
					"Attendees & Registration\n" +
							"Customer Service\n" +
							"+49 (0)69 630089 0\n" +
							"customerservice@jax.de"));
			repository.save(new EventEntity(3L,
					"\n" +
							"SPRING CONFERENCE Spring I/O 2024",
					"Join the Spring community from around the world.There is no better place to share, discuss, collaborate and socialise with other Spring professionals and enthusiasts.",
					"Contact info@springio.net / Twitter https://twitter.com/spring_io / YouTube https://www.youtube.com/@SpringIOConference /"));

			repository.save(new EventEntity(4L,
					"PM IT Rally",
					"МИ ОРГАНІЗОВУЄМО ПОДІЇ ДЛЯ РОЗВИТКУ ІТ-СЕРЕДОВИЩА.\u2028НАС ОБ'ЄДНУЄ ОДНА ЦІЛЬ – РІСТ ТА РОЗВИТОК ІТ-СФЕРИ.",
					"+380 93 746-30-73, info.itrally@gmail.com"));
		};
	}
}
