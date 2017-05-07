package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * This is a helper class to handle common code in the app; its main function at the time of
 * creation is associated with handling media (playing audio files).  It uses the audioManager
 * to handle the app that gets audio focus, we use it to request focus and also setup a listener
 * so that we can handle it when another app gets focus (mAudioFocusChangeListener).
 * To use this app the caller instantiates it and passes in their Context, to play an audio file
 * just call method playIt and pass in the resource id of the audio file, finally the caller
 * should invoke the clear method when it's done.
 *
 * Created by seanduffy on 5/6/17.
 */

public class AppHelper {
    // Define local objects we need
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
    private Context mContext;

    // Not used but showed how can assign annonymous class obj to variable
    private MediaPlayer.OnCompletionListener mCompletionListener =
            new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    clearMediaPlayer();
                }
            };

    // Constructor, caller should pass in their context
    public AppHelper(Context appContext) {
        // Assign member variables
        mContext = appContext;
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        // Assign the focus change listener to member variable, makes it cleaner below
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
            // Get a new media player object
            mMediaPlayer = MediaPlayer.create(mContext,audioResourceId);
            mMediaPlayer.start();

            // Setup on completion listener to call clearMediaPlayer when audio completes
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