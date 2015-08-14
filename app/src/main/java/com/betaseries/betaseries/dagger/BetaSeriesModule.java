package com.betaseries.betaseries.dagger;

import android.content.Context;

import com.betaseries.betaseries.BuildConfig;
import com.betaseries.betaseries.authentification.AuthentificationManager;
import com.betaseries.betaseries.back.UserManager;
import com.betaseries.betaseries.back.episodes.unseen.UnseenManager;
import com.betaseries.betaseries.webservice.BetaSeriesAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by florentchampigny on 30/07/15.
 */
@Singleton
@Module
public class BetaSeriesModule {

    @Singleton
    @Provides
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Singleton
    @Provides
    public Gson provideGson() {
        GsonStrategy gsonStrategy = new GsonStrategy();
        return new GsonBuilder().addDeserializationExclusionStrategy(gsonStrategy).addSerializationExclusionStrategy(gsonStrategy).create();
    }

    @Singleton
    @Provides
    public UnseenManager provideUnseenManager(Gson gson, Context context) {
        return new UnseenManager(context, gson);
    }

    @Singleton
    @Provides
    public UserManager provideUserManager(Gson gson, Context context) {
        return new UserManager(context, gson);
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                return originalResponse.newBuilder()
                        .header("Cache-Control", String.format("max-age=%d, only-if-cached, max-stale=%d", 10*60*60, 0))
                        .build();
            }
        });
        return okHttpClient;
    }

    @Singleton
    @Provides
    public BetaSeriesAPI provideBetaSeriesApi(OkHttpClient okHttpClient, Gson gson, AuthentificationManager authentificationManager) {
        return new RestAdapter.Builder()
                .setEndpoint(BuildConfig.URL_BETASERIES)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(okHttpClient))
                .setLog(new AndroidLog("Retrofit"))
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(request -> {
                    request.addHeader("X-BetaSeries-Key", BuildConfig.API_KEY);
                    request.addHeader("X-BetaSeries-Version", "2.4");
                    request.addHeader("Accept", "application/json");

                    String userToken = authentificationManager.getToken();
                    if (userToken != null)
                        request.addHeader("X-BetaSeries-Token", userToken);
                })
                .build()
                .create(BetaSeriesAPI.class);
    }

}
