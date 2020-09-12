package com.gtecthrissur.round.fireballescape;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.Random;

public class FireBall extends View {

    Bitmap fireball_1;
    Bitmap fireball_2;
    Rect fireball_box;
    int fireball_left;
    int fireball_top;
    int fireball_width;
    int fireball_height;
    boolean framechange;
    int framecount;
    final int ACCELERATION = Screen.height / 100;
    final Random random = new Random();

    public FireBall(Context context) {
        super(context);

        fireball_1 = BitmapFactory.decodeResource(getResources(), R.drawable.fire_ball_1);
        fireball_2 = BitmapFactory.decodeResource(getResources(), R.drawable.fire_ball_2);
        fireball_width = Screen.width / 8;
        fireball_height = fireball_width * 2;

        framecount = 0;
        framechange = false;
    }

    // set bounds for fireball
    public void setBounds() {
        fireball_box = new Rect(fireball_left, fireball_top, fireball_left + fireball_width, fireball_top + fireball_height);
    }

    // set fireball start position ('column' ranges from 1 to 4)
    public void setStartPosition(int column_id) {
        int column_width;
        int half_column_width;

        column_id--;
        column_width = Screen.width / 4;
        half_column_width = column_width / 2;
        fireball_left = (column_id * column_width) + half_column_width - (fireball_width / 2);
        fireball_top = -fireball_height;

        setBounds();
    }

    // update firball position
    public void updatePosition() {
        fireball_top += ACCELERATION;
        setBounds();
    }

    // check if firball collide with blue paddle
    public boolean hitOnBluePaddle(int paddle_top, int blue_paddle_left, int blue_paddle_right) {
        if (fireball_top + fireball_height > paddle_top && fireball_left > blue_paddle_left &&
                fireball_left + fireball_width < blue_paddle_right) {
            return true;
        } else {
            return false;
        }
    }

    // check if fireball collide with orange paddle
    public boolean hitOnOrangePaddle(int paddle_top, int orange_paddle_left, int orange_paddle_right) {
        if (fireball_top + fireball_height > paddle_top && fireball_left > orange_paddle_left &&
                fireball_left + fireball_width < orange_paddle_right) {
            return true;
        } else {
            return false;
        }
    }

    // check if fireball go off-screen
    public boolean fallDown() {
        if (fireball_top > Screen.height) {
            return true;
        } else {
            return false;
        }
    }

    // draw fireball_1 on screen at updated position
    public void drawFireball(Canvas canvas) {
        if (framecount % 10 == 0) {
            framechange = (framechange) ? false : true;
        }

        if (framechange) canvas.drawBitmap(fireball_1, null, fireball_box, null);
        else canvas.drawBitmap(fireball_2, null, fireball_box, null);

        framecount++;
        if (framecount > 60) framecount = 0;
    }

    private int getColumnPosition(int previous) {
        if (previous == 0) return previous = random.nextInt(6) + 1;
        final int rnd = random.nextInt(6) + 1;
        return previous = (rnd < previous? rnd : rnd + 1);
    }

    public void setFireballColumn(int previous, FireBall fireBall) {
        int fireball_1_column;
        int fireball_2_column;
        int n = getColumnPosition(previous);

        switch (n) {
            case 1:
                fireball_1_column = 1;
                fireball_2_column = 2;
                break;
            case 2:
                fireball_1_column = 2;
                fireball_2_column = 3;
                break;
            case 3:
                fireball_1_column = 3;
                fireball_2_column = 4;
                break;
            case 4:
                fireball_1_column = 1;
                fireball_2_column = 3;
                break;
            case 5:
                fireball_1_column = 2;
                fireball_2_column = 4;
                break;
            case 6:
                fireball_1_column = 1;
                fireball_2_column = 4;
                break;
            default:
                fireball_1_column = 1;
                fireball_2_column = 4;
        }

        setStartPosition(fireball_1_column);
        fireBall.setStartPosition(fireball_2_column);
    }
}
