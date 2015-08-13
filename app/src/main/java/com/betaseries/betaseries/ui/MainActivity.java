package com.betaseries.betaseries.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.betaseries.betaseries.BuildConfig;
import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Member;
import com.betaseries.betaseries.ui.episodes.unseen.UnseenShowsFragment;
import com.betaseries.betaseries.ui.planning.PlanningFragment;
import com.betaseries.betaseries.ui.show.annuaire.AnnuaireFragment;
import com.betaseries.betaseries.ui.show.my.MyShowsFragment;
import com.github.florent37.carpaccio.Carpaccio;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AbstractDrawerActivity {

    @Bind(R.id.drawer_carpaccio)
    Carpaccio drawerCarpaccio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        authentificationManager.authentifier(BuildConfig.BETASERIES_USER, BuildConfig.BETASERIES_PASSWORD)
                .subscribeOn(Schedulers.io())
                .onErrorReturn(throwable -> {
                    Toast.makeText(MainActivity.this, "Authentification error", Toast.LENGTH_SHORT).show();
                    return null;
                })
                .subscribe(authentification -> {
                    if (!userManager.hasUser())
                        betaSeriesAPI.getInfosUserSummary()
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(response -> {
                                    userManager.setUser(response.getMember());
                                    displayUnseenEpisodes();
                                });
                    else
                        displayUnseenEpisodes();
                });
    }

    @OnClick(R.id.drawer_unseen_episodes)
    protected void displayUnseenEpisodes() {
        setContentFragment(UnseenShowsFragment.newInstance());
        closeDrawer();
    }

    @OnClick(R.id.drawer_my_shows)
    protected void displayMyShows() {
        setContentFragment(MyShowsFragment.newInstance());
        closeDrawer();
    }

    @OnClick(R.id.drawer_shows)
    protected void displayAllShows() {
        setContentFragment(AnnuaireFragment.newInstance());
        closeDrawer();
    }

    @OnClick(R.id.drawer_planning)
    protected void displayPlanning() {
        setContentFragment(PlanningFragment.newInstance());
        closeDrawer();
    }

    @Override
    public void drawerOpened() {
        super.drawerOpened();
        drawerCarpaccio.mapObject("user", userManager.getUser());
    }
}

