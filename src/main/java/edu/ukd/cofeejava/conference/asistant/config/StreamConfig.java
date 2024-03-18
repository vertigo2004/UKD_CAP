package edu.ukd.cofeejava.conference.asistant.config;



import edu.ukd.cofeejava.conference.asistant.dto.Stream;
import edu.ukd.cofeejava.conference.asistant.model.StreamEntity;
import edu.ukd.cofeejava.conference.asistant.repo.StreamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StreamConfig {

    @Autowired
    StreamRepo repo;
    public StreamConfig(StreamRepo repo) {
        this.repo = repo;
        init();
    }

    public void init() {
        StreamEntity streamEntity1 = new StreamEntity();
        streamEntity1.setName("PM IT Rally");
        streamEntity1.setLocation("Ivano-Frankivsk");
        repo.save(streamEntity1);

        StreamEntity streamEntity2 = new StreamEntity();
        streamEntity2.setName("DEVOXX UK");
        streamEntity2.setLocation("Lviv");
        repo.save(streamEntity2);

        StreamEntity streamEntity3 = new StreamEntity();
        streamEntity3.setName("JAX 2024");
        streamEntity3.setLocation("Kiev");
        repo.save(streamEntity3);

        StreamEntity streamEntity0 = new StreamEntity();
        streamEntity0.setName("SPRING CONFERENCE Spring I/O 2024");
        streamEntity0.setLocation("Lviv");
        repo.save(streamEntity0);

    }

}
