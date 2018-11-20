package com.udacity.gradle.builditbigger;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import ml.medyas.jokeactivity.JokesActivity;
import ml.medyas.jokeslibrary.JokeClass;
import ml.medyas.jokeslibrary.JokeListClass;
import ml.medyas.jokeslibrary.JokesClass;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.EndpointsAsyncTaskInterface {
    public static final String JOKE_SETUP = "jokeSetup";
    public static final String JOKE_PUNCHLINE = "jokePunchline";
    private Dialog dialog;
    private EndpointsAsyncTask task;

    private InterstitialAd mInterstitialAd;
    private AdView mAdView;


    @Nullable
    private SimpleIdlingResource mIdlingResource = null;

    public SimpleIdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Build it Bigger");
        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if (getIdlingResource() != null) {
            getIdlingResource().setIdleState(false);
        }

        if (task != null) task.cancel(true);
        task = new EndpointsAsyncTask(this);
        task.execute();
        showDialog();
    }

    public void showDialog() {
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

        if (result.equals("")) {
            Toast.makeText(this, R.string.error_msg, Toast.LENGTH_SHORT).show();
            return;
        }
        Gson gson = new GsonBuilder().create();
        JokeClass j = gson.fromJson(result, JokeClass.class);
        bundle.putString(JOKE_SETUP, j.getSetup());
        bundle.putString(JOKE_PUNCHLINE, j.getPunchline());

        intent.putExtras(bundle);
        startActivity(intent);

        if (getIdlingResource() != null) {
            getIdlingResource().setIdleState(true);
        }

        dialog.dismiss();

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (task != null) {
            task.cancel(true);
        }
    }
}
