package com.example.admin.comicsapp.comics;

import com.example.admin.comicsapp.models.ComicsBaseJson;
import com.example.admin.comicsapp.services.ComicsRestService;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Admin on 28/06/2017.
 */

public class ComicsViewModel {
    private final ComicsRestService service;

    @Inject
    public ComicsViewModel(ComicsRestService service) {
        this.service = service;
    }

    public Observable<ComicsBaseJson> onFetchComics() {
        return service.getComicsInfo();
    }
}
