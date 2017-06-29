package com.example.admin.comicsapp.dagger;

import android.app.Application;

import com.example.admin.comicsapp.application.ApplicationComponent;
import com.example.admin.comicsapp.application.ApplicationModule;
import com.example.admin.comicsapp.application.DaggerApplicationComponent;
import com.example.admin.comicsapp.comics.ComicsActivity;
import com.example.admin.comicsapp.comics.ComicsComponent;
import com.example.admin.comicsapp.comics.ComicsModule;
import com.example.admin.comicsapp.details.ComicDetailsActivity;
import com.example.admin.comicsapp.details.ComicDetailsComponent;
import com.example.admin.comicsapp.details.ComicDetailsModule;

/**
 * Class that contains all of the logic for managing the dependency graph
 */
public abstract class InjectableApplication extends Application {
    protected ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ComicsComponent createComicsComponent(ComicsActivity comicsActivity) {
        return applicationComponent.plus(new ComicsModule(comicsActivity));
    }

    public ComicDetailsComponent createComicDetailsComponent(ComicDetailsActivity comicsDetailsActivity) {
        return applicationComponent.plus(new ComicDetailsModule(comicsDetailsActivity));
    }
}
