package com.example.admin.comicsapp.comics;

import com.example.admin.comicsapp.dagger.ActivityComponent;
import com.example.admin.comicsapp.dagger.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by Admin on 28/06/2017.
 */

@ActivityScope
@Subcomponent(modules = ComicsModule.class)
public interface ComicsComponent extends ActivityComponent {
    void inject(ComicsActivity comicsActivity);
}
