package edu.ukd.cofeejava.conference.asistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Topic {
    private Long id;
    private String speaker;
    private String title;
    private String summary;
    private LocalDateTime scheduleStart;
    private LocalDateTime scheduleEnd;
    private List<Question> questions;

}