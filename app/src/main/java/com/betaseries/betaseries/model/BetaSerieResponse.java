package com.betaseries.betaseries.model;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 10/04/15.
 */
public class BetaSerieResponse {
    private Show show;
    private Episode episode;
    private ArrayList<Show> shows;
    private ArrayList<Episode> episodes;
    private ArrayList<Picture> pictures;
    private ArrayList<Video> videos;
    private ArrayList<ShowSimilar> similars;
    private ArrayList<java.lang.Character> characters;

    private ArrayList<Object> errors;

    private Member member;

    private ArrayList<Comment> comments;
    //region getters/setters


    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }

    public ArrayList<java.lang.Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<java.lang.Character> characters) {
        this.characters = characters;
    }

    public ArrayList<ShowSimilar> getSimilars() {
        return similars;
    }

    public void setSimilars(ArrayList<ShowSimilar> similars) {
        this.similars = similars;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }

    public ArrayList<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<Picture> pictures) {
        this.pictures = pictures;
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ArrayList<Object> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<Object> errors) {
        this.errors = errors;
    }


    //endregion
}
