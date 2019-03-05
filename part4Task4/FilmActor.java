package org.epamtasks.part4.part4Task4;

import java.io.Serializable;

public class FilmActor implements Serializable {
    private String film;
    private String actor;

    public FilmActor(String film, String actor) {
        this.film = film;
        this.actor = actor;
    }

    public String getInfo() {
        return "Film: " + film + " Actor: " + actor;
    }

}
