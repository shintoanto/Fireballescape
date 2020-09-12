package com.gtecthrissur.round.fireballescape;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class PaddleBlue extends View {

    Bitmap paddle_blue;
    Rect paddle_blue_box;
    int paddle_blue_left;
    int paddle_blue_top;
    int paddle_blue_width;
    int paddle_blue_height;

    public PaddleBlue(Context context) {
        super(context);

        paddle_blue = BitmapFactory.decodeResource(getResources(), R.drawable.paddle_blue);

        paddle_blue_width = Screen.width / 4;
        paddle_blue_height = Screen.height / 16;
        paddle_blue_left = 0;
        paddle_blue_top = Screen.height - (paddle_blue_height * 3); //- (paddle_blue_height / 2);

        setBounds();
    }

    // get left of blue paddle
    public int getPaddleBlueLeft() {
        return paddle_blue_left;
    }

    // get top of blue paddle
    public int getPaddleBlueTop() {
        return paddle_blue_top;
    }

    // get width of blue paddle
    public int getPaddleBlueWidth() {
        return paddle_blue_width;
    }

    // set drawing area or bounds for blue paddle
    public void setBounds() {
        paddle_blue_box = new Rect(paddle_blue_left, paddle_blue_top, paddle_blue_left + paddle_blue_width, paddle_blue_top + paddle_blue_height);
    }

    // move blue paddle to right, if possible
    public void moveRight(int paddle_orange_left) {
        if((paddle_blue_left + paddle_blue_width) < paddle_orange_left) {
            paddle_blue_left += paddle_blue_width;
            setBounds();
        }
    }

    // move blue paddle to left, if possible
    public void moveLeft() {
        if(paddle_blue_left > 0) {
            paddle_blue_left -= paddle_blue_width;
            setBounds();
        }
    }

    // draw blue paddle on screen
    public void drawPaddleBlue(Canvas canvas) {
        canvas.drawBitmap(paddle_blue, null, paddle_blue_box, null);
    }
}
