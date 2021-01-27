package com.praveen.KafkaWithSpringBoot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.praveen.KafkaWithSpringBoot.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class ConsumerService {

    HashMap<Integer,HashMap<String,Integer>> trendTrack =new HashMap<Integer,HashMap<String,Integer>>();
    HashMap<Integer,String> trend =new HashMap<>();

    private final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String movie) throws IOException {

        Movie newMovie = new ObjectMapper().readValue(movie, Movie.class);

        //===================================================
        /*
        Year Range
        1990-2000
        2000-2010
        2010-2020

        Most Trending actor for every decade based on number of movies release in that year range
         */
        //===================================================
        int yearRange = 0;
        if(newMovie.getYear()>=1990&&newMovie.getYear()<2000){
            yearRange = 0;
        }else if (newMovie.getYear()>=2000&&newMovie.getYear()<2010){
            yearRange = 1;
        }else{
            yearRange = 2;
        }

        HashMap<String,Integer> hmap= new HashMap<>();
        if(trendTrack.containsKey(yearRange)) {
            hmap= trendTrack.get(yearRange);
            hmap.put(newMovie.getActor(), hmap.getOrDefault(newMovie.getActor(),0)+1);
            if(hmap.get(newMovie.getActor())>=hmap.get(trend.get(yearRange)))
            {
                trend.put(yearRange, newMovie.getActor());
            }
        }
        else
        {
            trend.put(yearRange, newMovie.getActor());
            hmap.put(newMovie.getActor(),1);
        }
        trendTrack.put(yearRange,hmap);

        logger.info("---------------------------------------------------------------------");
//        String years = "";
//        if (yearRange == 0){
//            years = "1900-2000";
//        }else if (yearRange == 1){
//            years = "2000-2010";
//        }else{
//            years = "2010-2020";
//        }
        logger.info("Top Trending Actor of "+ "1900-2000" + " is " + trend.get(0));
        logger.info("Top Trending Actor of "+ "2000-2010" + " is " + trend.get(1));
        logger.info("Top Trending Actor of "+ "2010-2020" + " is " + trend.get(2));
        logger.info("---------------------------------------------------------------------");

    }
}
