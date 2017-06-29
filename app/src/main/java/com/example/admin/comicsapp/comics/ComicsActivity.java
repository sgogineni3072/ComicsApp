package com.example.admin.comicsapp.comics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.admin.comicsapp.R;
import com.example.admin.comicsapp.dagger.ActivityComponent;
import com.example.admin.comicsapp.dagger.BaseActivity;
import com.example.admin.comicsapp.dagger.InjectableApplication;
import com.example.admin.comicsapp.details.ComicDetailsActivity;
import com.example.admin.comicsapp.models.ComicsBaseJson;
import com.example.admin.comicsapp.models.Item;
import com.example.admin.comicsapp.models.Result;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

public class ComicsActivity extends BaseActivity {
    private final CompositeSubscription subscriptions = new CompositeSubscription();
    @Inject
    ComicsViewModel comicsViewModel;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Result> results;
    @BindView(R.id.content)
    RecyclerView comicsContent;
    @Inject
    ComicsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
        subscriptions.addAll(comicsViewModel.onFetchComics().subscribe(this::displayComics, this::displayErrorMessage));
        comicsContent.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        comicsContent.setLayoutManager(mLayoutManager);
        comicsContent.setAdapter(adapter);

        comicsContent.addOnItemTouchListener(
                new RecyclerItemClickListener(this, comicsContent ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Log.d("App", "onItemClick position: " + position);

                        Intent myIntent = new Intent(getApplicationContext(), ComicDetailsActivity.class);
                        myIntent.putExtra("TITLE", results.get(position).title);
                        myIntent.putExtra("DESC", results.get(position).description);
                        myIntent.putExtra("PAGE_COUNT", results.get(position).pageCount);
                        myIntent.putExtra("PRICE", "£" + results.get(position).prices.get(0).price);

                        String authors = null;
                        for (Item item : results.get(position).creators.items) {
                            authors = authors + item.name + ",";
                        }
                        myIntent.putExtra("AUTHORS", authors);

                        startActivity(myIntent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );

    }

    private void displayComics(ComicsBaseJson comics) {
        Log.i("ComicsService", "ComicsInfo Call successful");
        results = comics.data.results;
        adapter.setItems(comics.data.results);
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
