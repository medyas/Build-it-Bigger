package com.udacity.gradle.builditbigger;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import ml.medyas.jokeactivity.JokesActivity;
import ml.medyas.jokeslibrary.JokeClass;
import ml.medyas.jokeslibrary.JokesClass;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.EndpointsAsyncTaskInterface {
    private JokesClass jokes;
    private Toolbar toolbar;
    private Dialog dialog ;
    private EndpointsAsyncTask task;


    @Nullable
    private SimpleIdlingResource mIdlingResource  = null;
    public SimpleIdlingResource getIdlingResource() {
        if(mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIdlingResource() != null) {
            getIdlingResource().setIdleState(true);
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Build it Bigger");

        jokes = new JokesClass();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
       /*
        Toast.makeText(this, jokes.getRandomJoke(), Toast.LENGTH_LONG).show();

        JokeListClass.JokeClass joke = jokes.getJoke();

        Intent intent = new Intent(this, JokesActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("jokeSetup", joke.getSetup());
        bundle.putString("jokePunchline", joke.getPunchline());
        intent.putExtras(bundle);
        startActivity(intent);
        */
        if (getIdlingResource() != null) {
            getIdlingResource().setIdleState(false);
        }

        if(task!=null) task.cancel(true);
        task = new EndpointsAsyncTask(this);
        task.execute();
        showDialog();
    }

    public void showDialog(){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.loading_dialog);

        dialog.show();

    }

    @Override
    public void onDataLoaded(String result) {

        Intent intent = new Intent(this, JokesActivity.class);
        Bundle bundle = new Bundle();

        if(result.equals("")) {
            bundle.putString("jokeSetup", "");
            bundle.putString("jokePunchline", "");
        } else {
            Gson gson = new GsonBuilder().create();
            JokeClass j = gson.fromJson(result, JokeClass.class);
            bundle.putString("jokeSetup", j.getSetup());
            bundle.putString("jokePunchline", j.getPunchline());
        }

        intent.putExtras(bundle);
        startActivity(intent);

        if (getIdlingResource() != null) {
            getIdlingResource().setIdleState(true);
        }

        dialog.dismiss();
    }
}

