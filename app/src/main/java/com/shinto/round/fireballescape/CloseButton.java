package  com.gtecthrissur.round.fireballescape;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public class CloseButton extends View {

    Bitmap closebutton;
    Rect closebutton_box;
    int closebutton_left;
    int closebutton_top;
    int closebutton_width;
    int closebutton_height;

    public CloseButton(Context context) {
        super(context);

        closebutton = BitmapFactory.decodeResource(getResources(), R.drawable.close);
        closebutton_width = Screen.width / 8;
        closebutton_height = closebutton_width;
        closebutton_top = 0;
        closebutton_left = Screen.width - closebutton_width;

        closebutton_box = new Rect(closebutton_left, closebutton_top, closebutton_left + closebutton_width, closebutton_top + closebutton_height);
    }

    // draw fireball_1 on screen at updated position
    public void drawCloseButton(Canvas canvas) {
        canvas.drawBitmap(closebutton, null, closebutton_box, null);
    }

    // get left position of close button
    public int getCloseButtonLeft() {
        return closebutton_left;
    }

    // get top position of close button
    public int getCloseButtonTop() {
        return closebutton_top;
    }

    // get right position of close button
    public int getCloseButtonRight() {
        return closebutton_left + closebutton_width;
    }

    // get bottom position of close button
    public int getCloseButtonBottom() {
        return closebutton_top + closebutton_height;
    }

    // check if user tap on the close button
    public boolean closeButtonPressed(int x, int y) {
        if (x >= closebutton_left && x <= closebutton_left + closebutton_width &&
                y >= closebutton_top && y <= closebutton_top + closebutton_height) {
            return true;
        } else {
            return false;
        }
    }
}
