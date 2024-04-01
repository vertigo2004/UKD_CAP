package edu.ukd.cofeejava.conference.asistant.service;

import edu.ukd.cofeejava.conference.asistant.dto.Event;
import edu.ukd.cofeejava.conference.asistant.dto.Question;
import edu.ukd.cofeejava.conference.asistant.dto.Speaker;
import edu.ukd.cofeejava.conference.asistant.dto.Stream;
import edu.ukd.cofeejava.conference.asistant.dto.Topic;
import edu.ukd.cofeejava.conference.asistant.model.StreamEntity;
import edu.ukd.cofeejava.conference.asistant.repo.StreamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class MegaService {

    @Autowired
    private StreamRepo streamRepo;
    private static final Map<Long, Event> EVENTS = new HashMap<>() {{
        put(1L, new Event(
                1L,
                "DEVOXX UK",
                "The Developer Community Conference\n" +
                    "8 - 10 May, 2024 | London\n" +
                    "Join us in London for a global gathering of the developer community at Devoxx UK 2024. A diverse group of inspiring speakers from around the world will cover vital developer-focused topics and share the latest technology advances.",
                "DEVOXX UK IS ORGANISED BY DMJE LTD. REGISTERED OFFICE 52 HIGH STREET, PINNER, MIDDLESEX. HA5 5PW UNITED KINGDOM. COMPANY REGISTRATION NUMBER 08481796"));
        put(2L, new Event(
                2L,
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
        put(3L, new Event(
                3L,
                "\n" +
                    "SPRING CONFERENCE Spring I/O 2024",
                "Join the Spring community from around the world.There is no better place to share, discuss, collaborate and socialise with other Spring professionals and enthusiasts.",
                "Contact info@springio.net / Twitter https://twitter.com/spring_io / YouTube https://www.youtube.com/@SpringIOConference /"));
        put(0L,  new Event(
                0L,
                "PM IT Rally",
                "МИ ОРГАНІЗОВУЄМО ПОДІЇ ДЛЯ РОЗВИТКУ ІТ-СЕРЕДОВИЩА.\u2028НАС ОБ'ЄДНУЄ ОДНА ЦІЛЬ – РІСТ ТА РОЗВИТОК ІТ-СФЕРИ.",
                "+380 93 746-30-73, info.itrally@gmail.com"));
    }};

    public Event getEventById(long id) {
        return EVENTS.getOrDefault(id, EVENTS.get(0L));
    }
    public Collection<Event> getAllEvents() {
        return EVENTS.values();
    }

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
    public Topic getTopicById(long id) {
//    ToDo: Prepare fixtures when DTO is ready.
//        return new Topic(...);
        return null;
    }
    public Collection<Topic> getAllTopics() {
//    ToDo: Prepare fixtures when DTO is ready.
//        return TOPICS.values();
        return null;
    }

//      Speaker Fixtures:
//    ОКСАНА ДИМІНСЬКА
//    VP of Client Success at SoftServe
//    ОРЕСТ ДМИТРАСЕВИЧ
//    Засновник платформи Kaizen Hub
//    АННА ДУМА
//    Senior PM at SDP
    public Speaker getSpeakerById(long id) {
//    ToDo: Prepare fixtures when DTO is ready.
//        return new Topic(...);
        return null;
    }
    public Collection<Speaker> getAllSpeakers() {
//    ToDo: Prepare fixtures when DTO is ready.
//        return SPEAKERS.values();
        return null;
    }

    public Stream getStreamById(long id) {
 //   return STREAMS.getOrDefault(id, STREAMS.get(0L));
    return streamRepo.findById(id).orElseThrow().fromEntity();
    }

    public List<Stream> getAllStreams() {
        List<Stream> result = new ArrayList<>();
        Iterator<StreamEntity> iterator = streamRepo.findAll().iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next().fromEntity());
        }
        return result;
    }

    public Collection<Question> getQuestionsByTopicId(long topicId) {
//    ToDo: Prepare fixtures when DTO is ready.
//        return new Topic(...);
        return null;
    }

}
