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
    public void init() {
        StreamEntity streamEntity = new StreamEntity();
        streamEntity.setName("PM IT Rally");
        streamEntity.setLocation("Ivano-Frankivsk");
        repo.save(streamEntity);

        streamEntity.setName("DEVOXX UK");
        streamEntity.setLocation("Lviv");
        repo.save(streamEntity);

        streamEntity.setName("JAX 2024");
        streamEntity.setLocation("Kiev");
        repo.save(streamEntity);

        streamEntity.setName("SPRING CONFERENCE Spring I/O 2024");
        streamEntity.setLocation("Lviv");
        repo.save(streamEntity);

    }

}
