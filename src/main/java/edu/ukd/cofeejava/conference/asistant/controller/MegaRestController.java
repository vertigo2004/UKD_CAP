package edu.ukd.cofeejava.conference.asistant.controller;

import edu.ukd.cofeejava.conference.asistant.dto.Topic;
import edu.ukd.cofeejava.conference.asistant.service.MegaService;
import edu.ukd.cofeejava.conference.asistant.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/rest")
public class MegaRestController {

    @Autowired
    private MegaService megaService;


//    localhost:8080/event?id=123&name=value&name2=value2
    @GetMapping("/event")
//    Attribute mapping example using URL Request Parameters
    public Event getEvent(@RequestParam(name="id") long id) {

        return megaService.getEventById(id);
    }

    //    localhost:8080/event/123/qwe/1
    @GetMapping("/event/{id}")
//    Attribute mapping example using URL Path Variables
    public Event getEventFromPath(@PathVariable("id") final long id) {
        return megaService.getEventById(id);
    }

    @GetMapping("/events")
//    Attribute mapping example using URL Path Variables
    public Collection<Event> getAllEvents() {
        return megaService.getAllEvents();
    }


    @GetMapping("/topic/{id}")
    public Topic getTopicById(@PathVariable("id") final long id){
        return megaService.getTopicById(id);
    }

    @GetMapping("/topics")
    public Collection<Topic> getAllTopics() {
        return megaService.getAllTopics();
    }



}
