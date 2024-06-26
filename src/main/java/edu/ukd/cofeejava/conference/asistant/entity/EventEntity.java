package edu.ukd.cofeejava.conference.asistant.entity;

import edu.ukd.cofeejava.conference.asistant.dto.Event;
import jakarta.persistence.Column;
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
public class EventEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(length = 1000)
    private String info;
    private String host;

    public Event toDto() {
        return new Event(this.id, this.name, this.info, this.host);
    }
}
