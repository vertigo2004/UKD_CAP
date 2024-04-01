package edu.ukd.cofeejava.conference.asistant.dto;

import edu.ukd.cofeejava.conference.asistant.entity.EventEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Long id;
    private String name;
    private String info;
    private String host;

    public EventEntity toEntity() {
        return new EventEntity(this.id, this.name, this.info, this.host);
    }
}
