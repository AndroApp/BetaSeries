package com.betaseries.betaseries.ui.episodes.unseen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.github.florent37.carpaccio.Carpaccio;
import com.github.florent37.carpaccio.CarpaccioLogger;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by florentchampigny on 03/08/15.
 */
public class UnseenEpisodesFragment extends AbstractFragment {

    public static UnseenEpisodesFragment newInstance() {
        return new UnseenEpisodesFragment();
    }

    @Bind(R.id.carpaccio)
    Carpaccio carpaccio;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unseen_episodes,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        CarpaccioLogger.ENABLE_LOG = true;

        betaSeriesAPI.episodeListAVoir(20)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(betaSerieResponse -> {
                    carpaccio.mapList("show", betaSerieResponse.getShows());
                });
    }
}
