package com.example.faridfedora.sheypoortest.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.faridfedora.sheypoortest.MovieModel;
import com.example.faridfedora.sheypoortest.R;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    MovieModel movieModel;
    TextView summaryTextView;
    ImageView collapsingImageView;
    TextView nameTextView;
    TextView infoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //back arrow on toolbar:
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });



        summaryTextView= (TextView) findViewById(R.id.summaryTextView);
        nameTextView= (TextView) findViewById(R.id.nameTextView);
        infoTextView= (TextView) findViewById(R.id.infoTextView);
        collapsingImageView= (ImageView) findViewById(R.id.collapsingImageView);
//        changeStatusBarColor();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initializeViews();


    }


    /**
     * retrieves movie data from parcellable and sets it's details to views
     * */
    private void initializeViews() {
        movieModel=getIntent().getExtras().getParcelable("movieModel");
//        Toast.makeText(this, ""+movieModel.getImage().get("medium"), Toast.LENGTH_SHORT).show();
        summaryTextView.setText(Html.fromHtml(movieModel.getSummary()));
        nameTextView.setText(movieModel.getName());
        String info = movieModel.getPremiered() + " * " + movieModel.getRuntime() + " min * " + getIntent().getStringExtra("rating")+"/10";
        infoTextView.setText(info);
        Picasso.with(getApplicationContext()).load(getIntent().getStringExtra("originalImage")).into(collapsingImageView);
    }


    private void changeStatusBarColor() {
        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();

            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#1568B8"));
        }
    }








}
