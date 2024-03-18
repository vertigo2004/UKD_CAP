package edu.ukd.cofeejava.conference.asistant.repository;

import edu.ukd.cofeejava.conference.asistant.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Long> {

}
