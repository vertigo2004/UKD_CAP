package edu.ukd.cofeejava.conference.asistant.controller;

import edu.ukd.cofeejava.conference.asistant.dto.Event;
import edu.ukd.cofeejava.conference.asistant.dto.Stream;
import edu.ukd.cofeejava.conference.asistant.service.MegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
public class MegaMVCController {

    @Autowired
    private MegaService megaService;

    @GetMapping("/event/{id}")
    public String greeting(@PathVariable("id") final long id,
                           Model model) {
        model.addAttribute("event", megaService.getEventById(id));
        return "event";
    }

    @GetMapping("/events")
    public String greeting(Model model) {
        Map<Event, List<Stream>> eventsWithStreams = megaService.getEventsWithStreams();
        model.addAttribute("events", eventsWithStreams);

        return "events";
    }

    @GetMapping("/new_event")
    public String newEvent(Model model) {
        model.addAttribute("event", new Event());
        return "eventForm";
    }

    @PostMapping("/new_event")
    public String saveEvent(Event event) {
        megaService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/edit_event/{id}")
    public String editEvent(@PathVariable("id") final long id, Model model) {
        model.addAttribute("event", megaService.getEventById(id));
        return "eventForm";
    }


    @ExceptionHandler(NoSuchElementException.class)
    public String noSuchElement() {
        return "eventNotFound";
    }

    @GetMapping("/stream/{id}")
    public String getStream(@PathVariable("id") final long id, Model model) {
        model.addAttribute("stream", megaService.getStreamById(id));
        return "stream";
    }

    @GetMapping("/streams")
    public String getAllStreams(Model model) {
        model.addAttribute("streams", megaService.getAllStreams());

        return "streams";
    }

    @GetMapping("/delete_event/{id}")
    public String deleteEvent(@PathVariable("id") final long id) {
        megaService.deleteEvent(id);
        return "redirect:/events";
    }

    @GetMapping("/topic/{id}")
    public String topic(@PathVariable("id") final long id, Model model) {
        model.addAttribute("topic", megaService.getTopicById(id));
        return "topic";
    }

    @GetMapping("/topics")
    public String topic(Model model) {
        model.addAttribute("topics", megaService.getAllTopics());
        return "topics";
    }
}
