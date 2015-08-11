package com.betaseries.betaseries.model;

import com.betaseries.betaseries.utils.DateUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by florentchampigny on 11/04/15.
 */
public class Episode implements Serializable{
    private Integer id;
    private Integer thetvdbId;
    private Object youtubeId;
    private String title;
    private Integer season;
    private Integer episode;
    private Show show;
    private String code;
    private Integer global;
    private String description;
    private String date;
    private Note note;
    private User user;
    private String comments;
    private ArrayList<Object> subtitles = new ArrayList<Object>();

    public String getUrlBanner(){
        return "https://api.betaseries.com/pictures/episodes?key=d932200243da&id=" + getId() + "&width=800&height=450";
    }

    public String getSeasonEpisode(){
        return season+" - "+episode;
    }

    public String getDateAndDuration(){
        String dateFr = DateUtils.getDateFr(getDate());

        int length = 0;
        if (getShow().getLength() != null)
            length = Integer.parseInt(getShow().getLength());

        //we add the episode duration
        if (length > 0) {
            dateFr += " (" + length + " minute ";

            if (length > 1)
                dateFr += "s";

            dateFr += ")";
        }
        return dateFr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getThetvdbId() {
        return thetvdbId;
    }

    public void setThetvdbId(Integer thetvdbId) {
        this.thetvdbId = thetvdbId;
    }

    public Object getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(Object youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getGlobal() {
        return global;
    }

    public void setGlobal(Integer global) {
        this.global = global;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ArrayList<Object> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(ArrayList<Object> subtitles) {
        this.subtitles = subtitles;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", thetvdbId=" + thetvdbId +
                ", youtubeId=" + youtubeId +
                ", title='" + title + '\'' +
                ", season=" + season +
                ", episode=" + episode +
                ", show=" + show +
                ", code='" + code + '\'' +
                ", global=" + global +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", note=" + note +
                ", user=" + user +
                ", comments='" + comments + '\'' +
                ", subtitles=" + subtitles +
                '}';
    }
}
