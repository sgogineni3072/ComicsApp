package com.example.admin.comicsapp.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.admin.comicsapp.R;
import com.example.admin.comicsapp.dagger.ActivityComponent;
import com.example.admin.comicsapp.dagger.BaseActivity;
import com.example.admin.comicsapp.dagger.InjectableApplication;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicDetailsActivity extends BaseActivity {
    @BindView(R.id.valTitle)
    TextView title;
    @BindView(R.id.valDesc)
    TextView desc;
    @BindView(R.id.valPageCount)
    TextView pageCount;
    @BindView(R.id.valPrice)
    TextView price;
    @BindView(R.id.valAuthors)
    TextView authors;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_details);
        ButterKnife.bind(this, this);

        if(getIntent() != null) {
            title.setText(getIntent().getStringExtra("TITLE"));
            desc.setText(getIntent().getStringExtra("DESC"));
            pageCount.setText(getIntent().getStringExtra("PAGE_COUNT"));
            price.setText(getIntent().getStringExtra("PRICE"));
            authors.setText(getIntent().getStringExtra("AUTHORS"));
        }
    }

    @Override
    protected ActivityComponent createActivityComponent(InjectableApplication applicationContext) {
        return applicationContext.createComicDetailsComponent(this);
    }

    @Override
    protected void satisfyDependencies(ActivityComponent component) {
        ((ComicDetailsComponent) component).inject(this);
    }
}
