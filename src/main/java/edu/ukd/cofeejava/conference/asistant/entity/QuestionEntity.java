package edu.ukd.cofeejava.conference.asistant.entity;

import edu.ukd.cofeejava.conference.asistant.dto.Question;
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
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(length = 1000)
    private String text;
    private int likes;
//    private TopicEntity topic;

    public Question toDto() {
        return new Question(id, text, likes);
    }
}
