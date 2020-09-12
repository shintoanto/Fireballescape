package com.gtecthrissur.round.fireballescape;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;

public class Sound extends View {

    MediaPlayer hit_tone;
    Context gamectx;

    public Sound(Context context) {
        super(context);

        gamectx = context;
    }

    // play sound for hitting ball on paddles
    public void playHitTone(int sound_id) {
        if(hit_tone != null) {
            hit_tone.stop();
            hit_tone.release();
        }

        if(sound_id == 1) hit_tone = MediaPlayer.create(gamectx, R.raw.arrow_hit);
        else if(sound_id == 2) hit_tone = MediaPlayer.create(gamectx, R.raw.explosion);

        try {
            hit_tone.start();
        } catch(Exception e) {
            //
        }
    }
}
