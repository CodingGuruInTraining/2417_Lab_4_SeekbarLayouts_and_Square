package com.example.hl4350hb.seekbarlayouts;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SquareActivity extends AppCompatActivity {

    public static final String EXTRA_INSIDE_SQUARE = "com.example.mark.tapthesquare.inside_square";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        // Get a reference to the Intent that launched this Activity
        Intent launchIntent = getIntent();

        // Gets the Extra that was added to the Intent in SeekBarActivity
        int squareSize = launchIntent.getIntExtra(SeekBarActivity.EXTRA_SQUARE_SIZE, 100);

        // Get a reference to ImageView and draw a square in it
        ImageView squareView = (ImageView) findViewById(R.id.square);

        ShapeDrawable square = new ShapeDrawable(new RectShape());
        square.setIntrinsicHeight(squareSize);
        square.setIntrinsicWidth(squareSize);

        square.getPaint().setColor(Color.GREEN);

        squareView.setImageDrawable(square);

        squareView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to carry data back to launching Activity
                Intent resultIntent = new Intent();
                // Add value true as an Extra
                resultIntent.putExtra(EXTRA_INSIDE_SQUARE, true);
                // Set the result to be OK, and also provide the Intent
                setResult(RESULT_OK, resultIntent);
                // Close this Activity
                finish();
            }
        });

        View mainView = findViewById(android.R.id.content);
        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_INSIDE_SQUARE, false);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
