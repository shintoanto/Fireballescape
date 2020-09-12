package com.gtecthrissur.round.fireballescape;

import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class GameResult extends Activity {

    long duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove application title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the view to fill entire screen area
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_gameend);

        duration = getIntent().getLongExtra("duration", 0);

        TextView lblDuration = (TextView) findViewById(R.id.lblDuration);
        lblDuration.setText(duration + " seconds");
    }

    public void exitGame(View v) {
        finish();
    }
}
