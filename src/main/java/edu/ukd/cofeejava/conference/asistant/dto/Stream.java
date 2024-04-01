package edu.ukd.cofeejava.conference.asistant.dto;

import edu.ukd.cofeejava.conference.asistant.entity.StreamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stream {

    private Long id;
    private String name;
    private String location;
    private int conferenceID;

    public StreamEntity toEntity() {
        return new StreamEntity(this.id, this.name, this.location, this.conferenceID);
    }
}
