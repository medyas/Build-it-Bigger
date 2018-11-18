package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

import ml.medyas.jokeactivity.JokesActivity;
import ml.medyas.jokeslibrary.JokeListClass;
import ml.medyas.jokeslibrary.JokesClass;


public class MainActivity extends AppCompatActivity {
    private JokesClass jokes;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Build it Bigger");

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

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
       // Toast.makeText(this, jokes.getRandomJoke(), Toast.LENGTH_LONG).show();
        JokeListClass.JokeClass joke = jokes.getJoke();

        Intent intent = new Intent(this, JokesActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("jokeSetup", joke.getSetup());
        bundle.putString("jokePunchline", joke.getPunchline());
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
