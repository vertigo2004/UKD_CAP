package edu.ukd.cofeejava.conference.asistant.repository;


import edu.ukd.cofeejava.conference.asistant.entity.StreamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepository extends CrudRepository<StreamEntity, Long> {



}
