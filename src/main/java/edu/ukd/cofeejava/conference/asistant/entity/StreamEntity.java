package edu.ukd.cofeejava.conference.asistant.entity;

import edu.ukd.cofeejava.conference.asistant.dto.Stream;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventEntity event;

    public Stream toDto() {
        return new Stream(this.id, this.name, this.location, this.event.toDto());
    }

}
