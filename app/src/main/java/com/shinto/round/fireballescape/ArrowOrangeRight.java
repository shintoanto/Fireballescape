package com.gtecthrissur.round.fireballescape;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ArrowOrangeRight extends View {

    Bitmap arrow_orange_right;
    Rect arrow_orange_right_box;
    int arrow_orange_right_left;
    int arrow_orange_right_top;
    int arrow_orange_right_width;
    int arrow_orange_right_height;

    public ArrowOrangeRight(Context context) {
        super(context);

        arrow_orange_right = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_orange_right);

        arrow_orange_right_width = Screen.width / 8;
        arrow_orange_right_height = Screen.height / 16;
        arrow_orange_right_left = Screen.width - arrow_orange_right_width - (Screen.width / 16);
        arrow_orange_right_top = Screen.height - arrow_orange_right_height - (arrow_orange_right_height / 2);

        arrow_orange_right_box = new Rect(arrow_orange_right_left, arrow_orange_right_top, arrow_orange_right_left + arrow_orange_right_width, arrow_orange_right_top + arrow_orange_right_height);
    }

    // check if arrow orange right has been hit by player
    public boolean hit(int x, int y) {
        if (x >= arrow_orange_right_left && x <= (arrow_orange_right_left + arrow_orange_right_width) &&
                y >= arrow_orange_right_top && y <= (arrow_orange_right_top + arrow_orange_right_height)) {
            return true;
        } else {
            return false;
        }
    }

    // draw arrow orange right on screen
    public void drawArrowOrangeRight(Canvas canvas) {
        canvas.drawBitmap(arrow_orange_right, null, arrow_orange_right_box, null);
    }
}
