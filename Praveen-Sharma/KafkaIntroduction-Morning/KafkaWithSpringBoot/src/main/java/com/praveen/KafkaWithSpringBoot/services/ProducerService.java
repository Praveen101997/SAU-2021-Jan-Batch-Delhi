package com.praveen.KafkaWithSpringBoot.services;

import com.praveen.KafkaWithSpringBoot.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, Movie> kafkaTemplate;

    public void sendData(String name, String actor, String genre, int year) {
        Movie newMovie=new Movie().setName(name).setActor(actor).setGenre(genre).setYear(year);
        logger.info(String.format("Movie Data Added -> %s", newMovie));
        this.kafkaTemplate.send(TOPIC, newMovie);
    }
}
