package com.betaseries.betaseries.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by florentchampigny on 31/07/15.
 */
@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    public static ContextModule with(Context context) {
        return new ContextModule(context);
    }

    @Provides
    public Context provideContext() {
        return context;
    }
}
