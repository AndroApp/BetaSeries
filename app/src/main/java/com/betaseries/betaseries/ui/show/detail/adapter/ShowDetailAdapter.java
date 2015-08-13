package com.betaseries.betaseries.ui.show.detail.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.show.detail.view.ShowDetailViewHolder;


/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowDetailAdapter extends RecyclerView.Adapter<ShowDetailViewHolder> {

    protected Show show;

    public void setShow(Show show){
        if(show != null) {
            this.show = show;
            this.notifyDataSetChanged();
        }
    }

    @Override
    public ShowDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_show_detail, parent, false);
        return new ShowDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowDetailViewHolder holder, int position) {
        holder.bind(this.show);
    }

    @Override
    public int getItemCount() {
        if(this.show == null)
            return 0;
        else
            return 1;
    }
}
