package com.example.admin.comicsapp.details;

import com.example.admin.comicsapp.dagger.ActivityComponent;
import com.example.admin.comicsapp.dagger.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ComicDetailsModule.class)
public interface ComicDetailsComponent extends ActivityComponent {
    void inject(ComicDetailsActivity comicDetailsActivity);
}
