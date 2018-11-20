package ml.medyas.jokeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class JokesActivity extends AppCompatActivity {

    private String jokeSetup = "";
    private String jokePunchline = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setTitle("Funny Jokes !");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey("jokeSetup") && getIntent().getExtras().containsKey("jokePunchline") ) {
                jokeSetup = getIntent().getExtras().getString("jokeSetup");
                jokePunchline = getIntent().getExtras().getString("jokePunchline");
            }
        }

        TextView textSetup = findViewById(R.id.text_setup);
        TextView textPunchline = findViewById(R.id.text_punchline);

        textSetup.setText(jokeSetup);
        textPunchline.setText(jokePunchline);
    }
}
