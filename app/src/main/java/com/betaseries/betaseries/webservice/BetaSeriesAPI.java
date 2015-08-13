package com.betaseries.betaseries.webservice;

import com.betaseries.betaseries.model.BetaSerieResponse;

import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by florentchampigny on 02/08/15.
 */
public interface BetaSeriesAPI {


    @GET("/episodes/display") //.episode
    Observable<Object> episodeDetail(@Query("id") String id);

    @POST("/episodes/downloaded")
    Observable<Object> episodeMarquerTelecharge(@Query("id") String id);

    @DELETE("/episodes/downloaded")
    Observable<Object> episodeEnleverTelecharge(@Query("id") String id);

    @GET("/episodes/latest") //.episode
    Observable<Object> episodeDernierDiffuse(@Query("id") String id);

    @GET("/episodes/next")
    Observable<Object> episodeProchainDiffuse(@Query("id") String id);

    @POST("/episodes/note")
    Observable<Object> episodeNoter(@Query("id") Integer id, @Query("note") int note); //1 à 5

    @DELETE("/episodes/note")
    Observable<Object> episodeEnleverNote(@Query("id") String id); //1 à 5

    @GET("/episodes/search") //.episode
    Observable<Object> episodeRecherche(@Query("show_id") String idSerie, @Query("number") String numero); //numero : SxxExx

    @POST("/episodes/watched")
    Observable<Object> episodeMarquerVu(@Query("id") Integer id);

    @POST("/episodes/watched")
    Observable<Object> episodesMarquerVu(@Query("id") String ids); //episodes separés par une virgule

    @DELETE("/episodes/watched")
    Observable<Object> episodeEnleverVu(@Query("id") String ids);

    //endregion

    //region shows

    @POST("/shows/archive")
    Observable<Object> serieArchiverDansMonCompte(@Query("id") String serieId);

    @DELETE("/shows/archive")
    Observable<Object> serieRetirerDansMonCompte(@Query("id") String serieId);

    @GET("/shows/characters")
    Observable<BetaSerieResponse> serieListePersonnages(@Query("id") String serieId);

    @GET("/shows/display") //.show
    Observable<BetaSerieResponse> serieInformations(@Query("id") String serieId);

    @GET("/shows/episodes") //.episodes
    Observable<BetaSerieResponse> serieListeEpisodes(@Query("id") String serieId);

    @POST("/shows/favorite")
    Observable<Object> serieAjouterFavoris(@Query("id") String serieId);

    @DELETE("/shows/favorite")
    Observable<Object> serieRetirerFavoris(@Query("id") String serieId);

    @GET("/shows/favorites") //.shows
    Observable<BetaSerieResponse> serieFavorisDe(@Query("id") String membreId);

    @GET("/shows/list") //.shows
    Observable<BetaSerieResponse> serieListeSeries(@Query("order") String order, @Query("since") long since);
    //order : alphabetical, popularity, followers
    //since : N'afficher que les séries modifiées à partir de cette date (timestamp UNIX)

    @POST("/shows/note")
    Observable<Object> serieNoter(@Query("id") String serieId, @Query("note") int note);
    //note de 1 à 5

    @DELETE("/shows/note")
    Observable<Object> serieRetirerNote(@Query("id") String serieId);

    @GET("/shows/pictures")
    Observable<Object> serieListeImages(@Query("id") String serieId);  //.pictures

    @GET("/shows/random") //.shows
    Observable<BetaSerieResponse> serieAuHasard(@Query("nb") int nombre);

    @POST("/shows/recommendation")
    Observable<Object> serieRecommanderAUnAmi(@Query("id") String serieId, @Query("to") String amiId,
                                @Query("comment") String commentaire);

    @DELETE("/shows/recommendation")
    Observable<Object> serieRetirerRecommanderAUnAmi(@Query("id") String recommandationID);

    @GET("/shows/recommendations")
    Observable<Object> serieMesRecommandations();

    @GET("/shows/search") //.shows
    Observable<Object> serieRecherche(@Query("title") String title, @Query("order") String order,
                        @Query("npp") int nombreParPage, @Query("page") int page);
    //order : alphabetical, popularity, followers
    //page : default 1

    @POST("/shows/show")
    Observable<Object> serieAjouterAMaListe(@Query("id") String serieId);

    @DELETE("/shows/show")
    Observable<Object> serieRetirerDeMaListe(@Query("id") String serieId);

    @GET("/shows/similars")
    Observable<BetaSerieResponse> serieSimilaires(@Query("id") String serieId); //.similars

    @GET("/shows/videos")
    Observable<Object> serieListeVideos(@Query("id") String serieId); //.videos

    @POST("/shows/tags")
    Observable<Object> serieModifierTags(@Query("id") String serieId, @Query("tags") String tags);
    //tags separés par une virgule


    @GET("/members/infos")
    Observable<BetaSerieResponse> getInfosUser(@Query("summary") String summary,@Query("only") String only);


    @GET("/planning/general")
    Observable<BetaSerieResponse> planning_general();

    @GET("/planning/member")
    Observable<BetaSerieResponse> planning_member();


    @GET("/comments/comments")
    Observable<BetaSerieResponse> comments(@Query("type") String type,@Query("id") String id,@Query("nbpp") String nbpp,@Query("replies") String replies);

    @POST("/comments/comment")
    Observable<BetaSerieResponse> commenter(@Query("type") String type,@Query("id") String id,@Query("text") String text,@Query("in_reply_to") String in_reply_to);


    @POST("/episodes/watched")
    Observable<BetaSerieResponse> episodeWatched(@Query("id") String id);


    @DELETE("/episodes/watched")
    Observable<BetaSerieResponse> episodeNotWatched(@Query("id") String id);


    @GET("/comments/replies")
    Observable<BetaSerieResponse> replies(@Query("id") String id);


    @GET("/episodes/list")
    Observable<BetaSerieResponse> episodeListAVoir();

}
