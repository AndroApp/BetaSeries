package com.betaseries.betaseries.authentification.webservice;

import com.betaseries.betaseries.authentification.model.Authentification;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

public interface AuthentificationService {

    @FormUrlEncoded
    @POST("/members/auth")
    Observable<Authentification> authentifier(@Field("login") String login, @Field("password") String passwordMD5);
}
