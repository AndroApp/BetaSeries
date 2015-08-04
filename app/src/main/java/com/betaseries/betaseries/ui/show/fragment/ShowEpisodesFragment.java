package com.betaseries.betaseries.ui.show.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.github.florent37.carpaccio.Carpaccio;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowEpisodesFragment extends AbstractFragment {
    private static final String SHOW_ID = "SHOW_ID";

    public static Fragment newInstance(String showId) {
        Fragment fragment = new ShowEpisodesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SHOW_ID, showId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Bind(R.id.carpaccio)
    Carpaccio carpaccio;

    protected String showId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showId = getArguments().getString(SHOW_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_episodes, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        betaSeriesAPI.serieListeEpisodes(showId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(betaSerieResponse -> {
                    carpaccio.mapList("episode", betaSerieResponse.getEpisodes());
                });
    }
}
