package edu.ukd.cofeejava.conference.asistant.service;

import edu.ukd.cofeejava.conference.asistant.dto.Event;
import edu.ukd.cofeejava.conference.asistant.dto.Question;
import edu.ukd.cofeejava.conference.asistant.dto.Speaker;
import edu.ukd.cofeejava.conference.asistant.dto.Stream;
import edu.ukd.cofeejava.conference.asistant.dto.Topic;
import edu.ukd.cofeejava.conference.asistant.entity.EventEntity;
import edu.ukd.cofeejava.conference.asistant.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class MegaService {

    @Autowired
    private EventRepository eventRepository;



    public Event getEventById(long id) {
        EventEntity entity = eventRepository.findById(id).orElseThrow();
        return Event.fromEntity(entity);
    }

    public List<Event> getAllEvents() {

        List<Event> eventList = new ArrayList<>();

        for (EventEntity entity : eventRepository.findAll()) {
            eventList.add(Event.fromEntity(entity));
        }
        return eventList;
    }

    public void saveEvent(Event event) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(event.getId());
        eventEntity.setName(event.getName());
        eventEntity.setInfo(event.getInfo());
        eventEntity.setHost(event.getHost());
        eventRepository.save(eventEntity);

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

//    Stream Fixtures:
//      Lviv IT Rally
    public Stream getStreamById(long id) {
//    ToDo: Prepare fixtures when DTO is ready.
//        return new Topic(...);
        return null;
    }
    public Collection<Stream> getAllStreams() {
//    ToDo: Prepare fixtures when DTO is ready.
//        return STREAMS.values();
        return null;
    }


    public Collection<Question> getQuestionsByTopicId(long topicId) {
//    ToDo: Prepare fixtures when DTO is ready.
//        return new Topic(...);
        return null;
    }

}
