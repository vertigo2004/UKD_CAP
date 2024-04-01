package edu.ukd.cofeejava.conference.asistant.entity;

import edu.ukd.cofeejava.conference.asistant.dto.Stream;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
    private int conferenceID;

    public Stream toDto() {
        return new Stream(this.id, this.name, this.location, this.conferenceID);
    }

}
