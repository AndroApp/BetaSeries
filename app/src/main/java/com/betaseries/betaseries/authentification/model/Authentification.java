package com.betaseries.betaseries.authentification.model;

/**
 * Created by florentchampigny on 11/04/15.
 */
public class Authentification {
    private Authentification.User user;
    private String token;
    private String hash;

    public Authentification.User getUser() {
        return user;
    }

    public void setUser(Authentification.User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public class User {
        private int id;
        private String login;
        private boolean in_account;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public boolean isIn_account() {
            return in_account;
        }

        public void setIn_account(boolean in_account) {
            this.in_account = in_account;
        }
    }


    @Override
    public String toString() {
        return "Authentification{" +
                ", token='" + token + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
