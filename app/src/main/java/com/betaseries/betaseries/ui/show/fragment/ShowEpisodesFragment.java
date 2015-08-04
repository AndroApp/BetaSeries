package com.betaseries.betaseries.ui.show.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.BetaSerieResponse;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.betaseries.betaseries.ui.show.adapter.ShowEpisodesAdapter;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowEpisodesFragment extends AbstractFragment {
    private static final String SHOW_ID = "SHOW_ID";

    public static Fragment newInstance(String showId) {
        Fragment fragment = new ShowEpisodesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SHOW_ID,showId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    protected String showId;
    protected ShowEpisodesAdapter adapter = new ShowEpisodesAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showId = getArguments().getString(SHOW_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview_simple, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewMaterialAdapter(adapter));

        MaterialViewPagerHelper.registerRecyclerView(getActivity(), recyclerView, null);

        betaSeriesAPI.serieListeEpisodes(showId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(betaSerieResponse -> {
                    adapter.addAll(betaSerieResponse.getEpisodes());
                    recyclerView.getAdapter().notifyDataSetChanged();
                });
    }
}
