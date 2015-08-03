package com.betaseries.betaseries.dagger;

import com.betaseries.betaseries.authentification.AuthentificationManager;
import com.betaseries.betaseries.authentification.AuthentificationModule;
import com.betaseries.betaseries.ui.AbstractActivity;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.betaseries.betaseries.webservice.BetaSeriesAPI;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import de.greenrobot.event.EventBus;

@Singleton
@Component(modules = {BetaSeriesModule.class, ContextModule.class, AuthentificationModule.class})
public interface BetaSeriesComponent {

    AuthentificationManager authentificationManager();
    BetaSeriesAPI githubApi();
    Gson gson();
    EventBus eventBus();

    void inject(AbstractFragment abstractFragment);
    void inject(AbstractActivity abstractActivity);
}