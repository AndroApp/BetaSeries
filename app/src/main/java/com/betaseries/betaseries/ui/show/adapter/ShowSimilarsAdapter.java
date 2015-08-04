package com.betaseries.betaseries.ui.show.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.ShowSimilar;
import com.betaseries.betaseries.ui.show.view.ShowSimilarViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowSimilarsAdapter extends RecyclerView.Adapter<ShowSimilarViewHolder> {

    private List<ShowSimilar> list = new ArrayList<>();

    public void addAll(List<ShowSimilar> shows){
        if(shows != null) {
            this.list.addAll(shows);
            this.notifyDataSetChanged();
        }
    }

    @Override
    public ShowSimilarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_show_similar, parent, false);
        return new ShowSimilarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowSimilarViewHolder holder, int position) {
        holder.bind(this.list.get(position));
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
