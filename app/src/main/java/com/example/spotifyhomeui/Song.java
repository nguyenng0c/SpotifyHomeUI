package com.example.spotifyhomeui;

public class Song {
    private String title;
    private String artist;
    private int imageRes;

    public Song(String title, String artist, int imageRes) {
        this.title = title;
        this.artist = artist;
        this.imageRes = imageRes;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getImageRes() { return imageRes; }
}