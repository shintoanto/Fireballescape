package com.gtecthrissur.round.fireballescape;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public class Screen extends View {

    public static int width;
    public static int height;
    Rect background;
    Bitmap game_bg;

    public Screen(Context context) {
        super(context);

        game_bg = BitmapFactory.decodeResource(getResources(), R.drawable.game_bg);
        background = new Rect(0, 0, Screen.width, Screen.height);
    }

    // draw screen background
    public void drawBackground(Canvas canvas) {
        canvas.drawBitmap(game_bg, null, background, null);
    }
}
