package com.gtecthrissur.round.fireballescape;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public class Pauser extends View {

    Bitmap pauser;
    Rect pauser_box;
    int pauser_left;
    int pauser_top;
    int pauser_width;
    int pauser_height;
    boolean paused;

    public Pauser(Context context) {
        super(context);

        pauser_width = Screen.width / 8;
        pauser_height = pauser_width;
        pauser_top = 0;
        pauser_left = 0;

        pauser_box = new Rect(pauser_left, pauser_top, pauser_left + pauser_width, pauser_top + pauser_height);

        paused = false;
    }

    // draw pauser button on screen
    public void drawPauserButton(Canvas canvas) {
        if(paused) {
            pauser = BitmapFactory.decodeResource(getResources(), R.drawable.play);
        } else {
            pauser = BitmapFactory.decodeResource(getResources(), R.drawable.stop);
        }

        canvas.drawBitmap(pauser, null, pauser_box, null);
    }

    // get status of pauser button
    public boolean gamePosed() {
        return paused;
    }

    public void toggleStatus() {
        if(paused) paused = false;
        else paused = true;
    }

    // check if user tap on the pauser button
    public boolean pauserButtonPressed(int x, int y) {
        if (x >= pauser_left && x <= pauser_left + pauser_width &&
                y >= pauser_top && y <= pauser_top + pauser_height) {
            return true;
        } else {
            return false;
        }
    }
}
