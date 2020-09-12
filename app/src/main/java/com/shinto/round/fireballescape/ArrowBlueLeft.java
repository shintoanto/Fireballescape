package com.gtecthrissur.round.fireballescape;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ArrowBlueLeft extends View {

    Bitmap arrow_blue_left;
    Rect arrow_blue_left_box;
    int arrow_blue_left_left;
    int arrow_blue_left_top;
    int arrow_blue_left_width;
    int arrow_blue_left_height;
    public ArrowBlueLeft(Context context) {
        super(context);

        arrow_blue_left = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_blue_left);

        arrow_blue_left_width = Screen.width / 8;
        arrow_blue_left_height = Screen.height / 16;
        arrow_blue_left_left = Screen.width / 16;
        arrow_blue_left_top = Screen.height - arrow_blue_left_height - (arrow_blue_left_height / 2);

        arrow_blue_left_box = new Rect(arrow_blue_left_left, arrow_blue_left_top, arrow_blue_left_left + arrow_blue_left_width, arrow_blue_left_top + arrow_blue_left_height);
    }

    // check if arrow blue left has been hit by player
    public boolean hit(int x, int y) {
        if (x >= arrow_blue_left_left && x <= (arrow_blue_left_left + arrow_blue_left_width) &&
                y >= arrow_blue_left_top && y <= (arrow_blue_left_top + arrow_blue_left_height)) {
            return true;
        } else {
            return false;
        }
    }

    // draw arrow blue left on screen
    public void drawArrowBlueLeft(Canvas canvas) {
        canvas.drawBitmap(arrow_blue_left, null, arrow_blue_left_box, null);
    }
}
