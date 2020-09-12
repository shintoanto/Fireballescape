package com.gtecthrissur.round.fireballescape;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove application title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the view to fill entire screen area
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // get screen width and height in pixels
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size); // set android:minSdkVersion="13"
        Screen.width = size.x;
        Screen.height = size.y;

        setContentView(R.layout.activity_main);
    }

    public void startGame(View v) {
        Intent i = new Intent("com.gtecthrissur.round.GameLoader");
        startActivity(i);
        //finish();
    }

    public void exitGame(View v) {
        finish();
    }
}
