package edu.ukd.cofeejava.conference.asistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Speaker {

    private long id;
    private String name;
    private String info;
    private String photo;

//    public static Speaker fromSpeaker( )

}
