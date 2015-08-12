package com.betaseries.betaseries.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.betaseries.betaseries.BuildConfig;
import com.betaseries.betaseries.R;
import com.betaseries.betaseries.ui.episodes.unseen.UnseenShowsFragment;
import com.betaseries.betaseries.ui.show.annuaire.AnnuaireFragment;

import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AbstractDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        authentificationManager.authentifier(BuildConfig.BETASERIES_USER, BuildConfig.BETASERIES_PASSWORD)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(throwable -> {
                    Toast.makeText(MainActivity.this, "Authentification error", Toast.LENGTH_SHORT).show();
                    return null;
                })
                .subscribe(authentification -> {
                    displayUnseenEpisodes();
                    //displayAnnuaire();
                });
    }


    protected void displayUnseenEpisodes() {
        setContentFragment(UnseenShowsFragment.newInstance());
    }

    protected void displayAnnuaire() {
        setContentFragment(AnnuaireFragment.newInstance());
    }

}

