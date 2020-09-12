package  com.gtecthrissur.round.fireballescape;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ArrowOrangeLeft extends View {

    Bitmap arrow_orange_left;
    Rect arrow_orange_left_box;
    int arrow_orange_left_left;
    int arrow_orange_left_top;
    int arrow_orange_left_width;
    int arrow_orange_left_height;

    public ArrowOrangeLeft(Context context) {
        super(context);

        arrow_orange_left = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_orange_left);

        arrow_orange_left_width = Screen.width / 8;
        arrow_orange_left_height = Screen.height / 16;
        arrow_orange_left_left = Screen.width - (Screen.width / 4) - arrow_orange_left_width;
        arrow_orange_left_top = Screen.height - arrow_orange_left_height - (arrow_orange_left_height / 2);

        arrow_orange_left_box = new Rect(arrow_orange_left_left, arrow_orange_left_top, arrow_orange_left_left + arrow_orange_left_width, arrow_orange_left_top + arrow_orange_left_height);
    }

    // check if arrow orange left has been hit by player
    public boolean hit(int x, int y) {
        if (x >= arrow_orange_left_left && x <= (arrow_orange_left_left + arrow_orange_left_width) &&
                y >= arrow_orange_left_top && y <= (arrow_orange_left_top + arrow_orange_left_height)) {
            return true;
        } else {
            return false;
        }
    }

    // draw arrow orange left on screen
    public void drawArrowOrangeLeft(Canvas canvas) {
        canvas.drawBitmap(arrow_orange_left, null, arrow_orange_left_box, null);
    }
}
