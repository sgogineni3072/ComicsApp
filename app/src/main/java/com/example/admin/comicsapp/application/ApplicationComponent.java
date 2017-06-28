package com.example.admin.comicsapp.application;

import com.example.admin.comicsapp.comics.ComicsComponent;
import com.example.admin.comicsapp.comics.ComicsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Admin on 28/06/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(ComicsApplication injected);

    ComicsComponent plus(ComicsModule comicsModule);
}
