package com.betaseries.betaseries.ui.show.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.betaseries.betaseries.ui.show.adapter.ShowCastingAdapter;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowCastingFragment extends AbstractFragment {
    private static final String SHOW_ID = "SHOW_ID";

    public static Fragment newInstance(String showId) {
        Fragment fragment = new ShowCastingFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SHOW_ID, showId);
        fragment.setArguments(bundle);
        return fragment;
    }

    protected String showId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showId = getArguments().getString(SHOW_ID);
    }

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    ShowCastingAdapter adapter = new ShowCastingAdapter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview_simple, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        final int numberCellsPerLine = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberCellsPerLine));
        recyclerView.setAdapter(new RecyclerViewMaterialAdapter(adapter, numberCellsPerLine));

        MaterialViewPagerHelper.registerRecyclerView(getActivity(), recyclerView, null);

        betaSeriesAPI.serieListePersonnages(showId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(betaSerieResponse -> {
                    adapter.addAll(betaSerieResponse.getCharacters());
                    recyclerView.getAdapter().notifyDataSetChanged();
                });
    }
}
