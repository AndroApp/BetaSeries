package com.betaseries.betaseries.ui.episodes.unseen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.controllers.EventImageViewController;
import com.betaseries.betaseries.model.Episode;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractFragment;
import com.github.florent37.carpaccio.Carpaccio;
import com.github.florent37.carpaccio.controllers.adapter.CarpaccioRecyclerViewAdapter;
import com.github.florent37.carpaccio.controllers.adapter.RecyclerViewCallbackAdapter;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 11/08/15.
 */
public class UnseenEpisodesDetailFragment extends AbstractFragment {

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
    public void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        eventBus.unregister(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        carpaccio.mapObject("show", show);
        carpaccio.mapList("episode", show.getUnseen());

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

        // init swipe to dismiss logic
        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                // callback for drag-n-drop, false to skip this feature
                return false;
            }

            @Override
            public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                if (viewHolder.getAdapterPosition() == 0) return 0;
                return super.getSwipeDirs(recyclerView, viewHolder);
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // callback for swipe to dismiss, removing item from data and adapter
                Episode episode = (Episode) carpaccio.getMappedList("episode").get(viewHolder.getAdapterPosition() - adapter.getHeaderCount());
                episode.setSeen(true);
                adapter.notifyItemChanged(viewHolder.getAdapterPosition());
            }
        });
        swipeToDismissTouchHelper.attachToRecyclerView(recyclerView);
    }

    public static Fragment newInstance(Show show) {
        UnseenEpisodesDetailFragment fragment = new UnseenEpisodesDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("show", show);
        fragment.setArguments(args);
        return fragment;
    }

    public void onEvent(EventImageViewController.EventImage eventImage){
        if(eventImage.url.equals(show.getUrlShow()))
            getActivity().supportStartPostponedEnterTransition();
    }
}
