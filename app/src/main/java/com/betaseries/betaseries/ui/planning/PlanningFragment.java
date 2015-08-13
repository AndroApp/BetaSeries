package com.betaseries.betaseries.ui.planning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betaseries.betaseries.R;
import com.betaseries.betaseries.ui.AbstractFragment;

/**
 * Created by florentchampigny on 13/08/15.
 */
public class PlanningFragment extends AbstractFragment{

    public static PlanningFragment newInstance(){
        return new PlanningFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_planning, container, false);
    }

}
