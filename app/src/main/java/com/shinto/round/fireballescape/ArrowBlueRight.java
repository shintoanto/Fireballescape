package  com.gtecthrissur.round.fireballescape;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ArrowBlueRight extends View {

    Bitmap arrow_blue_right;
    Rect arrow_blue_right_box;
    int arrow_blue_right_left;
    int arrow_blue_right_top;
    int arrow_blue_right_width;
    int arrow_blue_right_height;

    public ArrowBlueRight(Context context) {
        super(context);

        arrow_blue_right = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_blue_right);

        arrow_blue_right_width = Screen.width / 8;
        arrow_blue_right_height = Screen.height / 16;
        arrow_blue_right_left = (Screen.width / 16) + arrow_blue_right_width + (Screen.width / 16);
        arrow_blue_right_top = Screen.height - arrow_blue_right_height - (arrow_blue_right_height / 2);

        arrow_blue_right_box = new Rect(arrow_blue_right_left, arrow_blue_right_top, arrow_blue_right_left + arrow_blue_right_width, arrow_blue_right_top + arrow_blue_right_height);
    }

    // check if arrow blue right has been hit by player
    public boolean hit(int x, int y) {
        if (x >= arrow_blue_right_left && x <= (arrow_blue_right_left + arrow_blue_right_width) &&
                y >= arrow_blue_right_top && y <= (arrow_blue_right_top + arrow_blue_right_height)) {
            return true;
        } else {
            return false;
        }
    }

    // draw arrow blue right on screen
    public void drawArrowBlueRight(Canvas canvas) {
        canvas.drawBitmap(arrow_blue_right, null, arrow_blue_right_box, null);
    }
}
