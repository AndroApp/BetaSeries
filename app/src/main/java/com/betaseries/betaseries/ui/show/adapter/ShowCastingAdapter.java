package com.betaseries.betaseries.ui.show.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Character;
import com.betaseries.betaseries.ui.show.view.ShowCastingViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowCastingAdapter extends RecyclerView.Adapter<ShowCastingViewHolder> {

    private List<Character> list = new ArrayList<>();

    public void addAll(List<Character> list){
        if(list != null) {
            this.list.addAll(list);
            this.notifyDataSetChanged();
        }
    }

    @Override
    public ShowCastingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_show_character, parent, false);
        return new ShowCastingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowCastingViewHolder holder, int position) {
        holder.bind(this.list.get(position));
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
