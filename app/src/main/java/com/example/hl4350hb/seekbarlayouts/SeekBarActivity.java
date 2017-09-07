package com.example.hl4350hb.seekbarlayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends AppCompatActivity {

    SeekBar mSeekBar;
    TextView mSeekBarLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);
        mSeekBarLabel = (TextView) findViewById(R.id.seek_bar_value_label);

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
}
