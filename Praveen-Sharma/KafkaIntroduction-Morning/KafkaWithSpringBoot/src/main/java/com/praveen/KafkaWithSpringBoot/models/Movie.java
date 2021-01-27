package com.praveen.KafkaWithSpringBoot.models;

public class Movie {

    private int year;
    private String name;
    private String actor;
    private String genre;

    public Movie() {
    }
    public Movie(int year, String name, String actor, String genre) {
        this.year = year;
        this.name = name;
        this.actor = actor;
        this.genre = genre;
    }


    public int getYear() {
        return year;
    }

    public Movie setYear(int year) {
        this.year = year;
        return this;
    }

    public String getName() {
        return name;
    }

    public Movie setName(String name) {
        this.name = name;
        return this;
    }

    public String getActor() {
        return actor;
    }

    public Movie setActor(String actor) {
        this.actor = actor;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Movie setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    @Override
    public String toString() {
        String str  = "Movie Detail = ["+"Name:"+ getName() +" | "+"Actor:"+getActor()+" | "+"Genre:"+ getGenre()+" | "+"Release Year:"+getYear()+"]";
        return str;
    }
}
