package edu.ukd.cofeejava.conference.asistant.entity;

import edu.ukd.cofeejava.conference.asistant.dto.Question;
import edu.ukd.cofeejava.conference.asistant.dto.Topic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 500)
    private String speaker;
    @Column(length = 1000)
    private String title;
    @Column(length = 1000)
    private String summary;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime scheduleStart;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime scheduleEnd;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "topic_id")
    private List<QuestionEntity> questions;

    public Topic toDto() {
        List<Question> questions = this.questions.stream().map(QuestionEntity::toDto).collect(Collectors.toList());
        return new Topic(this.id, this.speaker, this.title, this.summary, scheduleStart, scheduleEnd, questions);
    }
}
