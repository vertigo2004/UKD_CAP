package edu.ukd.cofeejava.conference.asistant.dto;

import edu.ukd.cofeejava.conference.asistant.entity.EventEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
    private Long id;
    private String name;
    private String info;
    private String host;

    public static Event fromEntity(EventEntity entity) {
        return new Event(entity.getId(), entity.getName(), entity.getInfo(), entity.getHost());
    }
}
