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
 * This handle the Family activity, if want to see comments look at the NumbersActivity file,
 * the logic is almost identical
 */
public class FamilyActivity extends AppCompatActivity {
    ArrayList<Word> words;

    private AppHelper appHelper;

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
        words.add(new Word(R.drawable.family_father, "father", "ape", R.raw.family_father));
        words.add(new Word(R.drawable.family_mother, "mother", "ata", R.raw.family_mother));
        words.add(new Word(R.drawable.family_son, "son", "angsi", R.raw.family_son));
        words.add(new Word(R.drawable.family_daughter, "daughter", "tune", R.raw.family_daughter));
        words.add(new Word(R.drawable.family_older_brother, "older brother", "taachi",
                R.raw.family_older_brother));
        words.add(new Word(R.drawable.family_younger_brother, "younger brother", "chalitti",
                R.raw.family_younger_brother));
        words.add(new Word(R.drawable.family_older_sister, "older sister", "tete",
                R.raw.family_older_sister));
        words.add(new Word(R.drawable.family_younger_sister, "younger sister", "kolliti",
                R.raw.family_younger_sister));
        words.add(new Word(R.drawable.family_grandmother, "grandmother", "ama",
                R.raw.family_grandmother));
        words.add(new Word(R.drawable.family_grandfather, "grandfather", "paapa",
                R.raw.family_grandfather));

        // We now create the custom adapter that has our words, required since the array is array
        // of two dimensional objects having english/miwok words
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

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