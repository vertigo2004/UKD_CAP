package edu.ukd.cofeejava.conference.asistant.repository;

import edu.ukd.cofeejava.conference.asistant.entity.TopicEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<TopicEntity, Long> {
}
