package com.example.admin.comicsapp.dagger;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Base module for Activities Created by androber on 10/10/2016.
 */
@Module
public class ActivityModule {
    private BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    @SuppressWarnings("WeakerAccess")
    public Activity provideActivity() {
        return activity;
    }

}
