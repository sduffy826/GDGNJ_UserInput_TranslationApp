package com.example.android.miwok;

import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
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
 * This handle the Phrases activity, if want to see comments look at the NumbersActivity file,
 * the logic is almost identical
 */
public class PhrasesActivity extends AppCompatActivity {
    ArrayList<Word> words;

    AppHelper appHelper;

    @Override
    protected void onStop() {
        super.onStop();
        appHelper.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        appHelper = new AppHelper(this);

        // We create the array list where each cell contains a word object, that object has
        // the english and miwok translation.
        words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus\u2605",
                R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinne oyaase'ne",
                R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michekses?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "eenes'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'm coming.", "hee' eenem", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming", "eenem", R.raw.phrase_im_coming));
        words.add(new Word("Let's go", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here", "anninem", R.raw.phrase_come_here));

        // We now create the custom adapter that has our words, required since the array is array
        // of two dimensional objects having english/miwok words
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

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