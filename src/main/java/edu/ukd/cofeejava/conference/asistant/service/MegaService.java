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
import edu.ukd.cofeejava.conference.asistant.repository.TopicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class MegaService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private StreamRepository streamRepository;

    @Autowired
    private TopicRepository topicRepository;

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

    public Topic getTopicById(long id) {
        return topicRepository.findById(id).orElseThrow().toDto();
    }
    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topicEntity -> topics.add(topicEntity.toDto()));
        return topics;
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
