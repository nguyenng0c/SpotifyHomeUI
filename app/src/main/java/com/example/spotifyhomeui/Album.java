package com.example.spotifyhomeui;

public class Album {
    private String type;
    private String title;
    private int imageRes;
    private boolean showOverlay;

    public Album(String type, String title, int imageRes, boolean showOverlay) {
        this.type = type;
        this.title = title;
        this.imageRes = imageRes;
        this.showOverlay = showOverlay;
    }

    public String getType() { return type; }
    public String getTitle() { return title; }
    public int getImageRes() { return imageRes; }
    public boolean isShowOverlay() { return showOverlay; }
}