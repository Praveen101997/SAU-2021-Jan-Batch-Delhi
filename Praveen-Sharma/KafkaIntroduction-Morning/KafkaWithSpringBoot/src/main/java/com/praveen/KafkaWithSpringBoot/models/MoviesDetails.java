package com.praveen.KafkaWithSpringBoot.models;

import java.util.ArrayList;
import java.util.List;

public class MoviesDetails {

    List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void moviesAdd(){
        movieList.add(new Movie(1998,"Movie1","Actor1","Genre1"));
        movieList.add(new Movie(1998,"Movie2","Actor2","Genre2"));
        movieList.add(new Movie(1999,"Movie3","Actor3","Genre1"));
        movieList.add(new Movie(1998,"Movie4","Actor3","Genre3"));
        movieList.add(new Movie(1997,"Movie5","Actor3","Genre1"));
        movieList.add(new Movie(2009,"Movie6","Actor5","Genre2"));
        movieList.add(new Movie(2019,"Movie7","Actor1","Genre1"));
        movieList.add(new Movie(2001,"Movie8","Actor8","Genre3"));
        movieList.add(new Movie(1997,"Movie9","Actor2","Genre4"));
        movieList.add(new Movie(1993,"Movie10","Actor1","Genre1"));
        movieList.add(new Movie(2014,"Movie11","Actor9","Genre3"));
        movieList.add(new Movie(2018,"Movie12","Actor7","Genre2"));
        movieList.add(new Movie(2017,"Movie13","Actor6","Genre1"));
        movieList.add(new Movie(2015,"Movie14","Actor8","Genre4"));
        movieList.add(new Movie(2005,"Movie15","Actor5","Genre1"));
        movieList.add(new Movie(1994,"Movie16","Actor9","Genre3"));
        movieList.add(new Movie(2002,"Movie17","Actor3","Genre1"));
        movieList.add(new Movie(2004,"Movie18","Actor5","Genre2"));
        movieList.add(new Movie(2013,"Movie19","Actor2","Genre3"));
        movieList.add(new Movie(1991,"Movie20","Actor6","Genre1"));
        movieList.add(new Movie(2000,"Movie21","Actor2","Genre4"));
        movieList.add(new Movie(2010,"Movie22","Actor7","Genre3"));
        movieList.add(new Movie(2020,"Movie23","Actor3","Genre1"));
        movieList.add(new Movie(2012,"Movie24","Actor3","Genre2"));
        movieList.add(new Movie(1996,"Movie25","Actor5","Genre1"));
        movieList.add(new Movie(1992,"Movie26","Actor2","Genre3"));
        movieList.add(new Movie(2001,"Movie27","Actor5","Genre2"));
        movieList.add(new Movie(2011,"Movie28","Actor9","Genre1"));
        movieList.add(new Movie(2020,"Movie29","Actor3","Genre3"));
        movieList.add(new Movie(2014,"Movie30","Actor9","Genre1"));
        movieList.add(new Movie(1995,"Movie31","Actor1","Genre2"));
        movieList.add(new Movie(1991,"Movie32","Actor5","Genre1"));

    }
}
