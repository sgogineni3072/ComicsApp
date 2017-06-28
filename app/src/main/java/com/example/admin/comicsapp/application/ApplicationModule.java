package com.example.admin.comicsapp.application;

/**
 * Created by Admin on 28/06/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.example.admin.comicsapp.dagger.InjectableApplication;
import com.example.admin.comicsapp.services.ComicsRestApiService;
import com.example.admin.comicsapp.services.ComicsRestService;
import com.example.admin.comicsapp.services.ServiceFactory;

import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * For providing the singletons at application level.
 */
@Module
public class ApplicationModule {
    InjectableApplication application;

    public ApplicationModule(InjectableApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Context providesApplicationContext() {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    InjectableApplication providesApplication() {
        return application;
    }

    @Singleton
    @Provides
    Resources provideResources() {
        return application.getResources();
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences() {
        return application.getSharedPreferences("Application", Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    @Named("IO")
    Scheduler provideIoScheduler() {
        return Schedulers.from(Executors.newSingleThreadExecutor());
    }

    @Provides
    @Named("UI")
    Scheduler provideAndroidUiScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Singleton
    @Provides
    static ComicsRestApiService provideComicsRestApiService() {
        return ServiceFactory.createRetrofitService(ComicsRestApiService.class, ComicsRestApiService.SERVICE_ENDPOINT);
    }

    @Singleton
    @Provides
    ComicsRestService provideIGTRestService(ComicsRestApiService apiService) {
        return new ComicsRestService(apiService);
    }
}
