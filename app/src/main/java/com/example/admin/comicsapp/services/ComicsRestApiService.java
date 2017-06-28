package com.example.admin.comicsapp.services;

import com.example.admin.comicsapp.models.ComicsBaseJson;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Admin on 27/06/2017.
 */

public interface ComicsRestApiService {
    String SERVICE_ENDPOINT = "http://gateway.marvel.com/";

    @GET("v1/public/comics?ts=1&apikey=9486986a830f03f160b2b7979d0cfbd1&hash=aa7838a6b741852a6aab976109bcc53c")
    Observable<ComicsBaseJson> getComics();

}
