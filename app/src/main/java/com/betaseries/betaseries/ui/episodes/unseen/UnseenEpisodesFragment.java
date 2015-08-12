package com.betaseries.betaseries.ui.episodes.unseen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.controllers.EventImageViewController;
import com.betaseries.betaseries.model.Episode;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.github.florent37.carpaccio.Carpaccio;
import com.github.florent37.carpaccio.controllers.adapter.CarpaccioRecyclerViewAdapter;
import com.github.florent37.carpaccio.controllers.adapter.Holder;
import com.github.florent37.carpaccio.controllers.adapter.OnItemSwipedListener;
import com.github.florent37.carpaccio.controllers.adapter.RecyclerViewCallbackAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 11/08/15.
 */
public class UnseenEpisodesFragment extends AbstractFragment {

    public static UnseenEpisodesFragment newInstance(Show show) {
        UnseenEpisodesFragment fragment = new UnseenEpisodesFragment();
        Bundle args = new Bundle();
        args.putSerializable("show", show);
        fragment.setArguments(args);
        return fragment;
    }

    @Bind(R.id.carpaccio)
    Carpaccio carpaccio;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    Show show;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show = (Show) getArguments().getSerializable("show");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unseen_episodes_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        carpaccio.mapObject("show", show);
        carpaccio.mapList("episode", show.getUnseen());

        {
            CarpaccioRecyclerViewAdapter adapter = carpaccio.getAdapter("episode");
            adapter.setRecyclerViewCallback(new RecyclerViewCallbackAdapter() {
                @Override
                public void onBind(Object object, View view, int position) {
                    super.onBind(object, view, position);
                    if (object instanceof Episode) {
                        Episode episode = (Episode) object;
                        if (episode.isSeen()) {
                            view.findViewById(R.id.card).setVisibility(View.GONE);
                        } else {
                            view.findViewById(R.id.card).setVisibility(View.VISIBLE);
                        }
                    }
                }
            });
            adapter.setOnItemSwipedListener(new OnItemSwipedListener<Episode>() {
                @Override
                public boolean OnItemSwipedListener(Episode episode, int i, Holder holder, RecyclerView.Adapter adapter) {
                    if (!episode.isSeen()) {
                        episode.setSeen(true);
                        return false;
                    } else
                        return true;
                }
            });
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        eventBus.unregister(this);
    }

    public void onEvent(EventImageViewController.EventImage eventImage){
        if(eventImage.url.equals(show.getUrlShow()))
            getActivity().supportStartPostponedEnterTransition();
    }
}
