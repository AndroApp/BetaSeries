package com.betaseries.betaseries.ui.show.annuaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.betaseries.betaseries.ui.show.ShowDetailActivity;
import com.betaseries.betaseries.webservice.Constants;
import com.github.florent37.carpaccio.Carpaccio;
import com.github.florent37.carpaccio.CarpaccioLogger;
import com.github.florent37.carpaccio.controllers.adapter.Holder;
import com.github.florent37.carpaccio.controllers.adapter.OnItemClickListener;
import com.github.florent37.carpaccio.controllers.adapter.OnItemClickListenerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by florentchampigny on 03/08/15.
 */
public class AnnuaireFragment extends AbstractFragment {

    public static AnnuaireFragment newInstance() {
        return new AnnuaireFragment();
    }

    @Bind(R.id.carpaccio)
    Carpaccio carpaccio;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unseen_show,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        CarpaccioLogger.ENABLE_LOG = true;

        betaSeriesAPI.serieListeSeries(Constants.ORDER_FOLLOWERS, -1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(betaSerieResponse -> {
                    carpaccio.mapList("show", betaSerieResponse.getShows());
                });

        carpaccio.onItemClick("show", new OnItemClickListenerAdapter<Show>() {
            @Override
            public void onItemClick(Show show, int i, Holder holder) {
                Intent intent = new Intent(getActivity(), ShowDetailActivity.class);
                intent.putExtra(ShowDetailActivity.SHOW, show);
                startActivity(intent);
            }
        });
    }
}
