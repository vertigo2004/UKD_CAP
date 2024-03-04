package edu.ukd.cofeejava.conference.asistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Topic {
    private Long id;
    private String Speaker;
    private String Title;
    private String Summary;
//    private Date ScheduleStart;
//    private Date ScheduleEnd;

}
