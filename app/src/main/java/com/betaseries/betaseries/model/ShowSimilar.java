package com.betaseries.betaseries.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 10/04/15.
 */
public class ShowSimilar implements Serializable{
    private int id;
    private String show_title;
    private int show_id;
    private int thetvdb_id;
    private String login;
    private String login_id;
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShowTitle() {
        return show_title;
    }

    public void setShowTitle(String show_title) {
        this.show_title = show_title;
    }

    public int getShowId() {
        return show_id;
    }

    public void setShowId(int show_id) {
        this.show_id = show_id;
    }

    public int getThetvdb_id() {
        return thetvdb_id;
    }

    public void setThetvdb_id(int thetvdb_id) {
        this.thetvdb_id = thetvdb_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
