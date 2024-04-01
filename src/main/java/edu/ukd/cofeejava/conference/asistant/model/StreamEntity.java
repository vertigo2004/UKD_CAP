package edu.ukd.cofeejava.conference.asistant.model;

import edu.ukd.cofeejava.conference.asistant.dto.Stream;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Entity
@Data
public class StreamEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
    private int conferenceID;

    public Stream fromEntity() {
        return new Stream(this.id, this.name, this.location, this.conferenceID);
    }

}
