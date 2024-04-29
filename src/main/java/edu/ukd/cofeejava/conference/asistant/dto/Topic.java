package edu.ukd.cofeejava.conference.asistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Topic {
    private Long id;
    private String speaker;
    private String title;
    private String summary;
    private Date scheduleStart;
    private Date scheduleEnd;
    private List<Question> questions;

}