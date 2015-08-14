package com.betaseries.betaseries.model;

import com.betaseries.betaseries.utils.DateUtils;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by florentchampigny on 11/04/15.
 */
public class Episode extends SugarRecord<Episode> implements Serializable {

    @SerializedName("id")
    Integer episodeId;

    Integer thetvdbId;
    String youtube_id;
    String title;
    Integer season;
    Integer episode;
    Show show;
    String code;
    Integer global;
    String description;
    String date;
    Note note;
    User user;
    String comments;
    ArrayList<Object> subtitles = new ArrayList<Object>();

    private boolean swiped = false;
    private boolean voted = false;
    private int noteUser = 5;

    public boolean isSwiped() {
        return swiped;
    }

    public void setSwiped(boolean swiped) {
        this.swiped = swiped;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    public void setNoteUser(float note) {
        this.noteUser = (int) note;
        this.voted = true;
    }

    public int getNoteUser() {
        return this.noteUser;
    }

    public String getUrlBanner() {
        return "https://api.betaseries.com/pictures/episodes?key=d932200243da&id=" + episodeId + "&width=200&height=100";
    }

    public String getUrlBackground() {
        return "https://api.betaseries.com/pictures/episodes?key=d932200243da&id=" + episodeId + "&width=900&height=500";
    }

    public String getSeasonEpisode() {
        return "S" + season + " E" + episode;
    }

    public String getDateFr() {
        String dateFr = DateUtils.getDateFr(getDate());

        int length = 0;
        if (getShow().getLength() != null)
            length = Integer.parseInt(getShow().getLength());

        return dateFr;
    }

    public String getDateFrSmall() {
        return DateUtils.getDateFrSmall(getDate());
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setId(Integer id) {
        this.episodeId = id;
    }

    public Integer getThetvdbId() {
        return thetvdbId;
    }

    public void setThetvdbId(Integer thetvdbId) {
        this.thetvdbId = thetvdbId;
    }

    public String getYoutubeId() {
        return youtube_id;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtube_id = youtubeId;
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
                ", youtubeId=" + youtube_id +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Episode)) return false;

        Episode episode = (Episode) o;

        return !(episodeId != null ? !episodeId.equals(episode.episodeId) : episode.episodeId != null);

    }

    @Override
    public int hashCode() {
        return episodeId != null ? episodeId.hashCode() : 0;
    }
}
