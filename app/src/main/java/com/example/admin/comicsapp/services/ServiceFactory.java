package com.example.admin.comicsapp.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Admin on 27/06/2017.
 */
public class ServiceFactory {

    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        T service = retrofit.create(clazz);

        return service;
    }
}
