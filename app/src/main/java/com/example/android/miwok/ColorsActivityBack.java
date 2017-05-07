
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This is an unused class, I left in the project so you could see the code before I used the
 * AppHelper class, it's good just for reference :)
 */
public class ColorsActivityBack extends AppCompatActivity {
    ArrayList<Word> words;
    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener =
            new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    clearMediaPlayer();
                }
            };

    @Override
    protected void onStop() {
        super.onStop();
        clearMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // We create the array list where each cell contains a word object, that object has
        // the english and miwok translation.
        words = new ArrayList<Word>();
        words.add(new Word(R.drawable.color_red, "red", "wetetti", R.raw.color_red));
        words.add(new Word(R.drawable.color_green, "green", "chokokki", R.raw.color_green));
        words.add(new Word(R.drawable.color_brown, "brown", "takaakki", R.raw.color_brown));
        words.add(new Word(R.drawable.color_gray, "gray", "topoppi", R.raw.color_gray));
        words.add(new Word(R.drawable.color_black, "black", "kululli", R.raw.color_black));
        words.add(new Word(R.drawable.color_white, "white", "kelelli", R.raw.color_white));
        words.add(new Word(R.drawable.color_dusty_yellow, "dusty yellow", "topiise",
                R.raw.color_dusty_yellow));
        words.add(new Word(R.drawable.color_mustard_yellow, "mustard yellow", "chiwiite",
                R.raw.color_mustard_yellow));

        // We now create the custom adapter that has our words, required since the array is array
        // of two dimensional objects having english/miwok words
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        // Get list view object and add our custom adapter to it
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = (Word) adapterView.getItemAtPosition(i);
                clearMediaPlayer();
                mMediaPlayer = MediaPlayer.create(ColorsActivityBack.this,
                        word.getAudioId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
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
        }
    }
}