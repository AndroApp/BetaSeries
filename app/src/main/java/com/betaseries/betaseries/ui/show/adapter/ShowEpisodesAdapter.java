package com.betaseries.betaseries.ui.show.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Episode;
import com.betaseries.betaseries.ui.show.view.ShowEpisodeViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowEpisodesAdapter extends RecyclerView.Adapter<ShowEpisodeViewHolder> {

    protected List<Episode> list = new ArrayList<>();

    public void addAll(List<Episode> list){
        if(list != null) {
            this.list.addAll(list);
            this.notifyDataSetChanged();
        }
    }

    @Override
    public ShowEpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_show_episode, parent, false);
        return new ShowEpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowEpisodeViewHolder holder, int position) {
        holder.bind(this.list.get(position));
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
