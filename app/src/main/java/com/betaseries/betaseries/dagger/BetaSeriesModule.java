package com.betaseries.betaseries.dagger;

import com.betaseries.betaseries.webservice.BetaSeriesAPI;
import com.betaseries.betaseries.BuildConfig;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * Created by florentchampigny on 30/07/15.
 */
@Singleton
@Module
public class BetaSeriesModule {

    @Singleton
    @Provides
    public EventBus provideEventBus(){
        return EventBus.getDefault();
    }

    @Singleton
    @Provides
    public Gson provideGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    public BetaSeriesAPI provideBetaSeriesApi() {
        return new RestAdapter.Builder()
                .setEndpoint(BuildConfig.URL_BETASERIES)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog("Retrofit"))
                .build()
                .create(BetaSeriesAPI.class);
    }

}
