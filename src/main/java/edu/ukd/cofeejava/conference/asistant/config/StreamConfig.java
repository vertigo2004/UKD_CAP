package edu.ukd.cofeejava.conference.asistant.config;



import edu.ukd.cofeejava.conference.asistant.repository.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StreamConfig {

    @Autowired
    StreamRepository repo;
    public StreamConfig(StreamRepository repo) {
        this.repo = repo;
        init();
    }

    public void init() {


    }

}
