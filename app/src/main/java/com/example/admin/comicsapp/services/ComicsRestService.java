package com.example.admin.comicsapp.services;

import com.example.admin.comicsapp.models.ComicsBaseJson;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Admin on 27/06/2017.
 */

public class ComicsRestService {
    private final ComicsRestApiService apiService;

    public ComicsRestService(ComicsRestApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<ComicsBaseJson> getComicsInfo() {
        return apiService.getComics()
                .compose(manageThreads());
    }

    /**
     * Ensures it is run in the background but emitted in the foreground.
     */
    private <T> Observable.Transformer<T, T> manageThreads() {
        return in -> in.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());

    }
}
