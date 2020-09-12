package com.gtecthrissur.round.fireballescape;

import android.content.Context;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class GameController extends View {

    Context gamecontext;
    Screen screen;
    ArrowBlueLeft arrowBlueLeft;
    ArrowBlueRight arrowBlueRight;
    ArrowOrangeLeft arrowOrangeLeft;
    ArrowOrangeRight arrowOrangeRight;
    PaddleBlue paddleBlue;
    PaddleOrange paddleOrange;
    FireBall fireBall_1;
    FireBall fireBall_2;
    CloseButton closebutton;
    Pauser pauser;
    Sound sound;
    long start_time;
    long end_time;
    long game_duration;
    boolean game_running;
    boolean quit_game;
    int previous;
    final int ARROWHIT  = 1;
    final int EXPLOSION = 2;

    public GameController(Context context) {
        super(context);

        gamecontext = context;
        game_running = true;
        quit_game = false;
        start_time = System.currentTimeMillis();

        createGameObjects();
    }

    // create game objects
    private void createGameObjects() {
        screen = new Screen(gamecontext);
        arrowBlueLeft = new ArrowBlueLeft(gamecontext);
        arrowBlueRight = new ArrowBlueRight(gamecontext);
        arrowOrangeLeft = new ArrowOrangeLeft(gamecontext);
        arrowOrangeRight = new ArrowOrangeRight(gamecontext);
        paddleBlue = new PaddleBlue(gamecontext);
        paddleOrange = new PaddleOrange(gamecontext);
        fireBall_1 = new FireBall(gamecontext);
        fireBall_2 = new FireBall(gamecontext);
        fireBall_1.setStartPosition(1);
        fireBall_2.setStartPosition(4);
        closebutton = new CloseButton(gamecontext);
        pauser = new Pauser(gamecontext);
        sound = new Sound(gamecontext);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        screen.drawBackground(canvas);

        if (game_running) {
            fireBall_1.drawFireball(canvas);
            fireBall_2.drawFireball(canvas);

            arrowBlueLeft.drawArrowBlueLeft(canvas);
            arrowBlueRight.drawArrowBlueRight(canvas);
            arrowOrangeLeft.drawArrowOrangeLeft(canvas);
            arrowOrangeRight.drawArrowOrangeRight(canvas);

            paddleBlue.drawPaddleBlue(canvas);
            paddleOrange.drawPaddleOrange(canvas);

            closebutton.drawCloseButton(canvas);
            pauser.drawPauserButton(canvas);

            if(!pauser.gamePosed()) {
                fireBall_1.updatePosition();
                fireBall_2.updatePosition();

                if (fireBall_1.hitOnBluePaddle(paddleBlue.getPaddleBlueTop(), paddleBlue.getPaddleBlueLeft(),
                        paddleBlue.getPaddleBlueLeft() + paddleBlue.getPaddleBlueWidth()) ||
                        fireBall_1.hitOnOrangePaddle(paddleOrange.getPaddleOrangeTop(), paddleOrange.getPaddleOrangeLeft(),
                                paddleOrange.getPaddleOrangeLeft() + paddleOrange.getPaddleOrangeWidth()) ||
                        fireBall_2.hitOnBluePaddle(paddleBlue.getPaddleBlueTop(), paddleBlue.getPaddleBlueLeft(),
                                paddleBlue.getPaddleBlueLeft() + paddleBlue.getPaddleBlueWidth()) ||
                        fireBall_2.hitOnOrangePaddle(paddleOrange.getPaddleOrangeTop(), paddleOrange.getPaddleOrangeLeft(),
                                paddleOrange.getPaddleOrangeLeft() + paddleOrange.getPaddleOrangeWidth())) {

                    game_running = false;
                    sound.playHitTone(EXPLOSION);
                }

                if (fireBall_1.fallDown() || fireBall_2.fallDown()) {
                    fireBall_1.setFireballColumn(previous, fireBall_2);
                }

                if (quit_game) ((Activity) gamecontext).finish();
            }

            invalidate(); // call the method onDraw() again and again
        } else {
            end_time = System.currentTimeMillis();
            game_duration = (end_time - start_time) / 1000;

            Intent i = new Intent("com.gtecthrissur.round.fireballescape.GameResult");
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("duration", game_duration);
            gamecontext.startActivity(i);

            ((Activity) gamecontext).finish();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float xpos = event.getX();
        float ypos = event.getY();

        if(!pauser.gamePosed()) {
            if (arrowBlueRight.hit((int) xpos, (int) ypos)) {
                sound.playHitTone(ARROWHIT);
                paddleBlue.moveRight(paddleOrange.getPaddleOrangeLeft());
            } else if (arrowBlueLeft.hit((int) xpos, (int) ypos)) {
                sound.playHitTone(ARROWHIT);
                paddleBlue.moveLeft();
            }

            if (arrowOrangeRight.hit((int) xpos, (int) ypos)) {
                sound.playHitTone(ARROWHIT);
                paddleOrange.moveRight();
            } else if (arrowOrangeLeft.hit((int) xpos, (int) ypos)) {
                sound.playHitTone(ARROWHIT);
                paddleOrange.moveLeft(paddleBlue.getPaddleBlueLeft() + paddleBlue.getPaddleBlueWidth());
            }
        }

        if(pauser.pauserButtonPressed((int)xpos, (int)ypos)) {
            pauser.toggleStatus();
        }

        if(closebutton.closeButtonPressed((int)xpos, (int)ypos)) {
            quit_game = true;
        }

        return super.onTouchEvent(event);
    }
}
