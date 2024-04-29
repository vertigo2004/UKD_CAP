package edu.ukd.cofeejava.conference.asistant.repository;

import edu.ukd.cofeejava.conference.asistant.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionEntity, Long> {
}
