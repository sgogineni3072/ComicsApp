package com.example.admin.comicsapp.comics;

import com.example.admin.comicsapp.dagger.ActivityModule;

import dagger.Module;

/**
 * Created by Admin on 28/06/2017.
 */
@Module
public class ComicsModule extends ActivityModule {
    public ComicsModule(ComicsActivity activity) {
        super(activity);
    }
}
