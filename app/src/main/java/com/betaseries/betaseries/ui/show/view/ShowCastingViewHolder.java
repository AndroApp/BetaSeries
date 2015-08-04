package com.betaseries.betaseries.ui.show.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Character;
import com.squareup.picasso.Picasso;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class ShowCastingViewHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.image)
    ImageView imageView;

    @Bind(R.id.title)
    TextView title;

    @Bind(R.id.subtitle)
    TextView subtitle;

    public ShowCastingViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Character character){
        this.title.setText(character.getActor());
        this.subtitle.setText(character.getName());

        Picasso.with(itemView.getContext()).load(character.getPicture()).fit().centerCrop().into(imageView);
    }
}
