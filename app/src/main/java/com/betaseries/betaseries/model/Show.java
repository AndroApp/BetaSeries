package com.betaseries.betaseries.model;

import com.betaseries.betaseries.Application;
import com.betaseries.betaseries.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 10/04/15.
 */
public class Show implements Serializable{
    private int id;
    private int thetvdb_id;
    private String imdb_id;
    private String title;
    private String description;
    private String seasons;
    private List<SeasonDetail> seasons_details = new ArrayList<SeasonDetail>();
    private String episodes;
    private String followers;
    private String comments;
    private String similars;
    private String characters;
    private String creation;
    private List<String> genres = new ArrayList<String>();
    private String length;
    private String network;
    private String rating;
    private String status;
    private String language;
    private Note notes;
    private Boolean in_account;
    private User user;
    private String resource_url;
    private ArrayList<Episode> unseen;



    public Boolean isIn_account() {
        return in_account;
    }

    public ArrayList<Episode> getUnseen() {
        return unseen;
    }

    public void setUnseen(ArrayList<Episode> unseen) {
        this.unseen = unseen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThetvdb_id() {
        return thetvdb_id;
    }

    public void setThetvdb_id(int thetvdb_id) {
        this.thetvdb_id = thetvdb_id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public List<SeasonDetail> getSeasons_details() {
        return seasons_details;
    }

    public void setSeasons_details(List<SeasonDetail> seasons_details) {
        this.seasons_details = seasons_details;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSimilars() {
        return similars;
    }

    public void setSimilars(String similars) {
        this.similars = similars;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Note getNotes() {
        return notes;
    }

    public void setNotes(Note notes) {
        this.notes = notes;
    }

    public Boolean getIn_account() {
        return in_account;
    }

    public void setIn_account(Boolean in_account) {
        this.in_account = in_account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getResource_url() {
        return resource_url;
    }

    public void setResource_url(String resource_url) {
        this.resource_url = resource_url;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", thetvdb_id=" + thetvdb_id +
                ", imdb_id='" + imdb_id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", seasons='" + seasons + '\'' +
                ", seasons_details=" + seasons_details +
                ", episodes='" + episodes + '\'' +
                ", followers='" + followers + '\'' +
                ", comments='" + comments + '\'' +
                ", similars='" + similars + '\'' +
                ", characters='" + characters + '\'' +
                ", creation='" + creation + '\'' +
                ", genres=" + genres +
                ", length='" + length + '\'' +
                ", network='" + network + '\'' +
                ", rating='" + rating + '\'' +
                ", status='" + status + '\'' +
                ", language='" + language + '\'' +
                ", notes=" + notes +
                ", in_account=" + in_account +
                ", user=" + user +
                ", resource_url='" + resource_url + '\'' +
                '}';
    }

    public String getUrlBanner(){
        return "https://api.betaseries.com/pictures/shows?key=d932200243da&id=" + id + "&width=500&height=500&picked=banner";
    }

    public String getUrlShow(){
        return "https://api.betaseries.com/pictures/shows?key=d932200243da&id=" + id + "&width=400&height=600&picked=show";
    }

    public String getUrlBackground(){
        return "https://api.betaseries.com/pictures/shows?key=d932200243da&id=" + id + "&width=600&height=300&picked=show";
    }

    public String episodeNonVues(){

        return Application.app().getString(R.string.nb_episode_show_unseen, this.unseen.size());
    }
}
