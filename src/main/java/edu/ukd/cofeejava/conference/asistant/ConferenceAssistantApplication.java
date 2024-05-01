package edu.ukd.cofeejava.conference.asistant;

import edu.ukd.cofeejava.conference.asistant.entity.EventEntity;
import edu.ukd.cofeejava.conference.asistant.entity.QuestionEntity;
import edu.ukd.cofeejava.conference.asistant.entity.StreamEntity;
import edu.ukd.cofeejava.conference.asistant.entity.TopicEntity;
import edu.ukd.cofeejava.conference.asistant.repository.EventRepository;
import edu.ukd.cofeejava.conference.asistant.repository.QuestionRepository;
import edu.ukd.cofeejava.conference.asistant.repository.StreamRepository;
import edu.ukd.cofeejava.conference.asistant.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
public class ConferenceAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceAssistantApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventRepository eventRepo,
								  StreamRepository streamRepo,
								  TopicRepository topicRepo,
								  QuestionRepository questionRepo) {
		return (args) -> {
			eventRepo.save(new EventEntity(
					1L,
					"DEVOXX UK",
					"The Developer Community Conference\n" +
							"8 - 10 May, 2024 | London\n" +
							"Join us in London for a global gathering of the developer community at Devoxx UK 2024. A diverse group of inspiring speakers from around the world will cover vital developer-focused topics and share the latest technology advances.",
					"DEVOXX UK IS ORGANISED BY DMJE LTD. REGISTERED OFFICE 52 HIGH STREET, PINNER, MIDDLESEX. HA5 5PW UNITED KINGDOM. COMPANY REGISTRATION NUMBER 08481796"));
			eventRepo.save(new EventEntity(2L,
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
			eventRepo.save(new EventEntity(3L,
					"\n" +
							"SPRING CONFERENCE Spring I/O 2024",
					"Join the Spring community from around the world.There is no better place to share, discuss, collaborate and socialise with other Spring professionals and enthusiasts.",
					"Contact info@springio.net / Twitter https://twitter.com/spring_io / YouTube https://www.youtube.com/@SpringIOConference /"));

			EventEntity savedEvent = eventRepo.save(new EventEntity(4L,
					"PM IT Rally",
					"МИ ОРГАНІЗОВУЄМО ПОДІЇ ДЛЯ РОЗВИТКУ ІТ-СЕРЕДОВИЩА.\u2028НАС ОБ'ЄДНУЄ ОДНА ЦІЛЬ – РІСТ ТА РОЗВИТОК ІТ-СФЕРИ.",
					"+380 93 746-30-73, info.itrally@gmail.com"));

			StreamEntity stream = new StreamEntity(1L, "Java Development", "Аудиторія 330/5", savedEvent);
			streamRepo.save(stream);

			stream = new StreamEntity(2L, "QA Automation", "Аудиторія 326", savedEvent);
			streamRepo.save(stream);

			stream = new StreamEntity(3L, "BigData/MachineLearning/AI", "Аудиторія 411", savedEvent);
			streamRepo.save(stream);

			stream = new StreamEntity(4L, "IT Management", "Актовий зал", savedEvent);
			streamRepo.save(stream);

			LocalDateTime start = LocalDateTime.of(2024, Calendar.MONTH, 5,10,15);
			LocalDateTime end = start.plusHours(1);

			//  Topic fixture:
//    PM IT Rally 2 березня
//10:00    ВІДКРИТТЯ ПОДІЇ
//10:15    ОКСАНА ДИМІНСЬКА    From Zero to Hero
//11:20    ОРЕСТ ДМИТРАСЕВИЧ    Еволюція проектного менеджменту
//12:20    ОБІД
//13:20    АННА ДУМА    Project vs. Product Management
//14:20    БЛАГОДІЙНИЙ АУКЦІОН
//14:45    ПАНЕЛЬНА ДИСКУСІЯ
//15:25    ЗАКРИТТЯ ЗАХОДУ

			QuestionEntity q1 = questionRepo.save(new QuestionEntity(1L, "question1", 5));
			QuestionEntity q2 = questionRepo.save(new QuestionEntity(2L, "question2", 0));
			QuestionEntity q3 = questionRepo.save(new QuestionEntity(3L, "question3", 3));
			List<QuestionEntity> questions = Arrays.asList(q1, q2, q3);

			TopicEntity t1 = new TopicEntity(1L, "ОКСАНА ДИМІНСЬКА", "From Zero to Hero", "From Zero to Hero Summary", start, end, questions);
			start = LocalDateTime.of(2024, Calendar.MONTH, 5,11,20);
			end = start.plusHours(1);
			TopicEntity t2 = new TopicEntity(2L, "ОРЕСТ ДМИТРАСЕВИЧ", "Еволюція проектного менеджменту", "Еволюція проектного менеджменту Summary", start, end, null);

			start = LocalDateTime.of(2024 ,Calendar.MONTH, 5,13,20);
			end = start.plusHours(1);
			TopicEntity t3 = new TopicEntity(3L, "АННА ДУМА", "Project vs. Product Management", "Project vs. Product Management Summary", start, end, null);
			topicRepo.saveAll(Arrays.asList(t1, t2, t3));

			TopicEntity topicEntity1 = topicRepo.findById(1L).get();
			System.out.println(topicEntity1);
		};
	}
}
