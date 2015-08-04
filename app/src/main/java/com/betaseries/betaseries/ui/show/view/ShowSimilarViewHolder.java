package com.betaseries.betaseries.ui.show.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.ShowSimilar;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowSimilarViewHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.image)
    ImageView imageView;

    @Bind(R.id.title)
    TextView title;

    public ShowSimilarViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(ShowSimilar show){
        this.title.setText(show.getShowTitle());
        Picasso.with(itemView.getContext()).load(show.getUrlBanner()).fit().centerCrop().into(imageView);
    }
}
