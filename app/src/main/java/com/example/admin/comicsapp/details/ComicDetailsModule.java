package com.example.admin.comicsapp.details;

import com.example.admin.comicsapp.dagger.ActivityModule;

import dagger.Module;

@Module
public class ComicDetailsModule extends ActivityModule {
    public ComicDetailsModule(ComicDetailsActivity activity) {
        super(activity);
    }
}
