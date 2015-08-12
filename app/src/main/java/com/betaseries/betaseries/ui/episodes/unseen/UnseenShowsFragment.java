package com.betaseries.betaseries.ui.episodes.unseen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.Application;
import com.betaseries.betaseries.R;
import com.betaseries.betaseries.back.episodes.unseen.UnseenManager;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.github.florent37.carpaccio.Carpaccio;
import com.github.florent37.carpaccio.CarpaccioLogger;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by florentchampigny on 03/08/15.
 */
public class UnseenShowsFragment extends AbstractFragment {

    public static UnseenShowsFragment newInstance() {
        return new UnseenShowsFragment();
    }

    @Bind(R.id.carpaccio)
    Carpaccio carpaccio;

    @Inject
    UnseenManager unseenManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unseen_show,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Application.app().component().inject(this);

        CarpaccioLogger.ENABLE_LOG = true;

        carpaccio.mapList("show", unseenManager.load().getUnseens());
        betaSeriesAPI.episodeListAVoir()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(betaSerieResponse -> {
                    unseenManager.replace(betaSerieResponse.getShows()).save();
                    carpaccio.mapList("show", betaSerieResponse.getShows());
                });

        carpaccio.onItemClick("show", (show, i, cellView) -> {
            Intent intent = new Intent(getActivity(), UnseenEpisodesActivity.class);
            intent.putExtra(UnseenEpisodesActivity.SHOW, (Show)show);
            Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                    Pair.create(cellView.findViewById(R.id.image_serie), "image")
            ).toBundle();
            ActivityCompat.startActivity(getActivity(),intent, bundle);
        });
    }
}
