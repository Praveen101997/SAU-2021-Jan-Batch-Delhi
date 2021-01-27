package com.praveen.KafkaWithSpringBoot.controllers;

import com.praveen.KafkaWithSpringBoot.models.Movie;
import com.praveen.KafkaWithSpringBoot.models.MoviesDetails;
import com.praveen.KafkaWithSpringBoot.services.ConsumerService;
import com.praveen.KafkaWithSpringBoot.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final ProducerService producerService;
    private final ConsumerService consumerService;

    @Autowired
    KafkaController(ProducerService producerService, ConsumerService consumerService) {
        this.producerService = producerService;
        this.consumerService = consumerService;
    }

    @GetMapping(value = "/auto")
    public void sendMessage() {
        MoviesDetails moviesDetails = new MoviesDetails();
        moviesDetails.moviesAdd();
        List<Movie> movieList= moviesDetails.getMovieList();
        for(Movie movie:movieList){
            this.producerService.sendData(movie.getName(),movie.getActor(),movie.getGenre(),movie.getYear());
        }
    }

    @PostMapping(value = "/moviepublish")
    public void sendMessageToKafkaTopic(@RequestParam(value = "name") String name, @RequestParam(value = "actor") String actor,
                                        @RequestParam(value = "genre") String genre, @RequestParam(value = "releaseyear") int releaseyear) {
        this.producerService.sendData(name,actor,genre, releaseyear);
    }
}
