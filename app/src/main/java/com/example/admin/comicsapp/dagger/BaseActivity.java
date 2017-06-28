package com.example.admin.comicsapp.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Admin on 28/06/2017.
 */

/**
 * Base Activity that is used to help ensure the correct workflow is followed for creating the
 * Dagger DI graph
 */
public abstract class BaseActivity extends AppCompatActivity {
    private ActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        component = createActivityComponent((InjectableApplication) getApplicationContext());
        satisfyDependencies(component);
    }

    /**
     * Create the Activity's component. This needs to be created by the Activity itself as creating
     * it in this parent class would mean the Activity's dependencies would not be visible.
     *
     * @param applicationContext The context of the application which contains the dependency graph
     * @return The new Activity component that will live for the lifespan of the Activity
     */
    protected abstract ActivityComponent createActivityComponent(InjectableApplication applicationContext);

    /**
     * Call inject on all the classes which require fields injection
     *
     * @param component The component that was created using
     */
    protected abstract void satisfyDependencies(ActivityComponent component);

    @Override
    protected void onDestroy() {
        component = null;
        super.onDestroy();
    }

}

