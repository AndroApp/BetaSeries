package com.betaseries.betaseries.ui.show.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.model.Show;
import com.betaseries.betaseries.ui.AbstractActivity;
import com.betaseries.betaseries.ui.show.detail.fragment.ShowCastingFragment;
import com.betaseries.betaseries.ui.show.detail.fragment.ShowDetailFragment;
import com.betaseries.betaseries.ui.show.detail.fragment.ShowEpisodesFragment;
import com.betaseries.betaseries.ui.show.detail.fragment.ShowSimilarFragment;
import com.github.florent37.materialviewpager.MaterialViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 04/08/15.
 */
public class ShowDetailActivity extends AbstractActivity {

    public static final String SHOW = "SHOW";

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.materialViewPager)
    MaterialViewPager materialViewPager;

    @Bind(R.id.header_title)
    TextView headerTitle;

    protected Show show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_serie);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        this.setTitle("");

        this.show = (Show) getIntent().getExtras().getSerializable(SHOW);

        this.headerTitle.setText(show.getTitle());

        materialViewPager.setImageUrl(show.getUrlBanner(), 0);

        materialViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return ShowDetailFragment.newInstance("" + show.getId());
                    case 1:
                        return ShowEpisodesFragment.newInstance("" + show.getId());
                    case 2:
                        return ShowCastingFragment.newInstance("" + show.getId());
                    case 3:
                        return ShowSimilarFragment.newInstance("" + show.getId());
                }
                return null;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.show_detail).toUpperCase();
                    case 1:
                        return getString(R.string.show_episodes).toUpperCase();
                    case 2:
                        return getString(R.string.show_casting).toUpperCase();
                    case 3:
                        return getString(R.string.show_similars).toUpperCase();
                }
                return super.getPageTitle(position);
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        materialViewPager.getViewPager().setOffscreenPageLimit(materialViewPager.getViewPager().getAdapter().getCount());
        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());
    }
}

