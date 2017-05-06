package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * Created by seanduffy on 5/6/17.
 */

public class AppHelper {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
    private Context mContext;

    private MediaPlayer.OnCompletionListener mCompletionListener =
            new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    clearMediaPlayer();
                }
            };


    public AppHelper(Context appContext) {
        // Assign member variables
        mContext = appContext;
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            public void onAudioFocusChange(int focusChange) {
                if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                    mMediaPlayer.pause();
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                    mMediaPlayer.stop();
                    mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                    mMediaPlayer.pause();
                } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                    mMediaPlayer.start();
                }
            }
        };
    }

    // Play the audio file associated with the resource passed in
    public void playIt(int audioResourceId) {
        // Request audio focus
        int amResult = mAudioManager.requestAudioFocus(
                mAudioFocusChangeListener,
                AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN);
        if (amResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            clearMediaPlayer();
            // Get media player object
            mMediaPlayer = MediaPlayer.create(mContext,audioResourceId);
            mMediaPlayer.start();
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    clearMediaPlayer();
                }
            });
        }
    }

    // Called when we want to clear resources assocated with this helper
    public void clear() {
        clearMediaPlayer();
        mAudioFocusChangeListener = null;
        mAudioManager = null;
    }

    /**
     * Helper method to release the mMediaPlayer object
     */
    private void clearMediaPlayer() {
        if (mMediaPlayer != null) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
            }
            mMediaPlayer.release();
            mMediaPlayer = null;
            if (mAudioManager != null) {
                mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
            }
        }
    }
}
