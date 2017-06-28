package com.example.admin.comicsapp.application;

import com.example.admin.comicsapp.dagger.InjectableApplication;

/**
 * Created by Admin on 28/06/2017.
 */

public class ComicsApplication extends InjectableApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent.inject(this);
    }
}
