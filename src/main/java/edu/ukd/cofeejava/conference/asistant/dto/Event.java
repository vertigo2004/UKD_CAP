package edu.ukd.cofeejava.conference.asistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
    private Long id;
    private String name;
    private String info;
    private String host;
}
