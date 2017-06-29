package com.example.admin.comicsapp.comics;

import com.example.admin.comicsapp.dagger.ActivityModule;

import dagger.Module;

@Module
public class ComicsModule extends ActivityModule {
    public ComicsModule(ComicsActivity activity) {
        super(activity);
    }
}
