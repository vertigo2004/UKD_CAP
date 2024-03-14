package edu.ukd.cofeejava.conference.asistant.repo;


import edu.ukd.cofeejava.conference.asistant.dto.Stream;


import edu.ukd.cofeejava.conference.asistant.model.StreamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepo extends CrudRepository<StreamEntity, Long> {



}
