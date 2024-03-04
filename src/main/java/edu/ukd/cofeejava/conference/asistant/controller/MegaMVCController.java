package edu.ukd.cofeejava.conference.asistant.controller;

import edu.ukd.cofeejava.conference.asistant.service.MegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MegaMVCController {

    @Autowired
    private MegaService megaService;

    @GetMapping("/event/{id}")
    public String greeting(@PathVariable("id") final long id,
                           Model model
    ) {
        model.addAttribute("event", megaService.getEventById(id));
        return "event";
    }

    @GetMapping("/events")
    public String greeting(Model model) {
        model.addAttribute("events", megaService.getAllEvents());
        return "events";
    }





    @GetMapping("/stream/{id}")
    public String stream(@PathVariable("id") final long id,
                           Model model
    ) {
        model.addAttribute("stream", megaService.getStreamById(id));
        return "stream";
    }

    @GetMapping("/streams")
    public String stream(Model model) {
        model.addAttribute("streams", megaService.getAllStreams());
        return "streams";
    }
}
