package edu.ukd.cofeejava.conference.asistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {

    private long id;
    private Topic topicId;
    private int likes;
    private int guest;
}
