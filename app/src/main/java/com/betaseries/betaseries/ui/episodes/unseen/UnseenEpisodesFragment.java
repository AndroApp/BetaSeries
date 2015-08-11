package com.betaseries.betaseries.ui.episodes.unseen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.betaseries.betaseries.ui.show.ShowDetailActivity;
import com.github.florent37.carpaccio.Carpaccio;
import com.github.florent37.carpaccio.CarpaccioLogger;
import com.github.florent37.carpaccio.controllers.adapter.OnItemClickListener;

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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(betaSerieResponse -> {
                    carpaccio.mapList("show", betaSerieResponse.getShows());
                });

        carpaccio.onItemClick("show", (show, i, view1) -> {
            Intent intent = new Intent(getActivity(), UnseedEpisodesDetailActivity.class);
            intent.putExtra(UnseedEpisodesDetailActivity.SHOW, (Show)show);
            Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), Pair.create(view1.findViewById(R.id.image_serie), "image")).toBundle();
            ActivityCompat.startActivity(getActivity(),intent, bundle);
        });
    }
}
