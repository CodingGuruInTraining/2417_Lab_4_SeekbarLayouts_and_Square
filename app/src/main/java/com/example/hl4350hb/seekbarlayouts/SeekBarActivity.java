package com.example.hl4350hb.seekbarlayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity {

    SeekBar mSeekBar;
    TextView mSeekBarLabel;
    public static final String EXTRA_SQUARE_SIZE = "com.example.mark.tapthesquare.squaresize";
    private static final int SQUARE_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);
        mSeekBarLabel = (TextView) findViewById(R.id.seek_bar_value_label);

        Button showSquare = (Button) findViewById(R.id.display_square_button);

        showSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create new Intent, specify launching Activity and target Activity
                Intent launchSquareActivity = new Intent(SeekBarActivity.this, SquareActivity.class);
                // Add data to the Intent
                launchSquareActivity.putExtra(EXTRA_SQUARE_SIZE, mSeekBar.getProgress());
                // Launch new Activity using the Intent
                startActivityForResult(launchSquareActivity, SQUARE_REQUEST_CODE);
            }
        });

        // Set initial value
        mSeekBarLabel.setText(getString(R.string.seekbar_progress, mSeekBar.getProgress()));

        addSeekBarListener();
    }

    private void addSeekBarListener() {
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mSeekBarLabel.setText(getString(R.string.seekbar_progress, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Required to make, but don't need to change
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Ditto
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Need to check what request ended up with this result
        if (requestCode == SQUARE_REQUEST_CODE & resultCode == RESULT_OK) {
            // Get the data from the Intent
            boolean tappedSquare = data.getBooleanExtra(SquareActivity.EXTRA_INSIDE_SQUARE, false);

            // Indicate result to user with a Toast
            if (tappedSquare) {
                Toast.makeText(this, "You tapped the square!", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "Sorry, you missed the square", Toast.LENGTH_LONG).show();
            }
        }

        if (resultCode == RESULT_CANCELED) {
            // If the user pressed the back button
            Toast.makeText(this, "Y u press BACK button?!", Toast.LENGTH_LONG).show();
        }
    }
}
