package com.gtecthrissur.round.fireballescape;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class PaddleOrange extends View {

    Bitmap paddle_orange;
    Rect paddle_orange_box;
    int paddle_orange_left;
    int paddle_orange_top;
    int paddle_orange_width;
    int paddle_orange_height;

    public PaddleOrange(Context context) {
        super(context);

        paddle_orange = BitmapFactory.decodeResource(getResources(), R.drawable.paddle_orange);

        paddle_orange_width = Screen.width / 4;
        paddle_orange_height = Screen.height / 16;
        paddle_orange_left = Screen.width - (Screen.width / 4);
        paddle_orange_top = Screen.height - (paddle_orange_height * 3);

        setBounds();
    }

    // set drawing area or bounds for blue paddle
    public void setBounds() {
        paddle_orange_box = new Rect(paddle_orange_left, paddle_orange_top, paddle_orange_left + paddle_orange_width, paddle_orange_top + paddle_orange_height);
    }

    // get left of orange paddle
    public int getPaddleOrangeLeft() {
        return paddle_orange_left;
    }

    // get top of orange paddle
    public int getPaddleOrangeTop() {
        return paddle_orange_top;
    }

    // get width of orange paddle
    public int getPaddleOrangeWidth() {
        return paddle_orange_width;
    }

    // move blue paddle to right, if possible
    public void moveRight() {
        if((paddle_orange_left + paddle_orange_width) < Screen.width) {
            paddle_orange_left += paddle_orange_width;
            setBounds();
        }
    }

    // move blue paddle to left, if possible
    public void moveLeft(int paddle_blue_right_side) {
        if(paddle_orange_left > paddle_blue_right_side) {
            paddle_orange_left -= paddle_orange_width;
            setBounds();
        }
    }

    // draw blue paddle on screen
    public void drawPaddleOrange(Canvas canvas) {
        canvas.drawBitmap(paddle_orange, null, paddle_orange_box, null);
    }
}
