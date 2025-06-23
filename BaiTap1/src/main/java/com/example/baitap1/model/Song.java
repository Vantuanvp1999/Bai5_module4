package com.example.baitap1.model;

public class Song {
    private String name;
    private String artist;
    private String genre;
    private String file;

    public Song() {
    }

    public Song(String name, String artist, String genre, String file) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
