package edu.ukd.cofeejava.conference.asistant.service;

import edu.ukd.cofeejava.conference.asistant.dto.Event;
import edu.ukd.cofeejava.conference.asistant.dto.Question;
import edu.ukd.cofeejava.conference.asistant.dto.Speaker;
import edu.ukd.cofeejava.conference.asistant.dto.Stream;
import edu.ukd.cofeejava.conference.asistant.dto.Topic;
import edu.ukd.cofeejava.conference.asistant.entity.EventEntity;
import edu.ukd.cofeejava.conference.asistant.repository.EventRepository;
import edu.ukd.cofeejava.conference.asistant.entity.StreamEntity;
import edu.ukd.cofeejava.conference.asistant.repository.StreamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Slf4j
public class MegaService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private StreamRepository streamRepository;

    public Event getEventById(long id) {
        return eventRepository.findById(id).orElseThrow().toDto();
    }

    public List<Event> getAllEvents() {

        List<Event> eventList = new ArrayList<>();

        for (EventEntity entity : eventRepository.findAll()) {
            eventList.add(entity.toDto());
        }
        return eventList;
    }

    public Map<Event, List<Stream>> getEventsWithStreams() {
        Map<Event, List<Stream>> resultMap = new HashMap<>();
        for (EventEntity event : eventRepository.findAll()) {
            List<Stream> result = new ArrayList<>();
            for (StreamEntity stream : streamRepository.findByEvent(event)) {
                result.add(stream.toDto());
            }
            resultMap.put(event.toDto(), result);
        }

        return resultMap;
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




private static final Map<Long, Topic> TOPICS = new HashMap<>() {

        Calendar c1 = new GregorianCalendar(2024 ,Calendar.MONTH, 5,8,24,123);
        Calendar c2 = new GregorianCalendar(2024 ,Calendar.MONTH, 5,8,24,123);
        Date ScheduleStart = c1.getTime();
        Date ScheduleEnd = c2.getTime();
    {
        put(1L, new Topic(1L,"Іван","name","text", ScheduleStart, ScheduleEnd));

        put(2L, new Topic(2L,"Іван","name","text", ScheduleStart, ScheduleEnd));

        put(3L, new Topic(3L,"Іван","name","text", ScheduleStart, ScheduleEnd));

        put(0L, new Topic(0L,"Іван","name","text", ScheduleStart, ScheduleEnd));
    }
    };

    public Topic getTopicById(long id) {
        return TOPICS.getOrDefault(id,TOPICS.get(0L));
    }
    public Collection<Topic> getAllTopics() {
        return TOPICS.values();
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
    return streamRepository.findById(id).orElseThrow().toDto();
    }

    public List<Stream> getAllStreams() {
        List<Stream> result = new ArrayList<>();
        for (StreamEntity streamEntity : streamRepository.findAll()) {
            result.add(streamEntity.toDto());
        }
        return result;
    }

    public Collection<Question> getQuestionsByTopicId(long topicId) {
//    ToDo: Prepare fixtures when DTO is ready.
//        return new Topic(...);
        return null;
    }

    public void deleteEvent(long id) {
        log.info("Delete {}", id);
        eventRepository.deleteById(id);
    }
}
