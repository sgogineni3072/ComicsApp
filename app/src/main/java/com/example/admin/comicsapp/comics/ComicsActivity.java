package com.example.admin.comicsapp.comics;

import android.os.Bundle;
import android.util.Log;

import com.example.admin.comicsapp.R;
import com.example.admin.comicsapp.dagger.ActivityComponent;
import com.example.admin.comicsapp.dagger.BaseActivity;
import com.example.admin.comicsapp.dagger.InjectableApplication;
import com.example.admin.comicsapp.models.ComicsBaseJson;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

public class ComicsActivity extends BaseActivity {
    private final CompositeSubscription subscriptions = new CompositeSubscription();
    @Inject
    ComicsViewModel comicsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subscriptions.addAll(
                comicsViewModel.onFetchComics().subscribe(this::displayComics, this::displayErrorMessage));
    }

    private void displayComics(ComicsBaseJson comics) {
        Log.i("ComicsService", "ComicsInfo Call successful");
    }

    private void displayErrorMessage(Throwable error) {
        Log.e("ComicsService", error.getMessage());
    }

    @Override
    protected void onDestroy() {
        subscriptions.unsubscribe();
        super.onDestroy();
    }

    @Override
    protected ActivityComponent createActivityComponent(InjectableApplication applicationContext) {
        return applicationContext.createComicsComponent(this);
    }

    @Override
    protected void satisfyDependencies(ActivityComponent component) {
        ((ComicsComponent) component).inject(this);
    }

}
