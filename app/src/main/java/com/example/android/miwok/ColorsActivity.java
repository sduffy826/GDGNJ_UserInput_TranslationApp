
package com.example.android.miwok;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This handle the Colors activity, if want to see comments look at the NumbersActivity file,
 * the logic is almost identical
 */
public class ColorsActivity extends AppCompatActivity {
    ArrayList<Word> words;

    private AppHelper appHelper;

    @Override
    // When app stops then tell appHelper
    protected void onStop() {
        super.onStop();
        appHelper.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Get the appHelper object, it has common code for this app
        appHelper = new AppHelper(this);

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
                appHelper.playIt(word.getAudioId());
            }
        });
    }
}