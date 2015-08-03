package com.betaseries.betaseries.model;

import java.io.Serializable;

/**
 * Created by kevindejesusferreira on 24/04/15.
 */
public class Comment implements Serializable{

    String id;
    String user_id;
    String login;
    String avatar;
    String date;
    String text;
    String inner_id;
    int in_reply_to;

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInner_id() {
        return inner_id;
    }

    public void setInner_id(String inner_id) {
        this.inner_id = inner_id;
    }

    public int getIn_reply_to() {
        return in_reply_to;
    }

    public void setIn_reply_to(int in_reply_to) {
        this.in_reply_to = in_reply_to;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", login='" + login + '\'' +
                ", avatar='" + avatar + '\'' +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", inner_id='" + inner_id + '\'' +
                ", in_reply_to=" + in_reply_to +
                '}';
    }
}
